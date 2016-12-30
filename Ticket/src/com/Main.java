package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private int flag1=0;
	public static Main frame = new Main();
	private String PATH=System.getProperty("user.dir");
	private UserList userlist=new UserList();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		   frame.setTitle("电影订票系统");
		   frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		    gettxt(PATH+"\\id.txt");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 726, 560);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
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
			
			JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u540D/\u5BC6\u7801\u9519\u8BEF\uFF0C\u91CD\u65B0\u8F93\u5165");
			lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
			lblNewLabel_3.setBounds(206, 364, 263, 48);
			contentPane.add(lblNewLabel_3);
			lblNewLabel_3.setVisible(false);
			
			JButton btnNewButton = new JButton("登录");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   int i;
					   int flag=0;
					   for(i=0;i<userlist.size();i++){
						   User user=(User)userlist.get(i);
						   String s1=user.getID();
						   String s2=user.getPW();
						   if(s1.equals(textField.getText())&&s2.equals(passwordField.getText()))
						   {
							   flag=1; break;
						   }
					   }
				
					   if(flag==1){
						   frame.setVisible(false);
						   Movieinfo frame3=new Movieinfo(textField.getText());
						   frame3.setVisible(true);
					   }
					   else{
						   lblNewLabel_3.setVisible(true);
					   }
					   
				}
			});
			btnNewButton.setBounds(167, 422, 93, 52);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("退出");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   System.exit(0);
				}
			});
			
			btnNewButton_1.setBounds(407, 422, 93, 52);
			contentPane.add(btnNewButton_1);
			
			JButton button = new JButton("\u6CE8\u518C");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   Register frame2=new Register(userlist,frame);
					   frame.setVisible(false);
					   frame2.setVisible(true);
				}
			});  //註冊
			button.setBounds(285, 422, 93, 52);
			contentPane.add(button);
	}

	private void gettxt(String filepath) {
		// TODO Auto-generated method stub
		try {
            String encoding="GBK";
            File file=new File(filepath);
            if(file.isFile() && file.exists()){ 
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                      userlist.origin(lineTxt);
                }
                read.close();
		       }else{
		           System.out.println("找不到指定的文件");
		       }
		       } catch (Exception e) {
		           System.out.println("读取文件内容出错");
		           e.printStackTrace();
		       }  
	}
}
