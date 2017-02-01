package com.almond.way.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.almond.way.model.LoginUser;

public class LoginUserDao extends JdbcDaoSupport {
	
	public Collection<LoginUser> doQuery() {
		String sql = "select * from LOGIN_USR";
		
		return super.getJdbcTemplate().query(sql, new RowMapper<LoginUser>() {

			public LoginUser mapRow(ResultSet rs, int num) throws SQLException {
				LoginUser user = new LoginUser();
				user.setPk(rs.getInt("pk"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("pwd"));
				user.setAlias(rs.getString("alias"));
				return user;
			}
			
		});
	}

}
