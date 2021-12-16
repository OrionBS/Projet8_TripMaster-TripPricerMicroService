package com.tourguide.TripPricerMicroService.service.impl;

import com.tourguide.TripPricerMicroService.service.TripPricerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.List;
import java.util.UUID;

@Service
public class TripPricerServiceImpl implements TripPricerService {
    private Logger logger = LoggerFactory.getLogger(TripPricerServiceImpl.class);
    private final TripPricer tripPricer;

    public TripPricerServiceImpl(TripPricer tripPricer) {
        this.tripPricer = tripPricer;
    }

    @Override
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints) {
        List<Provider> answer = tripPricer.getPrice(apiKey,attractionId,adults,children,nightsStay,rewardsPoints);
        logger.info("Call");
        logger.info("Answer "+answer);
        return answer;
    }

    @Override
    public String getProviderName(String apiKey, int adults) {
        logger.info("Call");
        return tripPricer.getProviderName(apiKey,adults);
    }
}
