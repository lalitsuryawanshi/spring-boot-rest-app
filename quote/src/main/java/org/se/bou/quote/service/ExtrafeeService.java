package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.ExtrafeeDTO;

public interface ExtrafeeService {

    List<ExtrafeeDTO> getAllExtrafees();

    ExtrafeeDTO getExtrafeeById(Long id);

    ExtrafeeDTO createNewExtrafee(ExtrafeeDTO extrafeeDTO);

    ExtrafeeDTO saveExtrafeeByDTO(Long id, ExtrafeeDTO extrafeeDTO);

    ExtrafeeDTO updateExtrafee(Long id, ExtrafeeDTO extrafeeDTO);

    void deleteExtrafeeById(Long id);
    
    List<ExtrafeeDTO> getAllExtrafeeBySchoolId(Long extrafeeId);
}
