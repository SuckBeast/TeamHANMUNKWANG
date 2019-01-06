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

import Model.Cart;
import Model.Order;
import net.proteanit.sql.DbUtils;

public class CartDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

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

	public void insert(Cart cart) {
		getConn();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String current = dateFormat.format(date);
		System.out.println(current);

		String sql = "insert into cart values (SEQ_ID.NEXTVAL,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cart.getProduct_num());
			pst.setString(2, cart.getId());
			pst.setInt(3, cart.getOrder_count());
			pst.setString(4, current);
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("카트 입력 완료");
			} else {
				System.out.println("카트 입력 실패");
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TableModel selectAll(String id) {

		getConn();
		TableModel tableModel = null;

		String sql = "select cart_num as 순번, product.product_name as 상품명, product.product_price as 가격, order_count as 주문수량, order_date as 주문날짜"
				+ " from cart, member, product"
				+ " where cart.product_num = product.product_num and cart.id = member.id and member.id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			tableModel = DbUtils.resultSetToTableModel(rs);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableModel;
	}

	public int selectSum() {
		getConn();
		int sum = 0;

		String sql = "select product_price, cart.order_count from cart, product where cart.product_num = product.product_num";

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int price = rs.getInt(1);
				System.out.println("price : " + price);
				int count = rs.getInt(2);
				System.out.println("count : " + count);
				sum = sum + price * count;
				System.out.println(sum);
			}
			System.out.println(sum);
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}

	public ArrayList<Order> selectOrderInfo() {
		getConn();
		String sql = "select id, product_num, order_count, order_date from cart";
		ArrayList<Order> orderList = new ArrayList<>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				int num = rs.getInt(2);
				int order_count = rs.getInt(3);
				String order_date = rs.getString(4);
				
				Order order = new Order(id, num, order_count, order_date);
				orderList.add(order);
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderList;
	}

	public void delete(int num) {
		getConn();

		String sql = "delete from cart where cart_num=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, num);

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

			close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		getConn();

		String sql = "delete from cart";

		try {
			pst = conn.prepareStatement(sql);

			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				System.out.println("성공");
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
