package com.tusen.springBootProject.service;

import com.tusen.springBootProject.entity.CatFactNinja;
import com.tusen.springBootProject.entity.CatFactNinjaCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CatFactNinjaServiceImpl implements CatFactNinjaService{

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Mono<CatFactNinjaCustom> callCatFactNinjaApi(String param1) {

        WebClient webClient = webClientBuilder.build();
        String apiUrl = String.format(param1);

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(CatFactNinja.class)
                .map(this::customResponse);
    }

    @Override
    public CatFactNinjaCustom customResponse(CatFactNinja catFactNinja) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        CatFactNinjaCustom catFactNinjaCustom = new CatFactNinjaCustom();
        catFactNinjaCustom.setMessage(catFactNinja.getFact());
        catFactNinjaCustom.setCurrentDateTime(formatter.format(date));
        return catFactNinjaCustom;

    }
}
