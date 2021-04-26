package com.liuxubin.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Module1.CarsInformationManagement;
import com.liuxubin.Module1.CarsMaintenance;
import com.liuxubin.Module2.PurchasingManagement;
import com.liuxubin.Module3.ComprehensiveQuery;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModuleSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuleSelection frame = new ModuleSelection();
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
	public ModuleSelection() {
		setTitle("\u6A21\u5757\u9009\u62E9\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//车辆维护
		JButton btnNewButton = new JButton("\u8F66\u8F86\u7EF4\u62A4");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		btnNewButton.setBounds(279, 36, 350, 50);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CarsMaintenance frame = new CarsMaintenance();
				frame.setVisible(true);
				dispose();
			}
		});
		//采购管理
		JButton button = new JButton("\u91C7\u8D2D\u7BA1\u7406");
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		button.setBounds(279, 99, 350, 50);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PurchasingManagement frame = new PurchasingManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		//综合查询
		JButton button_1 = new JButton("\u7EFC\u5408\u67E5\u8BE2");
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		button_1.setBounds(279, 162, 350, 50);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ComprehensiveQuery frame = new ComprehensiveQuery();
				frame.setVisible(true);
				dispose();
			}
		});
		//返回信息登记
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_2.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 30));
		button_2.setBounds(279, 225, 350, 50);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LogIn frame = new LogIn();
				frame.setVisible(true);
				dispose();
			}
		});
	}

}
