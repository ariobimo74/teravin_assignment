package com.teravintech.assignment.service;

import com.teravintech.assignment.model.dto.BiodataDto;
import com.teravintech.assignment.model.entity.BiodataEntity;
import com.teravintech.assignment.repository.BiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiodataService
{
    @Autowired
    private BiodataRepository biodataRepository;

    public List<BiodataEntity> findAllBiodata()
    {
        return biodataRepository.findAll();
    }

    public Optional<BiodataEntity> findBiodataById(Integer biodataId)
    {
        return biodataRepository.findById(biodataId);
    }

    public List<BiodataDto> getAllBiodata()
    {
        return biodataRepository.getAllBiodata();
    }

    public List<BiodataDto> getAllBiodataAsc()
    {
        return biodataRepository.getAllBiodataAsc();
    }

    public List<BiodataDto> getAllBiodataDesc()
    {
        return biodataRepository.getAllBiodataDesc();
    }

    public List<BiodataDto> getBiodataByName(@Param("searchName") String theName)
    {
        return biodataRepository.getBiodataByName(theName);
    }

    public List<BiodataDto> getBiodataByNameAsc(@Param("searchName") String theName)
    {
        return biodataRepository.getBiodataByNameAsc(theName);
    }

    public List<BiodataDto> getBiodataByNameDesc(@Param("searchName") String theName)
    {
        return biodataRepository.getBiodataByNameDesc(theName);
    }

    public List<BiodataDto> getBiodataPagingAsc(@Param("rpg") Integer rpg, @Param("page") Integer page)
    {
        return biodataRepository.getBiodataPagingAsc(rpg, page);
    }

    public List<BiodataDto> getBiodataPagingDesc(@Param("rpg") Integer rpg, @Param("page") Integer page)
    {
        return biodataRepository.getBiodataPagingDesc(rpg, page);
    }

    public BiodataEntity saveBiodata(BiodataEntity biodataEntity)
    {
        return biodataRepository.save(biodataEntity);
    }
}
