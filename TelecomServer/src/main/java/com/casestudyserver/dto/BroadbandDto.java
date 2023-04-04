package com.casestudyserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BroadbandDto {

    private Long id;

    private String name;

    private Float cost;

    private Long duration;

    private Date creationDate;

    private Boolean isActive;

    private Boolean isDeleted;

}
