package com.tourguide.TripPricerMicroService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TripPricerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetPrice() throws Exception {
        //GIVEN
        String apiKey = "apiKey";
        UUID attractionId = UUID.randomUUID();
        int adults = 2;
        int children = 2;
        int nightsStay = 12;
        int rewardsPoints = 0;

        //WHEN
        mockMvc.perform(get("/getPrice")
                        .param("apiKey", apiKey)
                        .param("attractionId", attractionId.toString())
                        .param("adults", String.valueOf(adults))
                        .param("children", String.valueOf(children))
                        .param("nightsStay", String.valueOf(nightsStay))
                        .param("rewardsPoints", String.valueOf(rewardsPoints)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //THEN
    }

    @Test
    public void testGetProviderName() throws Exception {
        //GIVEN
        String apiKey = "apiKey";
        int adults = 2;
        //WHEN
        mockMvc.perform(get("/getProviderName")
                        .param("apiKey", apiKey)
                        .param("adults", String.valueOf(adults)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //THEN
    }

}
