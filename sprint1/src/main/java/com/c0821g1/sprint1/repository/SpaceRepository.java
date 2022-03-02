package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SpaceRepository extends JpaRepository<Spaces,Integer> {

    //    DuDH - Tạo mới Space
    @Modifying
    @Transactional
    @Query(value = "insert into spaces (floor_id, space_area, space_code, space_delete_flag, space_image, " +
            "space_manager_fee, space_note, space_price, space_status_id, space_type_id) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", nativeQuery = true)
    void saveSpace(Integer floor_id, String space_area, String space_code, Boolean space_delete_flag,
                   String space_image, String space_manager_fee, String space_note,
                   String space_price, Integer space_status_id, Integer space_type_id);

    //    DuDH - Chỉnh sửa Space
    @Modifying
    @Transactional
    @Query(value = "update spaces set floor_id=?, space_area=?, space_code=?, space_delete_flag=?, " +
            "space_image=?, space_manager_fee=?, space_note=?, space_price=?, space_status_id=?, " +
            "space_type_id=? where space_id=?", nativeQuery = true)
    void editSpace(Integer floor_id, String space_area, String space_code, Boolean space_delete_flag,
                   String space_image, String space_manager_fee, String space_note,
                   String space_price, Integer space_status_id, Integer space_type_id, Integer space_id);

}
