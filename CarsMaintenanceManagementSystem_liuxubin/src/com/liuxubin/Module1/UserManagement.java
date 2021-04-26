package com.liuxubin.Module1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Module3.UserEnquiry;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagement frame = new UserManagement();
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
	public UserManagement() {
		setTitle("\u5BA2\u6237\u5355\u4F4D\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//客户信息添加
		JButton btnNewButton = new JButton("\u5BA2\u6237\u4FE1\u606F\u6DFB\u52A0");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 18));
		btnNewButton.setBounds(124, 25, 147, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarsInformationManagement frame = new CarsInformationManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		//客户信息查询
		JButton button = new JButton("\u5BA2\u6237\u4FE1\u606F\u67E5\u8BE2");
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 18));
		button.setBounds(124, 79, 147, 41);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserEnquiry frame = new UserEnquiry();
				frame.setVisible(true);
				dispose();
			}
		});
		//返回客户单位管理
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 18));
		button_1.setBounds(124, 133, 147, 41);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarsMaintenance frame = new CarsMaintenance();
				frame.setVisible(true);
				dispose();
			}
		});
	}

}
