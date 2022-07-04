/**
 * 
 */
package com.adp.changeabill.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adp.changeabill.dto.ChangeResponse;
import com.adp.changeabill.service.BillService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ganjinav
 *
 */
@RestController
@Validated
@Slf4j
public class BillController {
	
	@Autowired
	private BillService billService;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ChangeResponse getAChange(@RequestParam @Min(1) @Max(100) long bill) {
		
		log.info("Entering changeabill controller");
		
		return billService.getChange(bill);
	}
	
	@PostMapping(value = "/reset")
	public String resetChange() {
		
		billService.resetChange();
		
		return "Success";
	}
}