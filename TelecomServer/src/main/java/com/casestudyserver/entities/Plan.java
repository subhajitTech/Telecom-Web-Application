package com.casestudyserver.entities;

import com.casestudyserver.dto.PlanDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plans")
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    private Float cost;

    private Long duration;

    private Date creationDate;

    private Boolean isActive;

    private Boolean isDeleted;
    public PlanDto getPlansDto(){
        PlanDto planDto = new PlanDto();
        planDto.setId(id);
        planDto.setName(name);
        planDto.setCost(cost);
        planDto.setDuration(duration);
        planDto.setCreationDate(creationDate);
        planDto.setIsActive(isActive);
        planDto.setIsDeleted(isDeleted);
        return planDto;
    }
}
