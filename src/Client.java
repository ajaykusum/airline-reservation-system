//*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */

import java.io.*;
import java.sql.*;
import java.net.*;
/**
 *
 * @author HP
 */
public class Client {
 
   public static void main(String []args) {
	   try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
try{
   Socket stk =new Socket("localhost",8000);
//String str="Mayur";
DataOutputStream out =new DataOutputStream(stk.getOutputStream());
DataInputStream in=new DataInputStream(stk.getInputStream());


System.out.println("client started");
registration reg =new registration(in,out);  
//System.out.println("login closed set visible start");
reg.setVisible(true);
//msg=keyb.readLine();
//System.out.println("from server: "+ msg);
}
catch(Exception e){
System.out.println("registration" + e);
}

}
}