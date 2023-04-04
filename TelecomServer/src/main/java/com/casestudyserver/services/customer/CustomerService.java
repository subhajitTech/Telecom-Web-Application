package com.casestudyserver.services.customer;

import com.casestudyserver.dto.*;
import com.casestudyserver.responce.GeneralResponse;

import java.util.List;

public interface CustomerService {

    GeneralResponse postPlan(PlanDto planDto);

    GeneralResponse postBroadband(BroadbandDto broadbandDto);

    List<PlanDto> getAllPlans();

    List<BroadbandDto> getAllBroadBands();

    PlanDto getPlanById(Long planId);

    BroadbandDto getBroadBandById(Long broadbandId);

    GeneralResponse subscribePlan(PlanSubscriptionDto planSubscriptionDto,Long planId);

    GeneralResponse subscribeBroadband(BroadBandSubscribeDto broadBandSubscribeDto,Long broadbandId);

    List<PlanSubscriptionDto> getAllSubscribedPlans(Long userId);

    List<BroadBandSubscribeDto> getAllSubscribedBroadBand(Long userId);
    UserDto getProfileByUserId(Long userId);

    GeneralResponse updateCustomerProfile(UserDto userDto,Long userId);

    List<PlanDto> getAllPlansForGuest();

    List<BroadbandDto> getAllBroadBandsForGuest();
}
