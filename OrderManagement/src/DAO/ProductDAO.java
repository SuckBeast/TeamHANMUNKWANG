package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import Model.ProductVo;
import net.proteanit.sql.DbUtils;

public class ProductDAO {

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

	public int insert(ProductVo product) {
		getConn();
		int cnt = 0;
		String sql = "insert into product values(?,?,?,?)";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, product.getpNum());
			pst.setString(2, product.getName());
			pst.setInt(3, product.getPrice());
			pst.setInt(4, product.getAmount());

			cnt = pst.executeUpdate();

			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public TableModel select() {
		getConn();
		//String sql = "select product_name as 상품명, product_price as 가격, product_amount as 재고량 from product";
		String sql = "select product_num as 상품번호, product_name as 상품명, product_price as 가격, product_amount as 재고량 from product order by product_num asc";
		TableModel tableModel = null;
		//String sql = "select * from product";
		
		try {
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			tableModel=DbUtils.resultSetToTableModel(rs);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tableModel;
	}
	
	public int update(ProductVo product) {
		getConn();
		String sql = "update product set product_name=?, product_price=?, product_amount=? where product_num=?";
		int cnt = 0;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, product.getName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getAmount());
			pst.setInt(4, product.getpNum());
			
			cnt = pst.executeUpdate();
			
			close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public void delete(int num) {
		getConn();
		String sql = "delete from product where product_num=?";

		try {
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, num);
			
			int cnt = pst.executeUpdate();
			
			if(cnt>0) {
				System.out.println("삭제완료");
			} else {
				System.out.println("실패");
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {

		try {
			if (pst != null)
				pst.close();

			if (conn != null)
				pst.close();

			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
