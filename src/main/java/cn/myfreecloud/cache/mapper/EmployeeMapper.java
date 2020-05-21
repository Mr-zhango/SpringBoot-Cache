package cn.myfreecloud.cache.mapper;

import cn.myfreecloud.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeById(Integer id);

    @Insert("insert into employee (lastName,email,gender,departmentId values(#{lastName},#{email},#{gender},#{departmentId}))")
    public void insertEmployee(Employee employee);

    @Update("update employee set lastName = #{lastName} ,email = #{email},gender = #{gender},departmentId = #{departmentId}")
    public void updateEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmployee(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmployeeByLastName(String lastName);
}
