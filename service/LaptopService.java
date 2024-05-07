package service;

import dto.BaseDTO;
import dto.LaptopDTO;
import repository.LaptopRepository;

import java.time.LocalDate;
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
}
