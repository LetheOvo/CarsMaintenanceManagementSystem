package com.liuxubin.Module2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Module3.AllParts;
import com.liuxubin.frames.ModuleSelection;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchasingManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchasingManagement frame = new PurchasingManagement();
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
	public PurchasingManagement() {
		setTitle("\u91C7\u8D2D\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//零件入库
		JButton btnNewButton = new JButton("\u96F6\u4EF6\u5165\u5E93");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 30));
		btnNewButton.setBounds(273, 54, 414, 57);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PartsStorage frame = new PartsStorage();
				frame.setVisible(true);
				dispose();
			}
		});
		//零件出库
		JButton button = new JButton("\u96F6\u4EF6\u51FA\u5E93");
		button.setFont(new Font("新宋体", Font.PLAIN, 30));
		button.setBounds(273, 124, 414, 57);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PartsOutOfStorage frame = new PartsOutOfStorage();
				frame.setVisible(true);
				dispose();
			}
		});
		//显示所有零件信息
		JButton button_1 = new JButton("\u663E\u793A\u6240\u6709\u96F6\u4EF6\u4FE1\u606F");
		button_1.setFont(new Font("新宋体", Font.PLAIN, 30));
		button_1.setBounds(273, 194, 414, 57);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AllParts frame = new AllParts();
				frame.setVisible(true);
				dispose();
			}
		});
		//返回模块选择界面
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_2.setFont(new Font("新宋体", Font.PLAIN, 30));
		button_2.setBounds(273, 264, 414, 57);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModuleSelection frame = new ModuleSelection();
				frame.setVisible(true);
				dispose();
			}
		});
	}

}
