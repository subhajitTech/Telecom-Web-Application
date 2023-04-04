package com.casestudyserver.entities;

import com.casestudyserver.dto.BroadBandSubscribeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class BroadBandSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;

    private Date createdDate;

    private Date expireAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "broadBand_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BroadBand broadBand;

    public BroadBandSubscribeDto getSubscriptionBroadBandDto() {
        BroadBandSubscribeDto broadBandSubscribeDto = new BroadBandSubscribeDto();
        broadBandSubscribeDto.setId(id);
        broadBandSubscribeDto.setPhoneNumber(phoneNumber);
        broadBandSubscribeDto.setCreatedDate(createdDate);
        broadBandSubscribeDto.setExpireAt(expireAt);
        broadBandSubscribeDto.setBroadbandId(broadBand.getId());
        broadBandSubscribeDto.setBroadbandName(broadBand.getName());
        broadBandSubscribeDto.setBroadbandCost(broadBand.getCost());
        broadBandSubscribeDto.setBroadbandDuration(broadBand.getDuration());
        broadBandSubscribeDto.setUserId(user.getId());
        broadBandSubscribeDto.setUsername(user.getName());
        return broadBandSubscribeDto;

    }

}
