package entities.task;

public interface TaskInterface {
    boolean getSubmitted();

    boolean getCommitted();

    boolean isHaveMark();

    boolean isShowDetail();

    void toShowDetail();

    void toNotShowDetail();
}
