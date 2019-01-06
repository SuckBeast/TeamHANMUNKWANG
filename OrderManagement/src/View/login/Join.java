package View.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller.MemberController;
import DAO.MemberDAO;
import Model.MemberVO;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField txt_memberId;
	private JTextField txt_memberPw;
	private JTextField txt_memberPwcheck;
	private JTextField txt_memberName;
	private JTextField txt_memberAddress;
	private JTextField txt_memberEmail;
	private JTextPane textPane;
	MemberController controller = new MemberController();
	MemberDAO memberDao = new MemberDAO();
	String idCheck="";
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
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
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(273, 351, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(273, 385, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_3.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(273, 417, 100, 30);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(273, 449, 100, 30);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_5.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(273, 482, 100, 30);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_6.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(272, 515, 100, 30);
		contentPane.add(lblNewLabel_6);

		JButton btn_memberJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_memberJoin.setBackground(new Color(240, 240, 240));
		btn_memberJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_memberId.getText();
				String pw = txt_memberPw.getText();
				String pwcheck = txt_memberPwcheck.getText();
				String name = txt_memberName.getText();
				String address = txt_memberAddress.getText();
				String email = txt_memberEmail.getText();
				if (idCheck == null) {
					if (!id.equals("") && !pw.equals("") && !name.equals("") && !address.equals("")
							&& !email.equals("")) {

						if (controller.passCheck(pw, pwcheck)) {

							MemberVO VO = new MemberVO(id, pw, pwcheck, name, address, email);

							int cnt = memberDao.insert(VO);
							if (cnt > 0) {
								JOptionPane.showMessageDialog(null, "회원가입 성공");
								Login.main(null);
								dispose();// 프레임을 끝낼때 쓴다.
							} else {
								JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입", JOptionPane.ERROR_MESSAGE);
								txt_memberId.setText("");
								txt_memberPw.setText("");
								txt_memberPwcheck.setText("");
								txt_memberName.setText("");
								txt_memberAddress.setText("");
								txt_memberEmail.setText("");
							}
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "회원가입", JOptionPane.ERROR_MESSAGE);
							txt_memberPw.setText("");
							txt_memberPwcheck.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "공백 에러를 없애주세요", "공백에러", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "중복 체크 해주세요", "중복체크 에러", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btn_memberJoin.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_memberJoin.setBounds(301, 570, 100, 30);
		contentPane.add(btn_memberJoin);

		JButton btn_memberCancel = new JButton("\uCDE8\uC18C");
		btn_memberCancel.setBackground(new Color(240, 240, 240));
		btn_memberCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btn_memberCancel.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_memberCancel.setBounds(436, 570, 100, 30);
		contentPane.add(btn_memberCancel);

		txt_memberId = new JTextField();
		txt_memberId.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberId.setBounds(373, 352, 200, 30);
		contentPane.add(txt_memberId);
		txt_memberId.setColumns(10);

		txt_memberPw = new JTextField();
		txt_memberPw.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberPw.setColumns(10);
		txt_memberPw.setBounds(373, 385, 200, 30);
		contentPane.add(txt_memberPw);

		txt_memberPwcheck = new JTextField();
		txt_memberPwcheck.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberPwcheck.setColumns(10);
		txt_memberPwcheck.setBounds(373, 417, 200, 30);
		contentPane.add(txt_memberPwcheck);

		txt_memberName = new JTextField();
		txt_memberName.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberName.setColumns(10);
		txt_memberName.setBounds(373, 449, 200, 30);
		contentPane.add(txt_memberName);

		txt_memberAddress = new JTextField();
		txt_memberAddress.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberAddress.setColumns(10);
		txt_memberAddress.setBounds(373, 482, 200, 30);
		contentPane.add(txt_memberAddress);

		txt_memberEmail = new JTextField();
		txt_memberEmail.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		txt_memberEmail.setColumns(10);
		txt_memberEmail.setBounds(373, 515, 200, 30);
		contentPane.add(txt_memberEmail);

		textPane = new JTextPane();
		textPane.setBackground(SystemColor.menu);
		textPane.setText("\uD68C\uC6D0\uAC00\uC785");
		textPane.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		textPane.setBounds(359, 300, 120, 40);
		contentPane.add(textPane);

		JButton btn_Idcheck = new JButton("\uC544\uC544\uB514 \uC911\uBCF5\uD655\uC778");
		btn_Idcheck.setBackground(new Color(240, 240, 240));
		btn_Idcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_memberId.getText();
				idCheck = memberDao.Idcheck(id);
				if (idCheck == null) {
					JOptionPane.showMessageDialog(null, "중복 없음");
				} else
					JOptionPane.showMessageDialog(null, "아이디 중복", "회원가입", JOptionPane.ERROR_MESSAGE);
			}

		});
		btn_Idcheck.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		btn_Idcheck.setBounds(585, 351, 130, 30);
		contentPane.add(btn_Idcheck);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_7.setBounds(804, 581, 80, 80);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 661);
		contentPane.add(lblNewLabel);
	}
}
