package CalendarSystem;

import java.util.*;
import java.time.*;
import java.util.Date;

class Reminder extends TimerTask {
    public void run() {
        System.out.println("Assessment in 24 hours!");
        }
}

public class Notification {
    private LocalDateTime notificationTime;
    private int period;
    private Timer timer;
    //private ArrayList<LocalDateTime> listOfAlarms = new ArrayList<>();

    public Notification(LocalDateTime notification) {
        this.notificationTime = notification.minusDays(1);
        timer = new Timer();
        timer.schedule(new Reminder(), Date.from((this.notificationTime.atZone(ZoneId.systemDefault())).toInstant()));
    }

    public Notification(LocalDateTime notification, int period) {
        this.notificationTime = notification.minusDays(1);
        this.period = period;
        //listOfAlarms = new ArrayList<>();
        //listOfAlarms.add(this.notification);
        timer = new Timer();
        timer.scheduleAtFixedRate(new Reminder(), Date.from((this.notificationTime.atZone(ZoneId.systemDefault())).toInstant()), period/*7*24*3600*1000*/);
    }

    public String getNotificationTime() {
        return notificationTime.toString();
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
