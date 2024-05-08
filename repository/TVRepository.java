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
    public List<TVDTO> getListTv() {
        List<TVDTO> inventory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("tv.txt"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    TVDTO item = new TVDTO();
                    item.setId(data[0]);
                    item.setName(data[1]);
                    item.setCategory(data[2]);
                    item.setPrice(Double.parseDouble(data[3]));
                    item.setQuantity(Integer.parseInt(data[4]));
                    item.setDispley(Double.valueOf(data[5]));
                    item.setCreatedDate(LocalDate.parse(data[6]));
                    inventory.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventory;
    }
}
