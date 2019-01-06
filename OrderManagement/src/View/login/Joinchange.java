package View.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;
import Model.MemberVO;
import View.user.LoginAfterGUI;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Joinchange extends JFrame {

	private JPanel contentPane;
	private JTextField txt_memberId;
	private JTextField txt_memberPw;
	private JTextField txt_memberName;
	private JTextField txt_memberAddress;
	private JTextField txt_memberPhone;
	MemberDAO dao = new MemberDAO();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	

	public void setJoin(MemberVO VO) {
		txt_memberId.setText(VO.getId());
		txt_memberPw.setText(VO.getPw());
		txt_memberName.setText(VO.getName());
		txt_memberAddress.setText(VO.getAddress());
		txt_memberPhone.setText(VO.getPhone());
		
	}

//	/**
	// * Create the frame.
	// */
	public Joinchange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(288, 364, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(288, 404, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uC774\uB984");
		lblNewLabel_3.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(288, 444, 100, 30);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_4.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(288, 483, 100, 30);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_5.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(288, 523, 100, 30);
		contentPane.add(lblNewLabel_5);

		txt_memberId = new JTextField();
		txt_memberId.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberId.setColumns(10);
		txt_memberId.setBounds(388, 363, 200, 30);
		contentPane.add(txt_memberId);

		txt_memberPw = new JTextField();
		txt_memberPw.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberPw.setColumns(10);
		txt_memberPw.setBounds(388, 403, 200, 30);
		contentPane.add(txt_memberPw);

		txt_memberName = new JTextField();
		txt_memberName.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberName.setColumns(10);
		txt_memberName.setBounds(388, 443, 200, 30);
		contentPane.add(txt_memberName);

		txt_memberAddress = new JTextField();
		txt_memberAddress.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberAddress.setColumns(10);
		txt_memberAddress.setBounds(388, 482, 200, 30);
		contentPane.add(txt_memberAddress);

		txt_memberPhone = new JTextField();
		txt_memberPhone.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberPhone.setColumns(10);
		txt_memberPhone.setBounds(388, 522, 200, 30);
		contentPane.add(txt_memberPhone);

		JButton button = new JButton("\uC218\uC815");
		button.setBackground(new Color(240, 240, 240));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Pw = txt_memberPw.getText();
				String Name = txt_memberName.getText();
				String Address = txt_memberAddress.getText();
				String Phone = txt_memberPhone.getText();
				String Id = txt_memberId.getText();

				int cnt = dao.Joinchange_update(Pw, Name, Address, Phone, Id);
				if (cnt > 0) {
					JOptionPane.showMessageDialog(null, "수정 성공");
					String id = dao.Login(Id, Pw);
					// manu 다시 띄우는데 id값을 보내서 띄움
					LoginAfterGUI login = new LoginAfterGUI();
					login.setMemberVo(Id);
					login.setVisible(true);

					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "수정 실패", "수정에러", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		button.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		button.setBounds(342, 562, 100, 30);
		contentPane.add(button);

		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.setBackground(new Color(240, 240, 240));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = txt_memberId.getText();
				String Pw = txt_memberPw.getText();
				String id = dao.Login(Id, Pw);
				
				LoginAfterGUI login = new LoginAfterGUI();
				login.setMemberVo(Id);
				login.setVisible(true);

				dispose();
			}
		});
		button_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		button_1.setBounds(454, 562, 100, 30);
		contentPane.add(button_1);

		JTextPane textPane = new JTextPane();
		textPane.setText("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		textPane.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(366, 316, 157, 37);
		contentPane.add(textPane);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_6.setBounds(803, 581, 80, 80);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 883, 661);
		contentPane.add(lblNewLabel);
	}
}
