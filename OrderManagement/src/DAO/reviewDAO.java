package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import Model.ProductVo;
import Model.Review;
import net.proteanit.sql.DbUtils;

public class reviewDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ArrayList<ProductVo> list = null;

	public Connection getConn() {

		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "system";
			String password = "1234";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int insert(Review review) {
		getConn();
		int cnt = 0;
		String sql = "insert into review values (?,?,?)";
		String star = "";
		
		for(int i=0; i<review.getStar(); i++)
			star = star + "★";
		
		System.out.println("별 저장");
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, review.getId());
			pst.setString(2, star);
			pst.setString(3, review.getWriteView());
			
			cnt = pst.executeUpdate();
			
			if(cnt>0) {
				System.out.println("리뷰에 입력 완료");
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	public TableModel select() {
		getConn();
		String sql = "select id as 사용자, star as 별점, writeview as 리뷰 from review";
		TableModel table = null;
		try {
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			table = DbUtils.resultSetToTableModel(rs);
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
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
}
