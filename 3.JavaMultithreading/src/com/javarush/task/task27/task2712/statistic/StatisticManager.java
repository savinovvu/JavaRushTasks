package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet();


    public static StatisticManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new StatisticManager();
        }
        return ourInstance;
    }


    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }


    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage() {
            storage = Arrays.stream(EventType.values()).collect(Collectors
                    .toMap(Function.identity(), k -> new ArrayList<EventDataRow>(),
                            (k1, k2) -> new ArrayList<EventDataRow>()));


        }

        private void put(EventDataRow data) {
            List<EventDataRow> eventDataRows = storage.get(data.getType());
            eventDataRows.add(data);
            storage.put(data.getType(), eventDataRows);
        }

    }

    public Map<LocalDate, Long> getProceedsPerDayForAdvertisement() {
        List<EventDataRow> eventDataRows = getInstance().statisticStorage.storage.get(EventType.SELECTED_VIDEOS);
        List<VideoSelectedEventDataRow> videoRows = eventDataRows.stream().filter(eventDataRow -> eventDataRow instanceof VideoSelectedEventDataRow)
                .map(eventDataRow -> (VideoSelectedEventDataRow) eventDataRow).collect(Collectors.toList());

        return videoRows.stream()
                .collect(Collectors.toMap(v -> v.getDate().toInstant()
                                .atZone(ZoneId.systemDefault()).toLocalDate(),
                        v -> v.getAmount(), (k1, k2) -> k1 + k2,
                        () -> new TreeMap<LocalDate, Long>(getDescDataComparator())));
    }


    public Map<LocalDate, Map<String, Integer>> getCookBysyTimeperDays() {
        List<EventDataRow> eventDataRows = getInstance().statisticStorage.storage.get(EventType.COOKED_ORDER);
        List<CookedOrderEventDataRow> cookedOrderEventDataRows = eventDataRows.stream().filter(eventDataRow -> eventDataRow instanceof CookedOrderEventDataRow)
                .map(eventDataRow -> (CookedOrderEventDataRow) eventDataRow).collect(Collectors.toList());

        return cookedOrderEventDataRows.stream()
                .collect(Collectors.groupingBy((cookedOrderEventDataRow) -> cookedOrderEventDataRow.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        () -> new TreeMap<LocalDate, Map<String, Integer>>(getDescDataComparator()), Collectors
                                .groupingBy(CookedOrderEventDataRow::getCookName, TreeMap::new,
                                        Collectors.summingInt(CookedOrderEventDataRow::getTime))));

    }

    private Comparator<LocalDate> getDescDataComparator() {
        return (d1, d2) -> {
            if (d2.isAfter(d1)) return 1;
            if (d2.isBefore(d1)) return -1;
            return 0;
        };
    }



   /* public static void main(String[] args) {
        List<EventDataRow> eventDataRows = Arrays.asList(
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 5000, 15, converter(LocalDate.now().plusDays(3))),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now().plusDays(2))),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now().plusDays(1))),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now().plusDays(1))),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now())),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now())),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now().minusDays(1))),
                new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 1111, 15, converter(LocalDate.now().minusDays(1)))
        );

        eventDataRows.forEach(eventDataRow -> getInstance().statisticStorage.put(eventDataRow));
        DirectorTablet tablet = new DirectorTablet();
        tablet.printAdvertisementProfit();
    }
    private static Date converter(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }*/


}


/*  public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs, Date currentDate) {
        List<EventDataRow> eventDataRows = Arrays.asList(
                new CookedOrderEventDataRow("name", "Ivanov", 360, new ArrayList<Dish>(), converter(LocalDate.now().plusDays(1))),
                new CookedOrderEventDataRow("name", "Ivanov", 361, new ArrayList<Dish>(), converter(LocalDate.now().plusDays(1))),
                new CookedOrderEventDataRow("name", "Ivanov", 80, new ArrayList<Dish>(), converter(LocalDate.now())),
                new CookedOrderEventDataRow("name", "Ivanov", 40, new ArrayList<Dish>(), converter(LocalDate.now())),
                new CookedOrderEventDataRow("name", "Ivanov", 20, new ArrayList<Dish>(), converter(LocalDate.now().minusDays(1))),
                new CookedOrderEventDataRow("name", "Ivanov", 10, new ArrayList<Dish>(), converter(LocalDate.now().minusDays(1))),

                new CookedOrderEventDataRow("name", "Petrov", 10, new ArrayList<Dish>(), converter(LocalDate.now().plusDays(1))),
                new CookedOrderEventDataRow("name", "Petrov", 20, new ArrayList<Dish>(), converter(LocalDate.now().plusDays(1))),
                new CookedOrderEventDataRow("name", "Petrov", 40, new ArrayList<Dish>(), converter(LocalDate.now())),
                new CookedOrderEventDataRow("name", "Petrov", 80, new ArrayList<Dish>(), converter(LocalDate.now())),
                new CookedOrderEventDataRow("name", "Petrov", 0, new ArrayList<Dish>(), converter(LocalDate.now().minusDays(1))),
                new CookedOrderEventDataRow("name", "Petrov", 0, new ArrayList<Dish>(), converter(LocalDate.now().minusDays(1)))
                );*/
