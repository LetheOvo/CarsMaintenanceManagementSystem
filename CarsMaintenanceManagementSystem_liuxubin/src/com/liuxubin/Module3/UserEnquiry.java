package com.liuxubin.Module3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.liuxubin.Model.Client;
import com.liuxubin.Module1.UserManagement;
import com.liuxubin.dao.ClientDao;
import com.liuxubin.util.JDBCUtil;

public class UserEnquiry extends JFrame {

	private JPanel contentPane;
	private JTextField clientNameTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private ClientDao clientDao = new ClientDao();
	private JTable clientInformationTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserEnquiry frame = new UserEnquiry();
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
	public UserEnquiry() {
		setTitle("\u5BA2\u6237\u4FE1\u606F\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5DF2\u6709\u5BA2\u6237\u4FE1\u606F\u5217\u8868\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u641C\u7D22\uFF1A");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 20));
		
		clientNameTxt = new JTextField();
		clientNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientNameSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		clientInformationTable = new JTable();
		clientInformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u8F66\u724C\u53F7", "\u7535\u8BDD\u53F7\u7801", "\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(clientInformationTable);
		this.fillTable(new Client());
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1)
					.addGap(3)
					.addComponent(lblNewLabel_2)
					.addGap(2)
					.addComponent(clientNameTxt, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 891, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(clientNameTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		button.addActionListener(new ActionListener() {
		/**
		 * 返回上一层	
		 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserManagement frame = new UserManagement();
				frame.setVisible(true);
				dispose();
			}
		});
		
	}
/**
 * 确认按名字查询客户信息
 * @param e
 */
	private void clientNameSearchActionPerformed(ActionEvent evt) {
		String ClientName=this.clientNameTxt.getText();
		Client client=new Client();
		client.setClientName(ClientName);
		this.fillTable(client);
	}
/**
 * 初始化把表格
 * @param client
 */
private void fillTable(Client client) {
	DefaultTableModel dtm=(DefaultTableModel) clientInformationTable.getModel();
	dtm.setRowCount(0);
	Connection conn=null;
	try {
		conn=jdbc.getConnection();
		ResultSet rs=clientDao.list(conn, client);
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("id"));
			v.add(rs.getString("ClientName"));
			v.add(rs.getString("Gender"));
			v.add(rs.getString("IDNumber"));
			v.add(rs.getString("PhoneNumber"));
			v.add(rs.getString("HomeAddress"));
			dtm.addRow(v);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		try {
			jdbc.closeCon(conn);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
}
