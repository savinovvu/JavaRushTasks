package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Comparator<Advertisement> comparatorAdvertisement = (o1, o2) -> {
            int result = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            if (result == 0) {
                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                result = Long.compare(oneSecondCost1, oneSecondCost2);
            }
            return result;
        };

        Collections.sort(storage.list(), comparatorAdvertisement);

        List<Advertisement> advertList = recurcyMethod(timeSeconds, storage.list());
        Collections.sort(advertList, comparatorAdvertisement);

       /* if (advertList.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));

        }else {*/
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertList,
                    advertList.stream().mapToLong(v -> v.getAmountPerOneDisplaying()).sum(), advertList.stream()
                    .mapToInt(v -> v.getDuration()).sum()));
      /*  }*/
        advertList.forEach(advertisement -> {
            ConsoleHelper
                    .writeMessage(advertisement.getName() + " is displaying... "
                            + advertisement.getAmountPerOneDisplaying() + ", "
                            + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
            advertisement.revalidate();
        });


    }


    private static List<Advertisement> recurcyMethod(int timeSeconds, List<Advertisement> advert) {
        if (timeSeconds == 0) return new ArrayList<>();
        List<List<Advertisement>> putList = new ArrayList<>();

        advert.stream().filter(advertisement -> advertisement.getHits() > 0 && timeSeconds - advertisement.getDuration() >= 0)
                .forEach(advertisement -> {
                    List<Advertisement> nextIterateList = new ArrayList<>(advert);
                    nextIterateList.remove(advertisement);
                    List<Advertisement> advertisements =
                            recurcyMethod(timeSeconds - advertisement.getDuration(), nextIterateList);
                    advertisements.add(advertisement);
                    putList.add(advertisements);
                });


        Comparator<List<Advertisement>> comparatorList = (List<Advertisement> a1, List<Advertisement> a2) ->
        {
            int result = Math.toIntExact(a1.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum() -
                    a2.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum());
            if (result == 0) {
                result = a1.stream().mapToInt(Advertisement::getDuration).sum() - a2.stream().mapToInt(Advertisement::getDuration).sum();
            }
            if (result == 0) {
                result = a2.size() - a1.size();
            }
            return result;
        };


        List<Advertisement> advertisements = putList.stream().max(comparatorList).orElse(new ArrayList<>());

        return advertisements;
    }
}
