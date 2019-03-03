package com.mcy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

	@Autowired
	SecondService service;

	@PostMapping("/post-service")
	public Response restService(@RequestBody Request request) {
		return new Response(request.getRequestValue1() + service.getValue(), request.getRequestValue2());
	}

}
