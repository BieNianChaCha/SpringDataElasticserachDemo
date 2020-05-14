package com.example.elasticserach.dao;

import com.example.elasticserach.domain.Company;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Package： com.example.elasticserach.dao
 * @Author: zhangchengjia
 * @Since: 2020/3/10 11:48
 * @Version: V1.0
 */
@Repository
public interface CompanyDAO extends ElasticsearchRepository<Company,Long> {

}
