package src.controller;

import src.dto.BaseDTO;
import src.service.TVService;

import java.util.Scanner;

public class TVController {
    public void createNewTV() {
        Scanner scanner = new Scanner(System.in);
        BaseController baseController = new BaseController();
        BaseDTO base = baseController.base();
        Double displey;
        while (true) {
            System.out.print("Displey : ");
            String priceInput = scanner.next();
            try {
                displey = Double.valueOf((priceInput));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Xatolik: Faqat raqam kiriting.");
            }
        }
        TVService tvService = new TVService();
        tvService.createNewTV(displey, base);

    }
}
