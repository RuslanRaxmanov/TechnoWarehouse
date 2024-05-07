package controller;

import dto.BaseDTO;
import service.PhoneService;

import java.util.Scanner;

public class PhoneController {
    public void createNewPhone() {
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

        PhoneService phoneService = new PhoneService();
        phoneService.createNewPhone(memory, color, base);
    }
}
