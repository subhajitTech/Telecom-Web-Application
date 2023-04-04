package com.casestudyserver.entities;

import com.casestudyserver.dto.GuestBroadBandSubscriptionDto;
import com.casestudyserver.dto.GuestPlanSubscriptionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class GuestBroadBandSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "broadBand_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BroadBand broadBand;

    public GuestBroadBandSubscriptionDto getGuestBroadBandSubscriptionDto(){
        GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto = new GuestBroadBandSubscriptionDto();
        guestBroadBandSubscriptionDto.setId(id);
        guestBroadBandSubscriptionDto.setPhoneNumber(phoneNumber);
        guestBroadBandSubscriptionDto.setCreatedDate(createdDate);
        guestBroadBandSubscriptionDto.setExpireAt(expireAt);
        guestBroadBandSubscriptionDto.setBroadbandId(broadBand.getId());
        guestBroadBandSubscriptionDto.setBroadbandCost(broadBand.getCost());
        guestBroadBandSubscriptionDto.setBroadbandDuration(broadBand.getDuration());
        return guestBroadBandSubscriptionDto;
    }

}
