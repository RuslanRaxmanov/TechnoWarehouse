package repository;

import dto.LaptopDTO;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public List<LaptopDTO> getListLaptop(){
        List<LaptopDTO> inventory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("laptop.txt"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 10) { // Assuming each line has 10 fields
                    LaptopDTO item = new LaptopDTO();
                    item.setId(data[0]);
                    item.setName(data[1]);
                    item.setCategory(data[2]);
                    item.setPrice(Double.parseDouble(data[3]));
                    item.setQuantity(Integer.parseInt(data[4]));
                    item.setColor(data[5]);
                    item.setProtsessor(data[6]);
                    item.setDispley(Double.parseDouble(data[7]));
                    item.setMemory(Integer.parseInt(data[8]));
                    item.setCreatedDate(LocalDate.parse(data[9]));
                    inventory.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventory;
    }
}
