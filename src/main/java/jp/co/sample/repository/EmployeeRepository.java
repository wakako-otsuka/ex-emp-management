package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * employeeテーブルを操作するリポジトリ.
 * 
 * @author wakako.otsuka
 *
 */
@Repository
public class EmployeeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Employee> Employee_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hireDate"));
		employee.setMailAddress(rs.getString("mailAddress"));
		employee.setZipCode(rs.getString("zipCode"));
		employee.setAddress(rs.getString("setAddress"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependentsCount"));

		return employee;
	};

	public List<Employee> findAll() {
		String sql = "SELECT id,name,image,gender,hiredate,mailAddress,zipCode,setAddress,telephone,salary,characteristics,dependentsCount,"
				+ "FROM employees ORDER BY HireDate;";

		List<Employee> employeeList = template.query(sql, Employee_ROW_MAPPER);

		return employeeList;
		
//		if (employeeList.size() != 0) {
//			return employeeList;
//
//		} else {
//			return null;
//
//		}
	}

	public Employee load(Integer id) {
		String sql = "SELECT id,name,image,gender,hiredate,mailAddress,zipCode,setAddress,telephone,salary,characteristics,dependentsCount"
				+ "FROM employees WHERE id=:id;";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Employee employee = template.queryForObject(sql, param, Employee_ROW_MAPPER);

		return employee;
	}

	public void update(Employee employee) {
		String sql = "UPDATE employees SET dependentsCount=:dependentsCount WHERE id=:id; ";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", employee.getId()).addValue("dependentsCount", employee.getDependentsCount());

		template.update(sql, param);

	}

}
