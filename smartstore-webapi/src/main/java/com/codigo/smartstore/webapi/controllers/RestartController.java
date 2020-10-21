package com.codigo.smartstore.webapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codigo.smartstore.webapi.SmartstoreWebapiApplication;

@RestController
public class RestartController {

	@PostMapping("/restart")
	public void restart() {

		SmartstoreWebapiApplication.restart();
	}
}
