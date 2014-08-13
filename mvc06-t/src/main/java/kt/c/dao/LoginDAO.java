package kt.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("loginDAO")
public class LoginDAO {
	@Autowired
	DataSource dataSource;
	
	public LoginVO login(LoginVO loginVO) throws Exception {
		LoginVO userVO = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, password, type ");
		sql.append(" from t_member ");
		sql.append(" where id = ? and ");
		sql.append("       password = ? ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setType(rs.getString("type"));
			}
			return userVO;
			
		} catch(Exception e) {
			throw e;

		} finally {
			try {rs.close();} catch (Exception e) {}
			try {pstmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
	}
}
