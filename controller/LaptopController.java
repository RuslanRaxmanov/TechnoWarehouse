package controller;

import dto.BaseDTO;
import service.LaptopService;

import java.util.Scanner;

public class LaptopController {
    public void createNewLaptop() {
        Scanner scanner = new Scanner(System.in);
        BaseController baseController = new BaseController();
        BaseDTO base = baseController.base();
        Integer memory;
        while (true) {
            System.out.print("Memory : ");
            String priceInput = scanner.next();
            try {
                memory = Integer.parseInt(priceInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a number only !!!");
            }
        }

        System.out.print("Color : ");
        String color = scanner.next();

        System.out.print("Protsessor : ");
        String protsessor = scanner.next();

        Double displey;
        while (true) {
            System.out.print("Displey : ");
            String priceInput = scanner.next();
            try {
                displey = Double.valueOf((priceInput));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a number only !!!");
            }
        }
        LaptopService laptopService = new LaptopService();
        laptopService.createNewLaptop(memory, color, protsessor, displey, base);
    }
}
