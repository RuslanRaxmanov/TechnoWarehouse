package src.db;

import java.io.File;
import java.io.IOException;

public class Dbinit {
    public static void init() {
        File phone = new File("phone.txt");
        if (!phone.exists()) {
            try {
                phone.createNewFile();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File laptop = new File("laptop.txt");
        if (!laptop.exists()) {
            try {
                laptop.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File file = new File("tv.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
