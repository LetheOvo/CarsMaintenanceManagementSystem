package com.liuxubin.Module1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class ManagementSystem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementSystem frame = new ManagementSystem();
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
	public ManagementSystem() {
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 559);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setForeground(SystemColor.textText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(14, 13, 146, 24);
		textField.setBackground(SystemColor.controlHighlight);
		textField.setForeground(SystemColor.textText);
		textField.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField.setText("\u6DFB\u52A0\u5BA2\u6237\u4FE1\u606F\uFF1A");
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 63, 112, 24);
		textField_1.setBackground(SystemColor.controlHighlight);
		textField_1.setForeground(SystemColor.textText);
		textField_1.setText("\u5BA2\u6237\u59D3\u540D\uFF1A");
		textField_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 101, 112, 24);
		textField_2.setBackground(SystemColor.controlHighlight);
		textField_2.setForeground(SystemColor.textText);
		textField_2.setText("\u6027\u522B\uFF1A");
		textField_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 138, 112, 24);
		textField_3.setBackground(SystemColor.controlHighlight);
		textField_3.setForeground(SystemColor.textText);
		textField_3.setText("\u8EAB\u4EFD\u8BC1\uFF1A");
		textField_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 175, 112, 24);
		textField_4.setBackground(SystemColor.controlHighlight);
		textField_4.setForeground(SystemColor.textText);
		textField_4.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		textField_4.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(126, 212, 112, 24);
		textField_5.setBackground(SystemColor.controlHighlight);
		textField_5.setForeground(SystemColor.textText);
		textField_5.setText("\u5730\u5740\uFF1A");
		textField_5.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(126, 249, 112, 24);
		textField_6.setBackground(SystemColor.controlHighlight);
		textField_6.setForeground(SystemColor.textText);
		textField_6.setText("\u54C1\u724C\uFF1A");
		textField_6.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(126, 286, 112, 24);
		textField_7.setBackground(SystemColor.controlHighlight);
		textField_7.setForeground(SystemColor.textText);
		textField_7.setText("\u8F66\u578B\uFF1A");
		textField_7.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(126, 323, 112, 24);
		textField_8.setBackground(SystemColor.controlHighlight);
		textField_8.setForeground(SystemColor.textText);
		textField_8.setText("\u5907\u6CE8\uFF1A");
		textField_8.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_8.setColumns(10);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(236, 65, 550, 24);
		textField_9.setFont(new Font("新宋体", Font.PLAIN, 20));
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(236, 102, 550, 24);
		textField_10.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_10.setColumns(10);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(236, 140, 550, 24);
		textField_11.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_11.setColumns(10);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setBounds(236, 177, 550, 24);
		textField_12.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_12.setColumns(10);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setBounds(236, 214, 550, 24);
		textField_13.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_13.setColumns(10);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setBounds(236, 251, 550, 24);
		textField_14.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_14.setColumns(10);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setBounds(236, 288, 550, 24);
		textField_15.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_15.setColumns(10);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setBounds(236, 325, 684, 102);
		textField_16.setFont(new Font("新宋体", Font.PLAIN, 20));
		textField_16.setColumns(10);
		contentPane.add(textField_16);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		btnNewButton.setBounds(226, 440, 125, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(459, 440, 125, 39);
		contentPane.add(btnNewButton_1);
		
		button = new JButton("\u8FD4\u56DE");
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		button.setBounds(689, 440, 125, 39);
		contentPane.add(button);
	}
}
