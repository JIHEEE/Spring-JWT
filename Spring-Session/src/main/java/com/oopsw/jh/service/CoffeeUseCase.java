package com.oopsw.jh.service;

import java.util.List;
import java.util.Optional;

import com.oopsw.jh.dto.CoffeeDTO;

public interface CoffeeUseCase {
    Optional<List<CoffeeDTO>> findAll();
}
