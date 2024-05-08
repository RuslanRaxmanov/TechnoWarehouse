package src.service;

import src.dto.BaseDTO;
import src.dto.LaptopDTO;
import src.repository.LaptopRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class LaptopService {
    public void createNewLaptop(Integer memory, String color, String protsessor, Double displey, BaseDTO base) {
        LaptopDTO dto = new LaptopDTO();
        dto.setName(base.getName());
        dto.setCategory("Laptop");
        dto.setId(String.valueOf(UUID.randomUUID()));
        dto.setCreatedDate(LocalDate.now());
        dto.setQuantity(base.getQuantity());
        dto.setMemory(memory);
        dto.setProtsessor(protsessor);
        dto.setDispley(displey);
        dto.setColor(color);
        dto.setPrice(base.getPrice());
        LaptopRepository laptopRepository = new LaptopRepository();
        laptopRepository.addLaptop(dto);
    }
    public void allLaptopList() {
        LaptopRepository laptopRepository = new LaptopRepository();
        List<LaptopDTO> laptopDTOList = laptopRepository.getListLaptop();
        if (laptopDTOList.isEmpty()){
            System.out.printf("\nFile is empty\n");
        }
        int count = 1;
        for (LaptopDTO laptopDTO : laptopDTOList) {
            if (count == 1) {
                System.out.println("===============================================");
            }
            System.out.println("id : " + count);
            System.out.println("Name : " + laptopDTO.getName());
            System.out.println("Category : " + laptopDTO.getCategory());
            System.out.println("Price : " + laptopDTO.getPrice());
            System.out.println("Quantity : " + laptopDTO.getQuantity());
            System.out.println("Color : " + laptopDTO.getColor());
            System.out.println("Protsessor : " + laptopDTO.getProtsessor());
            System.out.println("Displey : " + laptopDTO.getDispley());
            System.out.println("Memory : " + laptopDTO.getMemory());
            System.out.println("CreatedDate : " + laptopDTO.getCreatedDate());
            System.out.println("===============================================");
            count++;
        }
    }
}
