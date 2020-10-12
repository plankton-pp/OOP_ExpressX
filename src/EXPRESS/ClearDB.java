package EXPRESS;

import java.sql.*;

public class ClearDB {
    public ClearDB(){
        ClearUPDATE();
    }
    public ClearDB(String key){
        if(key.contains("clearall")){
            Clear();
        }
    }
    public void Clear(){
        Connection con = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE From transport_detail;");
            st.executeUpdate("DELETE From transport;");
            st.executeUpdate("DELETE From status;");
            st.executeUpdate("DELETE From updatedb;");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ClearUPDATE(){
        System.out.println("Clear DB:Table 'updatedb' already has cleaned up! ");
        Connection con = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE From updatedb;");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
