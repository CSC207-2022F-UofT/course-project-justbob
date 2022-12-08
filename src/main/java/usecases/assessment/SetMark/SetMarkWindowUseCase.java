package usecases.assessment.SetMark;

import ports.database.EntityGateway;
import ports.usecases.assessment.setMark.SetMarkWindowInputBoundary;
import ports.usecases.assessment.setMark.SetMarkWindowRequest;
import ports.usecases.assessment.setMark.SetMarkWindowResponse;

public class SetMarkWindowUseCase implements SetMarkWindowInputBoundary {

    public final EntityGateway entityGateway;

    public SetMarkWindowUseCase(EntityGateway entityGateway) {
        this.entityGateway = entityGateway;
    }

    public SetMarkWindowResponse execute(SetMarkWindowRequest request) {
        return new SetMarkWindowResponse(request.instanceName, request.instanceNumber);
    }
}
