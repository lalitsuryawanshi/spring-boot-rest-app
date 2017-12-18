package org.se.bou.quote.controller.v1;

import org.se.bou.quote.api.v1.model.SchoolDTO;
import org.se.bou.quote.api.v1.model.SchoolListDTO;
import org.se.bou.quote.service.SchoolService;
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
@RequestMapping(SchoolController.BASE_URL)
public class SchoolController {

	public static final String BASE_URL = "/api/v1/schools";
	
	private final SchoolService schoolService;
	
	private SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SchoolListDTO getListOfSchools(){
		log.info("Sending {} List of Schools ", 1 );
        return new SchoolListDTO(schoolService.getAllSchools());
    }
	 
	@GetMapping({"/{schoolId}"})
	@ResponseStatus(HttpStatus.OK)
	public SchoolDTO getSchoolById(@PathVariable Long schoolId){
	    return schoolService.getSchoolById(schoolId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDTO createNewSchool(@RequestBody SchoolDTO schoolDTO){
        return schoolService.createNewSchool(schoolDTO);
    }

    @PutMapping({"/{schoolId}"})
    @ResponseStatus(HttpStatus.OK)
    public SchoolDTO updateSchool(@PathVariable Long schoolId, @RequestBody SchoolDTO schoolDTO){
        return schoolService.updateSchool(schoolId, schoolDTO);
    }

    @DeleteMapping({"/{schoolId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool(@PathVariable Long schoolId){
    	schoolService.deleteSchoolById(schoolId);
    }
}
