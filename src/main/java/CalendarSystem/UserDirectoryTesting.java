package CalendarSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserDirectoryTesting {
    public static void main(String[] args) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        System.out.println("Hi");
        File file = new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\UserDirectoryFilePathTest.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir"), "src/main/java/CalendarSystem/StickyNotes\\rememberToEditStickyNoteFileNames.txt"), true));
    }
}
