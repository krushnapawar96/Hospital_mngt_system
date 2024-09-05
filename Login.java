package hospital.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
	JTextField textfield;
	JPasswordField jpassworldfield;
	JButton b1, b2;
	
	Login()
	{	
		JLabel namelabel=new JLabel("username");
		namelabel.setBounds(40, 20, 100, 30);
		namelabel.setFont(new Font("Tahoma",Font.PLAIN,16));
		namelabel.setForeground(Color.BLACK);
		add(namelabel);
		
		JLabel password=new JLabel("password");
	 	password.setBounds(40,70,100,30);
		password.setFont(new Font("Tahoma",Font.PLAIN,16));
		password.setForeground(Color.BLACK);
		add(password);
		
		textfield=new JTextField();
		textfield.setBounds(150,20,150,30);
		textfield.setFont(new Font("Tahoma",Font.PLAIN,15));
		textfield.setBackground(new Color(100,180,0));
		add(textfield);
		
		jpassworldfield=new JPasswordField();
		jpassworldfield.setBounds(150,70,150,30);
		jpassworldfield.setFont(new Font("Tahoma",Font.BOLD,15));
		jpassworldfield.setBackground(new Color(100,180,0));
		add(jpassworldfield);
		
		ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/hospitals.jpg")); 
		Image i1=imageIcon.getImage().getScaledInstance(350,200,Image.SCALE_DEFAULT);
		ImageIcon imageIcon1=new ImageIcon(i1);
		JLabel label=new JLabel(imageIcon1);
		label.setBounds(300, -30,400,300);
		add(label);
		
		b1=new JButton("Login");
		b1.setBounds(40, 140,120,30);
		b1.setFont(new Font("SERIF",Font.BOLD,15));
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBounds(180,140,120,30);
		b2.setFont(new Font("SERIF",Font.BOLD,15));
		b2.addActionListener(this);
		add(b2);
			
		getContentPane().setBackground(new Color(120,145,133));
		setSize(750,300);
		setLocation(400,220);
		setLayout(null);
		setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1) 
		{
			try {
				connn c=new connn();
				String user=textfield.getText();
				String pass=jpassworldfield.getText();
				
				String q="select * from login where ID='"+user+"' and pw = '"+pass+"'";
				ResultSet resultSet=c.statement.executeQuery(q);
				
				if(resultSet.next()) {
					new reception();
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid");
					
				}	
			}catch(Exception E) {
				E.printStackTrace();
			}	
		}
		else 
		{
			System.exit(20);
		}
	}

	public static void main(String[] args) 
	{
		new Login();
	}

}
