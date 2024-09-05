package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class update extends JFrame
{
	update()
	{
		JPanel panel=new JPanel();
		panel.setBounds(5,5,940,490);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
		Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
		ImageIcon imageIcon1=new ImageIcon(image);
		JLabel label=new JLabel(imageIcon1);
		label.setBounds(500,60,300,300);
		panel.add(label);
		
		JLabel label1=new JLabel("Update patient details");
		label1.setBounds(124,11,222,25);
		label1.setFont(new Font("Tahoma",Font.BOLD,20));
		label1.setForeground(Color.white);
		panel.add(label1);
		
		JLabel label2=new JLabel("Name :");
		label2.setBounds(25,88,100,14);
		label2.setFont(new Font("Tahoma",Font.PLAIN,14)); 
		label2.setForeground(Color.white);
		panel.add(label2);
		
		Choice choice=new Choice();
		choice.setBounds(248, 85, 140, 25);
		panel.add(choice);
		
		try {
			connn c=new connn();
			ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
			while(resultSet.next()) {
				choice.add(resultSet.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel label3=new JLabel("room number");
		label3.setBounds(25,129,140,14);
		label3.setFont(new Font("Tahoma",Font.PLAIN,14));
		label3.setForeground(Color.white);
		panel.add(label3);
		
		JTextField textfield=new JTextField();
		textfield.setBounds(248,129,140,20);
		panel.add(textfield);
		
		
		JLabel label4=new JLabel("In-Time :");
		label4.setBounds(25,174,140,14);
		label4.setFont(new Font("Tahoma",Font.PLAIN,14));
		label4.setForeground(Color.white);
		panel.add(label4);
		
		JTextField textintime =new JTextField();
		textintime.setBounds(248,174,140,20);
		panel.add(textintime);
		
		JLabel label5=new JLabel("Amount Paid (Rs)");
		label5.setBounds(25,216,150,14);
		label5.setFont(new Font("Tahoma",Font.PLAIN,14));
		label5.setForeground(Color.white);
		panel.add(label5);
		
		JTextField textfieldamount =new JTextField();
		textfieldamount.setBounds(248,216,140,20);
		panel.add(textfieldamount);
		
		JLabel label6=new JLabel("Pending Amount (RS)");
		label6.setBounds(25,261,140,14);
		label6.setFont(new Font("Tahoma",Font.PLAIN,14));
	    label6.setForeground(Color.white);
		panel.add(label6);
		
		JTextField textfieldpending=new JTextField();
		textfieldpending.setBounds(248,261,140,20);
		panel.add(textfieldpending);
		
		JButton check=new JButton("Check");
		check.setBounds(281,378,89,23);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		panel.add(check);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String id=choice.getSelectedItem();
				String q="select * from patient_info where Name= '"+id+"'";
				try {
					connn c=new connn();
					ResultSet resultSet=c.statement.executeQuery(q);
				 	while(resultSet.next()) {
						textfield.setText(resultSet.getString("Room_Number"));
						textintime.setText(resultSet.getString("Time"));
						textfieldamount.setText(resultSet.getString("Deposit"));
					}
					
					ResultSet resultSet1=c.statement.executeQuery("select * from room where room_no ='"+textfield.getText()+"'");
					while(resultSet1.next()) 
					{
	
						String price=resultSet1.getString("Price");
						int amountpaid =Integer.parseInt(price)-Integer.parseInt(textfieldamount.getText());
						textfieldpending.setText(""+amountpaid);
					}
				}catch(Exception E) {
					E.printStackTrace();
				}
				
			}
		});
		
		JButton update=new JButton("Update");
		update.setBounds(56,378,89,23);
		update.setFont(new Font("Tahoma",Font.BOLD,14));
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		panel.add(update);
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try {
					connn c=new connn();
					String q=choice.getSelectedItem();
					String room=textfield.getText();
					String time=textintime.getText();
					String amount=textfieldamount.getText();
					c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"',Time= '"+time+"', deposit ='"+amount+"'where name = '"+q+"'");
					JOptionPane.showMessageDialog(null, "Updated successfully");
					setVisible(false);
					
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		JButton back=new JButton("BACk");
		back.setBounds(168,378,89,23);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		panel.add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);	
			}
		});
		setUndecorated(true);
		setSize(950,500);
		setLayout(null);
		setLocation(250,200);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new update();
	}
}
