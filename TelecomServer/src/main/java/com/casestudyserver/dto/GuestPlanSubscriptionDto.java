package com.casestudyserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GuestPlanSubscriptionDto {

    private  Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    private Long planId;

    private Float planCost;

    private Long duration;

}
