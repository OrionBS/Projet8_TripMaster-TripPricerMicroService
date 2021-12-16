package com.tourguide.TripPricerMicroService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tripPricer.TripPricer;

import java.util.Locale;

@Configuration
public class TripPricerMicroServiceModule {

    @Bean
    public TripPricer getTripPricer() {
        Locale.setDefault(Locale.ENGLISH);
        return new TripPricer();
    }

}
