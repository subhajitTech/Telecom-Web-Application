package com.casestudyserver.services.guest;

import com.casestudyserver.dto.*;
import com.casestudyserver.entities.*;
import com.casestudyserver.repos.*;
import com.casestudyserver.responce.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestPlanSubscriptionRepo guestPlanSubscriptionRepo;

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private BroadBandRepo broadBandRepo;

    @Autowired
    private GuestBroadBandSubscriptionRepo guestBroadBandSubscriptionRepo;

    @Override
    public List<PlanDto> getAllPlansForGuest() {
        return plansRepo.findAll().stream().map(Plan::getPlansDto).collect(Collectors.toList());
    }

    @Override
    public List<BroadbandDto> getAllBroadBandsForGuest() {
        return broadBandRepo.findAll().stream().map(BroadBand::getBroadbandDto).collect(Collectors.toList());
    }

    @Override
    public PlanDto getPlanById(Long planId) {
        PlanDto planDto = null;
        Optional<Plan> optionalPlan = plansRepo.findById(planId);
        if (optionalPlan.isPresent()) {
            planDto = optionalPlan.get().getPlansDto();
        }
        return planDto;
    }

    @Override
    public BroadbandDto getBroadBandById(Long broadbandId) {
        BroadbandDto broadbandDto = null;
        Optional<BroadBand> optionalBroadBand = broadBandRepo.findById(broadbandId);
        if (optionalBroadBand.isPresent()) {
            broadbandDto = optionalBroadBand.get().getBroadbandDto();
        }
        return broadbandDto;
    }

    @Override
    public GeneralResponse subscribePlan(GuestPlanSubscriptionDto guestPlanSubscriptionDto, Long planId) {
        GeneralResponse response = new GeneralResponse();
        Optional<Plan> optionalPlan = plansRepo.findById(planId);
        if (optionalPlan.isPresent()) {
            GuestPlanSubscription guestPlanSubscription = new GuestPlanSubscription();
            guestPlanSubscription.setPhoneNumber(guestPlanSubscriptionDto.getPhoneNumber());
            guestPlanSubscription.setCreatedDate(new Date());
            guestPlanSubscription.setExpireAt(guestPlanSubscriptionDto.getExpireAt());
            guestPlanSubscription.setPlan(optionalPlan.get());
            guestPlanSubscriptionRepo.save(guestPlanSubscription);
            response.setMessage("Plan subscribed Successfully");
            response.setStatus(HttpStatus.CREATED);
        } else {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("Plan not found!");
        }
        return response;
    }

    @Override
    public GeneralResponse subscribeBroadband(GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto, Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        Optional<BroadBand> optionalBroadBand = broadBandRepo.findById(broadbandId);
        if (optionalBroadBand.isPresent()) {
            GuestBroadBandSubscription guestBroadBandSubscription = new GuestBroadBandSubscription();
            guestBroadBandSubscription.setPhoneNumber(guestBroadBandSubscriptionDto.getPhoneNumber());
            guestBroadBandSubscription.setCreatedDate(new Date());
            guestBroadBandSubscription.setExpireAt(guestBroadBandSubscriptionDto.getExpireAt());
            guestBroadBandSubscription.setBroadBand(optionalBroadBand.get());
            guestBroadBandSubscriptionRepo.save(guestBroadBandSubscription);
            response.setMessage("BroadBand subscribed Successfully");
            response.setStatus(HttpStatus.CREATED);
        } else {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            response.setMessage("BroadBand not found!");
        }
        return response;
    }

}
