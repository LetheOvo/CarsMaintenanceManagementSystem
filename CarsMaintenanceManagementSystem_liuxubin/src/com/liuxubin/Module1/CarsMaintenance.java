package com.liuxubin.Module1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.frames.ModuleSelection;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarsMaintenance extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarsMaintenance frame = new CarsMaintenance();
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
	public CarsMaintenance() {
		setTitle("\u8F66\u8F86\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//客户单位管理
		JButton btnNewButton = new JButton("\u5BA2\u6237\u5355\u4F4D\u7BA1\u7406");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		btnNewButton.setBounds(172, 33, 309, 63);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserManagement frame = new UserManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		//车辆信息管理
		JButton button = new JButton("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		button.setBounds(172, 109, 309, 63);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InformationManagement frame = new InformationManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		//车辆维修记录
		JButton button_1 = new JButton("\u8F66\u8F86\u7EF4\u4FEE\u8BB0\u5F55");
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		button_1.setBounds(172, 189, 309, 63);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MaintenanceRecords frame = new MaintenanceRecords();
				frame.setVisible(true);
				dispose();
			}
		});
		//返回模块选择界面
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModuleSelection frame = new ModuleSelection();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		button_2.setBounds(172, 265, 309, 63);
		contentPane.add(button_2);
	}
}
