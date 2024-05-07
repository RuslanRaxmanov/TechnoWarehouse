package repository;

import dto.PhoneDTO;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {
    public void addPhone(PhoneDTO dto) {
        PrintWriter printWriter = null;

        try {
            File file = new File("phone.txt");

            printWriter = new PrintWriter(new FileWriter("phone.txt", true));

            if (!file.exists() || file.length() == 0) {
                // Faylning birinchi qatoriga header ni yozish
                printWriter.println("ID;Name;Category;Price;Quantity;Color;Memory;CreatedDate");
            }
            String data = dto.getId() + ";" + dto.getName() + ";" + dto.getCategory() + ";" + dto.getPrice() + ";" + dto.getQuantity() + ";" +
                    dto.getColor() + ";" + dto.getMemory() + ";" + dto.getCreatedDate() + "\n";
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
