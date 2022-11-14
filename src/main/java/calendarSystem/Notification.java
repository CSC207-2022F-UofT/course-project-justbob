package calendarSystem;

import java.util.*;
import java.time.*;
import java.util.Date;

class Reminder extends TimerTask {
    public void run() {
        System.out.println("Assessment in 24 hours!");
        }
}

public class Notification {
    private LocalDateTime notification;
    private Timer timer;
    //private ArrayList<LocalDateTime> listOfAlarms = new ArrayList<>();

    public Notification(LocalDateTime notification) {
        this.notification = notification.minusDays(1);
        timer = new Timer();
        timer.schedule(new Reminder(), Date.from((this.notification.atZone(ZoneId.systemDefault())).toInstant()));
    }

    public Notification(LocalDateTime notification, int period) {
        this.notification = notification.minusDays(1);
        //listOfAlarms = new ArrayList<>();
        //listOfAlarms.add(this.notification);
        timer = new Timer();
        timer.scheduleAtFixedRate(new Reminder(), Date.from((this.notification.atZone(ZoneId.systemDefault())).toInstant()), period/*7*24*3600*1000*/);
    }

//    public void addNotification(LocalDateTime alarm) {
//        listOfAlarms.add(alarm);
//    }

//    public void removeNotification(LocalDateTime alarm) {
//        listOfAlarms.remove(alarm);
//    }
//
//    public void getNotification() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
