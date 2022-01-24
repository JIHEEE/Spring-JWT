package com.oopsw.jh.provider.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oopsw.jh.core.service.CoffeeUseCase;
import com.oopsw.jh.core.service.dto.CoffeeDTO;

@Service
public class CoffeeService implements CoffeeUseCase {

    @Override
    public Optional<List<CoffeeDTO>> findAll() {
        return Optional.of(
                Arrays.asList(CoffeeDTO.builder().name("latte").price(1200).build(), CoffeeDTO.builder().name("americano").price(900).build())
        );
    }
}
