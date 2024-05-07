package controller;

import dto.BaseDTO;

import java.util.Scanner;

public class BaseController {
    private Double from, upTo;

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

}
