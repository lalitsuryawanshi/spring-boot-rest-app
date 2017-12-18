package org.se.bou.quote.controller.v1;

import org.se.bou.quote.api.v1.model.GrouppriceDTO;
import org.se.bou.quote.api.v1.model.GrouppriceListDTO;
import org.se.bou.quote.service.GrouppriceService;
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
@RequestMapping(GrouppriceController.BASE_URL)
public class GrouppriceController {

	public static final String BASE_URL = "/api/v1/groupprices";
	
	private final GrouppriceService grouppriceService;
	
	private GrouppriceController(GrouppriceService grouppriceService) {
		this.grouppriceService = grouppriceService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GrouppriceListDTO getListOfGroupprices(){
		log.info("Sending {} List of Service fees ", 1 );
        return new GrouppriceListDTO(grouppriceService.getAllGroupprices());
    }
	 
	@GetMapping({"/{grouppriceId}"})
	@ResponseStatus(HttpStatus.OK)
	public GrouppriceDTO getGrouppriceById(@PathVariable Long grouppriceId){
	    return grouppriceService.getGrouppriceById(grouppriceId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrouppriceDTO createNewGroupprice(@RequestBody GrouppriceDTO grouppriceDTO){
        return grouppriceService.createNewGroupprice(grouppriceDTO);
    }

    @PutMapping({"/{grouppriceId}"})
    @ResponseStatus(HttpStatus.OK)
    public GrouppriceDTO updateGroupprice(@PathVariable Long grouppriceId, @RequestBody GrouppriceDTO grouppriceDTO){
        return grouppriceService.updateGroupprice(grouppriceId, grouppriceDTO);
    }

    @DeleteMapping({"/{grouppriceId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteGroupprice(@PathVariable Long grouppriceId){
    		grouppriceService.deleteGrouppriceById(grouppriceId);
    }
}
