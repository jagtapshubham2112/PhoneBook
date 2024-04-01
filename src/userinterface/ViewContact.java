package userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

public class ViewContact  {
	JDialog d;
	String pId ;
	// to view records in table
			public ViewContact(JFrame parent) {

				d = new JDialog();				
				d.setModal(true);
				
				
				Vector<String> columnNames = new Vector<String>();
				Vector<Vector<Object>> data = new Vector<Vector<Object>>();
				JPanel p = new JPanel();
				p.setBorder(BorderFactory.createTitledBorder("List"));

				try {

					String url = "jdbc:sqlite:D:\\Projects\\PhoneBook\\PhoneBookDb.db";
					Connection con = DriverManager.getConnection(url);
					String sql = "SELECT P_Id,P_FirstName,P_LastName,P_Mobile FROM Contact_Master;";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					ResultSetMetaData md = rs.getMetaData();
					int columns = md.getColumnCount();
					for (int i = 1; i <= columns; i++) {
						columnNames.addElement(md.getColumnName(i));

					}
					while (rs.next()) {
						Vector<Object> row = new Vector<Object>(columns);
						for (int i = 1; i <= columns; i++) {
							row.addElement(rs.getObject(i));
						}
						data.addElement(row);
					}
					rs.close();
					stmt.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				JTable table = new JTable(data, columnNames);

				table.setFont(new Font("Arial", Font.PLAIN, 14));
				TableColumn col;
				for (int i = 0; i < table.getColumnCount(); i++) {
					col = table.getColumnModel().getColumn(i);
					col.setMaxWidth(250);

				}
				// Get the selected row from JTableP and put the data into JTextfields
			    table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
			    @Override
			    public void valueChanged(ListSelectionEvent e) {
			          int i = table.getSelectedRow();	         
			          pId = table.getValueAt(i, 0).toString();	
			          d.dispose();
			      }
			  });
			   
				JScrollPane scrollPane = new JScrollPane(table);
				p.setLayout(new BorderLayout());
				p.add(scrollPane, BorderLayout.CENTER);
				//p.setBounds(10, 10, 400, 470);
				
				d.setTitle("List");
				d.setSize(new Dimension(400,250));
				d.add(p,BorderLayout.CENTER);
				
				d.setLocationRelativeTo(parent);
				d.setVisible(true);

			}
			public String getPersonId() {
				   return pId;	
				   
			   }
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		new ViewContact(frm);

	}

}

