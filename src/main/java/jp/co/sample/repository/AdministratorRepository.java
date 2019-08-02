package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;

/**
 * Administratorを操作するリポジトリ
 * @author rksuser
 *
 */
@RequestMapping
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {

		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String insertSql = "INSERT administrators into (id,name,mailAddress,password;) VALUES(:id,:name,:mailAddress,:password);";
		template.update(insertSql, param);

	}

	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password",
				password);
		String Sql = "SELECT id,name,mailAddress,password FROM administrators WHERE :mailAddress AND :password";
		List<Administrator> administratorlist = template.query(Sql, param, ADMINISTRATOR_ROW_MAPPER);

		if(administratorlist.size() != 0) {
			return administratorlist.get(0);

		}else {
			return null;

		}

	}
}