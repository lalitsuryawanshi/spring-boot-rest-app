package org.se.bou.quote.controller.v1;

import org.se.bou.quote.api.v1.model.ExtrafeeDTO;
import org.se.bou.quote.api.v1.model.ExtrafeeListDTO;
import org.se.bou.quote.service.ExtrafeeService;
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
@RequestMapping(ExtrafeeController.BASE_URL)
public class ExtrafeeController {

	public static final String BASE_URL = "/api/v1/extrafees";
	
	private final ExtrafeeService extrafeeService;
	
	private ExtrafeeController(ExtrafeeService extrafeeService) {
		this.extrafeeService = extrafeeService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ExtrafeeListDTO getListOfExtrafees(){
		log.info("Sending {} List of Extrafees ", 1 );
        return new ExtrafeeListDTO(extrafeeService.getAllExtrafees());
    }
	 
	@GetMapping({"/{extrafeeId}"})
	@ResponseStatus(HttpStatus.OK)
	public ExtrafeeDTO getExtrafeeById(@PathVariable Long extrafeeId){
	    return extrafeeService.getExtrafeeById(extrafeeId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExtrafeeDTO createNewExtrafee(@RequestBody ExtrafeeDTO extrafeeDTO){
        return extrafeeService.createNewExtrafee(extrafeeDTO);
    }

    @PutMapping({"/{extrafeeId}"})
    @ResponseStatus(HttpStatus.OK)
    public ExtrafeeDTO updateExtrafee(@PathVariable Long extrafeeId, @RequestBody ExtrafeeDTO extrafeeDTO){
        return extrafeeService.updateExtrafee(extrafeeId, extrafeeDTO);
    }

    @DeleteMapping({"/{extrafeeId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteExtrafee(@PathVariable Long extrafeeId){
    		extrafeeService.deleteExtrafeeById(extrafeeId);
    }
}
