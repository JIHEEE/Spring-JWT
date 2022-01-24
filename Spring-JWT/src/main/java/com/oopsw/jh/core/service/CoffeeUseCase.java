package com.oopsw.jh.core.service;

import java.util.List;
import java.util.Optional;

import com.oopsw.jh.core.service.dto.CoffeeDTO;

public interface CoffeeUseCase {
    Optional<List<CoffeeDTO>> findAll();
}
