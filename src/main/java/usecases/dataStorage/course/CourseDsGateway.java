package usecases.dataStorage.course;

public interface CourseDsGateway {
    boolean existsCourse(CourseDsRequestModel requestModel);
    CourseDsResponseModel loadCourse(CourseDsRequestModel requestModel);
}
