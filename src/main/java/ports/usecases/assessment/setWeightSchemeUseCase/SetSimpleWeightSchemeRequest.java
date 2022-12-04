package ports.usecases.assessment.setWeightSchemeUseCase;

public class SetSimpleWeightSchemeRequest {

    public String username; /*abstract to path class*/

    public String courseCode; /*abstract to path class*/

    public String assessmentTitle;
    public int numberOfInstances;

    public double weightOfEachInstance;

    public SetSimpleWeightSchemeRequest() {}

    public SetSimpleWeightSchemeRequest(String username, String courseCode, String assessmentTitle,
                                        int numberOfInstances, double weightOfEachInstance) {
        this.username = username;
        this.courseCode = courseCode;
        this.assessmentTitle = assessmentTitle;
        this.numberOfInstances = numberOfInstances;
        this.weightOfEachInstance = weightOfEachInstance;
    }

}
