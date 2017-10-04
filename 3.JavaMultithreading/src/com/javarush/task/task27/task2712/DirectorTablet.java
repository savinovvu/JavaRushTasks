package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DirectorTablet {


    public void printArchivedVideoSet() {

    }

    public void printActiveVideoSet() {
    }

    public void printCookWorkloading() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<LocalDate, Map<String, Integer>> pair : StatisticManager.getInstance().getCookBysyTimeperDays().entrySet()) {
            ConsoleHelper.writeMessage(pair.getKey().format(dtf));

            pair.getValue().entrySet().stream().filter(v -> v.getValue() > 0).forEach(v ->
                    ConsoleHelper.writeMessage(v.getKey() + " - " + (int) Math.ceil(v.getValue() / 60.0) + " min"));
        }
        ConsoleHelper.writeMessage("");
    }

    public void printAdvertisementProfit() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0;
        for (Map.Entry<LocalDate, Long> pair : StatisticManager.getInstance().getProceedsPerDayForAdvertisement().entrySet()) {
            long money = pair.getValue();
            ConsoleHelper.writeMessage(pair.getKey().format(dtf) + " - " + getMoneyString(money));
            total += money;
        }
        ConsoleHelper.writeMessage("Total - " + getMoneyString(total));
        ConsoleHelper.writeMessage("");

    }

    private String getMoneyString(long money) {
        char[] chars = String.valueOf(money).toCharArray();
        StringBuilder result = new StringBuilder();
        if (chars.length > 2) {
            for (int i = 0; i < chars.length; i++) {
                if (i == chars.length - 2) {
                    result.append(".");
                }
                result.append(chars[i]);
            }
            return result.toString();
        } else if (chars.length == 1){
            return "0.0" + String.valueOf(money);
        }
            else{
            return "0." + String.valueOf(money);
        }
    }
}