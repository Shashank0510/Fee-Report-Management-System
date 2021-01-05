import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GUI6{
	public static void Screen6()
	{
		JFrame jf =new JFrame("Accountant Section");
		JButton jb1 = new JButton("Add Student");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI7 obj = new GUI7();
				obj.Screen7();
				jf.dispose();
			}
		});
		jb1.setBounds(200,50,200,100);
		JButton jb2 = new JButton("View Student");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student obj =new Student();
				obj.ViewStudent();
				jf.dispose();
			}
		});
		jb2.setBounds(200,350,200,100);
		JButton jb3 = new JButton("Edit Student");
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI8 obj = new GUI8();
				obj.Screen8();
				jf.dispose();
			}
		});
		jb3.setBounds(200,200,200,100);
		
	
		JButton jb5 = new JButton("Logout");
		jb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI1 obj = new GUI1();
				obj.NewS();
				jf.dispose();
			}
		});
		jb5.setBounds(200,650,200,100);
		
		jf.add(jb1);
		jf.add(jb2);
		jf.add(jb3);
		
		jf.add(jb5);
		jf.setSize(600,1200);
		jf.setLayout(null);
		jf.setVisible(true);
	}
	
	
}