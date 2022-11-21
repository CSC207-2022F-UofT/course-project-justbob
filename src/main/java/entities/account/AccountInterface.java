package entities.account;

import entities.archive.Archive;
import entities.semester.Semester;

public interface AccountInterface {
    String getUsername();
    String getPassword();
    Archive getArchive();
    Semester getSemester();
}
