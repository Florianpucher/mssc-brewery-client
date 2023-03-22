package com.florian.msscbreweryclient.web.client;

import com.florian.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH = "/api/v1/beer";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID id) {
        return restTemplate.getForObject(apiHost + BEER_PATH + "/" + id.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto dto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH, dto);
    }

    public void updateBeer(UUID id, BeerDto dto) {
        restTemplate.put(apiHost + BEER_PATH + "/" + id.toString(), dto);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

}
