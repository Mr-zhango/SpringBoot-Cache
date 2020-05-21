package cn.myfreecloud.cache.service;

import cn.myfreecloud.cache.bean.Employee;
import cn.myfreecloud.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    // 请求的时候就去查询缓存,默认键就是这个id的entry 有就取到这个entry返回,没有的话就执行方法,然后返回,并且方缓存中一份
    // 放在方法上使用 value是缓存的名称 就是cache的名称 可以有多个 @Cacheable(value = {"emp","emp2"})
    @Cacheable(value = "emp")
    public Employee getEmpById(Integer id) {
        Employee employeeById = employeeMapper.getEmployeeById(id);
        return employeeById;
    }
}
