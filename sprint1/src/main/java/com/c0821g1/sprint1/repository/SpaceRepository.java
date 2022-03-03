package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface SpaceRepository extends JpaRepository<Spaces, Integer> {
    @Query(value = "SELECT * FROM spaces" +
            "WHERE spaces.space_delete_flag = 1", nativeQuery = true)
    Page<Spaces> findAllSpace(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update  spaces\n" +
            "set spaces.space_delete_flag = 0\n" +
            "where spaces.space_id = ?1 ", nativeQuery = true)
    void deleteSpaceById(Integer id);

    @Query(value = "SELECT * FROM spaces s \n" +
            "JOIN floors f ON s.floor_id = f.floor_id \n" +
            "JOIN spaces_type st ON st.space_type_id = s.space_type_id \n" +
            "JOIN spaces_status stt ON stt.space_status_id = s.space_status_id\n" +
            "WHERE f.floor_name LIKE concat('%',?1,'%') AND \n" +
            "s.space_code LIKE concat('%',?2,'%') AND\n" +
            "s.space_area LIKE concat('%',?3,'%') AND\n" +
            "st.space_type_name LIKE concat('%',?4,'%') AND\n" +
            "stt.spacer_status_name LIKE concat('%',?5,'%') AND\n" +
            "s.space_delete_flag = 1 ", nativeQuery = true)
    Page<Spaces> searchSpace(String floorName, String spaceCode, String spaceArea,
                             String spaceTypeName, String spaceStatusName, Pageable pageable);
}
