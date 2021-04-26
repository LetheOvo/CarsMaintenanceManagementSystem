package com.liuxubin.Module1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Model.Client;
import com.liuxubin.dao.ClientDao;
import com.liuxubin.frames.CarLog;
import com.liuxubin.frames.ModuleSelection;
import com.liuxubin.util.JDBCUtil;
import com.liuxubin.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CarsInformationManagement extends JFrame {

	private JPanel contentPane;
	private JTextField clientNameTxt;
	private JTextField GenderTxt;
	private JTextField IDNumberTxt;
	private JTextField phoneNumberTxt;
	private JTextField HomeAddressTxt;
	
	private JDBCUtil jdbc=new JDBCUtil();
	private ClientDao clientDao=new ClientDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarsInformationManagement frame = new CarsInformationManagement();
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
	
	
	public CarsInformationManagement() {

		// TODO Auto-generated method stub
		setTitle("\u5BA2\u6237\u4FE1\u606F\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u4E3B\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("������", Font.PLAIN, 25));
		lblNewLabel.setBounds(72, 55, 130, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u6027    \u522B\uFF1A");
		label.setFont(new Font("������", Font.PLAIN, 25));
		label.setBounds(72, 99, 130, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\u7801\uFF1A");
		label_1.setFont(new Font("������", Font.PLAIN, 25));
		label_1.setBounds(72, 142, 130, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8F66\u4E3B\u7535\u8BDD\uFF1A");
		label_2.setFont(new Font("������", Font.PLAIN, 25));
		label_2.setBounds(72, 185, 130, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5730    \u5740\uFF1A");
		label_3.setFont(new Font("������", Font.PLAIN, 25));
		label_3.setBounds(72, 228, 130, 30);
		contentPane.add(label_3);
		
		//���ػ�ӭ����
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton.setFont(new Font("�����ֺ��μ���", Font.PLAIN, 20));
		btnNewButton.setBounds(58, 285, 163, 65);
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
		
		//ȷ����Ϣ¼��
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliectTypeAddActionPerformed(e);
			}
		});
		button.setFont(new Font("�����ֺ��μ���", Font.PLAIN, 20));
		button.setBounds(458, 285, 163, 65);
		contentPane.add(button);
		
		
		clientNameTxt = new JTextField();
		clientNameTxt.setBounds(216, 59, 315, 30);
		contentPane.add(clientNameTxt);
		clientNameTxt.setColumns(10);
		
		GenderTxt = new JTextField();
		GenderTxt.setColumns(10);
		GenderTxt.setBounds(216, 106, 315, 30);
		contentPane.add(GenderTxt);
		
		IDNumberTxt = new JTextField();
		IDNumberTxt.setColumns(10);
		IDNumberTxt.setBounds(216, 149, 315, 30);
		contentPane.add(IDNumberTxt);
		
		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setColumns(10);
		phoneNumberTxt.setBounds(216, 185, 315, 30);
		contentPane.add(phoneNumberTxt);
		
		HomeAddressTxt = new JTextField();
		HomeAddressTxt.setColumns(10);
		HomeAddressTxt.setBounds(216, 228, 315, 30);
		contentPane.add(HomeAddressTxt);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restValueActionPerformed(e);
				
			}
		});
		button_1.setFont(new Font("�����ֺ��μ���", Font.PLAIN, 20));
		button_1.setBounds(260, 285, 163, 65);
		contentPane.add(button_1);
	
	}
	//ȷ����Ϣ¼���¼�����
	private void cliectTypeAddActionPerformed(ActionEvent evt) {
		String clientName=this.clientNameTxt.getText();
		String gender=this.GenderTxt.getText();
		String idNumber=this.IDNumberTxt.getText();
		String phoneNumber=this.phoneNumberTxt.getText();
		String homeAddress=this.HomeAddressTxt.getText();
		/**
		 * �ж��ı��������Ƿ�Ϊ��
		 */
		if(StringUtil.isEmpty(clientName)) {
			JOptionPane.showMessageDialog(null, "�ͻ���������Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(null, "�Ա���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(idNumber)) {
			JOptionPane.showMessageDialog(null, "���֤���벻��Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(phoneNumber)) {
			JOptionPane.showMessageDialog(null, "�绰���벻��Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(homeAddress)) {
			JOptionPane.showMessageDialog(null, "��ͥסַ����Ϊ�գ�");
			return;
		}
		Client clientType=new Client(clientName,gender,idNumber,phoneNumber,homeAddress);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			int n=clientDao.add(conn, clientType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "��Ϣ¼��ɹ���");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "��Ϣ¼��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��Ϣ¼��ʧ�ܣ�");
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
} 

	

	private void resetValue() {
		// TODO Auto-generated method stub
		this.clientNameTxt.setText("");
		this.GenderTxt.setText("");
		this.IDNumberTxt.setText("");
		this.phoneNumberTxt.setText("");
		this.HomeAddressTxt.setText("");
	}

	//������Ϣ�¼�����
	private void restValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
		
		
	}
}
