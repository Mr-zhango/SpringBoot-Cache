package cn.myfreecloud.cache;

import cn.myfreecloud.cache.bean.Employee;
import cn.myfreecloud.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTest {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    @Test
    public void contextLoads() {

        Employee employeeById = employeeMapper.getEmployeeById(1);
        System.out.println(employeeById);

    }

    /**
     * 默认保存对象是使用的jdk的序列化机制,使用Jackson2JsonRedisSerializer 将数据以json格式缓存,改变了默认的序列化规则
     *
     */
    @Test
    public void testRedis() {

        Employee employeeById = employeeMapper.getEmployeeById(1);
        System.out.println(employeeById);

        employeeRedisTemplate.opsForValue().set("employee", employeeById);

    }
}
