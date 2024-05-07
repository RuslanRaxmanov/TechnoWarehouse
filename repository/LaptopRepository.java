package repository;

import dto.LaptopDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LaptopRepository {
    public void addLaptop(LaptopDTO dto) {
        PrintWriter printWriter = null;

        try {
            File file = new File("laptop.txt");

            printWriter = new PrintWriter(new FileWriter("laptop.txt", true));

            if (!file.exists() || file.length() == 0) {
                // Faylning birinchi qatoriga header ni yozish
                printWriter.println("ID;Name;Category;Price;Quantity;Color;Protsessor;Displey;Memory;CreatedDate");
            }
            String data = dto.getId() + ";" + dto.getName() + ";" + dto.getCategory() + ";" + dto.getPrice() + ";" + dto.getQuantity() + ";" +
                    dto.getColor() + ";" + dto.getProtsessor() + ";" + dto.getDispley() + ";" + dto.getMemory() + ";" + dto.getCreatedDate() + "\n";
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
