package cn.myfreecloud.cache;

import cn.myfreecloud.cache.bean.Employee;
import cn.myfreecloud.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {

        Employee employeeById = employeeMapper.getEmployeeById(1);
        System.out.println(employeeById);

    }
}
