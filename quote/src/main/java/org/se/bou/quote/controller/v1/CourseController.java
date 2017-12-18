package org.se.bou.quote.controller.v1;

import org.se.bou.quote.api.v1.model.CourseDTO;
import org.se.bou.quote.api.v1.model.CourseListDTO;
import org.se.bou.quote.service.CourseService;
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
@RequestMapping(CourseController.BASE_URL)
public class CourseController {

	public static final String BASE_URL = "/api/v1/courses";
	
	private final CourseService courseService;
	
	private CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CourseListDTO getListOfCourses(){
		log.info("Sending {} List of Courses ", 1 );
        return new CourseListDTO(courseService.getAllCourses());
    }
	 
	@GetMapping({"/{courseId}"})
	@ResponseStatus(HttpStatus.OK)
	public CourseDTO getCourseById(@PathVariable Long courseId){
	    return courseService.getCourseById(courseId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createNewCourse(@RequestBody CourseDTO courseDTO){
        return courseService.createNewCourse(courseDTO);
    }

    @PutMapping({"/{courseId}"})
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO){
        return courseService.updateCourse(courseId, courseDTO);
    }

    @DeleteMapping({"/{courseId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(@PathVariable Long courseId){
    		courseService.deleteCourseById(courseId);
    }
}
