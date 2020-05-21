package cn.myfreecloud.cache.mapper;

import cn.myfreecloud.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeById(Integer id);

    @Insert("insert into employee (last_name,email,gender,department_id values(#{lastName},#{email},#{gender},#{departmentId}))")
    public void insertEmployee(Employee employee);

    @Update("update employee set last_name = #{lastName} ,email = #{email},gender = #{gender},department_id = #{departmentId} where id = #{id}")
    public void updateEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmployee(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmployeeByLastName(String lastName);
}
