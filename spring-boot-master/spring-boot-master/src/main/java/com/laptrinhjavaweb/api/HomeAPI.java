package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.NewDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPI {
	
	@GetMapping("/api/test")
    public ResponseEntity<String> testSpringBoot() {
        return ResponseEntity.ok("Success");
    }

	@PostMapping("/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return model;
    }
}
