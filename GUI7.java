import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class GUI7 {
	public static void Screen7() {
		
		JFrame jf=new JFrame ("Add Student");
		
		JLabel namelabel = new JLabel("Name:");
		namelabel.setBounds(20,25,150,10);
		JTextField userText =new JTextField();
		userText.setBounds(80,20,200,20);

		JLabel emaillabel =new JLabel("Email:");
		emaillabel.setBounds(20,70,150,10);
		JTextField email = new JTextField();
		email.setBounds(80,70,200,20);
		
		JLabel phoneNumber =new JLabel("Phone:");
		phoneNumber.setBounds(20,120,150,10);
		JTextField phone = new JTextField();
		phone.setBounds(80,120,200,20);
		
		JLabel courselabel =new JLabel("Course:");
		courselabel.setBounds(20,170,150,10);
		JTextField course = new JTextField();
		course.setBounds(80,170,200,20);
		
		JLabel fee =new JLabel("Fee:");
		fee.setBounds(20,220,150,10);
		JTextField feetext = new JTextField();
		feetext.setBounds(80,220,200,20);

		JLabel paidtext =new JLabel("Paid:");
		paidtext.setBounds(20,270,150,10);
		JTextField paid = new JTextField();
		paid.setBounds(80,270,200,20);
	
		JLabel DueText =new JLabel("Due:");
		DueText.setBounds(20,310,150,10);
		JTextField due = new JTextField();
		due.setBounds(80,310,200,20);

		JLabel CityText =new JLabel("City:");
    	CityText.setBounds(20,360,150,10);
		JTextField City = new JTextField();
		City.setBounds(80,360,200,20);
		
		JButton jb1 = new JButton("Add Student");
		jb1.setBounds(20,400,150,60);
		jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = userText.getText();
                String emailId = email.getText();
                String mobileNumber = phone.getText();
                String Course=course.getText();
                String Fee =feetext.getText();
                String Paid =paid.getText();
                String Due = due.getText();
                String city = City.getText();
                int len = mobileNumber.length();

                 if (len != 10) {
                    JOptionPane.showMessageDialog(jb1, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root123");

                    String query = "INSERT INTO Students values('" +firstName + "','" +emailId +"','" + mobileNumber + "','" +Course + "','" + Fee + "','" +Paid+ "','" +Due+ "','" +city + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(jb1, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(jb1,
                            "Student Details Added");
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
				GUI6 obj = new GUI6();
				obj.Screen6();
				jf.dispose();
			}
		});
		jb2.setBounds(200,400,150,60);
	
		jf.add(namelabel);
		jf.add(userText);
		jf.add(email);
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
		jf.setSize(400,600);
		jf.setLayout(null);
		jf.setVisible(true);
		
		
	}
}