import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class GUI8 {
	public static void Screen8() {
		JFrame jf=new JFrame("Edit Student");
		
		JLabel lblRollNo = new JLabel("Phone Number:");
		lblRollNo.setBounds(10,50,150,10);
		JTextField p = new JTextField();
		p.setBounds(130,50,200,20);
		
		
		JSeparator s = new JSeparator(); 
		s.setBounds(10,80 ,800, 10);
        s.setOrientation(SwingConstants.HORIZONTAL);
       
        
        
        JLabel namelabel = new JLabel("Name:");
		namelabel.setBounds(20,100,150,10);
		JTextField userText =new JTextField();
		userText.setBounds(80,100,200,20);

		JLabel emaillabel =new JLabel("Email:");
		emaillabel.setBounds(20,140,150,10);
		JTextField emaill = new JTextField();
		emaill.setBounds(80,140,200,20);
		
		JLabel phoneNumber =new JLabel("New Phone:");
		phoneNumber.setBounds(5,180,150,10);
		JTextField phone = new JTextField();
		phone.setBounds(80,180,200,20);
		
		JLabel courselabel =new JLabel("Course:");
		courselabel.setBounds(20,220,150,10);
		JTextField course = new JTextField();
		course.setBounds(80,220,200,20);
		
		JLabel fee =new JLabel("Fee:");
		fee.setBounds(20,270,150,10);
		JTextField feetext = new JTextField();
		feetext.setBounds(80,270,200,20);

		JLabel paidtext =new JLabel("Paid:");
		paidtext.setBounds(20,320,150,10);
		JTextField paid = new JTextField();
		paid.setBounds(80,320,200,20);
	
		JLabel DueText =new JLabel("Due:");
		DueText.setBounds(20,360,150,10);
		JTextField due = new JTextField();
		due.setBounds(80,360,200,20);

		JLabel CityText =new JLabel("City:");
    	CityText.setBounds(20,400,150,10);
		JTextField City = new JTextField();
		City.setBounds(80,400,200,20);
		
		
		
		JButton jb1 = new JButton("Update Student");
		jb1.setBounds(20,450,150,60);
		jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String oldphone=p.getText();
                String firstName = userText.getText();
                String emailId = emaill.getText();
                String mobileNumber = phone.getText();
                String Course=course.getText();
                String Fee =feetext.getText();
                String Paid =paid.getText();
                String Due = due.getText();
                String city = City.getText();
                int len2 =oldphone.length();
                int len = mobileNumber.length();
                int status=0;
                 if (len != 10) {
                    JOptionPane.showMessageDialog(jb1, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root123");

                    PreparedStatement st = (PreparedStatement) connection .prepareStatement("update students set name=?,email=?,phone=?,course=?,fee=?,paid=?,due=?,city=? where phone=?;");
                    st.setString(1, firstName);
                    st.setString(2, emailId);
                    st.setString(3, mobileNumber);
                    st.setString(4, Course);
                    st.setString(5, Fee);
                    st.setString(6, Paid);
                    st.setString(7, Due);
                    st.setString(8, city);
                    st.setString(9, oldphone);
                    status = st.executeUpdate();
                    if(status > 0){
    					JOptionPane.showMessageDialog(jb1,"Student updated successfully!");
    
    				}else{
    					JOptionPane.showMessageDialog(jb1,"Sorry, Unable to find student!");
    				}
    			}
                   
                    catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
		
		JButton jb2 = new JButton("Back");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI6 obj = new GUI6();
				obj.Screen6();
				jf.dispose();
			}
		});
		jb2.setBounds(200,450,150,60);
	
		jf.add(namelabel);
		jf.add(lblRollNo);
		jf.add(p);
		jf.add(s);
		jf.add(userText);
		jf.add(emaill);
		jf.add(emaillabel);
		jf.add(phoneNumber);
		jf.add(phone);
		jf.add(courselabel);
		jf.add(course);
		jf.add(fee);
		jf.add(feetext);
		jf.add(paidtext);
		jf.add(paid);
		jf.add(DueText);
		jf.add(due);
		jf.add(CityText);
		jf.add(City);
		jf.add(jb1);
		jf.add(jb2);
		jf.setSize(600,600);
		jf.setLayout(null);
		jf.setVisible(true);
		
		
		
		
	}
}