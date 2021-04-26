package com.liuxubin.Module2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.liuxubin.Model.Parts;
import com.liuxubin.dao.PartsDao;
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

public class PartsStorage extends JFrame {

	private JPanel contentPane;
	private JTextField partsIdTxt;
	private JTextField partsNumberTxt;
	private JTextField partsPriceTxt;
	

	private JDBCUtil jdbc=new JDBCUtil();
	private PartsDao partsDao=new PartsDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartsStorage frame = new PartsStorage();
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
	public PartsStorage() {
		setTitle("\u96F6\u4EF6\u5165\u5E93");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u96F6\u4EF6\u5165\u5E93\u5355");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(197, 45, 225, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u96F6\u4EF6\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(106, 117, 103, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 20));
		label.setBounds(106, 161, 103, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u96F6\u4EF6\u4EF7\u683C\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_1.setBounds(106, 205, 103, 31);
		contentPane.add(label_1);
		//返回采购管理界面
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 23));
		btnNewButton.setBounds(47, 264, 163, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PurchasingManagement frame = new PurchasingManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		//确认入库
		JButton button = new JButton("\u786E\u8BA4\u5165\u5E93");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmStorageActionPerformed(e);
			}
		});
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 23));
		button.setBounds(405, 264, 163, 49);
		contentPane.add(button);
		
		partsIdTxt = new JTextField();
		partsIdTxt.setBounds(197, 122, 261, 24);
		contentPane.add(partsIdTxt);
		partsIdTxt.setColumns(10);
		
		partsNumberTxt = new JTextField();
		partsNumberTxt.setColumns(10);
		partsNumberTxt.setBounds(197, 161, 261, 24);
		contentPane.add(partsNumberTxt);
		
		partsPriceTxt = new JTextField();
		partsPriceTxt.setColumns(10);
		partsPriceTxt.setBounds(197, 205, 261, 24);
		contentPane.add(partsPriceTxt);
		/**
		 * 重置
		 */
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restpartsActionPerformed(e);
			}
		});
		button_1.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 23));
		button_1.setBounds(228, 264, 163, 49);
		contentPane.add(button_1);
	}
	/**
	 * 确认入库事件处理
	 * @param e
	 */
protected void confirmStorageActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String partsId=this.partsIdTxt.getText();
		String partsNUmber=this.partsNumberTxt.getText();
		String partsPrice=this.partsPriceTxt.getText();
		/**
		 * 判断文本框是否为空
		 */
		if (StringUtil.isEmpty(partsId)) {
			JOptionPane.showMessageDialog(null, "零件名不能为空！");
		    return;
		}
		if (StringUtil.isEmpty(partsNUmber)) {
			JOptionPane.showMessageDialog(null, "零件数量不能为空！");
		    return;
		}
		if (StringUtil.isEmpty(partsPrice)) {
			JOptionPane.showMessageDialog(null, "零件价格不能为空！");
		    return;
		}
		Parts parts=new Parts(partsId,partsNUmber,partsPrice);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			int n=partsDao.add(conn,parts);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "入库成功！");
				interparts();
			}else {
				
				JOptionPane.showMessageDialog(null, "入库失败！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "入库失败！");
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

private void interparts() {
		// TODO Auto-generated method stub
	this.partsIdTxt.setText("");
	this.partsNumberTxt.setText("");
	this.partsPriceTxt.setText("");
	}

/**
 * 重置事件处理
 * @param e
 */
	protected void restpartsActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.interparts();
	}
}
