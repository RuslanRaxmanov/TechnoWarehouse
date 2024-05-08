
package controller;

import java.util.Scanner;

public class MainController {
    public void start() {
        BaseController baseController = new BaseController();
        SearchController searchController = new SearchController();
        showMenu();
        boolean b = true;
        while (b) {
            menu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter action: ");
            String action = scanner.next();
            switch (action) {
                case "1":
                    createNewProduct();
                    break;
                case "2":
                    searchController.searchByNameMenu();
                    break;
                case "3":
                    searchController.categorySearch();
                    break;
                case "4":
                    baseController.rangeInput();
                    break;
                case "5":
                    break;
                case "6":
                    about();
                    break;
                case "0":
                    System.out.println("Program Finished");
                    b = false;
                    break;
                default:
                    System.out.println("Select from the menu !!!");
            }
        }
    }

    private void createNewProduct() {
        PhoneController phoneController = new PhoneController();
        LaptopController laptopController = new LaptopController();
        TVController tvController = new TVController();
        showCategory();
        boolean b = true;
        while (b) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter action: ");
            String action = scanner.next();
            switch (action) {
                case "1":
                    phoneController.createNewPhone();
                    b = false;
                    break;
                case "2":
                    laptopController.createNewLaptop();
                    b = false;
                    break;
                case "3":
                    tvController.createNewTV();
                    b = false;
                    break;
                case "0":
                    System.out.print(" \n You have reached the main menu \n \n");
                    b = false;
                    break;
                default:
                    System.out.println("Select from the menu !!!");
            }
        }
    }

    private void showCategory() {
        String category = """
                \n** Category List **
                1. Phone 
                2. Laptop
                3. Tv
                0. Exit
                """;
        System.out.println(category);
    }

    public void showMenu() {
        String header = """
                                                     Techno Werehouse    
                                                                                    
                    System operation manual: to work in the system, you need to select sections using  
                the numbers shown in the menu and press the Enter button, you need to select 0 to go back \n                                   
                """;
        System.out.println(header);
    }

    public void menu() {
        String menu = """
                   *** Menu ***
                1. Add Techno
                2. Search by Name
                3. Search by Category
                4. Search by price range
                5. Techno All List
                6. About
                0. Exit
                """;
        System.out.println(menu);
    }

    private void about() {
        String about = """
                 ___ Information about the developer ____
                |           Name : Ruslan                |
                |        Surname : Raxmanov              |
                |            Age : 18                    |
                |   Email : milleniumeye17@gmail.com     |
                |________________________________________|
                """;
        System.out.println(about);
    }

}
