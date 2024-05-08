package service;

import dto.BaseDTO;
import dto.PhoneDTO;
import repository.PhoneRepository;

import java.time.LocalDate;
import java.util.List;
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

    public void allPhoneList() {
        PhoneRepository phoneRepository = new PhoneRepository();
        List<PhoneDTO> phoneDTOList = phoneRepository.getListPhone();
        if (phoneDTOList.isEmpty()){
            System.out.printf("\nFile is empty\n");
        }
        int count = 1;
        for (PhoneDTO phoneDTO : phoneDTOList) {
            if (count == 1) {
                System.out.println("===============================================");
            }
            System.out.println("id : " + count);
            System.out.println("Name : " + phoneDTO.getName());
            System.out.println("Category : " + phoneDTO.getCategory());
            System.out.println("Price : " + phoneDTO.getPrice());
            System.out.println("Quantity : " + phoneDTO.getQuantity());
            System.out.println("Memory : " + phoneDTO.getMemory());
            System.out.println("Color : " + phoneDTO.getColor());
            System.out.println("CreatedDate : " + phoneDTO.getCreatedDate());
            System.out.println("===============================================");
            count++;
        }
    }
}
