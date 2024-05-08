package src.controller;

import src.dto.*;
import src.repository.LaptopRepository;
import src.repository.PhoneRepository;
import src.repository.SearchRepository;
import src.repository.TVRepository;
import src.service.BaseService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BaseController {
    private Double from, upTo;

    public List<UnversalDTO> get() {
        SearchRepository searchRepository = new SearchRepository();
        LaptopRepository laptopRepository = new LaptopRepository();
        TVRepository tvRepository = new TVRepository();
        PhoneRepository phoneRepository = new PhoneRepository();

        List<PhoneDTO> phoneDTOList = phoneRepository.getListPhone();
        List<TVDTO> tvdtoList = tvRepository.getListTv();
        List<LaptopDTO> laptopDTOList = laptopRepository.getListLaptop();
        List<UnversalDTO> list = searchRepository.fullData(phoneDTOList, laptopDTOList, tvdtoList);
        return list;
    }

    public BaseDTO base() {
        BaseDTO baseDTO = new BaseDTO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name : ");
        String name = scanner.next();

        Double price;
        while (true) {
            System.out.print("Price: ");
            Scanner scanner1 = new Scanner(System.in);
            String priceInput = scanner1.next();
            try {
                price = Double.parseDouble(priceInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a number only !!!");
            }
        }
        Integer quantity;
        while (true) {
            System.out.print("Quantity : ");
            String priceInput = scanner.next();
            try {
                quantity = Integer.parseInt(priceInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a number only !!!");
            }
        }
        baseDTO.setName(name);
        baseDTO.setPrice(price);
        baseDTO.setQuantity(quantity);
        return baseDTO;
    }

    public void rangeInput() {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.print("From price : ");
            String priceInput = scanner.next();
            try {
                from = Double.parseDouble(priceInput);
                b = false;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a number only !!!");
            }

            while (true) {
                System.out.print("Up to Price : ");
                String price = scanner.next();
                try {
                    if (from <= Double.parseDouble(price)) {
                        upTo = Double.parseDouble(price);
                        break;
                    }
                    System.out.println("Up to the price will not be less than the price");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter a number only !!!");
                }
            }
            rangePrice(from, upTo);
        }
    }

    public void rangePrice(Double from, Double upTo) {
        List<UnversalDTO> list = get();
        int count = 1;
        for (UnversalDTO unversalDTO : list) {
            if (unversalDTO.getPrice() >= from && unversalDTO.getPrice() <= upTo) {
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
    }

    public void allTechno() {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            showMenu();
            System.out.print("Enter action: ");
            String action = scanner.next();
            switch (action) {
                case "1":
                    getAllTechno(true);
                    break;
                case "2":
                    getAllTechno(false);
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    System.out.println("Select from the menu !!!");
            }
        }
    }

    public void getAllTechno(Boolean sortDate) {
        List<UnversalDTO> list = get();
        Collections.sort(list, new Comparator<UnversalDTO>() {
            @Override
            public int compare(UnversalDTO o1, UnversalDTO o2) {
                if (sortDate == true) {
                    return o2.getCreatedDate().compareTo(o1.getCreatedDate());
                }
                return o1.getCreatedDate().compareTo(o2.getCreatedDate());
            }
        });
        BaseService.print(list);
    }

    public void showMenu() {
        String menuSort = """
                \n1. New Products 
                2. Old Products 
                0. Exit
                """;
        System.out.println(menuSort);
    }

}
