package service;

import dto.BaseDTO;
import dto.TVDTO;
import repository.TVRepository;

import java.time.LocalDate;
import java.util.UUID;

public class TVService {
    public void createNewTV(Double displey, BaseDTO base) {
        TVDTO dto = new TVDTO();
        dto.setName(base.getName());
        dto.setCategory("Tv");
        dto.setId(String.valueOf(UUID.randomUUID()));
        dto.setCreatedDate(LocalDate.now());
        dto.setQuantity(base.getQuantity());
        dto.setDispley(displey);
        dto.setPrice(base.getPrice());
        TVRepository tvRepository = new TVRepository();
        tvRepository.addTV(dto);
    }

}
