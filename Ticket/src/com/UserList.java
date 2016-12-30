package com;

import java.util.ArrayList;
public class UserList extends ArrayList{
       public void origin(String line){
    	      User user=new User();
    	      int i;
    	      for(i=0;i<line.length();i++)
    	          if(line.charAt(i)==' ') break;
    	      user.setID(line.substring(0, i));
    	      user.setPW(line.substring(i+1,line.length()));
    	      this.add(user);
       }
}
