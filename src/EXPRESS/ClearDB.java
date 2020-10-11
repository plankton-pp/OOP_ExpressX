package EXPRESS;

import java.sql.*;

public class ClearDB {
    public static void main(String args[]){
        Connection con = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE From transport_detail;");
            st.executeUpdate("DELETE From transport;");
            st.executeUpdate("DELETE From status;");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}