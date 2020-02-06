package com.teravintech.assignment.model.entity;

import com.teravintech.assignment.model.dto.BiodataDto;

import javax.persistence.*;

@SqlResultSetMapping(name = "biodataMapping", classes = {@ConstructorResult(targetClass = BiodataDto.class, columns = {
        @ColumnResult(name = "id", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "email", type = String.class)
})})

@NamedNativeQuery(name = "BiodataEntity.getAllBiodata", resultSetMapping = "biodataMapping",
query = "SELECT biodata.id, biodata.name, biodata.email\n " +
        "FROM biodata")

@NamedNativeQuery(name = "BiodataEntity.getAllBiodataAsc", resultSetMapping = "biodataMapping",
query = "SELECT biodata.id, biodata.name, biodata.email\n " +
        "FROM biodata ORDER BY biodata.name ASC")

@NamedNativeQuery(name = "BiodataEntity.getAllBiodataDesc", resultSetMapping = "biodataMapping",
query = "SELECT biodata.id, biodata.name, biodata.email\n" +
        "FROM biodata ORDER BY biodata.name DESC")

@NamedNativeQuery(name = "BiodataEntity.getBiodataByName", resultSetMapping = "biodataMapping",
query = "SELECT biodata.id, biodata.name, biodata.email\n" +
        "FROM biodata WHERE LOWER(biodata.name) LIKE LOWER(CONCAT('%',:searchName,'%'))")

@NamedNativeQuery(name = "BiodataEntity.getBiodataByNameAsc", resultSetMapping = "biodataMapping",
query = "SELECT biodata.id, biodata.name, biodata.email\n" +
        "FROM biodata\n" +
        "WHERE LOWER(biodata.name) LIKE LOWER(CONCAT('%',:searchName,'%'))\n" +
        "ORDER BY biodata.name ASC")

@NamedNativeQuery(name = "BiodataEntity.getBiodataByNameDesc", resultSetMapping = "biodataMapping",
query = "SELECT biodata.id, biodata.name, biodata.email\n" +
        "FROM biodata\n" +
        "WHERE LOWER(biodata.name) LIKE LOWER(CONCAT('%',:searchName,'%'))\n" +
        "ORDER BY biodata.name DESC")

@Entity
@Table(name = "biodata")
public class BiodataEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    public BiodataEntity() {
    }

    public BiodataEntity(Integer id, String name, String phoneNumber, String email, String address)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
