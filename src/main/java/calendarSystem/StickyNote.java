package calendarSystem;

import java.util.*;
import java.io.*;
import java.time.*;

public class StickyNote {
    private final int DAILY_MILLISECONDS = 24 * 3600 * 1000;
    private final int WEEKLY_MILLISECONDS = 7 * DAILY_MILLISECONDS;
    private String title;
    private String dotJot;
    private final Object[][] TYPES = {
            {"Assessment", 1},
            {"Timetable", 2},
            {"Miscellaneous", 3}
    };
    private int sundayPost = -7;//change into array
    private int mondayPost = -1;
    private int tuesdayPost = -2;
    private int wednesdayPost = -3;
    private int thursdayPost = -4;
    private int fridayPost = -5;
    private int saturdayPost = -6;
    private String type;
    private int typeNum;
    private String date;
    private String time;
    private String location;
    private ArrayList<LocalDate> dates = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private File stickyNoteFile;

    public StickyNote(String title, String type) {
        this.title = title;
        setType(type);
    }

    public void writeToStickyNote() {
        try {
            stickyNoteFile = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\" + "rememberToEditStickyNoteFileNames" + ".txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(stickyNoteFile));
            out.write(title + ": " + time);
            if (!(location.equals("N/A") || location == null)) {
                out.newLine();
                out.write(location);
            }
            out.newLine();
            Scanner sc = new Scanner(System.in);
            dotJot = sc.nextLine();
            while (!dotJot.equals("---POST---")) {
                out.write("\t· " + dotJot);
                out.newLine();
                dotJot = sc.nextLine();
            }
            sc.close();
            out.close();
        } catch (IOException io) {
            IOException();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setType(String type) {
        this.type = type;
        for (int i = 0; i < TYPES.length; i++) {
            if (this.type.equalsIgnoreCase((String) TYPES[i][0])) {
                typeNum = (int) TYPES[i][1];
            }
        }
    }

    public String getType() {
        return type;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public void postSpecificDays(LocalDate[] dates) {
        this.dates.addAll(Arrays.asList(dates));
    }//list of dates

    public void removeSpecificDays(LocalDate[] dates) {
        this.dates.removeAll(Arrays.asList(dates));
    }

    public ArrayList<LocalDate> getDates() {
        return dates;
    }

    public void postDaily(boolean dailyOrNot) {
        if (dailyOrNot) {
            sundayPost = 7;
            mondayPost = 1;
            tuesdayPost = 2;
            wednesdayPost = 3;
            thursdayPost = 4;
            fridayPost = 5;
            saturdayPost = 6;
        } else {
            sundayPost = -7;
            mondayPost = -1;
            tuesdayPost = -2;
            wednesdayPost = -3;
            thursdayPost = -4;
            fridayPost = -5;
            saturdayPost = -6;
        }
    }

    public void postWeekly(String[] days_of_week) {
        resetWeekly();
        for (String s : days_of_week) {
            if (s.equalsIgnoreCase("Sunday")) {
                sundayPost = 7;
            } else if (s.equalsIgnoreCase("Monday")) {
                mondayPost = 1;
            } else if (s.equalsIgnoreCase("Tuesday")) {
                tuesdayPost = 2;
            } else if (s.equalsIgnoreCase("Wednesday")) {
                wednesdayPost = 3;
            } else if (s.equalsIgnoreCase("Thursday")) {
                thursdayPost = 4;
            } else if (s.equalsIgnoreCase("Friday")) {
                fridayPost = 5;
            } else if (s.equalsIgnoreCase("Saturday")) {
                saturdayPost = 6;
            }
        }
    }

    public void resetWeekly() {
        sundayPost = -7;
        mondayPost = -1;
        tuesdayPost = -2;
        wednesdayPost = -3;
        thursdayPost = -4;
        fridayPost = -5;
        saturdayPost = -6;
    }

    public void setNotification(String date, String time) {
        //add time formatter
        LocalDateTime alarm = LocalDateTime.parse(date + " " + time);

        int count = 0;
        if (sundayPost > 0) {
            count++;
        }
        if (mondayPost > 0) {
            count++;
        }
        if (tuesdayPost > 0) {
            count++;
        }
        if (wednesdayPost > 0) {
            count++;
        }
        if (thursdayPost > 0) {
            count++;
        }
        if (fridayPost > 0) {
            count++;
        }
        if (saturdayPost > 0) {
            count++;
        }

        if (count == 7) {
            Notification dailyNotification = new Notification(alarm, DAILY_MILLISECONDS);
            notifications.add(dailyNotification);
        }

        if (sundayPost > 0) {
            Notification sundayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() % 7), WEEKLY_MILLISECONDS);
            notifications.add(sundayNotification);
        }
        if (mondayPost > 0) {
            Notification mondayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() - 1), WEEKLY_MILLISECONDS);
            notifications.add(mondayNotification);
        }
        if (tuesdayPost > 0) {
            Notification tuesdayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() - 2), WEEKLY_MILLISECONDS);
            notifications.add(tuesdayNotification);
        }
        if (wednesdayPost > 0) {
            Notification wednesdayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() - 3), WEEKLY_MILLISECONDS);
            notifications.add(wednesdayNotification);
        }
        if (thursdayPost > 0) {
            Notification thursdayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() - 4), WEEKLY_MILLISECONDS);
            notifications.add(thursdayNotification);
        }
        if (fridayPost > 0) {
            Notification fridayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() - 5), WEEKLY_MILLISECONDS);
            notifications.add(fridayNotification);
        }
        if (saturdayPost > 0) {
            Notification saturdayNotification = new Notification(alarm.minusDays(alarm.getDayOfWeek().getValue() - 6), WEEKLY_MILLISECONDS);
            notifications.add(saturdayNotification);
        }
        else {
            Notification notification = new Notification(alarm);
            notifications.add(notification);
        }
    }

    public void IOException() {
        System.out.println("Error.");
    }
}