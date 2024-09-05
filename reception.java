package hospital.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class reception extends JFrame{
	 reception()
	{
		 JPanel panel=new JPanel();
		 panel.setLayout(null);
		 panel.setBounds(5,160,1525,670);
		 panel.setBackground(new Color(100,200,120));
		 add(panel);
		 
		 JPanel panel1=new JPanel();
		 panel1.setLayout(null);
		 panel1.setBounds(5,5,1525,150);
		 panel1.setBackground(new Color(100,200,120));
		 add(panel1);
		 
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dr.png"));
		 Image image=i1.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
		 ImageIcon i2=new ImageIcon(image);
		 JLabel label=new JLabel(i2);
		 label.setBounds(1150,0,140,140);
		 panel1.add(label);
		 
		 ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/amb.png")); 
		 Image image1=i11.getImage().getScaledInstance(170,100,Image.SCALE_DEFAULT);
		 ImageIcon i22=new ImageIcon(image1);
		 JLabel label1=new JLabel(i22);
		 label1.setBounds(970,50,170,100);
		 panel1.add(label1);
		 
		 JButton btn=new JButton("Add New Patient");
		 btn.setBounds(30,15,200,30);
		 btn.setBackground(new Color(246,215,118));
		 panel1.add(btn);
		 btn.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new new_patient(); 
			 }
		 });
		 
		 JButton btn1=new JButton("Room");
		 btn1.setBounds(30,58,200,30);
		 btn1.setBackground(new Color(246,215,118));
		 panel1.add(btn1);
		 btn1.addActionListener(new ActionListener(){
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 new room();
				 
			 } 
		 });
		 
		 JButton btn2=new JButton("Department");
		 btn2.setBounds(30,100,200,30);
		 btn2.setBackground(new Color(246,215,118));
		 panel1.add(btn2);
		 btn2.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new department(); 	 
			 }
		 });
		 
		 JButton btn3=new JButton("All Employee Info");
		 btn3.setBounds(240,15,200,30);
		 btn3.setBackground(new Color(246,215,118));
		 panel1.add(btn3);
		 btn3.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new Employee_info();
				 
			 }
		 });
		
		 JButton btn4=new JButton("Patient Info");
		 btn4.setBounds(240,58 ,200,30);
		 btn4.setBackground(new Color(246,215,118));
		 panel1.add(btn4);
		 btn4.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 new all_patient_info();
			 }
		 });
		 
		 JButton btn5=new JButton("Patient Discharge");
		 btn5.setBounds(240,100,200,30);
		 btn5.setBackground(new Color(246,215,118));
		 panel1.add(btn5);
		 btn5.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new patient_discharge();
				 
			 }
		 });
		 
		 JButton btn6 = new JButton("Update Patient Details");
		 btn6.setBounds(450,15,200,30);
		 btn6.setBackground(new Color(246,215,118));
		 panel1.add(btn6);
		 btn6.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new update();
				 
			 }
		 });
		 
		 JButton btn7=new JButton("Hosplital Ambulance");
		 btn7.setBounds(450,58,200,30);
		 btn7.setBackground(new Color(246,215,118));
		 panel1.add(btn7);
		 btn7.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new ambulance();
			 }
		 });
		 
		 JButton btn8=new JButton("Search Room");
		 btn8.setBounds(450,100,200,30);
		 btn8.setBackground(new Color(246,215,118));
		 panel1.add(btn8);
		 btn8.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 new SearchRoom(); 	
				 
			 }
		 });
		 
		 JButton btn9=new JButton("Logout");
		 btn9.setBounds(680,15,200,30);
		 btn9.setBackground(new Color(246,215,118));
		 panel1.add(btn9);
		 
		 btn9.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) 
			 {
				 setVisible(false);
				 new Login(); 
				 
			 }
		 });
		 
		 setSize(1950,1090);
		 setLayout(null);
		 getContentPane().setBackground(Color.WHITE);;
		 setVisible(true);
		
	}

	public static void main(String[] args) 
	{
		new reception();
	}
}
