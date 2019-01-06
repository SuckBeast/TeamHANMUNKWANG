package View.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;
import View.admin.AdminGUI;
import View.user.LoginAfterGUI;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_memberId;
	private JTextField txt_memberPw;
	MemberDAO memberDao =new MemberDAO();
	public String NowLogin;
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
					Login frame = new Login();// Login의 클래스의 생성자를 생성 함. 
					frame.setVisible(true);//true 면 프레임을 띄운다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255,MAXIMIZED_BOTH));
		panel.setBounds(308, 72, 422, 535);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_memberId = new JTextField();
		txt_memberId.setBounds(142, 319, 150, 30);
		panel.add(txt_memberId);
		txt_memberId.setColumns(10);
		
		txt_memberPw = new JPasswordField();
		txt_memberPw.setBounds(142, 359, 150, 30);
		panel.add(txt_memberPw);
		txt_memberPw.setColumns(10);
		
		JButton btn_memberLogin = new JButton("\uB85C\uADF8\uC778");
		btn_memberLogin.setBackground(new Color(240, 240, 240));
		btn_memberLogin.setBounds(142, 399, 150, 30);
		panel.add(btn_memberLogin);
		btn_memberLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

	            String id = txt_memberId.getText();
	            String pw = txt_memberPw.getText();
	            String name = memberDao.Login(id, pw);
	            
	            if (name != null) {
	               JOptionPane.showMessageDialog(null, name + " 님 로그인 성공 하셨습니다.");
	               dispose();
	               NowLogin=id;
	               
	               if(id.equals("admin")) {
	            	   AdminGUI.adminId=NowLogin;
	            	   AdminGUI adminGui = new AdminGUI();
	            	   adminGui.setMemberVo(NowLogin);
	            	   adminGui.setVisible(true);
	               } else {
	            	   LoginAfterGUI.userId = NowLogin;
	            	   LoginAfterGUI loginAfterGui = new LoginAfterGUI();
	            	   loginAfterGui.setMemberVo(NowLogin);
	            	   loginAfterGui.setVisible(true);
	               }
	               
//	               manu m = new manu();
//	               m.getVO(NowLogin);
//	               m.setVisible(true);
	               
	            } else
	               JOptionPane.showMessageDialog(null, "로그인 실패 하셨습니다.", "로그인", JOptionPane.ERROR_MESSAGE);
	            txt_memberId.setText("");
	            txt_memberPw.setText("");
	         
			}
		});
		btn_memberLogin.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		
		JButton btn_memberJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_memberJoin.setBackground(new Color(240, 240, 240));
		btn_memberJoin.setBounds(69, 444, 150, 30);
		panel.add(btn_memberJoin);
		btn_memberJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join.main(null);
				dispose();
			}
		});
		btn_memberJoin.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 13));
		
		JButton btn_memberIdpwfind = new JButton("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btn_memberIdpwfind.setBackground(new Color(240, 240, 240));
		btn_memberIdpwfind.setBounds(228, 444, 150, 30);
		panel.add(btn_memberIdpwfind);
		btn_memberIdpwfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdpwFindMenu.main(null);
				dispose();
			}
		});
		btn_memberIdpwfind.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 13));
		
		lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(51, 319, 87, 30);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(51, 359, 87, 30);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uD55C\uBB38\uAD00");
		lblNewLabel_3.setFont(new Font("문체부 훈민정음체", Font.PLAIN, 70));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(69, 52, 295, 161);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\uD55C\uC57D \uC8FC\uBB38 \uAD00\uB9AC \uC2DC\uC2A4\uD15C");
		lblNewLabel_4.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(67, 222, 297, 54);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		lblNewLabel_5.setBounds(944, 570, 80, 80);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]bigmainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 1024, 650);
		contentPane.add(lblNewLabel);
	}
}
