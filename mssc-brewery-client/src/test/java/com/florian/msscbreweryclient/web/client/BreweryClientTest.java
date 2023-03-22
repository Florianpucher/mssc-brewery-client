package com.florian.msscbreweryclient.web.client;

import com.florian.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto dto = BeerDto.builder().id(UUID.randomUUID()).beerName("foo").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerById() {
        BeerDto dto = BeerDto.builder().id(UUID.randomUUID()).beerName("foo").build();
        client.updateBeer(UUID.randomUUID(), dto);
    }
}