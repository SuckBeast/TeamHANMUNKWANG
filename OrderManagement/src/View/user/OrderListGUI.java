package View.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import DAO.OrderDAO;
import View.admin.AdminGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class OrderListGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrderListGUI frame = new OrderListGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
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
	

	public OrderListGUI() {
		OrderDAO orderDao = new OrderDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_exit = new JButton("\uB2EB\uAE30");
		btn_exit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_exit.setBackground(new Color(240, 240, 240));
		btn_exit.setBounds(344, 547, 100, 30);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 288, 413, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15));
		table.setModel(orderDao.selectOrdProduct(LoginAfterGUI.userId));
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		resizeColumnWidth(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(249, 248, 120, 30);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uBB38\uBAA9\uB85D");
		panel.add(lblNewLabel_1, "name_25201279301264");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btn_exit);
		
		JButton btnNewButton = new JButton("\uC8FC\uBB38\uCDE8\uC18C");
		btnNewButton.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(466, 547, 100, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteIndex = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
				int index = Integer.valueOf(deleteIndex);
				System.out.println(index);
				orderDao.delete(index);
				JOptionPane.showMessageDialog(null, "주문을 취소했습니다.");
				table.setModel(orderDao.selectOrdProduct(LoginAfterGUI.userId));
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_2.setBounds(804, 581, 80, 80);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 884, 661);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		contentPane.add(lblNewLabel);
	}
}
