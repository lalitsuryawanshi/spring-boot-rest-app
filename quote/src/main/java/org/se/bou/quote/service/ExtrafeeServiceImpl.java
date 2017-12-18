package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.ExtrafeeMapper;
import org.se.bou.quote.api.v1.model.ExtrafeeDTO;
import org.se.bou.quote.domain.Extrafee;
import org.se.bou.quote.repository.ExtrafeeRepository;
import org.springframework.stereotype.Service;

@Service
public class ExtrafeeServiceImpl implements ExtrafeeService {

	private final ExtrafeeMapper extrafeeMapper;
	private final ExtrafeeRepository extrafeeRepository;
	
	public ExtrafeeServiceImpl(ExtrafeeMapper extrafeeMapper, ExtrafeeRepository extrafeeRepository) {
		this.extrafeeMapper = extrafeeMapper;
		this.extrafeeRepository = extrafeeRepository;
	}
	
	@Override
	public List<ExtrafeeDTO> getAllExtrafees() {
		return extrafeeRepository
                .findAll()
                .stream()
                .map(extrafee -> {
                	ExtrafeeDTO extrafeeDTO = extrafeeMapper.extrafeeToExtrafeeDTO(extrafee);
                   //Set Additional Attributes here
                   return extrafeeDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public ExtrafeeDTO getExtrafeeById(Long id) {
		return extrafeeRepository.findById(id)
                .map(extrafeeMapper::extrafeeToExtrafeeDTO)
                .map(extrafeeDTO -> {
                    //set Additional attributes here
                    return extrafeeDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public ExtrafeeDTO createNewExtrafee(ExtrafeeDTO extrafeeDTO) {
		return saveAndReturnDTO(extrafeeMapper.extrafeeDtoToExtrafee(extrafeeDTO));
	}

	@Override
	public ExtrafeeDTO saveExtrafeeByDTO(Long id, ExtrafeeDTO extrafeeDTO) {
		Extrafee extrafee = extrafeeMapper.extrafeeDtoToExtrafee(extrafeeDTO);
        extrafee.setSchoolId(id);
        return saveAndReturnDTO(extrafee);
	}

	@Override
	public ExtrafeeDTO updateExtrafee(Long id, ExtrafeeDTO extrafeeDTO) {
		return extrafeeRepository.findById(id).map(extrafee -> {

			if(extrafeeDTO.getSchoolId() != null){
                extrafee.setSchoolId(extrafeeDTO.getSchoolId());
            }
			if(extrafeeDTO.getExtraName() != null){
                extrafee.setExtraName(extrafeeDTO.getExtraName());
            }
			if(extrafeeDTO.getExtraPrice() != null){
                extrafee.setExtraPrice(extrafeeDTO.getExtraPrice());
            }

			//Set Additional Attributes
			ExtrafeeDTO returnDto = extrafeeMapper.extrafeeToExtrafeeDTO(extrafeeRepository.save(extrafee));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteExtrafeeById(Long id) {
		extrafeeRepository.deleteById(id);
	}
	
	private ExtrafeeDTO saveAndReturnDTO(Extrafee extrafee) {
		
		Extrafee savedCourse = extrafeeRepository.save(extrafee);

		ExtrafeeDTO returnDto = extrafeeMapper.extrafeeToExtrafeeDTO(savedCourse);

        //Set Additional Attributes here

        return returnDto;
    }

	@Override
	public List<ExtrafeeDTO> getAllExtrafeeBySchoolId(Long schoolId) {
		return extrafeeRepository.getAllExtrafeesBySchoolId(schoolId)
                .stream()
                .map(extrafee -> {
                	ExtrafeeDTO extrafeeDTO = extrafeeMapper.extrafeeToExtrafeeDTO(extrafee);
                   //Set Additional Attributes here
                   return extrafeeDTO;
                })
                .collect(Collectors.toList());
	}


}
