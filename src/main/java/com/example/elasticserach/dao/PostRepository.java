package com.example.elasticserach.dao;

import com.example.elasticserach.domain.Post;
import java.util.List;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Package： com.example.elasticserach.dao
 * @Author: zhangchengjia
 * @Since: 2020/3/11 13:51
 * @Version: V1.0
 */
public interface PostRepository extends ElasticsearchRepository<Post, String> {

    @Query("select * from  ")
    List<Post>  findAllByTEST();
}
