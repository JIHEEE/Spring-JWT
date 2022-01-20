package com.oopsw.jh.service.impl;


import org.springframework.stereotype.Service;

import com.oopsw.jh.dto.CoffeeDTO;
import com.oopsw.jh.service.CoffeeUseCase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService implements CoffeeUseCase {

    @Override
    public Optional<List<CoffeeDTO>> findAll() {
        return Optional.of(
                Arrays.asList(CoffeeDTO.builder().name("latte").price(1200).build(), CoffeeDTO.builder().name("americano").price(900).build())
        );
    }
    
}
