package com.liuxubin.Module1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Model.Records;
import com.liuxubin.dao.RecordsDao;
import com.liuxubin.util.JDBCUtil;
import com.liuxubin.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MaintenanceRecords extends JFrame {

	private JPanel contentPane;
	private JTextField plateNumberTxt;
	private JTextField partsIdTxt;
	private JTextField useNumberTxt;
	private JTextField repairNumberTxt;
	private JTextField repairTimeTxt;
	
	private JDBCUtil jdbc=new JDBCUtil();
	private RecordsDao recordsDao=new RecordsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaintenanceRecords frame = new MaintenanceRecords();
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
	public MaintenanceRecords() {
		setTitle("\u8F66\u8F86\u7EF4\u4FEE\u8BB0\u5F55\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u724C\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(117, 54, 100, 34);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u96F6\u4EF6\u540D\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 20));
		label.setBounds(117, 118, 100, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4F7F\u7528\u6570\u91CF\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_1.setBounds(117, 180, 100, 34);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4FEE\u7406\u5DE5\u53F7\uFF1A");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_2.setBounds(117, 241, 100, 34);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u4FEE\u7406\u65F6\u957F\uFF1A");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_3.setBounds(117, 308, 100, 34);
		contentPane.add(label_3);
		
		plateNumberTxt = new JTextField();
		plateNumberTxt.setFont(new Font("新宋体", Font.PLAIN, 20));
		plateNumberTxt.setBounds(212, 54, 281, 34);
		contentPane.add(plateNumberTxt);
		plateNumberTxt.setColumns(10);
		
		partsIdTxt = new JTextField();
		partsIdTxt.setFont(new Font("新宋体", Font.PLAIN, 20));
		partsIdTxt.setColumns(10);
		partsIdTxt.setBounds(212, 118, 281, 34);
		contentPane.add(partsIdTxt);
		
		useNumberTxt = new JTextField();
		useNumberTxt.setFont(new Font("新宋体", Font.PLAIN, 20));
		useNumberTxt.setColumns(10);
		useNumberTxt.setBounds(212, 180, 281, 34);
		contentPane.add(useNumberTxt);
		
		repairNumberTxt = new JTextField();
		repairNumberTxt.setFont(new Font("新宋体", Font.PLAIN, 20));
		repairNumberTxt.setColumns(10);
		repairNumberTxt.setBounds(212, 241, 281, 34);
		contentPane.add(repairNumberTxt);
		
		repairTimeTxt = new JTextField();
		repairTimeTxt.setFont(new Font("新宋体", Font.PLAIN, 20));
		repairTimeTxt.setColumns(10);
		repairTimeTxt.setBounds(212, 308, 281, 34);
		contentPane.add(repairTimeTxt);
		/**
		 * 返回上一级
		 */
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		btnNewButton.setBounds(54, 382, 146, 57);
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
		/**
		 * 信息打印_信息录入
		 */
		JButton button = new JButton("\u4FE1\u606F\u6253\u5370");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entryrecordsActionPerformed(e);
			}
		});
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		button.setBounds(470, 382, 146, 57);
		contentPane.add(button);
		
		/**
		 * 重置
		 */
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetrecordsActionPerformed(e);
			}
		});
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		button_1.setBounds(268, 382, 146, 57);
		contentPane.add(button_1);
		
	}
/**
 * 信息答应录入事件处理
 * @param evt
 */
	protected void entryrecordsActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String plateNumber=this.plateNumberTxt.getText();
		String partsId=this.partsIdTxt.getText();
		String useNumber=this.useNumberTxt.getText();
		String repairNumber=this.repairNumberTxt.getText();
		String repairTime=this.repairTimeTxt.getText();
		/**
		 * 判断文本框是否为空
		 */
		if (StringUtil.isEmpty(plateNumber)) {
			JOptionPane.showMessageDialog(null, "车牌号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsId)){
			JOptionPane.showMessageDialog(null, "零件名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(useNumber)) {
			JOptionPane.showMessageDialog(null, "使用数量不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairNumber)) {
			JOptionPane.showMessageDialog(null, "修理工号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairTime)) {
			JOptionPane.showMessageDialog(null, "修理时长不能为空！");
			return;
		}
		Records records=new Records(plateNumber,partsId,useNumber,repairNumber,repairTime);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			int n=recordsDao.add(conn, records);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "信息打印成功！");
			    entryrecords();
			} else {
				JOptionPane.showMessageDialog(null, "信息打印失败！");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "信息打印失败！");
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	private void entryrecords() {
	// TODO Auto-generated method stub
		this.partsIdTxt.setText("");
		this.plateNumberTxt.setText("");
		this.repairNumberTxt.setText("");
		this.repairTimeTxt.setText("");
		this.useNumberTxt.setText("");
}
/**
 * 重置信息事件处理
 * @param e
 */
	protected void resetrecordsActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.entryrecords();
	}
}
