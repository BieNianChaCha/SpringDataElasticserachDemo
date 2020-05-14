package com.example.elasticserach.controller;

import com.example.elasticserach.dao.CompanyDAO;
import com.example.elasticserach.domain.Company;
import com.google.common.collect.Lists;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package： com.example.elasticserach.controller
 * @Author: zhangchengjia
 * @Since: 2020/3/10 13:37
 * @Version: V1.0
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyDAO companyDAO;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @PostConstruct
    private void init (){
        if (companyDAO.findAll().iterator().hasNext())
            return;
        Company company1 = new Company(1l, "华宇科技有限公司1", "王科技1", "北京", "北京市海淀区清河中街68号华润五彩城购物中心二期13层", 100, 100, "工程建设");
        Company company2 = new Company(2l, "华宇科技有限公司2", "王科技2", "北京", "北京市海淀区清河中街68号华润五彩城购物中心二期13层", 101, 101, "工程建设");
        Company company3 = new Company(3l, "华宇科技有限公司3", "王科技3", "四川", "北京市海淀区清河中街68号华润五彩城购物中心二期13层", 102, 102, "资产交易");
        Company company4 = new Company(4l, "华宇科技有限公司4", "王科技4", "江西", "北京市海淀区清河中街68号华润五彩城购物中心二期13层", 103, 103, "土地交易");
        Company company5 = new Company(5l, "华宇科技有限公司5", "王科技5", "湖南", "北京市海淀区清河中街68号华润五彩城购物中心二期13层", 105, 104, "土地交易");
        Company company6 = new Company(6l, "华宇科技有限公司6", "王科技6", "北京", "北京市海淀区清河中街68号华润五彩城购物中心二期13层", 105, 105, "工程建设");
        companyDAO.saveAll(Lists.newArrayList(company1,company2,company3,company4,company5,company6));
    }

    @PutMapping("insert")
    public Company insert(Company company){
        Company save = companyDAO.save(company);
        return save;
    }

    @DeleteMapping("delete")
    public Boolean delete(Long id){
        try {
            companyDAO.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("select")
    public Company select (Long id){
        Optional<Company> byId = companyDAO.findById(id);
        if (byId.isPresent())
            return byId.get();
        return null;
    }

    @GetMapping("all")
    public Page<Company> getAll(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "transactionsNumber").and(Sort.by(Direction.ASC,"turnoverAmount")));
        return companyDAO.findAll(pageRequest);
    }

    @GetMapping("group")
    public Page<Company> group(){
        TermsAggregationBuilder field = AggregationBuilders.terms("group_name").field("transactionsNumber");
        field.showTermDocCountError(true);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.addAggregation(field);
        Page<Company> search = companyDAO.search(nativeSearchQueryBuilder.build());
        return search;
    }
}
