package src.service;

import src.controller.BaseController;
import src.dto.BaseDTO;
import src.dto.UnversalDTO;
import src.repository.SearchRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchService {

    public List<UnversalDTO> searchName(String name) {
        BaseController baseController = new BaseController();
        List<UnversalDTO> list = baseController.get();
        List<UnversalDTO> searchList = new LinkedList<>();

        int count = 1;
        for (UnversalDTO unversalDTO : list) {
            if (unversalDTO.getName().toLowerCase().contains(name.toLowerCase())) {
                if (count == 1) {
                    System.out.println("===============================================");
                }
                System.out.println("id : " + count);
                System.out.println("Name : " + unversalDTO.getName());
                System.out.println("Category : " + unversalDTO.getCategory());
                System.out.println("Price : " + unversalDTO.getPrice());
                System.out.println("Quantity : " + unversalDTO.getQuantity());
                if (unversalDTO.getColor() != null) {
                    System.out.println("Color : " + unversalDTO.getColor());
                }
                if (unversalDTO.getProtsessor() != null) {
                    System.out.println("Protsessor : " + unversalDTO.getProtsessor());
                }
                if (unversalDTO.getDispley() != null) {
                    System.out.println("Displey : " + unversalDTO.getDispley());
                }
                if (unversalDTO.getMemory() != null) {
                    System.out.println("Memory : " + unversalDTO.getMemory());
                }
                System.out.println("CreatedDate : " + unversalDTO.getCreatedDate());
                System.out.println("===============================================");
                searchList.add(unversalDTO);
                count++;
            }
        }
        return searchList;
    }

    public void sortDate(List<UnversalDTO> list) {
        int count = 1;
        for (UnversalDTO unversalDTO : list) {
            if (count == 1) {
                System.out.println("===============================================");
            }
            System.out.println("id : " + count);
            System.out.println("Name : " + unversalDTO.getName());
            System.out.println("Category : " + unversalDTO.getCategory());
            System.out.println("Price : " + unversalDTO.getPrice());
            System.out.println("Quantity : " + unversalDTO.getQuantity());
            if (unversalDTO.getColor() != null) {
                System.out.println("Color : " + unversalDTO.getColor());
            }
            if (unversalDTO.getProtsessor() != null) {
                System.out.println("Protsessor : " + unversalDTO.getProtsessor());
            }
            if (unversalDTO.getDispley() != null) {
                System.out.println("Displey : " + unversalDTO.getDispley());
            }
            if (unversalDTO.getMemory() != null) {
                System.out.println("Memory : " + unversalDTO.getMemory());
            }
            System.out.println("CreatedDate : " + unversalDTO.getCreatedDate());
            System.out.println("===============================================");
            count++;
        }
    }

    public void delete(String id, String fileName) {
        SearchRepository searchRepository = new SearchRepository();
        searchRepository.delete(id, fileName);
    }

    public void update(UnversalDTO dto, String fileName) {
        SearchRepository searchRepository = new SearchRepository();
        Scanner scanner = new Scanner(System.in);
        BaseController baseController = new BaseController();
        BaseDTO base = baseController.base();
        dto.setName(base.getName());
        dto.setPrice(base.getPrice());
        dto.setQuantity(base.getQuantity());
        if (dto.getMemory() != null) {
            Integer memory;
            while (true) {
                System.out.print("Memory : ");
                String priceInput = scanner.next();
                try {
                    memory = Integer.parseInt(priceInput);
                    dto.setMemory(memory);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter a number only !!!");
                }
            }
        }
        if (dto.getDispley() != null) {
            Double displey;
            while (true) {
                System.out.print("Displey : ");
                String priceInput = scanner.next();
                try {
                    displey = Double.valueOf((priceInput));
                    dto.setDispley(displey);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter a number only !!!");
                }
            }
        }
        if (dto.getProtsessor() != null) {
            System.out.print("Protsessor : ");
            String protsessor = scanner.next();
            dto.setProtsessor(protsessor);
        }
        if (dto.getColor() != null) {
            System.out.print("Color : ");
            String color = scanner.next();
            dto.setColor(color);
        }
        searchRepository.update(fileName, dto);
    }

}
