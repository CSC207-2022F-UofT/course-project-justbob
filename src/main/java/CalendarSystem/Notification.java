package CalendarSystem;

import java.util.*;
import java.time.*;
import java.util.Date;

/**
 * Helper class prints out notification message when timer is met.
 * */
class Reminder extends TimerTask {
    public void run() {
        System.out.println("Assessment in 24 hours!");
        }
}

/**
 * Notification class consists of two constructors: a notification that only occurs once,
 * and a notification that occurs periodically.
 * */
public class Notification {
    private LocalDateTime notificationTime;
    private int period;
    private Timer timer;
    //private ArrayList<LocalDateTime> listOfAlarms = new ArrayList<>();

    /**
     * Class constructor registers this date and time as a one-time notification.
     * Notification is called on when the current date and time match the given date and time.
     *
     * @param notification  the time at which a notification is scheduled for
     * */
    public Notification(LocalDateTime notification) {
        this.notificationTime = notification.minusDays(1);
        timer = new Timer();
        timer.schedule(new Reminder(), Date.from((this.notificationTime.atZone(ZoneId.systemDefault())).toInstant()));
    }

    /**
     * Class constructor registers this date and time, and period as a recurring notification.
     * Notification is alarmed when the current date and time match the given date and time,
     * and it is called on again whenever the registered period elapses.
     *
     * @param notification  the time at which a notification is scheduled for
     * @param period the time the notification is called on repeatedly after the first call
     * */
    public Notification(LocalDateTime notification, int period) {
        this.notificationTime = notification.minusDays(1);
        this.period = period;
        //listOfAlarms = new ArrayList<>();
        //listOfAlarms.add(this.notification);
        timer = new Timer();
        timer.scheduleAtFixedRate(new Reminder(), Date.from((this.notificationTime.atZone(ZoneId.systemDefault())).toInstant()), period/*7*24*3600*1000*/);
    }

    /**
     * Returns notification original date and time.
     * */
    public String getNotificationTime() {
        return notificationTime.toString();
    }

    /**
     * Returns period at which notification recurs if applicable.
     * */
    public int getPeriod() {
        return period;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
