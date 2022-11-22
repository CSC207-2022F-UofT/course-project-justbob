package usecases.dataStorage.course;

public interface CourseDsGateway {
    boolean existsCourse(CourseDsRequestModel requestModel);
    CourseDsModel loadCourse(CourseDsRequestModel requestModel) throws IllegalArgumentException;
}
