package View.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PwFind extends JFrame {

	private JPanel contentPane;
	private JTextField txt_memberId;
	private JTextField txt_memberName;
	private JTextField txt_memberEmail;
	private JButton btn_memberCheck;
	private JButton btn_memberCancel;
	MemberDAO dao = new MemberDAO();
	public static String id; 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwFind frame = new PwFind();
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
	public PwFind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638\uCC3E\uAE30");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(362, 322, 200, 60);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(304, 403, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(304, 444, 100, 30);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_4.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(304, 484, 100, 30);
		contentPane.add(lblNewLabel_4);
		
		txt_memberId = new JTextField();
		txt_memberId.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberId.setColumns(10);
		txt_memberId.setBounds(405, 402, 200, 30);
		contentPane.add(txt_memberId);
		
		txt_memberName = new JTextField();
		txt_memberName.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberName.setColumns(10);
		txt_memberName.setBounds(405, 444, 200, 30);
		contentPane.add(txt_memberName);
		
		txt_memberEmail = new JTextField();
		txt_memberEmail.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberEmail.setColumns(10);
		txt_memberEmail.setBounds(405, 484, 200, 30);
		contentPane.add(txt_memberEmail);
		
		btn_memberCheck = new JButton("\uD655\uC778");
		btn_memberCheck.setBackground(new Color(240, 240, 240));
		btn_memberCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id =txt_memberId.getText();
				String name =txt_memberName.getText();
				String phone = txt_memberEmail.getText();
				
				boolean check =dao.select(id,name,phone);
				
				if(check) {
					PwFind2.main(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "입력하신 정보가 일치 하지 않습니다.", "비밀번호찾기", JOptionPane.ERROR_MESSAGE);
					txt_memberId.setText("");
					txt_memberName.setText("");
					txt_memberEmail.setText("");
				}
				
			}
		});
		btn_memberCheck.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 20));
		btn_memberCheck.setBounds(357, 531, 100, 30);
		contentPane.add(btn_memberCheck);
		
		btn_memberCancel = new JButton("\uCDE8\uC18C");
		btn_memberCancel.setBackground(new Color(240, 240, 240));
		btn_memberCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdpwFindMenu.main(null);
				dispose();
			}
		});
		btn_memberCancel.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 20));
		btn_memberCancel.setBounds(483, 531, 100, 30);
		contentPane.add(btn_memberCancel);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_5.setBounds(804, 581, 80, 80);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 661);
		contentPane.add(lblNewLabel);
	}

}
