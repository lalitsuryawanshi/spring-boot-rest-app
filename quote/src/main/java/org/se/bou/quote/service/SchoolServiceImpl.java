package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.AccommodationMapper;
import org.se.bou.quote.api.v1.mapper.CourseMapper;
import org.se.bou.quote.api.v1.mapper.ExtrafeeMapper;
import org.se.bou.quote.api.v1.mapper.GrouppriceMapper;
import org.se.bou.quote.api.v1.mapper.SchoolMapper;
import org.se.bou.quote.api.v1.mapper.ServicefeeMapper;
import org.se.bou.quote.api.v1.model.AccommodationDTO;
import org.se.bou.quote.api.v1.model.CourseDTO;
import org.se.bou.quote.api.v1.model.ExtrafeeDTO;
import org.se.bou.quote.api.v1.model.GrouppriceDTO;
import org.se.bou.quote.api.v1.model.SchoolDTO;
import org.se.bou.quote.api.v1.model.ServicefeeDTO;
import org.se.bou.quote.domain.School;
import org.se.bou.quote.repository.AccommodationRepository;
import org.se.bou.quote.repository.CourseRepository;
import org.se.bou.quote.repository.ExtrafeeRepository;
import org.se.bou.quote.repository.GrouppriceRepository;
import org.se.bou.quote.repository.SchoolRepository;
import org.se.bou.quote.repository.ServicefeeRepository;
import org.se.bou.quote.repository.StudentgroupRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {

	private final SchoolMapper schoolMapper;
	private final CourseMapper courseMapper;
	private final ServicefeeMapper servicefeeMapper;
	private final ExtrafeeMapper extrafeeMapper;
	private final AccommodationMapper accommodationMapper;
	private final SchoolRepository schoolRepository;
	private final CourseRepository courseRepository;
	private final ServicefeeRepository servicefeeRepository;
	private final ExtrafeeRepository extrafeeRepository;
	private final AccommodationRepository accommodationRepository;
	private final GrouppriceRepository grouppriceRepository;
	private final GrouppriceMapper grouppriceMapper;
	private final StudentgroupRepository studentgroupRepository;
	
	public SchoolServiceImpl(SchoolMapper schoolMapper, CourseMapper courseMapper, 
					ServicefeeMapper servicefeeMapper, ExtrafeeMapper extrafeeMapper,
					SchoolRepository schoolRepository, ServicefeeRepository servicefeeRepository,
					CourseRepository courseRepository, ExtrafeeRepository extrafeeRepository,
					AccommodationMapper accommodationMapper, AccommodationRepository accommodationRepository,
					GrouppriceRepository grouppriceRepository, GrouppriceMapper grouppriceMapper,
					StudentgroupRepository studentgroupRepository
					) {
		
		this.schoolMapper = schoolMapper;
		this.courseMapper = courseMapper;
		this.servicefeeMapper = servicefeeMapper;
		this.extrafeeMapper = extrafeeMapper;
		this.schoolRepository = schoolRepository;
		this.courseRepository = courseRepository;
		this.servicefeeRepository = servicefeeRepository;
		this.extrafeeRepository = extrafeeRepository;
		this.accommodationMapper = accommodationMapper;
		this.accommodationRepository = accommodationRepository;
		this.grouppriceRepository = grouppriceRepository;
		this.grouppriceMapper = grouppriceMapper;
		this.studentgroupRepository = studentgroupRepository;
	}
	
	@Override
	public List<SchoolDTO> getAllSchools() {
		return schoolRepository
                .findAll()
                .stream()
                .map(school -> {
                   SchoolDTO schoolDTO = schoolMapper.schoolToSchoolDTO(school);
                   //Set Additional Attributes here
                   // Set Courses
                   schoolDTO.setCourses(getCourseListForSchool(school.getSchoolId()));
                   schoolDTO.setAccommodations(getAccommodationListForSchool(school.getSchoolId()));
                   schoolDTO.setExtrafees(getExtrafeeListForSchool(school.getSchoolId()));
                   schoolDTO.setServicefees(getServicefeeListForSchool(school.getSchoolId()));
                   return schoolDTO;
                })
                .collect(Collectors.toList());
	}
	
	private List<CourseDTO> getCourseListForSchool(Long schoolId) {
		return courseRepository
				.getAllCoursesBySchoolId(schoolId)
                .stream()
                .map(course -> {
             	   	CourseDTO courseDTO = courseMapper.courseToCourseDTO(course);
             	   	courseDTO.setGroupPrices(getGrouppriceListForCourse(course.getCourseId()));
             	   	return courseDTO;
                })
                .collect(Collectors.toList());
	}
	
	private List<ExtrafeeDTO> getExtrafeeListForSchool(Long schoolId) {
		return extrafeeRepository
				.getAllExtrafeesBySchoolId(schoolId)
                .stream()
                .map(extrafee -> {
                	ExtrafeeDTO extrafeeDTO = extrafeeMapper.extrafeeToExtrafeeDTO(extrafee);
             	   	return extrafeeDTO;
                })
                .collect(Collectors.toList());
	}
	
	private List<ServicefeeDTO> getServicefeeListForSchool(Long schoolId) {
		return servicefeeRepository
				.getAllServicefeesBySchoolId(schoolId)
                .stream()
                .map(servicefee -> {
                	ServicefeeDTO servicefeeDTO = servicefeeMapper.servicefeeToServicefeeDTO(servicefee);
             	   	return servicefeeDTO;
                })
                .collect(Collectors.toList());
	}
	
	private List<AccommodationDTO> getAccommodationListForSchool(Long schoolId) {
		return accommodationRepository
				.getAllAccommodationsBySchoolId(schoolId)
                .stream()
                .map(accommodation -> {
                	AccommodationDTO accommodationDTO = accommodationMapper.accommodationToAccommodationDTO(accommodation);
             	   	return accommodationDTO;
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
	public SchoolDTO getSchoolById(Long id) {
		return schoolRepository.findById(id)
                .map(schoolMapper::schoolToSchoolDTO)
                .map(schoolDTO -> {
                    //set Additional attributes here
                		schoolDTO.setCourses(getCourseListForSchool(schoolDTO.getSchoolId()));
                		schoolDTO.setAccommodations(getAccommodationListForSchool(schoolDTO.getSchoolId()));
                		schoolDTO.setExtrafees(getExtrafeeListForSchool(schoolDTO.getSchoolId()));
                		schoolDTO.setServicefees(getServicefeeListForSchool(schoolDTO.getSchoolId()));
                    return schoolDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public SchoolDTO createNewSchool(SchoolDTO schoolDTO) {
		return saveAndReturnDTO(schoolMapper.schoolDtoToSchool(schoolDTO));
	}

	@Override
	public SchoolDTO saveSchoolByDTO(Long id, SchoolDTO schoolDTO) {
		School school = schoolMapper.schoolDtoToSchool(schoolDTO);
        school.setSchoolId(id);

        return saveAndReturnDTO(school);
	}

	@Override
	public SchoolDTO updateSchool(Long id, SchoolDTO schoolDTO) {
		return schoolRepository.findById(id).map(school -> {

            if(schoolDTO.getSchoolCountry() != null){
                school.setSchoolCountry(schoolDTO.getSchoolCountry());
            }
            if(schoolDTO.getSchoolLocation() != null){
                school.setSchoolLocation(schoolDTO.getSchoolLocation());
            }
            if(schoolDTO.getSchoolName() != null){
                school.setSchoolName(schoolDTO.getSchoolName());
            }

            SchoolDTO returnDto = schoolMapper.schoolToSchoolDTO(schoolRepository.save(school));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteSchoolById(Long id) {
		schoolRepository.deleteById(id);
	}
	
	private SchoolDTO saveAndReturnDTO(School school) {
		
		School savedSchool = schoolRepository.save(school);

        SchoolDTO returnDto = schoolMapper.schoolToSchoolDTO(savedSchool);

        //Set Additional Attributes here

        return returnDto;
    }


}
