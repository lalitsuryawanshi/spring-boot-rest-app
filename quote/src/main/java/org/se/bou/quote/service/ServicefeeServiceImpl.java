package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.ServicefeeMapper;
import org.se.bou.quote.api.v1.model.ServicefeeDTO;
import org.se.bou.quote.domain.Servicefee;
import org.se.bou.quote.repository.ServicefeeRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicefeeServiceImpl implements ServicefeeService {

	private final ServicefeeMapper servicefeeMapper;
	private final ServicefeeRepository servicefeeRepository;
	
	public ServicefeeServiceImpl(ServicefeeMapper servicefeeMapper, ServicefeeRepository servicefeeRepository) {
		this.servicefeeMapper = servicefeeMapper;
		this.servicefeeRepository = servicefeeRepository;
	}
	
	@Override
	public List<ServicefeeDTO> getAllServicefees() {
		return servicefeeRepository
                .findAll()
                .stream()
                .map(servicefee -> {
                   ServicefeeDTO ServicefeeDTO = servicefeeMapper.servicefeeToServicefeeDTO(servicefee);
                   //Set Additional Attributes here
                   return ServicefeeDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public ServicefeeDTO getServicefeeById(Long id) {
		return servicefeeRepository.findById(id)
                .map(servicefeeMapper::servicefeeToServicefeeDTO)
                .map(ServicefeeDTO -> {
                    //set Additional attributes here
                    return ServicefeeDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public ServicefeeDTO createNewServicefee(ServicefeeDTO ServicefeeDTO) {
		return saveAndReturnDTO(servicefeeMapper.servicefeeDtoToServicefee(ServicefeeDTO));
	}

	@Override
	public ServicefeeDTO saveServicefeeByDTO(Long id, ServicefeeDTO ServicefeeDTO) {
		Servicefee servicefee = servicefeeMapper.servicefeeDtoToServicefee(ServicefeeDTO);
        servicefee.setSchoolId(id);
        return saveAndReturnDTO(servicefee);
	}

	@Override
	public ServicefeeDTO updateServicefee(Long id, ServicefeeDTO ServicefeeDTO) {
		return servicefeeRepository.findById(id).map(servicefee -> {

			if(ServicefeeDTO.getSchoolId() != null){
				servicefee.setSchoolId(ServicefeeDTO.getSchoolId());
			}
			if(ServicefeeDTO.getServicePrice() != null){
				servicefee.setServicePrice(ServicefeeDTO.getServicePrice());
			}
			if(ServicefeeDTO.getServiceName() != null){
                servicefee.setServiceName(ServicefeeDTO.getServiceName());
            }

            //Set Additional Attributes
            ServicefeeDTO returnDto = servicefeeMapper.servicefeeToServicefeeDTO(servicefeeRepository.save(servicefee));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteServicefeeById(Long id) {
		servicefeeRepository.deleteById(id);
	}
	
	private ServicefeeDTO saveAndReturnDTO(Servicefee servicefee) {
		
		Servicefee savedServicefee = servicefeeRepository.save(servicefee);

        ServicefeeDTO returnDto = servicefeeMapper.servicefeeToServicefeeDTO(savedServicefee);

        //Set Additional Attributes here

        return returnDto;
    }

	@Override
	public List<ServicefeeDTO> getAllServicefeesBySchoolId(Long schoolId) {
		return servicefeeRepository.getAllServicefeesBySchoolId(schoolId)
                .stream()
                .map(servicefee -> {
                   ServicefeeDTO ServicefeeDTO = servicefeeMapper.servicefeeToServicefeeDTO(servicefee);
                   //Set Additional Attributes here
                   return ServicefeeDTO;
                })
                .collect(Collectors.toList());
	}


}
