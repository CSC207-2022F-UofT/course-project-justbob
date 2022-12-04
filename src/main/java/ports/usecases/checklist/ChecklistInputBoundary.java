package ports.usecases.checklist;

import ports.usecases.PathNotFoundError;

public interface ChecklistInputBoundary {
    ChecklistModel execute(String userName) throws PathNotFoundError;
}
