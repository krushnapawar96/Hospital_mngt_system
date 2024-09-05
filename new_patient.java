package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class new_patient extends JFrame implements ActionListener{
	
	JComboBox comboBox;
	
	JTextField textFieldNumber, textname,textFieldDisease, textFieldDeposit;
	
	JRadioButton r1,r2;
	
	 Choice c1;
	 
	 JLabel date;
	 
	 JButton b1,b2;
	new_patient()
	{
		JPanel panel=new JPanel();
		panel.setBounds(10,10,840,540);
		panel.setBackground(new Color(100,200,120));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
		Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon imageIcon1=new ImageIcon(image);
		JLabel label =new JLabel(imageIcon1);
		label.setBounds(550,150,200,200);
		panel.add(label);
		
		JLabel labelname=new JLabel("NEW PATIENT FORM");
		labelname.setBounds(118,11,260,53);
		labelname.setFont(new Font("Tahoma",Font.BOLD,20));
		panel.add(labelname);
		
		JLabel labelID=new JLabel("ID :");
		labelID.setBounds(35,76,200,14);
		labelID.setFont(new Font("Tahoma",Font.BOLD,15));
		labelID.setForeground(Color.white);
		panel.add(labelID);
		
		comboBox=new JComboBox(new String[] {"Aadhar card","Voter Id","Driving License"});
		comboBox.setBounds(271,73,150,20);	
		comboBox.setBackground(new Color(3,45,48));
		comboBox.setForeground(Color.white);
		comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(comboBox);
		
		JLabel labelnumber=new JLabel("Number :");
	    labelnumber.setBounds(35,111,200,14);
	    labelnumber.setForeground(Color.white);
	    labelnumber.setFont(new Font("Tahoma",Font.BOLD,14));
	    panel.add(labelnumber);
		
	    textFieldNumber=new JTextField();
		textFieldNumber.setBounds(271,111,150,20);
		panel.add(textFieldNumber);
		
		JLabel labelName=new JLabel("Name :");
		labelName.setBounds(35,151,200,14);
		labelName.setForeground(Color.white);
		labelName.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(labelName);
		
	    textname=new JTextField();
		textname.setBounds(271, 151, 150, 20);
		panel.add(textname);
		
		JLabel gender =new JLabel("Gender :");
		gender.setBounds(35,191,200,14);
		gender.setFont(new Font("Tahoma",Font.BOLD,14));
		gender.setForeground(Color.white);
		panel.add(gender);
		
		r1=new JRadioButton("Male");
		r1.setFont(new Font("Tahoma",Font.BOLD,14));
		r1.setForeground(Color.white);
		r1.setBackground(new Color(109,164,170));
		r1.setBounds(271,191,80,14);
		panel.add(r1);
		
		r2=new JRadioButton("Female");
		r2.setFont(new Font("Tahoma",Font.BOLD,14));
		r2.setForeground(Color.white);
		r2.setBackground(new Color(109,164,170));
		r2.setBounds(350,191,80,14);
		panel.add(r2);
		
		JLabel labelDisease =new JLabel("Disease :");
		labelDisease.setBounds(35,231,200,14);
		labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
		labelDisease.setForeground(Color.white);
		panel.add(labelDisease);
		
	    textFieldDisease=new JTextField();
		textFieldDisease.setBounds(271,231,150,20);
		panel.add(textFieldDisease);
		
		JLabel labelroom=new JLabel("Room :");
		labelroom.setBounds(35,274,200,14);
		labelroom.setFont(new Font("Tahoma",Font.BOLD,14));
		labelroom.setForeground(Color.white);
		panel.add(labelroom);
		
		//Room Choice Table//
		 c1=new Choice();
		 try {
			 connn c=new connn();
			 ResultSet resultSet=c.statement.executeQuery("Select * from room");
			 while(resultSet.next()) 
			 {
				 c1.add(resultSet.getString("room_no"));
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 c1.setBounds(271,274,150,20);
		 c1.setFont(new Font("Tahoma",Font.BOLD,14));
		 c1.setForeground(Color.WHITE);
		 c1.setBackground(new Color(3,45,48));
		 panel.add(c1);
		
		
		JLabel labeldate=new JLabel("Time :");
		labeldate.setBounds(35,316,200,14);
		labeldate.setFont(new Font("Tahoma",Font.BOLD,14));
		labeldate.setForeground(Color.white);
		panel.add(labeldate);
		
		Date date1=new Date();
		
		date=new JLabel(""+date1);
		date.setBounds(271,316,250,14);
		date.setForeground(Color.white);
		date.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(date);
		
		JLabel labelDeposit=new JLabel("Deposit :");
		labelDeposit.setBounds(35,359,200,17);
		labelDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
		labelDeposit.setForeground(Color.white);
		panel.add(labelDeposit);
		
		textFieldDeposit =new JTextField();
		textFieldDeposit.setBounds(271,359,150,20);
		panel.add(textFieldDeposit);
		
		b1=new JButton("Add");
		b1.setBounds(100,430,120,30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		panel.add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(260,430,120,30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		panel.add(b2);
		
		
		setUndecorated(true);
		setSize(800,550);
		setLayout(null);
		setLocation(300,205);
		setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1) 
		{
			connn c=new connn();
			String radioBTN=null;
			if(r1.isSelected())
			{
				radioBTN="Male";
				
			}
			else if(r2.isSelected())
			{
				radioBTN="Female";
			}
			String s1=(String) comboBox.getSelectedItem();
			String s2=textFieldNumber.getText();
			String s3=textname.getText();
			String s4=radioBTN;
			String s5=textFieldDisease.getText();
			String s6=c1.getSelectedItem();
			String s7=date.getText();
			String s8=textFieldDeposit.getText();
			
			try {
				String q="insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
				String q1="update room set Availability = 'Occupied' where room_no = "+s6;
				c.statement.executeUpdate(q);
				c.statement.executeUpdate(q1);
				
				JOptionPane.showMessageDialog(null, "Added Successfully");
				setVisible(false);
				
			}catch(Exception E) 
			{
				E.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
	}

	public static void main(String[] args) 
	{
		new new_patient();
	}
}
