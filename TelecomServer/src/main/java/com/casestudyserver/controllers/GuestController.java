package com.casestudyserver.controllers;

import com.casestudyserver.dto.GuestBroadBandSubscriptionDto;
import com.casestudyserver.dto.GuestPlanSubscriptionDto;
import com.casestudyserver.responce.GeneralResponse;
import com.casestudyserver.services.guest.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/guest/")
@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("plans")
    public GeneralResponse getAllPlansForGuest() {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(guestService.getAllPlansForGuest());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
        }
        return response;
    }

    @GetMapping("broadBands")
    public GeneralResponse getAllBroadBandsForGuest() {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(guestService.getAllBroadBandsForGuest());
            response.setStatus(HttpStatus.OK);
            response.setMessage("BroadBands Fetched Successfully!!!");
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
        }
        return response;
    }

    @GetMapping("plan/{planId}")
    public GeneralResponse getPlanById(@PathVariable Long planId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(guestService.getPlanById(planId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("Plans Fetched Successfully!!!");
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
        }
        return response;
    }

    @GetMapping("broadBand/{broadbandId}")
    public GeneralResponse getBroadBandById(@PathVariable Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        try {
            response.setData(guestService.getBroadBandById(broadbandId));
            response.setStatus(HttpStatus.OK);
            response.setMessage("BroadBands Fetched Successfully!!!");
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
        }
        return response;
    }

    @PostMapping("subscribe-plan/{planId}")
    public GeneralResponse subscribePlan(@RequestBody GuestPlanSubscriptionDto guestPlanSubscriptionDto, @PathVariable Long planId) {
        GeneralResponse response = new GeneralResponse();
        try {
            return guestService.subscribePlan(guestPlanSubscriptionDto,planId);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
        }
        return response;
    }

    @PostMapping("subscribe-broadband/{broadbandId}")
    public GeneralResponse subscribeBroadband(@RequestBody GuestBroadBandSubscriptionDto guestBroadBandSubscriptionDto, @PathVariable Long broadbandId) {
        GeneralResponse response = new GeneralResponse();
        try {
            return guestService.subscribeBroadband(guestBroadBandSubscriptionDto,broadbandId);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Sorry Something Wrong Happened.");
        }
        return response;
    }

}
