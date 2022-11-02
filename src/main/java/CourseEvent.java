
public class CourseEvent {
    private String type;

    private String day;
    private String startTime;
    private String endTime;
    private String location;

    public CourseEvent(String type, String day, String startTime, String endTime, String location) {
        this.type = type;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        return this.type + " on " + this.day + " from " + this.startTime + " to " + this.endTime + " at " + this.location;
    }


}
