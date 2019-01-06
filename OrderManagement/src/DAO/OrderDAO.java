package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.TableModel;

import Model.Order;
import net.proteanit.sql.DbUtils;

public class OrderDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void getConn() {

		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "system";
			String password = "1234";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(ArrayList<Order> orderList) {
		getConn();
		int cnt = 0;

		String sql = "insert into order_list values (SEQ_ID.NEXTVAL,?,?,?,?)";
		try {

			for (int i = 0; i < orderList.size(); i++) {
				Order order = orderList.get(i);
				
				pst = conn.prepareStatement(sql);
				
				pst.setString(1, order.getId());
				pst.setInt(2, order.getProduct_num());
				pst.setInt(3, order.getOrder_count());
				pst.setString(4, order.getOrder_date());
				
				cnt = pst.executeUpdate();
				
			}

			if (cnt > 0) {
				System.out.println("�Է¿Ϸ�");
			}

			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TableModel select() {
		getConn();
		
		String sql = "select distinct member.id as ���̵�, phone_num as ����ó, address as �ּ� from order_list, member where order_list.id = member.id";
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
	
	public TableModel selectOrdProduct(String id) {
		getConn();
		// �ֹ���ȣ, �ֹ�ǰ��, ��ǰ��, ����
		String sql = "select order_num as �ֹ���ȣ, product_name as ��ǰ��, order_amount as ����, order_date as �ֹ����� from order_list, product where id=? and order_list.product_num = product.product_num";
		TableModel table = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			table = DbUtils.resultSetToTableModel(rs);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}
	
	public void delete(int index) {
		getConn();
		String sql = "delete from order_list where order_num=?";
		int cnt = 0;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, index);
			
			cnt = pst.executeUpdate();
			
			if(cnt>0)
				System.out.println("���� ����");
			else
				System.out.println("���� ����");
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
