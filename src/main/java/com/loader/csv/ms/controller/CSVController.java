package com.loader.csv.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loader.csv.ms.message.ResponseMessage;
import com.loader.csv.ms.service.CSVService;

@Controller
@RequestMapping("/")
public class CSVController {

	String message = "";
	@Autowired
	CSVService csvService;
	
	@PostMapping
	public ResponseEntity<ResponseMessage> importData(@RequestParam("path") String path){
		
		try {
			csvService.save(path);
			message = "Data import success";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e) {
			message = "Data import error: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}
