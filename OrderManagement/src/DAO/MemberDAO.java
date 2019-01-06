package DAO;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	MemberVO VO;

	public void getConn() {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				conn.setAutoCommit(true);
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insert(MemberVO vo) {
		getConn();
		int cnt = 0;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());
			pst.setString(3, vo.getName());
			pst.setString(4, vo.getAddress());
			pst.setString(5, vo.getPhone());
			cnt = pst.executeUpdate();
			close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cnt;

	}

	public String IdFind(String name, String phone) {
		getConn();
		String id = null;
		String sql = "select id from member where NAME = ? and PHONE_NUM = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, phone);
			rs = pst.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;

	}

	public boolean select(String id, String name, String phone) {
		boolean check = false;
		getConn();
		String sql = "select PW from member where ID = ? and NAME = ? and phone_num=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, phone);

			rs = pst.executeQuery();
			if (rs.next()) {
				check = true;
			}

			close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;

	}

	public int update(String Pw, String id) {
		int cnt = 0;
		getConn();
		String sql = "update member set PW = ? where ID = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Pw);
			pst.setString(2, id);
			cnt = pst.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cnt;

	}

	public String Login(String id, String pw) {
		String name = null;
		getConn();
		String sql = "select name from member where id = ? and pw = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery(); // 문자열 반환
			// 만약에 로그인을 한다면 이름을 가져온다
			if (rs.next()) {
				name = rs.getString(1);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	public MemberVO Joinchange(String id) {

		getConn();
		String sql = "select * from member where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				String Id = rs.getString(1);
				String Pw = rs.getString(2);
				String Name = rs.getString(3);
				String Address = rs.getString(4);
				String Phone = rs.getString(5);
				VO = new MemberVO(Id, Pw, null, Name, Address, Phone);
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VO;

	}

	public void close() {
		try {
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String Idcheck(String id) {
		String idCheck = null;
		getConn();
		String sql = "select id from member where id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				idCheck = rs.getString(1);

			}
			close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return idCheck;
	}
	public int Joinchange_update(String pw , String name ,String address, String phone,String id) {
		int cnt = 0 ;
		getConn();
		String sql = "update member set pw = ? ,name = ? , address = ? ,PHONE_NUM= ? where id = ? ";
		try {
			pst =conn.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, name);
			pst.setString(3, address);
			pst.setString(4, phone);
			pst.setString(5, id);
			cnt = pst.executeUpdate();
			close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
		
	}

}
