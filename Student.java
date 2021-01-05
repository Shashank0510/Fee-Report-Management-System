import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class Student {

private String name,email,course;
private String fee,paid,due;
private String city,contactno;


public Student() {}

public Student(String name, String email, String course, String fee, String paid, String due, String city,
		 String contactno) {
	super();
	this.name = name;
	this.email = email;
	this.course = course;
	this.fee = fee;
	this.paid = paid;
	this.due = due;
	this.city = city;
	this.contactno = contactno;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getFee() {
	return fee;
}
public void setFee(String fee) {
	this.fee = fee;
}
public String getPaid() {
	return paid;
}
public void setPaid(String paid) {
	this.paid = paid;
}
public String getDue() {
	return due;
}
public void setDue(String due) {
	this.due = due;
}

public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public static List<Student> view(){
	List<Student> list=new ArrayList<Student>();
	try{
		  Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student",
                  "root", "root123");

              PreparedStatement st = (PreparedStatement) connection
                  .prepareStatement("select * from students");
              ResultSet rs = st.executeQuery();
		while(rs.next()){
			Student s=new Student();
	
			s.setName(rs.getString("name"));
			s.setEmail(rs.getString("email"));
			s.setCourse(rs.getString("course"));
			s.setFee(rs.getString("fee"));
			s.setPaid(rs.getString("paid"));
			s.setDue(rs.getString("due"));
		
			s.setCity(rs.getString("city"));

	
			s.setContactno(rs.getString("phone"));
			list.add(s);
		}
		connection.close();
	}catch(Exception e){System.out.println(e);}
	return list;
}

public void ViewStudent() {
	JFrame jf =new JFrame();
	List<Student> list=Student.view();
	int size=list.size();
	
	String data[][]=new String[size][12];
	int row=0;
	for(Student s:list){
		
		data[row][0]=s.getName();
		data[row][1]=s.getEmail();
		data[row][2]=s.getContactno();
		data[row][3]=String.valueOf(s.getCourse());
		data[row][4]=String.valueOf(s.getFee());
		data[row][5]=String.valueOf(s.getPaid());
        data[row][6]=s.getDue();
	    data[row][7]=s.getCity();
		
		row++;
	}
	String columnNames[]={"Name","Email","Phone","Course","Fee","Paid","Due","City"};
	
	JTable jt=new JTable(data,columnNames);
	JScrollPane sp=new JScrollPane(jt);
	jf.add(sp);
	
	jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	jf.setBounds(100, 100, 800, 400);
	jf.setVisible(true);
	jf.setLayout(null);
}

}
