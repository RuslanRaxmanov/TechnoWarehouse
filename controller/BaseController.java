package controller;

import dto.*;
import repository.LaptopRepository;
import repository.PhoneRepository;
import repository.SearchRepository;
import repository.TVRepository;

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

}
