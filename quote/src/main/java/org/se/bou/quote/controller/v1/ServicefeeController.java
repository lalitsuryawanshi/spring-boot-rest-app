package org.se.bou.quote.controller.v1;

import org.se.bou.quote.api.v1.model.ServicefeeDTO;
import org.se.bou.quote.api.v1.model.ServicefeeListDTO;
import org.se.bou.quote.service.ServicefeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ServicefeeController.BASE_URL)
public class ServicefeeController {

	public static final String BASE_URL = "/api/v1/servicefees";
	
	private final ServicefeeService servicefeeService;
	
	private ServicefeeController(ServicefeeService servicefeeService) {
		this.servicefeeService = servicefeeService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ServicefeeListDTO getListOfServicefees(){
		log.info("Sending {} List of Service fees ", 1 );
        return new ServicefeeListDTO(servicefeeService.getAllServicefees());
    }
	 
	@GetMapping({"/{servicefeeId}"})
	@ResponseStatus(HttpStatus.OK)
	public ServicefeeDTO getServicefeeById(@PathVariable Long servicefeeId){
	    return servicefeeService.getServicefeeById(servicefeeId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicefeeDTO createNewServicefee(@RequestBody ServicefeeDTO servicefeeDTO){
        return servicefeeService.createNewServicefee(servicefeeDTO);
    }

    @PutMapping({"/{servicefeeId}"})
    @ResponseStatus(HttpStatus.OK)
    public ServicefeeDTO updateServicefee(@PathVariable Long servicefeeId, @RequestBody ServicefeeDTO servicefeeDTO){
        return servicefeeService.updateServicefee(servicefeeId, servicefeeDTO);
    }

    @DeleteMapping({"/{servicefeeId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteServicefee(@PathVariable Long servicefeeId){
    		servicefeeService.deleteServicefeeById(servicefeeId);
    }
}
