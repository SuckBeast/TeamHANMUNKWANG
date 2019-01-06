package View.admin;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.ProductDAO;
import Model.ProductVo;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;

public class ProductRegisterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txt_productName;
	private JTextField txt_productPrice;
	private JTextField txt_productAmount;
	private JTextField txt_productNum;
	private ProductDAO productDAO = new ProductDAO();
	public static JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductRegisterGUI frame = new ProductRegisterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductRegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uC0C1\uD488\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(281, 384, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uC0C1\uD488\uC774\uB984");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(281, 417, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_3.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(281, 450, 100, 30);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("\uC7AC\uACE0\uB7C9");
		lblNewLabel_5.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(281, 485, 100, 30);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uD488\uB4F1\uB85D");
		lblNewLabel.setBounds(352, 331, 205, 44);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		txt_productName = new JTextField();
		txt_productName.setBounds(382, 418, 200, 30);
		contentPane.add(txt_productName);
		txt_productName.setColumns(10);
		
		txt_productPrice = new JTextField();
		txt_productPrice.setBounds(382, 451, 200, 30);
		contentPane.add(txt_productPrice);
		txt_productPrice.setColumns(10);
		
		txt_productAmount = new JTextField();
		txt_productAmount.setBounds(382, 485, 200, 30);
		contentPane.add(txt_productAmount);
		txt_productAmount.setColumns(10);
		
		JButton btn_productReg = new JButton("\uB4F1\uB85D");
		btn_productReg.setBackground(new Color(240, 240, 240));
		btn_productReg.setBounds(326, 525, 100, 30);
		btn_productReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pNum = Integer.parseInt(txt_productNum.getText());
				String name = txt_productName.getText();
				int price = Integer.parseInt(txt_productPrice.getText());
				int amount = Integer.parseInt(txt_productAmount.getText());
				
				ProductVo product = new ProductVo(pNum, name, price, amount);
				
				int cnt = productDAO.insert(product);
				
				if(cnt!=0) {
					JOptionPane.showMessageDialog(null, "상품등록성공!");
					table.setModel(productDAO.select());
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "상품등록 실패", "상품", JOptionPane.ERROR_MESSAGE);
					txt_productNum.setText("");
					txt_productName.setText("");
					txt_productPrice.setText("");
					txt_productAmount.setText("");
				}
			}
		});
		btn_productReg.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		contentPane.add(btn_productReg);
		
		txt_productNum = new JTextField();
		txt_productNum.setBounds(382, 385, 200, 30);
		contentPane.add(txt_productNum);
		txt_productNum.setColumns(10);
		
		JButton btn_exit = new JButton("\uCDE8\uC18C");
		btn_exit.setBackground(new Color(240, 240, 240));
		btn_exit.setBounds(457, 525, 100, 30);
		btn_exit.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		contentPane.add(btn_exit);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_6.setBounds(804, 581, 80, 80);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel_4.setBounds(0, 0, 884, 661);
		contentPane.add(lblNewLabel_4);
	}
}
