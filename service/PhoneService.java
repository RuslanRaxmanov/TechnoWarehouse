package service;

import dto.BaseDTO;
import dto.PhoneDTO;
import repository.PhoneRepository;

import java.time.LocalDate;
import java.util.UUID;

public class PhoneService {
    public void createNewPhone(Integer memory, String color, BaseDTO base) {
        PhoneDTO dto = new PhoneDTO();
        dto.setName(base.getName());
        dto.setCategory("Phone");
        dto.setId(String.valueOf(UUID.randomUUID()));
        dto.setCreatedDate(LocalDate.now());
        dto.setQuantity(base.getQuantity());
        dto.setMemory(memory);
        dto.setColor(color);
        dto.setPrice(base.getPrice());
        PhoneRepository phoneRepository = new PhoneRepository();
        phoneRepository.addPhone(dto);
    }
}
