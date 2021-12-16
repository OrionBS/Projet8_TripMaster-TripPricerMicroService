package com.tourguide.TripPricerMicroService.restController;

import com.tourguide.TripPricerMicroService.service.TripPricerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

@RestController
public class TripPricerRestController {

    private final TripPricerService tripPricerService;

    public TripPricerRestController(TripPricerService tripPricerService) {
        this.tripPricerService = tripPricerService;
    }

    @GetMapping(path = "/getPrice")
    public List<Provider> getPrice(@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints) {
        return tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }

    @GetMapping(path = "/getProviderName")
    public String getProviderName(@RequestParam String apiKey, @RequestParam int adults) {
        return tripPricerService.getProviderName(apiKey, adults);
    }
}
