package View.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class IdFind extends JFrame {

	private JPanel contentPane;
	private JTextField txt_memberName;
	private JTextField txt_memberEmail;
	MemberDAO dao = new MemberDAO();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdFind frame = new IdFind();
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
	public IdFind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(332, 339, 270, 50);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("\uC774\uB984");
		label.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(302, 391, 100, 30);
		contentPane.add(label);
		
		lblNewLabel_2 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(302, 431, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		txt_memberName = new JTextField();
		txt_memberName.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberName.setColumns(10);
		txt_memberName.setBounds(402, 392, 200, 30);
		contentPane.add(txt_memberName);
		
		txt_memberEmail = new JTextField();
		txt_memberEmail.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberEmail.setColumns(10);
		txt_memberEmail.setBounds(402, 431, 200, 30);
		contentPane.add(txt_memberEmail);
		
		JButton btn_memberCheck = new JButton("\uD655\uC778");
		btn_memberCheck.setBackground(new Color(240, 240, 240));
		btn_memberCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String name = txt_memberName.getText();
				String phone = txt_memberEmail.getText();
				String Id=dao.IdFind(name, phone);
				if(Id!=null) {
					JOptionPane.showMessageDialog(null, "회원님의 아이디는 " + Id+"입니다.");
					dispose();
					Login.main(null);
				}else {
					JOptionPane.showMessageDialog(null, "입력하신 정보의 아이디가 없습니다.", "아이디 찾기", JOptionPane.ERROR_MESSAGE);
					txt_memberName.setText("");
					txt_memberEmail.setText("");
				}
				
				

			}
		});
		btn_memberCheck.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_memberCheck.setBounds(362, 482, 100, 30);
		contentPane.add(btn_memberCheck);
		
		JButton btn_memberCancel = new JButton("\uCDE8\uC18C");
		btn_memberCancel.setBackground(new Color(240, 240, 240));
		btn_memberCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				IdpwFindMenu.main(null);
			}
		});
		btn_memberCancel.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_memberCancel.setBounds(474, 482, 100, 30);
		contentPane.add(btn_memberCancel);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_3.setBounds(804, 581, 80, 80);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 661);
		contentPane.add(lblNewLabel);
	}

}
