package com.example.elasticserach;

import com.example.elasticserach.dao.CompanyDAO;
import com.example.elasticserach.domain.Company;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticserachApplication.class)
class ElasticserachApplicationTests {

    @Autowired
    private CompanyDAO companyDAO;

    @Test
    public void index(){
        Company company = new Company(2L,"小米科技有限公司","雷军","北京","北京市海淀区清河中街68号华润五彩城购物中心二期13层",456,456654,"信息传输、软件和信息技术服务业");
        companyDAO.save(company);
    }
}
