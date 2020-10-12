package B6123338_B6122997_B6121921;

import javax.swing.*;
import java.sql.*;

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
					if(value[0]!="0"){
						st.executeUpdate("INSERT INTO `transport`( `package_id`,`sender_name`, `sender_address`, `sender_tel`, `receiver_name`, `receiver_address`, `receiver_tel`,`transport_id`) " +
								"VALUES ("+(Integer.parseInt(value[0]))+",'"+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"','"+value[5]+"','"+value[6]+"','"+value[7]+Integer.parseInt(value[0])+"')");
						}
				}
				st.close();
				con.close();

			}catch (SQLException sqle){
				JOptionPane.showMessageDialog(new JFrame(),"Insertion Fail","Alert From Trasport",JOptionPane.WARNING_MESSAGE);
				sqle.printStackTrace();
				checkerror=1;
			}
			if(checkerror>0){
			}else {
				JOptionPane.showConfirmDialog(new JFrame(),"Affected 1 row with ID: "+value[0]
						+"\nSend From: "+value[1]+"\n"
						+"To: "+value[4]+"\n"
						+"\n\nYour Tracking No: "+value[7]+Integer.parseInt(value[0])+"\n"
						,"TABLE: Transport, Transport_Detail",JOptionPane.OK_CANCEL_OPTION);
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
						st.executeUpdate("INSERT INTO `transport_detail`(`package_id`, `date`, `time`, `boxsize`, `volume`, `weight`, `price`, `status`, `transport_detail`,`transport_id`)" +
								"VALUES ("+box.getId()
								+",'"+value[0]
								+"','"+value[1]
								+"','"+box.getSize()
								+"','"+box.getVolume()
								+"','"+box.getWeight()
								+"','"+value[2]
								+"','"+box.getStatus()
								+"','"+box.getTransporting()
								+"','"+(value[3]+box.getId())+"');");
						st.executeUpdate("INSERT INTO `status`(`transport_id`, `package_id`, `picked_upTime`, `transportingTime`, `deliverTime`, `receivedTime`, `picked_upDate`, `transportingDate`, `deliverDate`, `receivedDate`, `status`)"+
								"VALUES('"+(value[3]+box.getId())
								+"','"+box.getId()
								+"','"+value[1]
								+"','00:00:00','00:00:00','00:00:00"
								+"','"+value[0]
								+"','null','null','null"
								+"','"+box.getStatus()+"');");
						}
				}
				st.close();
				con.close();

			}catch (SQLException sqle){
				JOptionPane.showMessageDialog(new JFrame(),"Insertion Fail","Alert From Transport_Detail",JOptionPane.WARNING_MESSAGE);
				sqle.printStackTrace();
				checkerror=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String[] query(String search) {
		Connection con ;
		Statement st;
		ResultSet rs;
		String[] data = new String[10];
		checkerror=0;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				if(con!=null){
					System.out.println("Connected ");
					rs = st.executeQuery(search);
					while (rs.next()){
						data= new String[]{rs.getString("transport_id")
								, String.format("%d", rs.getInt("package_id"))
								, rs.getString("date")
								, rs.getTime("time").toString()
								, rs.getString("boxsize")
								, rs.getString("volume")
								, String.format("%d", rs.getInt("weight"))
								, String.format("%d", rs.getInt("price"))
								, rs.getString("status")
								, rs.getString("transport_detail")
								, rs.getString("sender_name")
								, rs.getString("sender_address")
								, rs.getString("sender_tel")
								, rs.getString("receiver_name")
								, rs.getString("receiver_address")
								, rs.getString("receiver_tel")
						};
					}
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
		return data;
	}

}
