package com.example.elasticserach.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Package： com.example.elasticserach.domain
 * @Author: zhangchengjia
 * @Since: 2020/3/10 11:40
 * @Version: V1.0
 */
@Document(indexName = "company",type = "companyInfo")
public class Company {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String legalPerson;
    @Field(type = FieldType.Keyword)
    private String region;
    @Field(type = FieldType.Text)
    private String address;
    @Field(type = FieldType.Integer)
    private Integer transactionsNumber;
    @Field(type = FieldType.Integer)
    private Integer turnoverAmount;
    @Field(type = FieldType.Keyword)
    private String industry;

    public Company(Long id, String name, String legalPerson, String region, String address,
            Integer transactionsNumber, Integer turnoverAmount, String industry) {
        this.id = id;
        this.name = name;
        this.legalPerson = legalPerson;
        this.region = region;
        this.address = address;
        this.transactionsNumber = transactionsNumber;
        this.turnoverAmount = turnoverAmount;
        this.industry = industry;
    }

    public Company(String name, String legalPerson, String region, String address, Integer transactionsNumber,
            Integer turnoverAmount, String industry) {
        this.name = name;
        this.legalPerson = legalPerson;
        this.region = region;
        this.address = address;
        this.transactionsNumber = transactionsNumber;
        this.turnoverAmount = turnoverAmount;
        this.industry = industry;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTransactionsNumber() {
        return transactionsNumber;
    }

    public void setTransactionsNumber(Integer transactionsNumber) {
        this.transactionsNumber = transactionsNumber;
    }

    public Integer getTurnoverAmount() {
        return turnoverAmount;
    }

    public void setTurnoverAmount(Integer turnoverAmount) {
        this.turnoverAmount = turnoverAmount;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
