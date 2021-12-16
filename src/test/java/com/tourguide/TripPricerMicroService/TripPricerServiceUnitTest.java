package com.tourguide.TripPricerMicroService;

import com.tourguide.TripPricerMicroService.service.impl.TripPricerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tripPricer.Provider;
import tripPricer.TripPricer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class TripPricerServiceUnitTest {

    @InjectMocks
    private TripPricerServiceImpl tripPricerService;

    @Mock
    TripPricer tripPricer;

    @Test
    public void testGetPrice() {
        //GIVEN
        String apiKey = "apiKey";
        UUID attractionId = UUID.randomUUID();
        int adults = 2;
        int children = 2;
        int nightsStay = 12;
        int rewardsPoints = 0;
        Provider provider1 = new Provider(UUID.randomUUID(), "Eiffel Tower", 1253);
        List<Provider> providerList = new ArrayList<>();
        providerList.add(provider1);

        Mockito.when(tripPricer.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints)).thenReturn(providerList);

        //WHEN
        List<Provider> providersReceived = tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);

        //THEN
        Mockito.verify(tripPricer, Mockito.times(1)).getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
        Assertions.assertEquals(providerList, providersReceived);
    }

    @Test
    public void testGetProviderName() {
        //GIVEN
        String apiKey = "apiKey";
        int adults = 2;
        String providerName = "providerName";

        Mockito.when(tripPricer.getProviderName(apiKey, adults)).thenReturn(providerName);

        //WHEN
        String providerNameReceived = tripPricerService.getProviderName(apiKey, adults);

        //THEN
        Mockito.verify(tripPricer, Mockito.times(1)).getProviderName(apiKey, adults);
        Assertions.assertEquals(providerName, providerNameReceived);
    }

}
