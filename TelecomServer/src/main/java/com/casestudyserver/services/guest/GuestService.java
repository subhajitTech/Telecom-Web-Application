package com.casestudyserver.services.guest;

import com.casestudyserver.dto.*;
import com.casestudyserver.responce.GeneralResponse;

import java.util.List;

public interface GuestService {

    List<PlanDto> getAllPlansForGuest();

    List<BroadbandDto> getAllBroadBandsForGuest();

    PlanDto getPlanById(Long planId);

    BroadbandDto getBroadBandById(Long broadbandId);

    GeneralResponse subscribePlan(GuestPlanSubscriptionDto guestPlanSubscriptionDto,Long planId);

    GeneralResponse subscribeBroadband(GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto,Long broadbandId);

}
