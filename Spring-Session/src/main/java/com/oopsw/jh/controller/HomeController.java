package com.oopsw.jh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1/homeCoffees")
public class HomeController {
	
	@GetMapping
	public String getCoffee(HttpSession session, HttpServletRequest httpServletRequest) {
		
		log.info(session.getId()); // session : 872CFD4EFF7C5E0D5A367BF086B9476E
		
		return "coffee";
		
	}
	
}
