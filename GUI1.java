import javax.swing.*;
import java.sql.*;
import java.awt.*;  
import java.awt.event.*;  
class GUI1 {
	public static void NewS()
	{
	
		JFrame jf=new JFrame ("Fee Report");
		JButton jb = new JButton ("Admin Login");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI2 obj = new GUI2();
				obj.NewScreen();
				jf.dispose();
			}
		});
		
		jb.setBounds(100,200,300,50);
		JButton jb1 = new JButton("Accountant Login");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI5 obj = new GUI5();
				obj.Screen5();
				jf.dispose();
			}
		});
		jb1.setBounds(100,50,300,50);
		jf.add(jb);
		jf.add(jb1);
		jf.setSize(500,500);
		jf.setLayout(null);
		jf.setVisible(true);
		
		
	}
	public static void main(String args[]) {
		NewS();
}
}
