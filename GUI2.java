import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;
class GUI2 {
	public static  void NewScreen()
	{
	
		JFrame f=new JFrame ("Admin Login");
		JLabel namelabel = new JLabel("Name:");
		namelabel.setBounds(20,30,150,10);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(13,50,150,10);
		JTextField userText =new JTextField();
		userText.setBounds(80,20,200,20);
		JPasswordField passwordText= new JPasswordField();
		passwordText.setBounds(80,50,200,20);
		JButton jb1 = new JButton("Login");
	    jb1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                String password = passwordText.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/admin",
                        "root", "root123");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select aname, passcode from authentication where aname=? and passcode=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        f.dispose();
                        GUI3 ah = new GUI3();
                        ah.Screen();
                        JOptionPane.showMessageDialog(jb1, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(jb1, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
		jb1.setBounds(100,100,100, 50);
		f.add(namelabel);
		f.add(passwordLabel);
		f.add(userText);
		f.add(passwordText);
		f.add(jb1);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	
		
		
	}

	}
