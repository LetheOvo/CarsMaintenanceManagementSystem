package com.liuxubin.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Model.User;
import com.liuxubin.Module1.CarsInformationManagement;
import com.liuxubin.dao.UserDao;
import com.liuxubin.util.JDBCUtil;
import com.liuxubin.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passWordTxt;
	private JDBCUtil jdbc=new JDBCUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(148, 113, 128, 30);
		contentPane.add(lblNewLabel);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("新宋体", Font.PLAIN, 25));
		userNameTxt.setBounds(290, 113, 172, 30);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6  \u7801\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 25));
		label.setBounds(148, 185, 128, 30);
		contentPane.add(label);
		
		passWordTxt = new JPasswordField();
		passWordTxt.setFont(new Font("新宋体", Font.PLAIN, 25));
		passWordTxt.setColumns(10);
		passWordTxt.setBounds(290, 185, 172, 30);
		contentPane.add(passWordTxt);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restValueActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 25));
		btnNewButton.setBounds(125, 293, 140, 55);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u786E\u8BA4\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);		
			}
		});
		button.setFont(new Font("新宋体", Font.PLAIN, 25));
		button.setBounds(340, 293, 140, 55);
		contentPane.add(button);
		
	}
	//登陆事件处理
protected void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName=this.userNameTxt.getText();
		String passWord=this.passWordTxt.getText();
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user=new User(userName,passWord);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			User currentUser=userDao.login(conn,user);
			if (currentUser !=null) {
				JOptionPane.showMessageDialog(null, "登陆成功");
				dispose();
				ModuleSelection frame = new ModuleSelection();
				frame.setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "登陆失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//重置信息事件处理
	protected void restValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.userNameTxt.setText("");
		this.passWordTxt.setText("");
	}
}
