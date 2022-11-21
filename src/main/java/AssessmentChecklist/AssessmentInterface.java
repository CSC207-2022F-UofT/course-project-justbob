package AssessmentChecklist;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AssessmentInterface {

    void setWeight(double weight);

    double getWeight();

    void setDdl(LocalDate ddl);

    void setDdlTime(LocalTime ddlTime);

    LocalDate getDdlDate();

    LocalTime getDdlTime();

    void markAsFinished();

    void markAsNotFinished();

    boolean getFinished();

    void setMark(double mark);

    void removeMark();

    double getMark();

    boolean isHaveMark();

    boolean isShowDetail();

    String getName();

    String getCourseName();

    double getContribution();

    void toShowDetail();

    void toNotShowDetail();
}
