package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.CourseMapper;
import org.se.bou.quote.api.v1.mapper.GrouppriceMapper;
import org.se.bou.quote.api.v1.model.CourseDTO;
import org.se.bou.quote.api.v1.model.GrouppriceDTO;
import org.se.bou.quote.domain.Course;
import org.se.bou.quote.repository.CourseRepository;
import org.se.bou.quote.repository.GrouppriceRepository;
import org.se.bou.quote.repository.StudentgroupRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseMapper courseMapper;
	private final GrouppriceMapper grouppriceMapper;
	private final CourseRepository courseRepository;
	private final GrouppriceRepository grouppriceRepository;
	private final StudentgroupRepository studentgroupRepository;
	
	public CourseServiceImpl(CourseMapper courseMapper, CourseRepository courseRepository,
							 GrouppriceMapper grouppriceMapper, GrouppriceRepository grouppriceRepository,
							 StudentgroupRepository studentgroupRepository
							) {
		this.courseMapper = courseMapper;
		this.courseRepository = courseRepository;
		this.grouppriceMapper = grouppriceMapper;
		this.grouppriceRepository = grouppriceRepository;
		this.studentgroupRepository = studentgroupRepository;
	}
	
	@Override
	public List<CourseDTO> getAllCourses() {
		return courseRepository
                .findAll()
                .stream()
                .map(course -> {
                   CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
                   //Set Additional Attributes here
                   courseDTO.setGroupPrices(getGrouppriceListForCourse(course.getCourseId()));
                   return courseDTO;
                })
                .collect(Collectors.toList());
	}
	
	private List<GrouppriceDTO> getGrouppriceListForCourse(Long courseId) {
		return grouppriceRepository
				.getAllGrouppricesByCourseId(courseId)
                .stream()
                .map(groupprice -> {
                	GrouppriceDTO grouppriceDTO = grouppriceMapper.grouppriceToGrouppriceDTO(groupprice);
                		grouppriceDTO.setGroupName(studentgroupRepository.getStudentgroupNameByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                		grouppriceDTO.setGroupDescription(studentgroupRepository.getStudentgroupDescByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                		return grouppriceDTO;
                })
                .collect(Collectors.toList());
	}


	@Override
	public CourseDTO getCourseById(Long id) {
		return courseRepository.findById(id)
                .map(courseMapper::courseToCourseDTO)
                .map(courseDTO -> {
                    //set Additional attributes here
                	    courseDTO.setGroupPrices(getGrouppriceListForCourse(courseDTO.getCourseId()));
                    return courseDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public CourseDTO createNewCourse(CourseDTO courseDTO) {
		return saveAndReturnDTO(courseMapper.courseDtoToCourse(courseDTO));
	}

	@Override
	public CourseDTO saveCourseByDTO(Long id, CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
        course.setSchoolId(id);
        return saveAndReturnDTO(course);
	}

	@Override
	public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
		return courseRepository.findById(id).map(course -> {

			if(courseDTO.getCourseHours() != null){
				course.setCourseHours(courseDTO.getCourseHours());
			}
			if(courseDTO.getCoursePrice() != null){
				course.setCoursePrice(courseDTO.getCoursePrice());
			}
			if(courseDTO.getCourseName() != null){
                course.setCourseName(courseDTO.getCourseName());
            }

            //Set Additional Attributes
            CourseDTO returnDto = courseMapper.courseToCourseDTO(courseRepository.save(course));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}
	
	private CourseDTO saveAndReturnDTO(Course course) {
		
		Course savedCourse = courseRepository.save(course);

        CourseDTO returnDto = courseMapper.courseToCourseDTO(savedCourse);

        //Set Additional Attributes here

        return returnDto;
    }

	@Override
	public List<CourseDTO> getAllCoursesBySchoolId(Long schoolId) {
		return courseRepository.getAllCoursesBySchoolId(schoolId)
                .stream()
                .map(course -> {
                   CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
                   //Set Additional Attributes here
                   return courseDTO;
                })
                .collect(Collectors.toList());
	}


}
