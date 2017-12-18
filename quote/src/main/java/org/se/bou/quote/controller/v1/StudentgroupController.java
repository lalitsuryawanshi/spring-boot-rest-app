package org.se.bou.quote.controller.v1;

import org.se.bou.quote.api.v1.model.StudentgroupDTO;
import org.se.bou.quote.api.v1.model.StudentgroupListDTO;
import org.se.bou.quote.service.StudentgroupService;
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
@RequestMapping(StudentgroupController.BASE_URL)
public class StudentgroupController {

	public static final String BASE_URL = "/api/v1/studentgroups";
	
	private final StudentgroupService studentgroupService;
	
	private StudentgroupController(StudentgroupService studentgroupService) {
		this.studentgroupService = studentgroupService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentgroupListDTO getListOfStudentgroups(){
		log.info("Sending {} List of Service fees ", 1 );
        return new StudentgroupListDTO(studentgroupService.getAllStudentgroups());
    }
	 
	@GetMapping({"/{studentgroupId}"})
	@ResponseStatus(HttpStatus.OK)
	public StudentgroupDTO getStudentgroupById(@PathVariable Long studentgroupId){
	    return studentgroupService.getStudentgroupById(studentgroupId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentgroupDTO createNewStudentgroup(@RequestBody StudentgroupDTO studentgroupDTO){
        return studentgroupService.createNewStudentgroup(studentgroupDTO);
    }

    @PutMapping({"/{studentgroupId}"})
    @ResponseStatus(HttpStatus.OK)
    public StudentgroupDTO updateStudentgroup(@PathVariable Long studentgroupId, @RequestBody StudentgroupDTO studentgroupDTO){
        return studentgroupService.updateStudentgroup(studentgroupId, studentgroupDTO);
    }

    @DeleteMapping({"/{studentgroupId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentgroup(@PathVariable Long studentgroupId){
    		studentgroupService.deleteStudentgroupById(studentgroupId);
    }
}
