package View.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Cart;
import Model.MemberVO;
import Model.Order;
import Model.Review;
import View.admin.AdminGUI;
import View.login.Joinchange;
import View.login.Login;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.multi.MultiScrollPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import DAO.CartDAO;
import DAO.MemberDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.reviewDAO;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.CardLayout;

public class LoginAfterGUI extends JFrame {

	private JPanel contentPane;
	private JTable table_product;
	public static String userId = "test";
	private JTextField textField;
	private JTable table_cart;
	private JTable table_review;
	private JTextField txt_review;
	private MemberVO memberVO;
	private MemberDAO memberDao = new MemberDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAfterGUI frame = new LoginAfterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	public void setMemberVo(String id) {
		userId = id;
		System.out.println(userId);
		memberVO = memberDao.Joinchange(id);
	}

	public LoginAfterGUI() {
		ProductDAO productDao = new ProductDAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table_product = new JTable();
		table_product.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15));
		table_product.setBackground(Color.WHITE);
		table_product.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_product.setForeground(Color.BLACK);
		table_product.setModel(productDao.select());
		
//		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
//		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
//		TableColumnModel tcm = table_product.getColumnModel();
//		for (int i = 0; i < tcm.getColumnCount(); i++) {
//			tcm.getColumn(i).setCellRenderer(dtcr);
//		}
		
		resizeColumnWidth(table_product);
		
		table_cart = new JTable();
		table_cart.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15));
		table_cart.setBackground(new Color(255, 255, 255));
		
		resizeColumnWidth(table_cart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 14, 401, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel(userId + "\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1, "name_19821809160914");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(UIManager.getBorder("OptionPane.messageAreaBorder"));
		scrollPane.setBounds(41, 63, 401, 498);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table_product);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		JButton btnNewButton = new JButton("\uB2F4\uAE30");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(table_product.getSelectedRow());
				System.out.println(table_product.getSelectedColumn());
				System.out.println(table_product.getValueAt(table_product.getSelectedRow(), 0));
//				int productNum = (Integer)table.getValueAt(table.getSelectedRow(), 0);
//				System.out.println(productNum);

				String insertIndex = String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 0));
				int index = Integer.valueOf(insertIndex);

				System.out.println(index + ", " + userId);

				int product_num = index;
				Cart cart = new Cart(product_num, userId, 1);

				CartDAO cartDao = new CartDAO();
				cartDao.insert(cart);
				table_cart.setModel(cartDao.selectAll(userId));
			}
		});
		btnNewButton.setBounds(322, 580, 120, 30);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(480, 63, 494, 229);
		contentPane.add(scrollPane_1);

		CartDAO cartDao = new CartDAO();

		table_cart.setModel(cartDao.selectAll(userId));
		scrollPane_1.setViewportView(table_cart);
		scrollPane_1.setOpaque(false);
		scrollPane_1.getViewport().setOpaque(false);

		JButton btn_delete = new JButton("\uC0AD\uC81C");
		btn_delete.setBackground(new Color(240, 240, 240));
		btn_delete.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String deleteIndex = String.valueOf(table_cart.getValueAt(table_cart.getSelectedRow(), 0));
				int index = Integer.valueOf(deleteIndex);
				System.out.println(index);
				cartDao.delete(index);
				// JOptionPane.showMessageDialog(null, "삭제성공");
				table_cart.setModel(cartDao.selectAll(userId));
			}
		});
		btn_delete.setBounds(569, 314, 130, 30);
		contentPane.add(btn_delete);

		JButton btn_deleteAll = new JButton("\uC7A5\uBC14\uAD6C\uB2C8 \uBE44\uC6B0\uAE30");
		btn_deleteAll.setBackground(new Color(240, 240, 240));
		btn_deleteAll.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_deleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartDao.deleteAll();
				table_cart.setModel(cartDao.selectAll(userId));
			}
		});
		btn_deleteAll.setBounds(753, 314, 130, 30);
		contentPane.add(btn_deleteAll);

		JButton btn_order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btn_order.setBackground(new Color(240, 240, 240));
		btn_order.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Order> orderList = cartDao.selectOrderInfo();
				OrderDAO orderDao = new OrderDAO();
				orderDao.insert(orderList);

				int sum = cartDao.selectSum();
				String message = "주문이 완료되었습니다.\n" + "총 금액은 " + sum + "원 입니다.";
				JOptionPane.showMessageDialog(null, message);
				cartDao.deleteAll();
				table_cart.setModel(cartDao.selectAll(userId));
				
				
			}
		});
		btn_order.setBounds(583, 580, 300, 30);
		contentPane.add(btn_order);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240, MAXIMIZED_BOTH));
		panel.setBounds(480, 369, 522, 192);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 10, 479, 126);
		panel.add(scrollPane_2);

		reviewDAO reviewDao = new reviewDAO();

		table_review = new JTable();
		table_review.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15));
		table_review.setModel(reviewDao.select());
		scrollPane_2.setViewportView(table_review);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);

		txt_review = new JTextField();
		txt_review.setBounds(70, 147, 339, 35);
		panel.add(txt_review);
		txt_review.setColumns(10);
		
		resizeColumnWidth(table_review);
		
		JComboBox comboBox_review = new JComboBox();
		comboBox_review.setBackground(new Color(255, 255, 255));
		comboBox_review.setBounds(12, 146, 46, 37);
		comboBox_review.addItem(1);
		comboBox_review.addItem(2);
		comboBox_review.addItem(3);
		comboBox_review.addItem(4);
		comboBox_review.addItem(5);
		panel.add(comboBox_review);

		JButton btin_review = new JButton("\uB4F1\uB85D");
		btin_review.setBackground(new Color(240, 240, 240));
		btin_review.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btin_review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int star = (int) comboBox_review.getSelectedItem();
				String writeReview = txt_review.getText();
				System.out.println(star + ", " + writeReview);
				Review review = new Review(userId, star, writeReview);

				reviewDao.insert(review);
				table_review.setModel(reviewDao.select());
				resizeColumnWidth(table_review);
				txt_review.setText("");
			}
		});
		btin_review.setBounds(424, 147, 68, 35);
		panel.add(btin_review);

		JButton btn_memberAdjust = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btn_memberAdjust.setBackground(new Color(240, 240, 240));
		btn_memberAdjust.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_memberAdjust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Joinchange J = new Joinchange();
				J.setJoin(memberVO);
				J.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(805, 15, 120, 30);
		contentPane.add(btnNewButton_1);
		btn_memberAdjust.setBounds(509, 15, 120, 30);
		contentPane.add(btn_memberAdjust);

		JButton btn_orderList = new JButton("\uC8FC\uBB38\uBAA9\uB85D\uC870\uD68C");
		btn_orderList.setBackground(new Color(240, 240, 240));
		btn_orderList.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_orderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderListGUI frame = new OrderListGUI();
				frame.setVisible(true);
			}
		});
		btn_orderList.setBounds(658, 15, 120, 30);
		contentPane.add(btn_orderList);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_2.setBounds(944, 570, 80, 80);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]bigmainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 1024, 650);
		contentPane.add(lblNewLabel);
	}
}
