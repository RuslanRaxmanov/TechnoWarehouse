package controller;

import dto.UnversalDTO;
import service.LaptopService;
import service.PhoneService;
import service.SearchService;
import service.TVService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SearchController {
    private boolean sort = true;
    private List<UnversalDTO> responsList = null;
    private SearchService searchService = new SearchService();

    public void searchByNameMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================");
        boolean b = true;
        while (b) {
            showSearchName();
            System.out.print("Enter action: ");
            String action = scanner.next();
            switch (action) {
                case "1":
                    responsList = searchByName();
                    break;
                case "2":
                    sortData(responsList);
                    break;
                case "3":
                    productDelete(responsList);
                    break;
                case "4":
                    productUpdate(responsList);
                    break;
                case "0":
                    b = false;
                    responsList = null;
                    break;
                default:
                    System.out.println("Select from the menu !!!");
            }
        }
    }

    private List<UnversalDTO> searchByName() {
        SearchService searchService = new SearchService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product name : ");
        String name = scanner.next();
        List<UnversalDTO> universalDtoList = searchService.searchName(name);
        return universalDtoList;
    }

    private void sortData(List<UnversalDTO> unversalDTOS) {
        if (responsList == null) {
            System.out.println("\n No information found");
            return;
        }
        SearchService searchService = new SearchService();
        if (sort == true) {
            Collections.sort(unversalDTOS, new Comparator<UnversalDTO>() {
                @Override
                public int compare(UnversalDTO o1, UnversalDTO o2) {
                    return o1.getCreatedDate().compareTo(o2.getCreatedDate());
                }
            });
            sort = false;
            searchService.sortDate(unversalDTOS);
        } else if (sort == false) {
            Collections.sort(unversalDTOS, new Comparator<UnversalDTO>() {
                @Override
                public int compare(UnversalDTO o1, UnversalDTO o2) {
                    return o2.getCreatedDate().compareTo(o1.getCreatedDate());
                }
            });
            sort = true;
            searchService.sortDate(unversalDTOS);
        }
    }

    private void productDelete(List<UnversalDTO> responsList) {
        if (responsList == null) {
            System.out.println("\n No information found");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        Integer id;
        while (true) {
            System.out.print("Enter the product id : ");
            String priceInput = scanner.next();
            try {
                id = Integer.parseInt(priceInput);
                if (responsList.size() >= id-1) {
                    delete(responsList, id-1);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter only existing ids");
            }
        }
    }

    public void delete(List<UnversalDTO> responsList, Integer id) {
        for (UnversalDTO dto : responsList) {
            if (dto.getId() == responsList.get(id).getId()) {
                if (dto.getCategory().equals("Phone")) {
                    searchService.delete(dto.getId(), "phone");
                }
                if (dto.getCategory().equals("Tv")) {
                    searchService.delete(dto.getId(), "tv");
                }
                if (dto.getCategory().equals("Laptop")) {
                    searchService.delete(dto.getId(), "laptop");
                }
            }
        }
    }

    private void productUpdate(List<UnversalDTO> responsList) {
        if (responsList == null) {
            System.out.println("\n No information found");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        Integer id;
        while (true) {
            System.out.print("Enter the product id : ");
            String priceInput = scanner.next();
            try {
                id = Integer.parseInt(priceInput);
                if (responsList.size() >= id-1) {
                    update(responsList, id-1);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter only existing ids");
            }
        }
    }

    private void update(List<UnversalDTO> responsList, Integer id) {
        for (UnversalDTO dto : responsList) {
            if (dto.getId() == responsList.get(id).getId()) {
                if (dto.getCategory().equals("Phone")) {
                    searchService.update(dto, "phone");
                }
                if (dto.getCategory().equals("Tv")) {
                    searchService.update(dto, "tv");
                }
                if (dto.getCategory().equals("Laptop")) {
                    searchService.update(dto, "laptop");
                }
            }
        }
    }

    public void categorySearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================");
        boolean b = true;
        while (b) {
            showCategory();
            System.out.print("Enter action: ");
            String action = scanner.next();
            switch (action) {
                case "1" -> phone();
                case "2" -> laptop();
                case "3" -> tv();
                case "0" -> b = false;
                default -> System.out.println("Select from the menu !!!");
            }
        }
    }   private void tv() {
        TVService tvService = new TVService();
        tvService.allTvList();
    }

    private void laptop() {
        LaptopService laptopService = new LaptopService();
        laptopService.allLaptopList();
    }

    private void phone() {
        PhoneService phoneService = new PhoneService();
        phoneService.allPhoneList();
    }

    private void showSearchName() {
        String list = """
                \n***  Search chances ***
                1. Search by Name
                2. Sort by data
                3. Delete a product
                4. Update a product
                0. Exit              
                """;
        System.out.println(list);
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
}
