package com.oopsw.jh.core.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoffeeDTO {

    private String name;
    private Integer price;

}
