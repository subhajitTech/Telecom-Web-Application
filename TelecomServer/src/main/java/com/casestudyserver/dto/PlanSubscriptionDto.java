package com.casestudyserver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PlanSubscriptionDto {

    private  Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    private Long userId;

    private String username;

    private Long planId;

    private String planName;

    private Float planCost;

    private Long duration;

}

