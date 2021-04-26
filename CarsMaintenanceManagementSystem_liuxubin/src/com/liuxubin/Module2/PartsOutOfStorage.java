package com.liuxubin.Module2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PartsOutOfStorage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField partsIdTxt;
	private JTextField partsNumberTxt;
	private JTextField partsPriceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartsOutOfStorage frame = new PartsOutOfStorage();
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
	public PartsOutOfStorage() {
		setTitle("\u96F6\u4EF6\u51FA\u5E93");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u96F6\u4EF6\u5165\u5E93\u5355");
		label.setBounds(0, 0, 0, 0);
		label.setFont(new Font("新宋体", Font.PLAIN, 30));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u96F6\u4EF6\u540D\uFF1A");
		label_1.setBounds(0, 0, 0, 0);
		label_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 0, 0);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_2.setBounds(0, 0, 0, 0);
		label_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 0, 0, 0);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("\u96F6\u4EF6\u4EF7\u683C\uFF1A");
		label_3.setBounds(0, 0, 0, 0);
		label_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u6DFB\u52A0\u96F6\u4EF6\u51FA\u5E93\u5355");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 30));
		label_4.setBounds(247, 28, 225, 44);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u96F6\u4EF6\u540D\uFF1A");
		label_5.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_5.setBounds(156, 100, 103, 31);
		contentPane.add(label_5);
		
		partsIdTxt = new JTextField();
		partsIdTxt.setColumns(10);
		partsIdTxt.setBounds(247, 105, 261, 24);
		contentPane.add(partsIdTxt);
		
		JLabel label_6 = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_6.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_6.setBounds(156, 144, 103, 31);
		contentPane.add(label_6);
		
		partsNumberTxt = new JTextField();
		partsNumberTxt.setColumns(10);
		partsNumberTxt.setBounds(247, 144, 261, 24);
		contentPane.add(partsNumberTxt);
		
		JLabel label_7 = new JLabel("\u96F6\u4EF6\u4EF7\u683C\uFF1A");
		label_7.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_7.setBounds(156, 188, 103, 31);
		contentPane.add(label_7);
		
		partsPriceTxt = new JTextField();
		partsPriceTxt.setColumns(10);
		partsPriceTxt.setBounds(247, 188, 261, 24);
		contentPane.add(partsPriceTxt);
		//返回采购管理
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 23));
		button.setBounds(55, 247, 163, 49);
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
		//确认出库
		JButton button_1 = new JButton("\u786E\u8BA4\u51FA\u5E93");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 23));
		button_1.setBounds(436, 247, 163, 49);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restpartsActionPerformed(e);
			}
		});
		button_2.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 23));
		button_2.setBounds(247, 247, 163, 49);
		contentPane.add(button_2);
	}

	protected void restpartsActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.partsIdTxt.setText("");
		this.partsNumberTxt.setText("");
		this.partsPriceTxt.setText("");
	}
}
