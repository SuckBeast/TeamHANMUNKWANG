package View.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import DAO.MemberDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.MemberVO;
import View.login.Login;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTable table_product;
	public static String adminId;
	static String view;
	private JTextField textField;
	private JTable table_ordMember;
	private JTable table_ordProduct;
	private MemberVO memberVo;
	private MemberDAO memberDao =new MemberDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
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
		AdminGUI.adminId = id;
		memberVo = memberDao.Joinchange(id);
	}	
	

	/**
	 * Create the frame.
	 */
	public AdminGUI() {

		ProductDAO productDao = new ProductDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(75, 20, 442, 33);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uAD00\uB9AC\uC790\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4");
		panel.add(lblNewLabel_1, "name_20437852895199");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(606, 23, 150, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uBB38\uC790 \uBA85\uB2E8");
		panel_1.add(lblNewLabel_2, "name_20400014019923");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(606, 344, 150, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\uC8FC\uBB38 \uC2B9\uC778");
		panel_2.add(lblNewLabel_3, "name_20427045316749");
		lblNewLabel_3.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		table_product = new JTable();
		table_product.setModel(productDao.select());
		
		resizeColumnWidth(table_product);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(75, 63, 442, 481);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table_product);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductRegisterGUI.table =table_product;
				ProductRegisterGUI.main(null);
			}
		});
		btnNewButton.setBounds(159, 575, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setBackground(new Color(240, 240, 240));
		btnNewButton_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(table.getSelectedRow());
//				System.out.println(table.getSelectedColumn());
//				System.out.println(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				String deleteIndex = String.valueOf(table_product.getValueAt(table_product.getSelectedRow(), 0));
				int index = Integer.valueOf(deleteIndex);
				System.out.println(index);
				productDao.delete(index);
				JOptionPane.showMessageDialog(null, "삭제성공");
				table_product.setModel(productDao.select());
			}
		});
		btnNewButton_2.setBounds(343, 575, 100, 30);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(606, 63, 300, 200);
		contentPane.add(scrollPane_1);
		
		
		OrderDAO orderDao = new OrderDAO();
		table_ordMember = new JTable();
		table_ordMember.setModel(orderDao.select());
		scrollPane_1.setViewportView(table_ordMember);
		scrollPane_1.setOpaque(false);
		scrollPane_1.getViewport().setOpaque(false);
		
		resizeColumnWidth(table_ordMember);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(605, 384, 300, 200);
		contentPane.add(scrollPane_2);
		
		table_ordProduct = new JTable();
		scrollPane_2.setViewportView(table_ordProduct);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		
		resizeColumnWidth(table_ordProduct);
		
		JButton btnNewButton_1 = new JButton("\uC8FC\uBB38\uC870\uD68C");
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminGUI.view = String.valueOf(table_ordMember.getValueAt(table_ordMember.getSelectedRow(), 0));
				System.out.println(AdminGUI.view);
				table_ordProduct.setModel(orderDao.selectOrdProduct(AdminGUI.view));
			}
		});
		
		JButton btnNewButton_3 = new JButton("\uCC98\uC74C\uC73C\uB85C");
		btnNewButton_3.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(240, 240, 240));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(809, 24, 100, 30);
		contentPane.add(btnNewButton_3);
		btnNewButton_1.setBounds(809, 273, 100, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btn_start = new JButton("\uBC30\uB2EC\uC2DC\uC791");
		btn_start.setBackground(new Color(240, 240, 240));
		btn_start.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String deleteIndex = String.valueOf(table_ordProduct.getValueAt(table_ordProduct.getSelectedRow(), 0));
				int index = Integer.valueOf(deleteIndex);
				System.out.println(index);
				orderDao.delete(index);
				JOptionPane.showMessageDialog(null, "배달을 시작했습니다.");
				table_ordProduct.setModel(orderDao.selectOrdProduct(view));
			}
		});
		btn_start.setBounds(636, 594, 100, 30);
		contentPane.add(btn_start);
		
		JButton btn_exit = new JButton("\uC8FC\uBB38\uCDE8\uC18C");
		btn_exit.setBackground(new Color(240, 240, 240));
		btn_exit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteIndex = String.valueOf(table_ordProduct.getValueAt(table_ordProduct.getSelectedRow(), 0));
				int index = Integer.valueOf(deleteIndex);
				System.out.println(index);
				orderDao.delete(index);
				JOptionPane.showMessageDialog(null, "주문을 취소했습니다.");
				table_ordProduct.setModel(orderDao.selectOrdProduct(view));
			}
		});
		btn_exit.setBounds(772, 594, 100, 30);
		contentPane.add(btn_exit);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_4.setBounds(944, 569, 80, 80);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1024, 650);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]bigmainKakaoTalk_20180801_093411723.jpg"));
	}
}
