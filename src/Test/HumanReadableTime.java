package Test;

import java.util.Timer;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        String result;
        if (seconds >= 359999) {
            return "99:59:59";
        } else {
            int hours = seconds / 3600; // в одном часу 3600сек, делим на 3600 получаем часы
            int minutes = seconds % 3600 / 60; // остаток от деления на 3600 - количество сек не вошещних в часы, делим на 60 получаем минуты
            int sec = seconds % 60; // остаток от деления на 60 - количестко секунд
            result = String.format("%02d:%02d:%02d", hours, minutes, sec);
        }
        return result;
    }

}
