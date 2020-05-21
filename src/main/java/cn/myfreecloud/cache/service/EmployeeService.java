package cn.myfreecloud.cache.service;

import cn.myfreecloud.cache.bean.Employee;
import cn.myfreecloud.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    // 请求的时候就去查询缓存,默认键就是这个id的entry 有就取到这个entry返回,没有的话就执行方法,然后返回,并且方缓存中一份
    // 放在方法上使用 value是缓存的名称 就是cache的名称 可以有多个 @Cacheable(value = {"emp","emp2"})

    // value也能替换成 cacheNames="emp" 和 value = "emp" 效果一样 指定缓存的名字,将方法的放回结果放回到缓存中 一个或者多个缓存(cache)
    // key:
    //      Entry里面的key 默认是 SimpleKeyGenerator 生成的,也可以使用SpEL表达式来生成 #a0 #p0 #root.args[0] #id

    // condition:指定符合条件的情况下才缓存
    // condition = "#a0>1" id > 1 的情况下才进行缓存
    // unless:和unless用法刚好相反
    // sync:是否使用异步模式

    // 使用spEL表达式 指定使用参数的第一个参数作为key ==  key = "#p0"
    @Cacheable(value = {"emp"}, key = "#root.args[0]")
    public Employee getEmpById(Integer id) {
        Employee employeeById = employeeMapper.getEmployeeById(id);
        return employeeById;
    }

    /**
     * @param employee
     * @return
     * @CachePut : 既调用方法,也会更新缓存
     * 修改数据库的数据,同时更新缓存
     */
    @CachePut(value = {"emp"}, key = "#result.id")
    public Employee updateEmpById(Employee employee) {
        System.out.println("update:" + employee);
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * @CacheEvict: 清除缓存
     */
    @CacheEvict(value = {"emp"}, key = "#a0")
    public void deleteEmpById(Integer id) {

        System.out.println("deleteEmp:id=" + id);
        //employeeMapper.deleteEmployee(id);
    }
}
