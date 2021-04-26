package com.liuxubin.Module3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.liuxubin.Model.Parts;
import com.liuxubin.Module2.PurchasingManagement;
import com.liuxubin.dao.PartsDao;
import com.liuxubin.util.JDBCUtil;
import javax.swing.JTextField;

public class AllParts extends JFrame {

	private JPanel contentPane;
	private JTable partsTable;
	
	private JDBCUtil jdbc = new JDBCUtil();
	private PartsDao partsDao  = new PartsDao();
	private JTextField partsNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllParts frame = new AllParts();
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
	public AllParts() {
		setTitle("\u663E\u793A\u6240\u6709\u96F6\u4EF6\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6240\u6709\u96F6\u4EF6\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 13, 150, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 25));
		btnNewButton.setBounds(714, 579, 187, 52);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 58, 684, 478);
		contentPane.add(scrollPane);
		
		partsTable = new JTable();
		partsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u96F6\u4EF6\u540D\u79F0", "\u96F6\u4EF6\u6570\u91CF", "\u96F6\u4EF6\u4EF7\u683C"
			}
		));
		scrollPane.setViewportView(partsTable);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u96F6\u4EF6\u540D\u79F0\uFF1A");
		lblNewLabel_1.setBounds(215, 28, 105, 21);
		contentPane.add(lblNewLabel_1);
		
		partsNameTxt = new JTextField();
		partsNameTxt.setBounds(328, 25, 144, 24);
		contentPane.add(partsNameTxt);
		partsNameTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partsSearchActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(511, 24, 160, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PurchasingManagement frame = new PurchasingManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		this.fillTable(new Parts());
	}
	/**
	 * 零件名搜索事件处理
	 * @param evt
	 */
	protected void partsSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String partsName=this.partsNameTxt.getText();
		Parts parts=new Parts();
		parts.setPartsId(partsName);
		this.fillTable(parts);
	}

	/**
	 * 初始化表格
	 * @param parts
	 */
	private void fillTable(Parts parts) {
		DefaultTableModel dtm=(DefaultTableModel) partsTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			ResultSet rs=partsDao.list(conn, parts);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("PartsId"));
				v.add(rs.getString("PartsNumber"));
				v.add(rs.getString("PartsPrice"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
