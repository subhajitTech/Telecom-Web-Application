package com.casestudyserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GuestBroadBandSubscriptionDto {

    private Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    private Long broadbandId;

    private Float broadbandCost;

    private Long broadbandDuration;

}
