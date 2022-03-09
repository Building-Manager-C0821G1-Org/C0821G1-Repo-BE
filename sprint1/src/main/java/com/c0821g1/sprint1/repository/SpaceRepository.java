package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.dto.SpaceListDTO;
import com.c0821g1.sprint1.entity.space.Spaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface SpaceRepository extends JpaRepository<Spaces, Integer> {
    @Query(nativeQuery = true)
    List<SpaceListDTO> findAllSpace();

    @Query(nativeQuery = true)
    SpaceListDTO findSpaceById(Integer spaceId);

    @Modifying
    @Transactional
    @Query(value = "update  spaces\n" +
            "set spaces.space_delete_flag = 0\n" +
            "where spaces.space_id = ?1 ", nativeQuery = true)
    void deleteSpaceById(Integer id);
    @Query( nativeQuery = true)
    List<SpaceListDTO> searchSpace(String floorName, String spaceCode, String spaceArea,
                             String spaceTypeName, String spaceStatusName);
}
