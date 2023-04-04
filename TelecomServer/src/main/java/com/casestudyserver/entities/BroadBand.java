package com.casestudyserver.entities;

import com.casestudyserver.dto.BroadBandSubscribeDto;
import com.casestudyserver.dto.BroadbandDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class BroadBand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float cost;

    private Long duration;

    private Date creationDate;

    private Boolean isActive;

    private Boolean isDeleted;

    public BroadbandDto getBroadbandDto() {
        BroadbandDto broadbandDto = new BroadbandDto();
        broadbandDto.setId(id);
        broadbandDto.setName(name);
        broadbandDto.setCost(cost);
        broadbandDto.setDuration(duration);
        broadbandDto.setCreationDate(creationDate);
        broadbandDto.setIsActive(isActive);
        broadbandDto.setIsDeleted(isDeleted);
        return broadbandDto;
    }

}
