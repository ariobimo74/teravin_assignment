package com.teravintech.assignment.controller.rest;

import com.teravintech.assignment.model.dto.BiodataDto;
import com.teravintech.assignment.model.entity.BiodataEntity;
import com.teravintech.assignment.service.BiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "rest/biodata")
public class BiodataRest
{
    @Autowired
    private BiodataService biodataService;

    @GetMapping
    public List<BiodataEntity> findAllBiodata()
    {
        return biodataService.findAllBiodata();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findBiodataById(@PathVariable("id") Integer biodataId)
    {
        Optional<BiodataEntity> biodataEntityOptional = biodataService.findBiodataById(biodataId);
        if (biodataEntityOptional.isPresent())
        {
            return new ResponseEntity<>(biodataEntityOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/asc")
    public List<BiodataDto> findAllBiodataAsc()
    {
        return biodataService.getAllBiodataAsc();
    }

    @GetMapping("/desc")
    public List<BiodataDto> findAllBiodataDesc()
    {
        return biodataService.getAllBiodataDesc();
    }

    @GetMapping("/searchname")
    public List<BiodataDto> findBiodataByName(@RequestParam(name = "searchName") String theName)
    {
        return biodataService.getBiodataByName(theName);
    }

    @GetMapping("/searchname/asc")
    public List<BiodataDto> findBiodataByNameAsc(@RequestParam(name = "searchName") String theName)
    {
        return biodataService.getBiodataByNameAsc(theName);
    }

    @GetMapping("/searchname/desc")
    public List<BiodataDto> findBiodataByNameDesc(@RequestParam(name = "searchName") String theName)
    {
        return biodataService.getBiodataByNameDesc(theName);
    }

    @GetMapping("/paging/asc")
    public List<BiodataDto> findBiodataPagingAsc(@RequestParam("rpg") Integer rpg, @RequestParam("page") Integer page)
    {
        Integer x = (page*rpg) - rpg;

        return biodataService.getBiodataPagingAsc(rpg, x);
    }

    @GetMapping("/paging/desc")
    public List<BiodataDto> findBiodataPagingDesc(@RequestParam("rpg") Integer rpg, @RequestParam("page") Integer page)
    {
        Integer x = (page*rpg) - rpg;

        return biodataService.getBiodataPagingDesc(rpg, x);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BiodataEntity postBiodata(@RequestBody BiodataEntity biodataEntity)
    {
        BiodataEntity biodata = new BiodataEntity();
        biodata.setName(biodataEntity.getName());
        biodata.setEmail(biodataEntity.getEmail());
        biodata.setPhoneNumber(biodataEntity.getPhoneNumber());
        biodata.setAddress(biodataEntity.getAddress());
        return biodataService.saveBiodata(biodata);
    }
}
