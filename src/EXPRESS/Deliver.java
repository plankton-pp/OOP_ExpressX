package EXPRESS;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Deliver extends Thread{
    String type;
    public String[] statusList={"Picked up","Transport","Deliver","Received"};

    //CONSTRUCTOR*****************************************************************************************
    public Deliver(String type){
        this.type=type;
        run();
    }
    public void queryData(String data){
        Connection con =null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                rs = st.executeQuery("SELECT * FROM `status` WHERE transport_id LIKE '"+data+"%';");
                String [] id,stat,dat,tim,nex;
                int lenght=0;
                while (rs.next()){
                    lenght+=1;
                }
                id = new String[lenght];
                stat = new String[lenght];
                dat = new String[lenght];
                tim = new String[lenght];
                nex = new String[lenght];
                int loop=0;
                while (rs.next()){
                    id[loop]=rs.getString("transport_id");
                    stat[loop]=rs.getString("status");

                    dat[loop]=rs.getString("");
                    tim[loop]=rs.getString("");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
    }
    @Override
    public void run() {
        //Waiting For Sleep Thread
        queryData(type);
    }
    public void setData(String[] id,String[] stat,String[] dat,String[] tim,String[] nex){

    }
}
