package com.liuxubin.Module1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Model.Owner;
import com.liuxubin.dao.OwnerDao;
import com.liuxubin.util.JDBCUtil;
import com.liuxubin.util.StringUtil;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;

public class InformationManagement extends JFrame {

	private JPanel contentPane;
	private JTextField ownerNameTxt;
	private JTextField VehicleModelTxt;
	private JTextField VehicleRegistrationTxt;
	private JTextField ContactNumberTxt;
	private JDBCUtil jdbc=new JDBCUtil();
	private OwnerDao ownerDao=new OwnerDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationManagement frame = new InformationManagement();
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
	public InformationManagement() {
		setTitle("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u4E3B\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(118, 78, 125, 44);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8F66\u8F86\u578B\u53F7\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 25));
		label.setBounds(118, 135, 125, 44);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\u7801\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 25));
		label_1.setBounds(118, 192, 125, 44);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 25));
		label_2.setBounds(118, 249, 125, 44);
		contentPane.add(label_2);
		
		ownerNameTxt = new JTextField();
		ownerNameTxt.setFont(new Font("新宋体", Font.PLAIN, 25));
		ownerNameTxt.setBounds(257, 78, 209, 44);
		contentPane.add(ownerNameTxt);
		ownerNameTxt.setColumns(10);
		
		VehicleModelTxt = new JTextField();
		VehicleModelTxt.setFont(new Font("新宋体", Font.PLAIN, 25));
		VehicleModelTxt.setColumns(10);
		VehicleModelTxt.setBounds(257, 135, 209, 44);
		contentPane.add(VehicleModelTxt);
		
		VehicleRegistrationTxt = new JTextField();
		VehicleRegistrationTxt.setFont(new Font("新宋体", Font.PLAIN, 25));
		VehicleRegistrationTxt.setColumns(10);
		VehicleRegistrationTxt.setBounds(257, 192, 209, 44);
		contentPane.add(VehicleRegistrationTxt);
		
		ContactNumberTxt = new JTextField();
		ContactNumberTxt.setFont(new Font("新宋体", Font.PLAIN, 25));
		ContactNumberTxt.setColumns(10);
		ContactNumberTxt.setBounds(257, 249, 209, 44);
		contentPane.add(ContactNumberTxt);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		btnNewButton.setBounds(59, 329, 137, 34);
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
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		button.setBounds(242, 328, 137, 34);
		contentPane.add(button);
		//确认信息录入
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarInformationAddActionPerformed(e);
			}
		});
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		button_1.setBounds(420, 329, 137, 34);
		contentPane.add(button_1);
		
	}
/**
 * 确认信息录入事件处理
 * @param e
 */
	protected void CarInformationAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String ownerName=this.ownerNameTxt.getText();
		String vehicleModel=this.VehicleModelTxt.getText();
		String VehicleRegistration=this.VehicleRegistrationTxt.getText();
		String ContactNumber=this.ContactNumberTxt.getText();
		/**
		 * 判断文本框是否为空
		 */
		if (StringUtil.isEmpty(ownerName)) {
			JOptionPane.showMessageDialog(null, "车主姓名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(vehicleModel)) {
			JOptionPane.showMessageDialog(null, "车辆型号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(VehicleRegistration)) {
			JOptionPane.showMessageDialog(null, "车牌号码不能为空！");
			return;
		}
		if (StringUtil.isEmpty(ContactNumber)) {
			JOptionPane.showMessageDialog(null, "联系电话不能为空！");
			return;
		}
		Owner owner=new Owner(ownerName,vehicleModel,VehicleRegistration,ContactNumber);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			int n=ownerDao.add(conn,owner);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "信息录入成功！");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "信息录入失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "信息录入失败！");
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
	}

	private void resetValue() {
	// TODO Auto-generated method stub
		this.ownerNameTxt.setText("");
		this.VehicleModelTxt.setText("");
		this.VehicleRegistrationTxt.setText("");
		this.ContactNumberTxt.setText("");
}
/**
 * 重置信息事件处理
 * @param e
 */
	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}
}
