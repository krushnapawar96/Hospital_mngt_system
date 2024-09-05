package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class patient_discharge extends JFrame
{
	patient_discharge()
	{
		JPanel panel=new JPanel();
		panel.setBounds(5,5,790,390);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		JLabel label=new JLabel("CHECK-OUT");
		label.setBounds(100,20,150,20);
		label.setFont(new Font("Tahoma",Font.BOLD,20));
		label.setForeground(Color.white);
		panel.add(label);
		
		JLabel label2=new JLabel("Customer-Id");
		label2.setBounds(30,80,150,20);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		label2.setForeground(Color.white);
		panel.add(label2);
		
		Choice choice=new Choice();
		choice.setBounds(200,80,150,25);
		panel.add(choice);
		
		try {
			connn c=new connn();
			ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
			while(resultSet.next()) {
				choice.add(resultSet.getString("number"));
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		
		JLabel label3=new JLabel("Room Number");
		label3.setBounds(30,130,150,20);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		label3.setForeground(Color.white);
		panel.add(label3);
		
		JLabel RN=new JLabel();
		RN.setBounds(200,130,150,20);
		RN.setFont(new Font("Tahoma",Font.BOLD,14));
		RN.setForeground(Color.white);
		panel.add(RN);
		
		JLabel label4=new JLabel("IN Time");
		label4.setBounds(30,180,150,20);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		label4.setForeground(Color.white);
		panel.add(label4);
		
		JLabel InTime=new JLabel();
		InTime.setBounds(200,180,250,20);
		InTime.setFont(new Font("Tahoma",Font.BOLD,14));
		InTime.setForeground(Color.white);
		panel.add(InTime);
		
		JLabel label5=new JLabel("Out Time");
		label5.setBounds(30,230,150,20);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		label5.setForeground(Color.white);
		panel.add(label5);
		
		Date date=new Date();
		
		 JLabel OutTime=new JLabel(""+date);
		 OutTime.setBounds(200,230,250,20);
		 OutTime.setFont(new Font("Tahoma",Font.BOLD,14));
		 OutTime.setForeground(Color.white);
		 panel.add(OutTime);
		
		 JButton discharge=new JButton("Discharge");
		 discharge.setBounds(30,300,120,30);
		 discharge.setBackground(Color.black);
		 discharge.setForeground(Color.white);
		 panel.add(discharge);
		 discharge.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 connn c=new connn();
				 try {
					 c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
					 c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RN.getText()+"'");
					 JOptionPane.showMessageDialog(null, "Done");
					 setVisible(false);
				 }catch(Exception E) {
					 E.printStackTrace();
				 }
				 
			 }
		 });
		 
		 JButton check=new JButton("Check");
		 check.setBounds(170,300,120,30);
		 check.setBackground(Color.black);
		 check.setForeground(Color.white);
		 panel.add(check);
		 check.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 connn c=new connn();
				 try {
					 ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");
					 while(resultSet.next()) 
					 {
						 RN.setText(resultSet.getString("Room_Number"));
						 InTime.setText(resultSet.getString("Time"));
					 }
				 }catch(Exception E) {
					 E.printStackTrace();
				 }
				 
			 }
		 });
		 
		 JButton back=new JButton("Back");
		 back.setBounds(300,300,120,30);
		 back.setBackground(Color.black);
		 back.setForeground(Color.white);
		 panel.add(back);
		 back.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 setVisible(false);
			 }
		 });;
		setUndecorated(true);
		setSize(800,400);
		setLayout(null);
		setLocation(300,230);
		setVisible(true);	
	}

	public static void main(String[] args) 
	{
		new patient_discharge();
	}
}
