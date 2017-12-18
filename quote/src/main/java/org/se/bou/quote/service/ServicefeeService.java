package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.ServicefeeDTO;

public interface ServicefeeService {

    List<ServicefeeDTO> getAllServicefees();

    ServicefeeDTO getServicefeeById(Long id);

    ServicefeeDTO createNewServicefee(ServicefeeDTO servicefeeDTO);

    ServicefeeDTO saveServicefeeByDTO(Long id, ServicefeeDTO servicefeeDTO);

    ServicefeeDTO updateServicefee(Long id, ServicefeeDTO servicefeeDTO);

    void deleteServicefeeById(Long id);
    
    List<ServicefeeDTO> getAllServicefeesBySchoolId(Long schoolId);
}
