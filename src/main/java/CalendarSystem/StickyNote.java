package CalendarSystem;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

/**
 * StickyNote class represents a sticky note that can be posted on a calendar.
 * It can be written on, and assigned to dates. A StickyNote can be categorized into
 * an assessment, timetable, or miscellaneous sticky note. One-time and recurring notifications can be set for it.
 * */
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
    private String location = "N/A";
    private ArrayList<LocalDate> dates = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private File stickyNoteFile;

    /**
     * Class constructor specifying the sticky note title, and type.
     *
     * @param title name of the sticky note
     * @param type organizes the sticky note by categories
     * */
    public StickyNote(String title, String type) {
        this.title = title;
        setType(type);
    }

    /**
     * Method writes in a text file notes of a sticky note.
     *
     * @param dotJots an array of notes to write on the sticky note
     * */
    public void writeToStickyNote(String[] dotJots) {
        try {
            File stickyNotesDirectory = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes");
            if (!stickyNotesDirectory.exists()) {
                stickyNotesDirectory.mkdirs();
            }

            stickyNoteFile = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\" + getTitle() + ".txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(stickyNoteFile));
            out.write(title + ": " + time);
            if (!(location.equals("N/A") || location == null)) {
                out.newLine();
                out.write(location);
            }
            out.newLine();
            for (int i = 0; i < dotJots.length; i++) {
                out.newLine();
                out.write("\t· " + dotJots[i]);
            }
/*            Scanner sc = new Scanner(System.in);
            dotJot = sc.nextLine();
            while (!dotJot.equals("---POST---")) {
                out.write("\t· " + dotJot);
                out.newLine();
                dotJot = sc.nextLine();
            }
            sc.close();*/
            out.close();
        } catch (IOException io) {
            IOException();
        }
    }

    /**
     * Registers the title as the name of the sticky note,
     * and modifies the name of an existing text file to correspond
     *
     * @param title name of a sticky note
     * */
    public void setTitle(String title) {
        File stickyNoteFile = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\" + this.title + ".txt");
        if (stickyNoteFile.exists()) {
            try {
                File stickyNoteFile2 = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\" + title + ".txt");
                BufferedReader in = new BufferedReader(new FileReader(stickyNoteFile));
                BufferedWriter out = new BufferedWriter(new FileWriter(stickyNoteFile2));
                String line = in.readLine();
                while (line != null) {
                    out.write(line);
                    out.newLine();
                    line = in.readLine();
                }
            } catch (IOException io) {
                IOException();
            }
        }
        this.title = title;
    }

    /**
     * Returns the title of a sticky note.
     * */
    public String getTitle() {
        return title;
    }

    /**
     * Registers the time of event to the sticky note.
     *
     * @param time time during the day the event takes place
     * */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the time of event of a sticky note.
     * */
    public String getTime() {
        return time;
    }

    /**
     * Registers the location of event of a sticky note.
     *
     * @param location where the event takes place
     * */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the location of event of a sticky note.
     * */
    public String getLocation() {
        return location;
    }

    /**
     * Classifies the sticky note into an assessment, timetable, or miscellaneous type.
     *
     * @param type sticky note category
     * */
    public void setType(String type) {
        this.type = type;
        for (int i = 0; i < TYPES.length; i++) {
            if (this.type.equalsIgnoreCase((String) TYPES[i][0])) {
                typeNum = (int) TYPES[i][1];
            }
        }
    }

    /**
     * Returns the type of sticky note.
     * */
    public String getType() {
        return type;
    }

    /**
     * Returns the numeric value of the type of sticky note.
     * Assessment = 1
     * Timetable = 2
     * Miscellaneous = 3
     * */
    public int getTypeNum() {
        return typeNum;
    }

    /**
     * Assigns the sticky note an array of dates, so it can be posted on those days.
     *
     * @param dates array of dates the sticky note is assigned to
     * */
    public void postSpecificDays(LocalDate[] dates) {
        this.dates.addAll(Arrays.asList(dates));
    }//list of dates

    /**
     * Removes given dates if assigned to sticky note.
     *
     * @param dates array of dates the sticky note is not to be posted on if previously posted on
     * */
    public void removeSpecificDays(LocalDate[] dates) {
        this.dates.removeAll(Arrays.asList(dates));
    }

    /**
     * Returns dates sticky note is posted on.
     * */
    public ArrayList<LocalDate> getDates() {
        return dates;
    }

    /**
     * Posts sticky note daily if dailyOrNot is true, and removes sticky note
     * from being posted daily if dailyOrNot is false.
     *
     * @param dailyOrNot true posts daily, and false removes daily posts of a sticky note
     * */
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

    /**
     * Assigns the sticky note to be posted on the given days of week.
     * Uses the helper method, resetWeekly(), to reset the days of week
     * the sticky note is assigned to before each new assignment
     * in case the user forgets to remove those days.
     *
     * @param days_of_week days of week the sticky note is posted on
     * */
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

    /**
     * Helper method for postWeekly to reset the days of week the sticky note is posted on.
     * */
    public void resetWeekly() {
        sundayPost = -7;
        mondayPost = -1;
        tuesdayPost = -2;
        wednesdayPost = -3;
        thursdayPost = -4;
        fridayPost = -5;
        saturdayPost = -6;
    }

    /**
     * Registers date and time notification of a sticky note is set for.
     *
     * @param time time during the day the notification is set for
     * @param date first date the notification is set for
     * */
    public void setNotification(String date, String time) {
        //add time formatter
        //Locale.CANADA uses "a.m." and "p.m." while Locale.ENGLISH uses "AM" and "PM"
        String formattedTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH)).format(DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime alarm = LocalDateTime.parse(date + " " + formattedTime, DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm"));

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

        if (sundayPost > 0 || mondayPost > 0 || tuesdayPost > 0 || wednesdayPost > 0 || thursdayPost > 0 || fridayPost > 0 || saturdayPost > 0) {
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
        }
        else {
            Notification notification = new Notification(alarm);
            notifications.add(notification);
        }
    }

    /**
     * Removes all notifications the sticky note was set for.
     * */
    public void removeAllNotifications() {
        notifications.removeAll(notifications);
    }

    /**
     * Returns all notifications of the sticky note.
     * */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void IOException() {
        System.out.println("Error.");
    }

    /**
     * Returns value to post sticky note on Sundays or not.
     * */
    public int getSundayPost() {
        return sundayPost;
    }

    /**
     * Returns value to post sticky note on Mondays or not.
     * */
    public int getMondayPost() {
        return mondayPost;
    }

    /**
     * Returns value to post sticky note on Tuesdays or not.
     * */
    public int getTuesdayPost() {
        return tuesdayPost;
    }

    /**
     * Returns value to post sticky note on Wednesdays or not.
     * */
    public int getWednesdayPost() {
        return wednesdayPost;
    }

    /**
     * Return value to post sticky note on Thursdays or not.
     * */
    public int getThursdayPost() {
        return thursdayPost;
    }

    /**
     * Returns value to post sticky note on Fridays or not.
     * */
    public int getFridayPost() {
        return fridayPost;
    }

    /**
     * Returns value to post sticky note on Saturdays or not.
     * */
    public int getSaturdayPost() {
        return saturdayPost;
    }
}
