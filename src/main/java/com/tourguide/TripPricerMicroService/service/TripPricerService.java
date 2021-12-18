package com.tourguide.TripPricerMicroService.service;

import tripPricer.Provider;

import java.util.List;
import java.util.UUID;

public interface TripPricerService {

    /**
     * Récupère une liste de Provider avec un prix en fonction des params.
     * @param apiKey la clé de l'API.
     * @param attractionId l'id de l'attraction.
     * @param adults le nombre d'adultes.
     * @param children le nombre d'enfants.
     * @param nightsStay le nombre de nuits du séjour.
     * @param rewardsPoints le nombre de points gagnés.
     * @return la liste de Provider personnalisée.
     */
    public List<Provider> getPrice(String apiKey, UUID attractionId, int adults, int children, int nightsStay, int rewardsPoints);

    /**
     * Récupère le nom du Provider en fonction des params.
     * @param apiKey la clé de l'API.
     * @param adults le nombre d'adultes.
     * @return le nom du Provider correspondant.
     */
    public String getProviderName(String apiKey, int adults);
}
