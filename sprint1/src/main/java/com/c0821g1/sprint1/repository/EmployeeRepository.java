package com.c0821g1.sprint1.repository;


import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Bảo thêm mới nhân viên
    @Modifying
    @Transactional
    @Query(value = "insert into employee(employee_address," +
            "employee_code," +
            "employee_date_of_birth," +
            "employee_delete_flag," +
            "employee_email," +
            "employee_gender," +
            "employee_image," +
            "employee_name," +
            "employee_phone," +
            "employee_start_date," +
            "app_user_app_user_id," +
            "employee_position_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)", nativeQuery = true)
    void saveEmployee(String employeeAddress, String employeeCode, String employeeDateOfBirth, Boolean employeeDeleteFlag,
                      String employeeEmail, String employeeGender, String employeeImage, String employeeName,
                      String employeePhone, String employeeStartDate, Integer appUserAppUserId, Integer employeePositionId);


    //Bảo chỉnh sửa nhân viên
    @Transactional
    @Modifying
    @Query(value = "update employee as e " +
            "set e.employee_address =?1,e.employee_code =?2" +
            ",e.employee_date_of_birth =?3,e.employee_delete_flag =?4," +
            "e.employee_email =?5,e.employee_gender =?6," +
            "e.employee_image =?7,e.employee_name= ?8,e.employee_phone= ?9,e.employee_start_date= ?10," +
            "e.app_user_app_user_id= ?11,e.employee_position_id= ?12 " +
            "where employee_id =?13", nativeQuery = true)
    void editEmployee(String employeeAddress, String employeeCode, String employeeDateOfBirth, Boolean employeeDeleteFlag,
                      String employeeEmail, String employeeGender, String employeeImage, String employeeName,
                      String employeePhone, String employeeStartDate, Integer appUserAppUserId, Integer employeePositionId,
                      Integer employeeId);

    //Bảo đăng ký tài khoản cho nhân viên
    @Modifying
    @Transactional
    @Query(value = "insert into app_user(app_user_name," +
                                        "app_user_password)" +
                    "values  (:user_name," +
            "                 :user_password);", nativeQuery = true)
    void createEmployeeAccount(@Param("user_name") String appUserName, @Param("user_password") String appUserPassword);

    //Bảo kiểm tra email có tồn tại trong DB hay không
    @Query(value = "SELECT DISTINCT * " +
            "from employee  " +
            "where employee_email =?1", nativeQuery = true)
    Employee existsEmployeeByEmail(String employeeEmail);

    //Bảo kiểm tra mã nhân viên có tồn tại trong DB hay không
    @Query(value = "SELECT DISTINCT* " +
            "from employee  " +
            "where employee_code =?1", nativeQuery = true)
    Employee existsEmployeeByCode(String employeeCode);



}
