package repository;

import dto.TVDTO;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TVRepository {

    public void addTV(TVDTO dto) {
        PrintWriter printWriter = null;

        try {
            File file = new File("tv.txt");

            printWriter = new PrintWriter(new FileWriter("tv.txt", true));

            if (!file.exists() || file.length() == 0) {
                // Faylning birinchi qatoriga header ni yozish
                printWriter.println("ID;Name;Category;Price;Quantity;Displey;CreatedDate");
            }
            String data = dto.getId() + ";" + dto.getName() + ";" + dto.getCategory() + ";" + dto.getPrice() + ";" + dto.getQuantity() + ";" +
                    dto.getDispley() + ";" + dto.getCreatedDate() + "\n";
            printWriter.write(data);
            System.out.println("\n Succsesfly Add Product \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }

    }
}
