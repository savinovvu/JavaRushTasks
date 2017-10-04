package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.util.Objects;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.init();
        controller.init();
        view.setController(controller);
    }

    public void exit() {
        System.exit(0);

    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document == null) return;
        UndoListener listener = view.getUndoListener();
        document.removeUndoableEditListener(listener);
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(listener);
        view.update();

    }

    public void setPlainText(String text) {
        resetDocument();
        try {
            new HTMLEditorKit().read(new StringReader(text), document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        try {
            StringWriter writer = new StringWriter();
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
            return writer.toString();
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
            return "";
        }
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                new HTMLEditorKit().read(new FileReader(currentFile), document, 0);
                view.resetUndo();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (Objects.nonNull(currentFile)) {
            try {
                view.setTitle(currentFile.getName());

                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());

            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        } else saveDocumentAs();

    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());

            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

}

