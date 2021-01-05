import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

import javax.swing.*;
class GUI3 {
	public static void Screen()
	{
	
		JFrame jf=new JFrame ("Admin Section");
		JButton jb1 = new JButton("Add Accountant");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI4 obj = new GUI4();
				obj.newScreen2();
				jf.dispose();
			}
		});
		jb1.setBounds(200,50,200,100);
		
		JButton jb2= new JButton("Logout");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI1 obj = new GUI1();
				obj.NewS();
				jf.dispose();
			}
		});
		jb2.setBounds(200,350,200,100);
		jf.add(jb1);
	
		jf.add(jb2);
		jf.setSize(600,600);
		jf.setLayout(null);
		jf.setVisible(true);
		
		
	}
}