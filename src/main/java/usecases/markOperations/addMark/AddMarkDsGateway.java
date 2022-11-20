package usecases.markOperations.addMark;

public interface AddMarkDsGateway {
    boolean existsInstance(AddMarkDsRequestModel requestModel);
    /**
     * @param requestModel The request model to use. Requires that the mark is set.
     */
    void saveInstanceMark(AddMarkDsRequestModel requestModel);
}
