import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

import javax.swing.*;
class GUI4 {
	public static void newScreen2 ()
	{
		JFrame jf=new JFrame ("Add Accountant");
		JLabel namelabel = new JLabel("Name:");
		namelabel.setBounds(20,25,150,10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(13,55,150,10);
		
		JTextField userText =new JTextField();
		userText.setBounds(80,20,200,20);
		
		JPasswordField passwordText= new JPasswordField();
		passwordText.setBounds(80,50,200,20);
		
		JLabel emaillabel =new JLabel("Email:");
		emaillabel.setBounds(20,85,150,10);
		
		JTextField email = new JTextField();
		email.setBounds(80,80,200,20);
		
		JLabel phoneNumber =new JLabel("Phone:");
		phoneNumber.setBounds(20,110,150,10);
		
		JTextField phone = new JTextField();
		phone.setBounds(80,110,200,20);
		
		JButton jb1 = new JButton("Add");
		jb1.setBounds(100,140,100, 50);
		jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = userText.getText();
                String emailId = email.getText();
       
                String mobileNumber = phone.getText();
                int len = mobileNumber.length();
                String password = passwordText.getText();

                 if (len != 10) {
                    JOptionPane.showMessageDialog(jb1, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountant", "root", "root123");

                    String query = "INSERT INTO account values('" +firstName + "','" + password + "','" + emailId + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(jb1, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(jb1,
                            "Accountant Added");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
		
		
		JButton jb2 = new JButton("Back");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI3 obj = new GUI3();
				obj.Screen();
				jf.dispose();
			}
		});
		jb2.setBounds(100,200,100, 50);
		
		jf.add(namelabel);
		jf.add(passwordLabel);
		jf.add(emaillabel);
		jf.add(userText);
		jf.add(passwordText);
		jf.add(email);
		jf.add(phoneNumber);
		jf.add(phone);
		jf.add(jb1);
		jf.add(jb2);
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
		

}
