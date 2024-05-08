package src.service;

import src.dto.UnversalDTO;

import java.util.List;

public class BaseService {
    public static void print(List<UnversalDTO> list) {
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
}
