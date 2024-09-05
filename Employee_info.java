package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Employee_info extends JFrame
{
	Employee_info()
	{
		
		JPanel panel=new JPanel();
		panel.setBounds(5,5,990,590);
		panel.setBackground(new Color(109,164,170));
		panel.setLayout(null);
		add(panel);		
		
		JTable table=new JTable();
		table.setBounds(3,30,980,450);
		table.setBackground(new Color(109,164,170));
		table.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(table);
		
		try {
			connn c=new connn();
			String q="select * from EMP_INFO";
			ResultSet resultSet=c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel label1=new JLabel("Name");
		label1.setBounds(35,4,70,30);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label1);
		
		JLabel label2=new JLabel("Age");
		label2.setBounds(170,4,70,30);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label2);
		
		JLabel label3=new JLabel("Phone Number");
		label3.setBounds(330,4,150,30);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label3);
		
		JLabel label4=new JLabel("Salary");
		label4.setBounds(500,4,70,30);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label4);
		
		JLabel label5=new JLabel("Gmail"); 
		label5.setBounds(700,4,70,30);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label5);
		
		JLabel label6=new JLabel("Aadhar Number");
		label6.setBounds(850,4,150,30);
		label6.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label6);
		
		JButton button=new JButton("Back");
		button.setBounds(100,500,140,30);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.white);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		
		setUndecorated(true);
	    setSize(1000,600);
	    setLocation(250,100);
      	setLayout(null);
    	setVisible(true);
	}

	public static void main(String[] args) 
	{
		new Employee_info();
	}
}
