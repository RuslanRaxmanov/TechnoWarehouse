package src.repository;

import src.dto.PhoneDTO;

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
    public List<PhoneDTO> getListPhone() {
        List<PhoneDTO> inventory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("phone.txt"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 8) {
                    PhoneDTO item = new PhoneDTO();
                    item.setId(data[0]);
                    item.setName(data[1]);
                    item.setCategory(data[2]);
                    item.setPrice(Double.parseDouble(data[3]));
                    item.setQuantity(Integer.parseInt(data[4]));
                    item.setColor(data[5]);
                    item.setMemory(Integer.parseInt(data[6]));
                    item.setCreatedDate(LocalDate.parse(data[7]));
                    inventory.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventory;
    }


}
