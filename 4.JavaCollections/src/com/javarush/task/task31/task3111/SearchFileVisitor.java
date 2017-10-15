package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean isSearched = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            isSearched = false;
        }

        if (partOfContent != null && !new String(content).contains(partOfContent)) {
            isSearched = false;
        }

        int bytesSize = content.length;

        if (minSize != 0 && bytesSize <= minSize) {
            isSearched = false;
        }

        if (maxSize != 0 && bytesSize >= maxSize) {
            isSearched = false;
        }

        if (isSearched) {
            getFoundFiles().add(file);
        }
        return super.visitFile(file, attrs);
    }


}
