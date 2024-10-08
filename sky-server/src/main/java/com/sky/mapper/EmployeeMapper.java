package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工
     * @param employee
     */
    @AutoFill(value = OperationType.INSERT)
    @Insert("insert into employee(name, username, password, phone, sex, id_number, status,create_time, update_time, create_user, update_user)" +
            "values(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status},#{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    public void insert(Employee employee);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     * 动态SQL
     */
    public List<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 更新员工信息
     * @param employee
     * dongtaisql
     */
    @AutoFill(value = OperationType.UPDATE)
    public void update(Employee employee);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    public Employee getById(Long id);
}
