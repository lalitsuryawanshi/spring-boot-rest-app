package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.StudentgroupMapper;
import org.se.bou.quote.api.v1.model.StudentgroupDTO;
import org.se.bou.quote.domain.Studentgroup;
import org.se.bou.quote.repository.StudentgroupRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentgroupServiceImpl implements StudentgroupService {

	private final StudentgroupMapper studentgroupMapper;
	private final StudentgroupRepository studentgroupRepository;
	
	public StudentgroupServiceImpl(StudentgroupMapper studentgroupMapper, StudentgroupRepository studentgroupRepository) {
		this.studentgroupMapper = studentgroupMapper;
		this.studentgroupRepository = studentgroupRepository;
	}
	
	@Override
	public List<StudentgroupDTO> getAllStudentgroups() {
		return studentgroupRepository
                .findAll()
                .stream()
                .map(studentgroup -> {
                   StudentgroupDTO studentgroupDTO = studentgroupMapper.studentgroupToStudentgroupDTO(studentgroup);
                   //Set Additional Attributes here
                   return studentgroupDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public StudentgroupDTO getStudentgroupById(Long id) {
		return studentgroupRepository.findById(id)
                .map(studentgroupMapper::studentgroupToStudentgroupDTO)
                .map(studentgroupDTO -> {
                    //set Additional attributes here
                	   
                   return studentgroupDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public StudentgroupDTO createNewStudentgroup(StudentgroupDTO studentgroupDTO) {
		return saveAndReturnDTO(studentgroupMapper.studentgroupDtoToStudentgroup(studentgroupDTO));
	}

	@Override
	public StudentgroupDTO saveStudentgroupByDTO(Long id, StudentgroupDTO studentgroupDTO) {
		Studentgroup studentgroup = studentgroupMapper.studentgroupDtoToStudentgroup(studentgroupDTO);
        studentgroup.setSchoolId(id);
        return saveAndReturnDTO(studentgroup);
	}

	@Override
	public StudentgroupDTO updateStudentgroup(Long id, StudentgroupDTO studentgroupDTO) {
		return studentgroupRepository.findById(id).map(studentgroup -> {

			if(studentgroupDTO.getSchoolId() != null){
				studentgroup.setSchoolId(studentgroupDTO.getSchoolId());
			}
			if(studentgroupDTO.getGroupName() != null){
				studentgroup.setGroupName(studentgroupDTO.getGroupName());
			}
			if(studentgroupDTO.getGroupDesc() != null){
                studentgroup.setGroupDesc(studentgroupDTO.getGroupDesc());
            }

            //Set Additional Attributes
            StudentgroupDTO returnDto = studentgroupMapper.studentgroupToStudentgroupDTO(studentgroupRepository.save(studentgroup));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteStudentgroupById(Long id) {
		studentgroupRepository.deleteById(id);
	}
	
	private StudentgroupDTO saveAndReturnDTO(Studentgroup studentgroup) {
		
		Studentgroup savedStudentgroup = studentgroupRepository.save(studentgroup);

        StudentgroupDTO returnDto = studentgroupMapper.studentgroupToStudentgroupDTO(savedStudentgroup);

        //Set Additional Attributes here

        return returnDto;
    }

	@Override
	public List<StudentgroupDTO> getAllStudentgroupsBySchoolId(Long schoolId) {
		return studentgroupRepository.getAllStudentgroupsBySchoolId(schoolId)
                .stream()
                .map(studentgroup -> {
                   StudentgroupDTO studentgroupDTO = studentgroupMapper.studentgroupToStudentgroupDTO(studentgroup);
                   //Set Additional Attributes here
                   return studentgroupDTO;
                })
                .collect(Collectors.toList());
	}


}
