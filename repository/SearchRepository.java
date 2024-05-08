package repository;

import dto.LaptopDTO;
import dto.PhoneDTO;
import dto.TVDTO;
import dto.UnversalDTO;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SearchRepository {

    public List<UnversalDTO> fullData(List<PhoneDTO> phoneDTOS, List<LaptopDTO> laptopDTOS, List<TVDTO> tvdtos) {
        List<UnversalDTO> list = new LinkedList<>();
        for (LaptopDTO laptopDTO : laptopDTOS) {
            UnversalDTO unversalDTO = new UnversalDTO();
            unversalDTO.setId(laptopDTO.getId());
            unversalDTO.setName(laptopDTO.getName());
            unversalDTO.setPrice(laptopDTO.getPrice());
            unversalDTO.setColor(laptopDTO.getColor());
            unversalDTO.setCategory(laptopDTO.getCategory());
            unversalDTO.setMemory(laptopDTO.getMemory());
            unversalDTO.setProtsessor(laptopDTO.getProtsessor());
            unversalDTO.setDispley(laptopDTO.getDispley());
            unversalDTO.setQuantity(laptopDTO.getQuantity());
            unversalDTO.setCreatedDate(laptopDTO.getCreatedDate());
            list.add(unversalDTO);
        }
        for (PhoneDTO phoneDTO : phoneDTOS) {
            UnversalDTO unversalDTO = new UnversalDTO();
            unversalDTO.setId(phoneDTO.getId());
            unversalDTO.setName(phoneDTO.getName());
            unversalDTO.setPrice(phoneDTO.getPrice());
            unversalDTO.setColor(phoneDTO.getColor());
            unversalDTO.setCategory(phoneDTO.getCategory());
            unversalDTO.setMemory(phoneDTO.getMemory());
            unversalDTO.setQuantity(phoneDTO.getQuantity());
            unversalDTO.setCreatedDate(phoneDTO.getCreatedDate());
            list.add(unversalDTO);
        }
        for (TVDTO tvdto : tvdtos) {
            UnversalDTO unversalDTO = new UnversalDTO();
            unversalDTO.setId(tvdto.getId());
            unversalDTO.setName(tvdto.getName());
            unversalDTO.setPrice(tvdto.getPrice());
            unversalDTO.setCategory(tvdto.getCategory());
            unversalDTO.setDispley(tvdto.getDispley());
            unversalDTO.setQuantity(tvdto.getQuantity());
            unversalDTO.setCreatedDate(tvdto.getCreatedDate());
            list.add(unversalDTO);
        }
        return list;
    }

    public void delete(String id, String fileName) {
        String filePath = fileName + ".txt";
        File inputFile = new File(filePath);
        File tempFile = new File("temp.txt");

        String currentLine;

        try {
            // Write objects to read files
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Create an object to write to a temporary file
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Reading the file from the beginning of the line and checking the line
            while ((currentLine = bufferedReader.readLine()) != null) {
                // Check the string and write or pass the string
                if (currentLine.startsWith(id)) continue;
                bufferedWriter.write(currentLine + System.getProperty("line.separator"));
            }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();

            // Delete the old file
            if (!inputFile.delete()) {
                System.out.println("The file could not be deleted");
                return;
            }

            // Rename the new file with the old file name
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("An error occurred while converting the file");
            }

            System.out.println("\n Row deleted successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void update(String fileName, UnversalDTO dto) {
        String path = fileName + ".txt";
        File inputFile = new File(path);
        File tempFile = new File("temp.txt");
        String newLine = null;
        if (dto.getCategory().equals("Phone")) {
            newLine = dto.getId() + ";" + dto.getName() + ";" + dto.getCategory() + ";" + dto.getPrice() + ";" + dto.getQuantity() + ";" +
                    dto.getColor() + ";" + dto.getMemory() + ";" + dto.getCreatedDate() + "\n";
        } else if (dto.getCategory().equals("Tv")) {
            newLine = dto.getId() + ";" + dto.getName() + ";" + dto.getCategory() + ";" + dto.getPrice() + ";" +
                    dto.getQuantity() + ";" + dto.getDispley() + ";" + dto.getCreatedDate() + "\n";
        } else if (dto.getCategory().equals("Laptop")) {
            newLine = dto.getId() + ";" + dto.getName() + ";" + dto.getCategory() + ";" + dto.getPrice() + ";" + dto.getQuantity() + ";" +
                    dto.getColor() + ";" + dto.getProtsessor() + ";" + dto.getDispley() + ";" + dto.getMemory() + ";" + dto.getCreatedDate() + "\n";
        }
        String currentLine;

        try {
            // Create objects to read files
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Create an object to write to a temporary file
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Reading the file from the beginning of the line and checking the line
            while ((currentLine = bufferedReader.readLine()) != null) {
                // Update the row with the given id
                if (currentLine.startsWith(dto.getId())) {
                    currentLine = newLine;
                }
                // Write lines to a new file
                bufferedWriter.write(currentLine + System.getProperty("line.separator"));
            }

            // Shut down
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();

            // Delete the old file
            if (!inputFile.delete()) {
                System.out.println("The file could not be deleted ");
                return;
            }

            // Rename the new file with the old file name
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("An error occurred while converting the file");
            }

            System.out.println("\nRow updated successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
