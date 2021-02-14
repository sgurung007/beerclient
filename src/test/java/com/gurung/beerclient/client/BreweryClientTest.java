package com.gurung.beerclient.client;

import com.gurung.beerclient.model.BeerDto;
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
        BeerDto dto=client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
//        given
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();

        URI uri=client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testPutBeer(){
        BeerDto beerDto=BeerDto.builder().beerName("New New Beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void testDeleteBeer(){
        BeerDto.builder().beerName("Delete New Beer").build();
        client.deleteBeer(UUID.randomUUID());
    }
}