package EXPRESS;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DB {
	public int checkerror=0;
	public void insert_transport(String[] value) {
		Connection con = null;
		Statement st;
		ResultSet rs=null;
		checkerror=0;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				if(con!=null){
					System.out.println("Connected From transport");
					System.out.print("ID: ");
					if(value[0]!="0"){
						st.executeUpdate("INSERT INTO `transport`( `transport_id`,`sender_name`, `sender_address`, `sender_tel`, `receiver_name`, `receiver_address`, `receiver_tel`) " +
								"VALUES ("+(Integer.parseInt(value[0]))+",'"+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"','"+value[5]+"','"+value[6]+"')");
						}
				}
				st.close();
				con.close();

			}catch (SQLException sqle){
				JOptionPane.showMessageDialog(new JFrame(),"Insertion Fail","Alert",JOptionPane.WARNING_MESSAGE);
				sqle.printStackTrace();
				checkerror=1;
			}
			if(checkerror>0){

			}else {
				JOptionPane.showConfirmDialog(new JFrame(), "Affected 1 row with ID: " + value[0], "TABLE: Transport", JOptionPane.OK_CANCEL_OPTION);
			}
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void insert_transport_detail(String[] value,Box box) {
		Connection con = null;
		Statement st;
		ResultSet rs=null;
		checkerror=0;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				if(con!=null){
					System.out.println("Connected From trans_detail");
					if(value[0]!="0"){
						for (String i:value) {
							System.out.println(i);
						}
						st.executeUpdate("INSERT INTO `transport_detail`(`tansport_id`, `date`, `time`, `boxsize`, `volume`, `weight`, `price`, `status`, `transport_detail`)" +
								"VALUES ("+box.getId()+",'"+value[0]+"','"+value[1]+"','"+box.getSize()+"','"+box.getVolume()+"','"+box.getWeight()+"','"+value[2]+"','"+box.getStatus()+"','"+box.getTransporting()+"')");

						}
				}
				st.close();
				con.close();

			}catch (SQLException sqle){
				JOptionPane.showMessageDialog(new JFrame(),"Insertion Fail","Alert",JOptionPane.WARNING_MESSAGE);
				sqle.printStackTrace();
				checkerror=1;
			}
			if(checkerror>0){
			}else {
				JOptionPane.showConfirmDialog(new JFrame(),"Affected 1 row with ID: "+box.getId(),"TABLE: Transport_Detail",JOptionPane.OK_CANCEL_OPTION);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ResultSet query(String search) {
		Connection con = null;
		Statement st;
		ResultSet rs=null;
		checkerror=0;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				if(con!=null){
					System.out.println("Connected ");
					rs = st.executeQuery(search);
				}
				st.close();
				con.close();

			}catch (SQLException sqle){
				JOptionPane.showMessageDialog(new JFrame(),"Query Fail","Alert",JOptionPane.WARNING_MESSAGE);
				sqle.printStackTrace();
				checkerror=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}

}
