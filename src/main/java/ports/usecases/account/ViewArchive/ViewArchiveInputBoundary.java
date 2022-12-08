package ports.usecases.account.ViewArchive;

import ports.usecases.PathNotFoundError;

public interface ViewArchiveInputBoundary {
    ViewArchiveResponse execute(ViewArchiveRequest request) throws PathNotFoundError;
}
