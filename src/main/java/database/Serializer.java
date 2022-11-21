package database;

import java.io.*;

public class Serializer {
    /**
     * Serialize an object to a file.
     * Precondition: object and all of its nested data members implement serializable.
     * @param object the object to serialize
     * @param filename the name of the file to store data in
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if the file cannot be written to
     */
    public static void serialize(Serializable object, String filename) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(object);
        } finally {
            file.close();
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /**
     * read a serialized object from a file.
     * @param filename
     * @return the deserialized object.
     * @throws FileNotFoundException if the file is not found
     * @throws IOException if the file cannot be read from
     * @throws ClassNotFoundException if a serialized object could not be found.
     */
    public static Object deserialize(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream inputStream = null;
        try {
            ObjectInputStream objectInput = new ObjectInputStream(file);
            return objectInput.readObject();
        } finally {
            file.close();
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
