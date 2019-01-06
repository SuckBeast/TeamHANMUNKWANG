package View.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class IdpwFindMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdpwFindMenu frame = new IdpwFindMenu();
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
	public IdpwFindMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_memberIdfind = new JButton("\uC544\uC774\uB514\uCC3E\uAE30");
		btn_memberIdfind.setBackground(new Color(240, 240, 240));
		btn_memberIdfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdFind.main(null);
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514 / \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel_1.setFont(new Font("배달의민족 한나는 열한살", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(323, 342, 264, 63);
		contentPane.add(lblNewLabel_1);
		btn_memberIdfind.setFont(new Font("배달의민족 한나는 열한살", Font.BOLD, 15));
		btn_memberIdfind.setBounds(291, 435, 150, 30);
		contentPane.add(btn_memberIdfind);
		
		JButton btn_memberPwfind = new JButton("\uBE44\uBC00\uBC88\uD638\uCC3E\uAE30");
		btn_memberPwfind.setBackground(new Color(240, 240, 240));
		btn_memberPwfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PwFind.main(null);
				dispose();
			}
		});
		btn_memberPwfind.setFont(new Font("배달의민족 한나는 열한살", Font.BOLD, 15));
		btn_memberPwfind.setBounds(466, 435, 150, 30);
		contentPane.add(btn_memberPwfind);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_144716401.png"));
		label.setBounds(807, 582, 80, 80);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\\uBC30\uACBD\uC0AC\uC9C4\\[\uD06C\uAE30\uBCC0\uD658]middlemainKakaoTalk_20180801_093411723.jpg"));
		lblNewLabel.setBounds(0, 0, 887, 662);
		contentPane.add(lblNewLabel);
	}

}
