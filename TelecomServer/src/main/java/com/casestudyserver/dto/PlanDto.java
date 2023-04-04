package com.casestudyserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PlanDto {

    private  Long id;

    private String name;

    private Float cost;

    private Long duration;

    private Date creationDate;

    private Boolean isActive;

    private Boolean isDeleted;
}
