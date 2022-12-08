package usecases.account.ViewArchive;

import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.viewSemester.ViewSemesterResponse;
import views.ArchiveView;
import views.SemesterView;

import javax.swing.*;

public class ViewArchivePresenter {
    private final EntityGateway entityGateway;
    private final EntityFactory entityFactory;
    private final JFrame frame;
    private final JFrame parentFrame;

    ViewArchivePresenter(JFrame frame, EntityGateway entityGateway, EntityFactory entityFactory, JFrame parentFrame) {
        this.entityGateway = entityGateway;
        this.entityFactory = entityFactory;
        this.frame = frame;
        this.parentFrame = parentFrame;
    }

    public void present(ViewSemesterResponse response) {
        new ArchiveView(entityGateway, entityFactory, response, parentFrame);
        frame.dispose();
    }
}
