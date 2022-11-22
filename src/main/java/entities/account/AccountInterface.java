package entities.account;

import entities.account.archive.Archive;
import entities.account.semester.Semester;

public interface AccountInterface {
    String getUsername();
    String getPassword();
    Archive getArchive();
    Semester getSemester();
}
