package EXPRESS;

import javax.swing.*;
import java.sql.*;

public class DB {

	public void insert(String[] value) {
		Connection con = null;
		Statement st;
		ResultSet rs=null;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				if(con!=null){
					System.out.println("Connected ");
					System.out.print("ID: "+value[0]);
					System.out.print("ID: ");
					if(value[0]!="0"){
						for (String i:value) {
							System.out.println(i);
						}
						//`transport_id`,
						//"+value[0]+",
						st.executeUpdate("INSERT INTO `transport`( `transport_id`,`sender_name`, `sender_address`, `sender_tel`, `receiver_name`, `receiver_address`, `receiver_tel`) " +
								"VALUES ('"+(Integer.parseInt(value[0]))+","+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"','"+value[5]+"','"+value[6]+"')");

						System.out.println("affected 1 row with ID: "+value[0]);
						JOptionPane.showConfirmDialog(new JFrame(),"Affected 1 row with ID: "+value[0],"Alert",JOptionPane.OK_CANCEL_OPTION);
					}
				}
				st.close();
				con.close();

			}catch (SQLException sqle){
				JOptionPane.showMessageDialog(new JFrame(),"Insertion Fail","Alert",JOptionPane.WARNING_MESSAGE);
				sqle.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
