package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.space.Spaces;
import com.c0821g1.sprint1.repository.SpaceRepository;
import com.c0821g1.sprint1.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    SpaceRepository spaceRepository;

    //    DuDH - Tạo mới Space
    @Override
    public void saveNewSpace(Spaces spaces) {
        spaceRepository.saveSpace(spaces.getFloors().getFloorId(),spaces.getSpaceArea(),
                spaces.getSpaceCode(),spaces.getSpaceDeleteFlag(),spaces.getSpaceImage(),
                spaces.getSpaceManagerFee(),spaces.getSpaceNote(),spaces.getSpacePrice(),
                spaces.getSpaceStatus().getSpaceStatusId(),spaces.getSpacesType().getSpaceTypeId());
    }
    //    DuDH - Tìm kiếm tho ID
    @Override
    public Spaces findById(Integer id) {
        return spaceRepository.findById(id).orElse(null);
    }

    //    DuDH - Tạo mới tự động
    @Override
    public void save(Spaces spaces) {
        spaceRepository.save(spaces);
    }
    //    DuDH - Chỉnh sửa Space
    @Override
    public void editSpace(Spaces spaces) {
        spaceRepository.editSpace(spaces.getFloors().getFloorId(),spaces.getSpaceArea(),
                spaces.getSpaceCode(),spaces.getSpaceDeleteFlag(),spaces.getSpaceImage(),
                spaces.getSpaceManagerFee(),spaces.getSpaceNote(),spaces.getSpacePrice(),
                spaces.getSpaceStatus().getSpaceStatusId(),spaces.getSpacesType().getSpaceTypeId(), spaces.getSpaceId());
    }
}
