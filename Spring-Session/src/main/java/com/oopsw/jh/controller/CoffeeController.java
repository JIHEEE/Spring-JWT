package com.oopsw.jh.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oopsw.jh.dto.CoffeeDTO;
import com.oopsw.jh.service.impl.CoffeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/coffees")
@RequiredArgsConstructor
public class CoffeeController {
	
	private final CoffeeService coffeeService;
	
	@GetMapping
	public List<CoffeeDTO> getAllCoffees(HttpSession session){
		
		log.info("세션 아이디 : " + session.getId());
        log.info("사용자 이메일 주소 : " + String.valueOf(session.getAttribute("email")));
        log.info("권한 : " + String.valueOf(session.getAttribute("role")));
		
		return coffeeService.findAll().orElse(Collections.emptyList());
		
	}
	
}
