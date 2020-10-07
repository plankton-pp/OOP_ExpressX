package EXPRESS;

import java.sql.*;

public class DB {

	public ResultSet query(String sql) {
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
				}
				rs=st.executeQuery(sql);
			}catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}

}
