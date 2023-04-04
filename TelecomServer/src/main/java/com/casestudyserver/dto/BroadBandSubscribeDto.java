package com.casestudyserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BroadBandSubscribeDto {

    private  Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    private Long userId;

    private String username;

    private Long broadbandId;

    private String broadbandName;

    private Float broadbandCost;

    private Long broadbandDuration;


}
