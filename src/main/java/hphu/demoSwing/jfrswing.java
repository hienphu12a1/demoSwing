package hphu.demoSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import java.sql.*;

public class jfrswing extends JFrame {
	private JTextField txtFUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfrswing frame = new jfrswing();
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
	public jfrswing() throws SQLException, ClassNotFoundException {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(27, 23, 77, 29);
		getContentPane().add(lblUsername);
		
		txtFUserName = new JTextField();
		txtFUserName.setBounds(110, 23, 199, 29);
		getContentPane().add(txtFUserName);
		txtFUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setBounds(27, 64, 77, 16);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 55, 199, 29);
		getContentPane().add(passwordField);
		
		Button btnlogin = new Button("LOGIN");
		btnlogin.setForeground(Color.BLACK);
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnlogin.setBackground(Color.WHITE);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = demoConnection.getMysqlConnection();
					
					Statement statement = conn.createStatement();
					
					String sql = "SELECT * FROM employee";
					
					ResultSet rs = statement.executeQuery(sql);
					
					while(rs.next())
					{
						JOptionPane.showMessageDialog(null, rs.getString("username"));
						
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnlogin.setBounds(27, 104, 88, 29);
		getContentPane().add(btnlogin);
		
	
	}
}
