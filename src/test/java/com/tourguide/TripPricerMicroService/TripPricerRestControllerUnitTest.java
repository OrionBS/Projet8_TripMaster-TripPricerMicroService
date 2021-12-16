package com.tourguide.TripPricerMicroService;

import com.tourguide.TripPricerMicroService.restController.TripPricerRestController;
import com.tourguide.TripPricerMicroService.service.impl.TripPricerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tripPricer.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class TripPricerRestControllerUnitTest {

    @InjectMocks
    TripPricerRestController tripPricerRestController;

    @Mock
    TripPricerServiceImpl tripPricerService;

    @Test
    public void testGetPrice() {
        //GIVEN
        String apiKey = "apiKey";
        UUID attractionId = UUID.randomUUID();
        int adults = 2;
        int children = 2;
        int nightsStay = 12;
        int rewardsPoints = 0;
        Provider provider1 = new Provider(UUID.randomUUID(),"Eiffel Tower",1253);
        List<Provider> providerList = new ArrayList<>();
        providerList.add(provider1);

        Mockito.when(tripPricerService.getPrice(apiKey,attractionId,adults,children,nightsStay,rewardsPoints)).thenReturn(providerList);

        //WHEN
        List<Provider> providersReceived = tripPricerRestController.getPrice(apiKey,attractionId,adults,children,nightsStay,rewardsPoints);

        //THEN
        Mockito.verify(tripPricerService, Mockito.times(1)).getPrice(apiKey,attractionId,adults,children,nightsStay,rewardsPoints);
        Assertions.assertEquals(providerList,providersReceived);
    }

    @Test
    public void testGetProviderName() {
        //GIVEN
        String apiKey = "apiKey";
        int adults = 2;
        String providerName = "providerName";

        Mockito.when(tripPricerService.getProviderName(apiKey,adults)).thenReturn(providerName);

        //WHEN
        String providerNameReceived = tripPricerRestController.getProviderName(apiKey,adults);

        //THEN
        Mockito.verify(tripPricerService, Mockito.times(1)).getProviderName(apiKey,adults);
        Assertions.assertEquals(providerName,providerNameReceived);
    }
}
