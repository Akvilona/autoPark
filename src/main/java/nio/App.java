package nio;

import nio.dz.FileUserCrudRepository;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(final String[] args) throws IOException {
        File file = new File("users.csv");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        }
        FileUserCrudRepository fileUserCrudRepository = new FileUserCrudRepository(file);
        fileUserCrudRepository.delete(2L);
    }

}
