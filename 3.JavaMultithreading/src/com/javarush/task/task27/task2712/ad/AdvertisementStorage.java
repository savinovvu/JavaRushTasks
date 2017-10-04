package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();


    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.addAll(Arrays.asList(
                new Advertisement(someContent, "3 Video", 5000, 1, 30 * 60),
                new Advertisement(someContent, "2 Video", 2500, 1, 15 * 60),
             /*   new Advertisement(someContent, "10 Video", 5000, 100, 3 * 60),
                new Advertisement(someContent, "1 Video", 5000, 1, 1),
                new Advertisement(someContent, "4 Video", 100, 10, 15 * 60),*/
                new Advertisement(someContent, "5 Video", 2500, 1, 15 * 60)));
    }
}
