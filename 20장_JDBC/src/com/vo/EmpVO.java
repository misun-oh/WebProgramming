package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
	String emp_id;
	String emp_name;
	String emp_no;
	String email;
	String phone;
	String dept_code;
	String job_code;
	String salary;
	String bonus;
	String manager_id;
	String hire_date;
	String ent_date;
	String ent_yn;
	
}
