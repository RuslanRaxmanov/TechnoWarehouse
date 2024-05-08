package service;

import dto.BaseDTO;
import dto.TVDTO;
import repository.TVRepository;

import java.time.LocalDate;
import java.util.List;
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

    public void allTvList() {
        TVRepository tvRepository = new TVRepository();
        List<TVDTO> tvdtoList = tvRepository.getListTv();
        if (tvdtoList.isEmpty()) {
            System.out.printf("\nFile is empty\n");
        }
        int count = 1;
        for (TVDTO tvdto : tvdtoList) {
            if (count == 1) {
                System.out.println("===============================================");
            }
            System.out.println("id : " + count);
            System.out.println("Name : " + tvdto.getName());
            System.out.println("Category : " + tvdto.getCategory());
            System.out.println("Price : " + tvdto.getPrice());
            System.out.println("Quantity : " + tvdto.getQuantity());
            System.out.println("Displey : " + tvdto.getDispley());
            System.out.println("CreatedDate : " + tvdto.getCreatedDate());
            System.out.println("===============================================");
            count++;
        }
    }
}
