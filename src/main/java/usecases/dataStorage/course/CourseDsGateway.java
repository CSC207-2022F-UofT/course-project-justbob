package usecases.dataStorage.course;

public interface CourseDsGateway {
    boolean existsSemesterCourse(CourseDsRequestModel requestModel);
    boolean existsArchivedCourse(CourseDsRequestModel requestModel);
    CourseDsModel loadSemesterCourse(CourseDsRequestModel requestModel) throws NoSuchFieldException;
    CourseDsModel loadArchivedCourse(CourseDsRequestModel requestModel) throws NoSuchFieldException;
}
