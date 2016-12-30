package com;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame{
	   private JPanel contentPane;
	   private JTextField textField;
	   private JPasswordField passwordField;
	   private JPasswordField passwordField_1;
	   private String PATH=System.getProperty("user.dir");
	   UserList uu;
	   
       public Register(UserList userlist,Main frame){
    	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   		setBounds(100, 100, 726, 560);
	   		contentPane = new JPanel();
	   		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   		setContentPane(contentPane);
	   		contentPane.setLayout(null);
	   		uu=userlist;
	   		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
	   		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
	   		lblNewLabel.setBounds(109, 122, 93, 36);
	   		contentPane.add(lblNewLabel);
	   		
	   		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801");
	   		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
	   		lblNewLabel_1.setBounds(109, 213, 93, 36);
	   		contentPane.add(lblNewLabel_1);
	   		
	   		textField = new JTextField();
	   		textField.setBounds(318, 130, 254, 21);
	   		contentPane.add(textField);
	   		textField.setColumns(10);
	   		
	   		passwordField = new JPasswordField();
	   		passwordField.setBounds(318, 221, 254, 21);
	   		contentPane.add(passwordField);
	   		
	   		JLabel lblNewLabel_3 = new JLabel("   \u4E24\u6B21\u5BC6\u7801\u8F93\u5165\u4E0D\u76F8\u540C");
			lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
			lblNewLabel_3.setBounds(206, 364, 263, 48);
			contentPane.add(lblNewLabel_3);
			lblNewLabel_3.setVisible(false);
			
			JLabel lblNewLabel_4 = new JLabel("    \u5B58\u5728\u76F8\u540C\u7684\u7528\u6237\u540D");
			lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
			lblNewLabel_4.setBounds(206, 364, 263, 48);
			contentPane.add(lblNewLabel_4);
			lblNewLabel_4.setVisible(false);
			
	   		JButton btnNewButton = new JButton("\u786E\u5B9A");
	   		btnNewButton.addActionListener(new ActionListener() {
	   			public void actionPerformed(ActionEvent e) {
	   				   String s1=textField.getText();
	   				   String s2=passwordField.getText();
	   				   String s3=passwordField_1.getText();
	   				   if(s2.equals(s3)){
	   					   int i;
	   					   int flag=0;
	   					   for(i=0;i<userlist.size();i++){
	   						   User user=(User)userlist.get(i);
	   						   if(s1.equals(user.getID())){
	   							   flag=1; break;
	   						   }
	   					   }
	   					   if(flag==1){
	   						  lblNewLabel_4.setVisible(true);
		   					  lblNewLabel_3.setVisible(false);
	   					   }
	   					   else{
	   						   userlist.origin(s1+' '+s2);
	   						   rewrite(PATH+"\\id.txt");
	   						   setVisible(false);
	   						   frame.setVisible(true);
	   					   }
	   				   }
	   				   else{
	   					   lblNewLabel_4.setVisible(false);
	   					   lblNewLabel_3.setVisible(true);
	   				   }	   				   
	   			}
	   		});
	   		btnNewButton.setBounds(167, 422, 93, 52);
	   		contentPane.add(btnNewButton);
	   		
	   		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
	   		btnNewButton_1.addActionListener(new ActionListener() {
	   			public void actionPerformed(ActionEvent e) {
	   				   setVisible(false);
	   				   frame.setVisible(true);
	   				   }
	   		});
	   		btnNewButton_1.setBounds(407, 422, 93, 52);
	   		contentPane.add(btnNewButton_1);
	   		
	   		JLabel lblNewLabel_2 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
	   		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
	   		lblNewLabel_2.setBounds(109, 306, 104, 36);
	   		contentPane.add(lblNewLabel_2);
	   		
	   		passwordField_1 = new JPasswordField();
	   		passwordField_1.setBounds(318, 314, 254, 21);
	   		contentPane.add(passwordField_1);
       }
       
   	private void rewrite(String filepath) {
		// TODO Auto-generated method stub
	    File file=new File(filepath);
	      file.delete();
	      FileWriter write;
		try {
			write = new FileWriter(file);
			BufferedWriter bufferedwriter=new BufferedWriter(write);
			for(int i=0;i<uu.size();i++){
				User user=(User)uu.get(i);
				bufferedwriter.write(user.getID()+' '+user.getPW());
				System.out.println(user.getID()+' '+user.getPW());
				bufferedwriter.newLine();
				bufferedwriter.flush();
			}
			bufferedwriter.close();
			write.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
