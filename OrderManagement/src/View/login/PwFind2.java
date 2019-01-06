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

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PwFind2 extends JFrame {

	private JPanel contentPane;
	private JTextField txt_memberPw;
	private JTextField txt_memberPwcheck;
	MemberController controller = new MemberController();
	MemberDAO dao = new MemberDAO();
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwFind2 frame = new PwFind2();
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
	public PwFind2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("\uBE44\uBC00\uBC88\uD638\uBCC0\uACBD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		label.setBounds(301, 346, 300, 50);
		contentPane.add(label);
		
		lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(301, 406, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(301, 447, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		txt_memberPw = new JTextField();
		txt_memberPw.setBounds(402, 406, 200, 30);
		contentPane.add(txt_memberPw);
		txt_memberPw.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberPw.setColumns(10);
		
		txt_memberPwcheck = new JTextField();
		txt_memberPwcheck.setBounds(401, 446, 200, 30);
		contentPane.add(txt_memberPwcheck);
		txt_memberPwcheck.setFont(new Font("나눔스퀘어", Font.PLAIN, 20));
		txt_memberPwcheck.setColumns(10);
		
		JButton button = new JButton("\uD655\uC778");
		button.setBackground(new Color(240, 240, 240));
		button.setBounds(338, 491, 100, 30);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Pw =txt_memberPw.getText();
				String Pwcheck =txt_memberPwcheck.getText();
				
				if(controller.passCheck(Pw, Pwcheck)) {
					int cnt =dao.update(Pw,PwFind.id);
					if(cnt>0) {
						JOptionPane.showMessageDialog(null, "비밀번호 변경 성공", "비밀번호 변경", cnt);
						Login.main(null);
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호 변경 실패", "비밀번호 변경", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		button.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		
		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.setBackground(new Color(240, 240, 240));
		button_1.setBounds(467, 491, 100, 30);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		button_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		
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
