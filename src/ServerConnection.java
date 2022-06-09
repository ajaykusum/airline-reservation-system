// import static com.sun.glass.ui.Cursor.setVisible;
import java.io.*;
import java.net.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class ServerConnection extends Thread {
private Socket stk;
private Connection con;
public ServerConnection(Socket st,Connection conn){
stk=st;
con=conn;
start();


}
 public void run(){
 
try{
while(true){
DataInputStream in=new DataInputStream(stk.getInputStream());
DataOutputStream out = new DataOutputStream(stk.getOutputStream());
 Statement st= con.createStatement();
//System.out.println("3");
//System.out.println("4");
String flag=in.readUTF();
System.out.println(flag);
if(flag.equals("l")){
	System.out.println("1");
String id = in.readUTF();

System.out.println("2");
String p=in.readUTF();
System.out.println("3");
String Q = "SELECT user_name, password FROM account";
    ResultSet rs= st.executeQuery(Q);
System.out.println(id + p);
int execution = 0 ;
while(rs.next()) {

System.out.println(rs.getString("user_name"));
System.out.println(p);
System.out.println(rs.getString("password"));
if( id.equals(rs.getString("user_name")) && p.equals(rs.getString("password")) ) {
	System.out.println("Executed");
	execution++ ;
	break;
}
}
if(execution == 0) {
	 out.writeUTF("no");
	 }
else {
	  out.writeUTF("yes");
//	new ticketDetail().setVisible(true);
}
}


if(flag.equals("r")){
        System.out.println("22");
        String firstName=in.readUTF();
        String email=in.readUTF();
        String lastName=in.readUTF();
        String password =in.readUTF();
        String mobile =in.readUTF();
        String userName =in.readUTF();
        String query = "insert into account values('" + firstName + "','" + lastName + "','" + userName + "','" +
              password + "','" + email + "','" + mobile + "')";
        
        java.sql.Statement sta =  con.createStatement();
        sta.executeUpdate(query);
        out.writeUTF("yes");
        con.close();
//
//        String query="select * from registration where mob = " + "'" + mob + "'";
//        ResultSet rs= st.executeQuery(query);
//        if(rs.next()){
//            out.writeUTF("no");
//        }
//        else{
//         query="insert into student (Name_of_student,Father_Name,mob,dob,class,password) values(" + "'" + name +"'"+ "," + "'" +fname+"'" + "," +"'" + mob+ "'"  +"," + "'" + birth + "'" + "," +clas +","+ "'" + pas + "')";
//       int  n= st.executeUpdate(query);
//
//            if(n>0){
//                    query="select id from student where mob=" + "'" + mob+ "'" ;
//     rs=st.executeQuery(query);                  
//        rs.next();
//                   
                   
//                    out.writeUTF(Integer.toString(rs.getInt("id")));
//            }
//        }
   }
//profile started
if(flag.equals("tD")){
String FullName = in.readUTF();
String Phone = in.readUTF();
String BDate = in.readUTF();
String adrs = in.readUTF();
String frm = in.readUTF();
String t = in.readUTF();
String gender = in.readUTF();
String Dt = in.readUTF();
String Prc = in.readUTF();
	String query = "insert into ticket values('" + FullName + "','" + Phone + "','" +
	BDate + "','" + adrs + "','" + frm + "','" + t + "','" + gender + "','" + Dt + "','" + Prc + "' )";

                java.sql.Statement sta =  con.createStatement();
               int x = sta.executeUpdate(query);
               if(x != 0) {
            	   out.writeUTF("yes");
                   out.writeUTF(FullName);
               }
//                con.close();
                       


}
//show status


}
}
catch(Exception e){
System.out.println("1" +e);
}

try{
//stk.close();
}
catch(Exception e){
System.out.println("client"+e);
}
}
public static void main(String[]args) {

    try {
   	 Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "8807");

        System.out.println("Server Started");
        ServerSocket ss= new ServerSocket(8000);
        int count = 1 ; 
        System.out.println("my client connected");
      
       Socket stk ;
       do {
    	   stk = ss.accept();
    	   System.out.println("number of cient connected "+ count++);
    	   new ServerConnection(stk,con);
    	  
       }while(true);
       
       
//          int x =
 //      		 sta.executeUpdate(query);
    //    if (x == 0) {
     //       JOptionPane.showMessageDialog(jButton1, "This is alredy exist");
    //    } else {
    //       JOptionPane.showMessageDialog(jButton1,"Welcome, " + msg + "Your account is sucessfully created");
     //   }
       
    } catch (Exception exception) {
        exception.printStackTrace();
    }
}
}

