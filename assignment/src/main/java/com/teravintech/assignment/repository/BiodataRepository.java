package com.teravintech.assignment.repository;

import com.teravintech.assignment.model.dto.BiodataDto;
import com.teravintech.assignment.model.entity.BiodataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BiodataRepository extends JpaRepository<BiodataEntity, Integer>
{
    @Query(nativeQuery = true)
    List<BiodataDto> getAllBiodata();

    @Query(nativeQuery = true)
    List<BiodataDto> getAllBiodataAsc();

    @Query(nativeQuery = true)
    List<BiodataDto> getAllBiodataDesc();

    @Query(nativeQuery = true)
    List<BiodataDto> getBiodataByName(@Param("searchName") String theName);

    @Query(nativeQuery = true)
    List<BiodataDto> getBiodataByNameAsc(@Param("searchName") String theName);

    @Query(nativeQuery = true)
    List<BiodataDto> getBiodataByNameDesc(@Param("searchName") String theName);

    @Query(nativeQuery = true)
    List<BiodataDto> getBiodataPagingAsc(@Param("rpg") Integer rpg, @Param("page") Integer page);

    @Query(nativeQuery = true)
    List<BiodataDto> getBiodataPagingDesc(@Param("rpg") Integer rpg, @Param("page") Integer page);
}
