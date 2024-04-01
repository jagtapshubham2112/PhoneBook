package userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.Period;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sqlite.SQLiteException;

public class AddContact extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblId;
	private JLabel lblFirstName, lblLastName, lblMiddleName;
	private JLabel lblMobile, lblEmail, lblAddress, lblCity;

	private JLabel lblPhoto, lblPhotoPath;

	private JTextField txtId;

	private JTextField txtFirstName, txtLastName, txtMiddleName, txtAddress, txtCity;

	private JTextField txtMobile, txtEmail;	

	private String photoFile = "photo";

	private JButton btnNew, btnSave, btnView, btnEdit, btnDelete, btnPhoto, btnCancel;

	String StrId[], StrBdate[];

	public AddContact() {

		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.orange));
		

		lblId = new JLabel("Id: ");
		lblId.setFont(new Font("Arial", Font.BOLD, 14));
		lblId.setSize(300, 20);
		lblId.setLocation(20, 30);

		lblFirstName = new JLabel("First Name: ");
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 14));
		lblFirstName.setSize(300, 20);
		lblFirstName.setLocation(20, 70);

		lblMiddleName = new JLabel("Middle Name: ");
		lblMiddleName.setFont(new Font("Arial", Font.BOLD, 14));
		lblMiddleName.setSize(300, 20);
		lblMiddleName.setLocation(20, 100);

		lblLastName = new JLabel("Last Name: ");
		lblLastName.setFont(new Font("Arial", Font.BOLD, 14));
		lblLastName.setSize(300, 20);
		lblLastName.setLocation(20, 130);

		lblMobile = new JLabel("Mobile: ");
		lblMobile.setFont(new Font("Arial", Font.BOLD, 14));
		lblMobile.setSize(300, 20);
		lblMobile.setLocation(20, 170);

		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setSize(300, 20);
		lblEmail.setLocation(20, 200);

		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 14));
		lblAddress.setSize(300, 20);
		lblAddress.setLocation(20, 240);
		
		lblCity = new JLabel("City: ");
		lblCity.setFont(new Font("Arial", Font.BOLD, 14));
		lblCity.setSize(300, 20);
		lblCity.setLocation(20, 305);

		txtId = new JTextField("");
		txtId.setFont(new Font("Arial", Font.PLAIN, 14));
		txtId.setSize(150, 20);
		txtId.setLocation(150, 30);

		txtFirstName = new JTextField("");
		txtFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFirstName.setSize(150, 20);
		txtFirstName.setLocation(150, 70);

		txtMiddleName = new JTextField("");
		txtMiddleName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMiddleName.setSize(150, 20);
		txtMiddleName.setLocation(150, 100);

		txtLastName = new JTextField("");
		txtLastName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLastName.setSize(150, 20);
		txtLastName.setLocation(150, 130);

		txtMobile = new JTextField("");
		txtMobile.setFont(new Font("Arial", Font.BOLD, 14));
		txtMobile.setForeground(Color.blue);
		txtMobile.setBackground(Color.cyan);
		txtMobile.setSize(150, 20);
		txtMobile.setLocation(150, 170);

		txtEmail = new JTextField("");
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setSize(150, 20);
		txtEmail.setLocation(150, 200);

		txtAddress = new JTextField("");
		txtAddress.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAddress.setSize(150, 50);		
		txtAddress.setLocation(150, 240);
		
		txtCity = new JTextField("");
		txtCity.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCity.setSize(150, 20);
		txtCity.setLocation(150, 305);

		lblPhoto = new JLabel(new ImageIcon(ClassLoader.getSystemResource("photo/" + photoFile + ".png")));
		lblPhoto.setFont(new Font("Arial", Font.BOLD, 14));
		lblPhoto.setSize(100, 100);
		lblPhoto.setLocation(350, 10);

		lblPhotoPath = new JLabel("Photo Path");
		lblPhotoPath.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhotoPath.setSize(100, 20);
		lblPhotoPath.setLocation(150, 30);

		btnPhoto = new JButton("Photo", new ImageIcon(ClassLoader.getSystemResource("images/photo20x20.png")));
		btnPhoto.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPhoto.setSize(100, 25);
		btnPhoto.setLocation(350, 120);
		btnPhoto.setToolTipText("Add Photo");

		btnNew = new JButton("New", new ImageIcon(ClassLoader.getSystemResource("images/new20x20.png")));
		btnNew.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNew.setSize(100, 25);
		btnNew.setLocation(350, 155);
		btnNew.setToolTipText("New");

		btnSave = new JButton("Save", new ImageIcon(ClassLoader.getSystemResource("images/save20x20.png")));
		btnSave.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSave.setSize(100, 25);
		btnSave.setLocation(350, 185);
		btnSave.setToolTipText("Save Record");

		btnView = new JButton("View", new ImageIcon(ClassLoader.getSystemResource("images/view20x20.png")));
		btnView.setFont(new Font("Arial", Font.PLAIN, 14));
		btnView.setSize(100, 25);
		btnView.setLocation(350, 215);
		btnView.setToolTipText("View Record");

		btnEdit = new JButton("Edit", new ImageIcon(ClassLoader.getSystemResource("images/edit20x20.png")));
		btnEdit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEdit.setSize(100, 25);
		btnEdit.setLocation(350, 245);
		btnEdit.setToolTipText("Edit Record");

		btnDelete = new JButton("Delete", new ImageIcon(ClassLoader.getSystemResource("images/delete20x20.png")));
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDelete.setSize(100, 25);
		btnDelete.setLocation(350, 275);
		btnDelete.setToolTipText("Delete Record");
		
		btnCancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("images/cancel20x20.png")));
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancel.setSize(100, 25);
		btnCancel.setLocation(350, 305);
		btnCancel.setToolTipText("Close App");

		add(lblId);
		add(txtId);
		
		add(lblFirstName);
		add(lblMiddleName);
		add(lblLastName);

		add(txtFirstName);
		add(txtMiddleName);
		add(txtLastName);

		add(lblAddress);
		add(lblCity);
	
		add(txtAddress);
		add(txtCity);

		add(lblMobile);
		add(lblEmail);

		add(txtMobile);
		add(txtEmail);

		add(lblPhoto);	
		add(btnPhoto);

		add(btnNew);
		add(btnSave);
		add(btnView);
		add(btnEdit);
		add(btnDelete);
		add(btnCancel);

	
		setEnable("default");
		

		btnPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				FileDialog fd = new FileDialog(new JFrame(), "Open File");
				fd.setVisible(true);
				lblPhotoPath.setText(fd.getDirectory() + fd.getFile());
				lblPhoto.setIcon(new ImageIcon(fd.getDirectory() + fd.getFile()));
			}
		});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				setEnable("new");
				clearFields();
				int id = Integer.parseInt(getPId())+1;
				txtId.setText(String.valueOf(id));

			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				savePerson();
				setEnable("default");
			}
		});

		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFrame frame = new JFrame();
				viewRecord(new ViewContact(frame).getPersonId());

				setEnable("view");
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				updateRecord();
				setEnable("default");
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure? Exit the Apps?.", "Exiting Application.",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
	}
private void clearFields() {
	txtId.setText("");
	txtFirstName.setText("");
	txtMiddleName.setText("");
	txtLastName.setText("");
	txtAddress.setText("");
	lblPhotoPath.setText("photo/photo20x20.png");
	lblPhoto.setIcon(new ImageIcon(ClassLoader.getSystemResource("photo/photo.png")));
	txtMobile.setText("");
	txtEmail.setText("");

}
	private void setEnable(String mode) {
		switch (mode) {
		case "default":
			btnNew.setEnabled(true);
			btnSave.setEnabled(false);
			btnView.setEnabled(true);
			btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);
			btnPhoto.setEnabled(false);
			break;
		case "new":
			btnNew.setEnabled(false);
			btnSave.setEnabled(true);
			btnView.setEnabled(true);
			btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);
			btnPhoto.setEnabled(true);
			break;
		case "view":
			btnNew.setEnabled(true);
			btnSave.setEnabled(false);
			btnView.setEnabled(true);
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);
			btnPhoto.setEnabled(true);
			break;
		}
	}

	

	// to save records
	public void savePerson() {
		try {

			String url = "jdbc:sqlite:D:\\Projects\\PhoneBook\\PhoneBookDb.db";
			Connection con = DriverManager.getConnection(url);

			String query = "INSERT INTO `contact_master` (`P_FirstName`, `P_MiddleName`, `P_LastName`, `P_Mobile`, `P_Email`,`P_Photo`,`P_Address`,`P_City`) VALUES "
					+ "(?, ?, ?, ?, ?, ?,?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtFirstName.getText());
			ps.setString(2, txtMiddleName.getText());
			ps.setString(3, txtLastName.getText());
			ps.setString(4, txtMobile.getText());
			ps.setString(5, txtEmail.getText());
			ps.setString(6, lblPhotoPath.getText());
			ps.setString(7, txtAddress.getText());
			ps.setString(8, txtCity.getText());
		
			ps.execute();
			JOptionPane.showMessageDialog(null, "Record Saved Successfully!");
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fail to Save Record!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getPId() {
		try {
			String url = "jdbc:sqlite:D:\\Projects\\PhoneBook\\PhoneBookDb.db";
			Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String query = "SELECT * from contact_master ORDER BY P_Id DESC LIMIT 1;";
			ResultSet rs = st.executeQuery(query);
			int id = 0;
			while (rs.next()) {
				id = rs.getInt(1);
			}
			rs.close();
			con.close();
			String sid = String.valueOf(id);
			return sid;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// to view records
	public void viewRecord(String id) {
		try {
			String url = "jdbc:sqlite:D:\\Projects\\PhoneBook\\PhoneBookDb.db";
			Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String query = "SELECT contact_master.P_firstname," + "contact_master.P_middlename, contact_master.P_lastname,"
					+ "contact_master.P_mobile, contact_master.P_email, " + "contact_master.P_photo , "
					+ "contact_master.P_Address, contact_master.P_City  from contact_master "
					+ "WHERE contact_master.P_Id = '" + id + "' ;";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				String firstname = rs.getString(1);
				String middlename = rs.getString(2);
				String lastname = rs.getString(3);
				String mobile = rs.getString(4);
				String email = rs.getString(5);
				String photopath = rs.getString(6);
				String address = rs.getString(7);
				String city = rs.getString(8);
				

				txtId.setText(id);
				txtFirstName.setText(firstname);
				txtMiddleName.setText(middlename);
				txtLastName.setText(lastname);
				txtAddress.setText(address);
				txtCity.setText(city);
				lblPhotoPath.setText(photopath);
				lblPhoto.setIcon(new ImageIcon(photopath));
				txtMobile.setText(mobile);
				txtEmail.setText(email);
			

				lblPhoto.setToolTipText(lblPhotoPath.getText());
			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// to edit records
	public void updateRecord() {
		try {

			String url = "jdbc:sqlite:D:\\Projects\\PhoneBook\\PhoneBookDb.db";
			Connection con = DriverManager.getConnection(url);

			String query = "UPDATE `contact_master` SET  `P_FirstName`=?, `P_MiddleName`=?, `P_LastName`=?,"
					+ "`P_Mobile`=?, `P_Email`=?,`P_Photo`=?, `P_Address`=?, `P_City`=? WHERE `P_Id` = ?;";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, txtFirstName.getText());
			ps.setString(2, txtMiddleName.getText());
			ps.setString(3, txtLastName.getText());
			ps.setString(4, txtMobile.getText());
			ps.setString(5, txtEmail.getText());
			ps.setString(6, lblPhotoPath.getText());
			ps.setString(7, txtAddress.getText());
			ps.setString(8, txtCity.getText());
			
			ps.setString(9, txtId.getText());

			ps.execute();
			JOptionPane.showMessageDialog(null, "Record Edited Successfully!");

			ps.close();
			con.close();
		} catch (SQLiteException e) {
			JOptionPane.showMessageDialog(null, "Fail to Edited Record!");

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frm = new JFrame();
		
		frm.setUndecorated(true);		
		frm.setLocationRelativeTo(null);
		frm.setSize(500, 350);
		
		frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frm.setLocation((dim.width - 500) / 2, (dim.height - 350) / 2);
		
		frm.getContentPane().add(new AddContact());
		frm.setVisible(true);
	}

}

