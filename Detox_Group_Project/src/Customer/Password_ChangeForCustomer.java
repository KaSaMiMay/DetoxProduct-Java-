package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Admin_Dashboard;
import Admin.Admin_Login;
import Admin.Staff_Dashboard;
import Constructors.Account;
import Constructors.Staff;
import Dao.CRUD_Dao;
import Dao.Other_Dao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class Password_ChangeForCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtoldpwd;
	private JPasswordField txtnewpwd;
	private JPasswordField confirmpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password_ChangeForCustomer frame = new Password_ChangeForCustomer(new Staff());
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
	public Password_ChangeForCustomer(Staff s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(81, 192, 61));
		panel.setBounds(0, 0, 470, 62);
		contentPane.add(panel);

		JLabel lblAdminDashboard = new JLabel("Vitalsip Detox Juice\r\n ");
		lblAdminDashboard.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblAdminDashboard.setBounds(10, 0, 263, 62);
		panel.add(lblAdminDashboard);

		JLabel lblAdmin = new JLabel("Admin ");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdmin.setBounds(1215, 10, 126, 42);
		panel.add(lblAdmin);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1179, 10, 63, 42);
		panel.add(lblNewLabel_1);

		JButton btnBack = new JButton("Back to Login");
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
					new Staff_Dashboard(s).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        dispose();
		    }
		});

		btnBack.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(305, 77, 151, 33);
		contentPane.add(btnBack);

		txtoldpwd = new JPasswordField();
		txtoldpwd.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtoldpwd.setBounds(166, 121, 290, 26);
		contentPane.add(txtoldpwd);

		JLabel lblOldpsw = new JLabel("Old password         :");
		lblOldpsw.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblOldpsw.setBounds(12, 118, 169, 28);
		contentPane.add(lblOldpsw);

		JLabel lblNewpsw = new JLabel("New password       :");
		lblNewpsw.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblNewpsw.setBounds(12, 157, 169, 28);
		contentPane.add(lblNewpsw);

		txtnewpwd = new JPasswordField();
		txtnewpwd.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		txtnewpwd.setBounds(166, 160, 290, 26);
		contentPane.add(txtnewpwd);

		confirmpwd = new JPasswordField();
		confirmpwd.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		confirmpwd.setBounds(166, 199, 290, 26);
		contentPane.add(confirmpwd);

		JLabel lblConfirmpsw = new JLabel("Confirm password :");
		lblConfirmpsw.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		lblConfirmpsw.setBounds(12, 196, 144, 28);
		contentPane.add(lblConfirmpsw);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldpwd = new String(txtoldpwd.getPassword()).trim();
				String newpwd = new String(txtnewpwd.getPassword()).trim();
				String cmfpwd = new String(confirmpwd.getPassword()).trim();

				// Validate input
				if (oldpwd.isEmpty() || newpwd.isEmpty() || cmfpwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields must be filled in.");
					return;
				}

				if (!newpwd.equals(cmfpwd)) {
					JOptionPane.showMessageDialog(null, "New password and confirmation do not match.");
					return;
				}

				if (newpwd.equals(oldpwd)) {
					JOptionPane.showMessageDialog(null, "New password cannot be the same as the old password.");
					return;
				}

				String accountId = s.getName(); // Get the actual user ID

				try {
					CRUD_Dao userDAO = new CRUD_Dao();
					boolean isOldPwdCorrect = userDAO.verifyPassword(accountId, oldpwd);

					if (isOldPwdCorrect) {
						boolean isPasswordUpdated = userDAO.updatePassword(accountId, newpwd);
						if (isPasswordUpdated) {
							JOptionPane.showMessageDialog(null, "Password changed successfully!");
						} else {
							JOptionPane.showMessageDialog(null, "Failed to update password.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Old password is incorrect.");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error while changing password.");
				}
				new Admin_Login().setVisible(true);
			}
//			
		});
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		btnConfirm.setBackground(new Color(50, 205, 50));
		btnConfirm.setBounds(339, 250, 117, 33);
		contentPane.add(btnConfirm);

		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					// Show all password fields
					confirmpwd.setEchoChar((char) 0);
					txtnewpwd.setEchoChar((char) 0);
					txtoldpwd.setEchoChar((char) 0);
				} else {
					// Hide all password fields (set to default echo char for password fields)
					confirmpwd.setEchoChar('*');
					txtnewpwd.setEchoChar('*');
					txtoldpwd.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword.setFont(new Font("Monospaced", Font.PLAIN, 12));
		chckbxShowPassword.setBackground(UIManager.getColor("Button.light"));
		chckbxShowPassword.setBounds(166, 252, 132, 28);
		contentPane.add(chckbxShowPassword);
	}
}
