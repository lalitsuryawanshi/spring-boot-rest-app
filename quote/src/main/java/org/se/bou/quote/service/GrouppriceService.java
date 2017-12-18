package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.GrouppriceDTO;

public interface GrouppriceService {

    List<GrouppriceDTO> getAllGroupprices();

    GrouppriceDTO getGrouppriceById(Long id);

    GrouppriceDTO createNewGroupprice(GrouppriceDTO grouppriceDTO);

    GrouppriceDTO saveGrouppriceByDTO(Long id, GrouppriceDTO grouppriceDTO);

    GrouppriceDTO updateGroupprice(Long id, GrouppriceDTO grouppriceDTO);

    void deleteGrouppriceById(Long id);
    
    List<GrouppriceDTO> getAllGrouppricesByCourseId(Long courseId);
}
