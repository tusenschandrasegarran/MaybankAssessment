package com.tusen.springBootProject.service;

import com.tusen.springBootProject.entity.CatFactNinja;
import com.tusen.springBootProject.entity.CatFactNinjaCustom;
import reactor.core.publisher.Mono;

public interface CatFactNinjaService {

    public Mono<CatFactNinjaCustom> callCatFactNinjaApi(String param1);

    public CatFactNinjaCustom customResponse(CatFactNinja catFactNinja);
}
