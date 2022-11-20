package usecases.markOperations.addMark;

public interface AddMarkDsGateway {
    boolean existsInstance(String username, String courseCode, String assessmentTitle, int instanceIndex);
    boolean existsInstanceMark(String username, String courseCode, String assessmentTitle, int instanceIndex);
    void saveInstanceMark(String username, String courseCode, String assessmentTitle, int instanceIndex, double mark);
}
