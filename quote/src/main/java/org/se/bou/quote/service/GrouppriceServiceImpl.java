package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.GrouppriceMapper;
import org.se.bou.quote.api.v1.model.GrouppriceDTO;
import org.se.bou.quote.domain.Groupprice;
import org.se.bou.quote.repository.GrouppriceRepository;
import org.se.bou.quote.repository.StudentgroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GrouppriceServiceImpl implements GrouppriceService {

	private final GrouppriceMapper grouppriceMapper;
	private final GrouppriceRepository grouppriceRepository;
	private final StudentgroupRepository studentgroupRepository;
	
	public GrouppriceServiceImpl(GrouppriceMapper grouppriceMapper, GrouppriceRepository grouppriceRepository,
					StudentgroupRepository studentgroupRepository) {
		this.grouppriceMapper = grouppriceMapper;
		this.grouppriceRepository = grouppriceRepository;
		this.studentgroupRepository = studentgroupRepository;
	}
	
	@Override
	public List<GrouppriceDTO> getAllGroupprices() {
		return grouppriceRepository
                .findAll()
                .stream()
                .map(groupprice -> {
                   GrouppriceDTO grouppriceDTO = grouppriceMapper.grouppriceToGrouppriceDTO(groupprice);
                   //Set Additional Attributes here
                   grouppriceDTO.setGroupName(studentgroupRepository.getStudentgroupNameByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                   grouppriceDTO.setGroupDescription(studentgroupRepository.getStudentgroupDescByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                   return grouppriceDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public GrouppriceDTO getGrouppriceById(Long id) {
		return grouppriceRepository.findById(id)
                .map(grouppriceMapper::grouppriceToGrouppriceDTO)
                .map(grouppriceDTO -> {
                    //set Additional attributes here
                		grouppriceDTO.setGroupName(studentgroupRepository.getStudentgroupNameByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                		grouppriceDTO.setGroupDescription(studentgroupRepository.getStudentgroupDescByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                		return grouppriceDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public GrouppriceDTO createNewGroupprice(GrouppriceDTO grouppriceDTO) {
		return saveAndReturnDTO(grouppriceMapper.grouppriceDtoToGroupprice(grouppriceDTO));
	}

	@Override
	public GrouppriceDTO saveGrouppriceByDTO(Long id, GrouppriceDTO grouppriceDTO) {
		Groupprice groupprice = grouppriceMapper.grouppriceDtoToGroupprice(grouppriceDTO);
        groupprice.setGrouppriceId(id);
        return saveAndReturnDTO(groupprice);
	}

	@Override
	public GrouppriceDTO updateGroupprice(Long id, GrouppriceDTO grouppriceDTO) {
		return grouppriceRepository.findById(id).map(groupprice -> {

			if(grouppriceDTO.getCourseId() != null){
				groupprice.setCourseId(grouppriceDTO.getCourseId());
			}
			if(grouppriceDTO.getPrice() != null){
				groupprice.setPrice(grouppriceDTO.getPrice());
			}
			if(grouppriceDTO.getStudentgroupId() != null){
                groupprice.setStudentgroupId(grouppriceDTO.getStudentgroupId());
            }

            //Set Additional Attributes
            GrouppriceDTO returnDto = grouppriceMapper.grouppriceToGrouppriceDTO(grouppriceRepository.save(groupprice));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));
            

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteGrouppriceById(Long id) {
		grouppriceRepository.deleteById(id);
	}
	
	private GrouppriceDTO saveAndReturnDTO(Groupprice groupprice) {
		
		Groupprice savedGroupprice = grouppriceRepository.save(groupprice);

        GrouppriceDTO returnDto = grouppriceMapper.grouppriceToGrouppriceDTO(savedGroupprice);

        //Set Additional Attributes here

        return returnDto;
    }

	@Override
	public List<GrouppriceDTO> getAllGrouppricesByCourseId(Long courseId) {
		return grouppriceRepository.getAllGrouppricesByCourseId(courseId)
                .stream()
                .map(groupprice -> {
                   GrouppriceDTO grouppriceDTO = grouppriceMapper.grouppriceToGrouppriceDTO(groupprice);
                   //Set Additional Attributes here
                   grouppriceDTO.setGroupName(studentgroupRepository.getStudentgroupNameByStudentgroupId(groupprice.getGrouppriceId()));
                   grouppriceDTO.setGroupDescription(studentgroupRepository.getStudentgroupDescByStudentgroupId(grouppriceDTO.getStudentgroupId()));
                   return grouppriceDTO;
                })
                .collect(Collectors.toList());
	}


}
