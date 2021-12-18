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

    /**
     * Transmet une liste de Provider avec un prix en fonction des params.
     * @param apiKey la clé de l'API.
     * @param attractionId l'id de l'attraction.
     * @param adults le nombre d'adultes.
     * @param children le nombre d'enfants.
     * @param nightsStay le nombre de nuits du séjour.
     * @param rewardsPoints le nombre de points gagnés.
     * @return la liste de Provider personnalisée.
     */
    @GetMapping(path = "/getPrice")
    public List<Provider> getPrice(@RequestParam String apiKey, @RequestParam UUID attractionId, @RequestParam int adults, @RequestParam int children, @RequestParam int nightsStay, @RequestParam int rewardsPoints) {
        return tripPricerService.getPrice(apiKey, attractionId, adults, children, nightsStay, rewardsPoints);
    }

    /**
     * Transmet le nom du Provider en fonction des params.
     * @param apiKey la clé de l'API.
     * @param adults le nombre d'adultes.
     * @return le nom du Provider correspondant.
     */
    @GetMapping(path = "/getProviderName")
    public String getProviderName(@RequestParam String apiKey, @RequestParam int adults) {
        return tripPricerService.getProviderName(apiKey, adults);
    }
}
