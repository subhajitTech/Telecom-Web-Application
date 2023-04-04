package com.casestudyserver.entities;

import com.casestudyserver.dto.GuestPlanSubscriptionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class GuestPlanSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Plan plan;

    public GuestPlanSubscriptionDto getGuestPlanSubscriptionDto(){
        GuestPlanSubscriptionDto guestPlanSubscriptionDto = new GuestPlanSubscriptionDto();
        guestPlanSubscriptionDto.setId(id);
        guestPlanSubscriptionDto.setPhoneNumber(phoneNumber);
        guestPlanSubscriptionDto.setCreatedDate(createdDate);
        guestPlanSubscriptionDto.setExpireAt(expireAt);
        guestPlanSubscriptionDto.setPlanId(plan.getId());
        guestPlanSubscriptionDto.setPlanCost(plan.getCost());
        guestPlanSubscriptionDto.setDuration(plan.getDuration());
        return guestPlanSubscriptionDto;
    }


}
