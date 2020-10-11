package EXPRESS;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Deliver extends Thread{
    String type;

    public Deliver(String type){
        this.type=type;
    }

    @Override
    public void run() {
        for (int hello = 0; hello<5; hello++ ) {
            System.out.println(hello+1);
            if(type.equals("N")){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Connection con = null;
            ResultSet rs;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress", "root", "");
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    String sqlQuery = "SELECT * FROM `status` WHERE transport_id LIKE '" + type + "%';";
                    rs = st.executeQuery(sqlQuery);
                    System.out.println("TYPE: " + type);
                    String[] id, stat, dat, tim, nex, nexTime, nexDate;
                    int lenght = 0;
                    while (rs.next()) {
                        lenght += 1;
                    }
                    if(type.equals("N")){
                        try {
                            sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String[] statusList = {"Picked up", "Transport", "Deliver", "Received"};
                    id = new String[lenght];
                    stat = new String[lenght];
                    dat = new String[lenght];
                    tim = new String[lenght];
                    nex = new String[lenght];
                    nexTime = new String[lenght];
                    nexDate = new String[lenght];

                    int loop = 0;
                    rs = st.executeQuery(sqlQuery);
                    while (rs.next()) {
                        System.out.println("xID: " + rs.getString("transport_id"));
                        System.out.println("xStat: " + rs.getString("status"));

                        id[loop] = rs.getString("transport_id");
                        stat[loop] = rs.getString("status");
                        for (int i = 0; i < statusList.length; i++) {
                            //Check status to get next status to change
                            if (!stat[loop].equals("Received")) {
                                if (statusList[i].equals(stat[loop])) {
                                    nex[loop] = statusList[i + 1];
                                }
                            }
                        }
                        if(type.equals("N")){
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        switch (stat[loop]) {
                            case "Picked up":
                                dat[loop] = rs.getString("picked_upDate");
                                tim[loop] = rs.getString("picked_upTime");
                                nexDate[loop] = "transportingDate";
                                nexTime[loop] = "transportingTime";
                                break;
                            case "Transport":
                                dat[loop] = rs.getString("transportingDate");
                                tim[loop] = rs.getString("transportingTime");
                                nexDate[loop] = "deliverDate";
                                nexTime[loop] = "deliverTime";
                                break;
                            case "Deliver":
                                dat[loop] = rs.getString("deliverDate");
                                tim[loop] = rs.getString("deliverTime");
                                nexDate[loop] = "receivedDate";
                                nexTime[loop] = "receivedTime";
                                break;
                            case "Received":
                                dat[loop] = rs.getString("receivedDate");
                                tim[loop] = rs.getString("receivedTime");
                                break;
                            default:
                                break;
                        }
                    }
                    Calendar cal = new GregorianCalendar();
                    int day = cal.get(Calendar.DATE);
                    int mon = cal.get(Calendar.MONTH) + 1;
                    int year = cal.get(Calendar.YEAR);
                    String date = day + "-" + mon + "-" + year;
                    LocalTime now = LocalTime.now();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                    for (int i = 0; i < id.length; i++) {
                        System.out.println("Update:" + nexDate[i] + "->" + date);
                        //UPDATE `status` SET `status`='Picked up' WHERE transport_id='E1';
                        String sqlUpdate = null;
                        String values=null;
                        try{
                            if (!nex[i].equals(null)) {
                                String cur = dtf.format(now);
                                sqlUpdate = "UPDATE `status` SET `status`='" + nex[i] + "',`"
                                        + nexDate[i] + "`='" + date + "',`"
                                        + nexTime[i] + "`='" + cur + "' WHERE transport_id='" + id[i] + "';";
                                values = "'"+id[i]+"','"+nex[i]+"','"+cur+"'";
                            }
                        }
                        catch(NullPointerException npe){
                            continue;
                        }
                        st.executeUpdate(sqlUpdate);
                        st.executeUpdate("INSERT INTO updatedb('transport_id','status','time') VALUES("+values+");");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (ClassNotFoundException ce) {
                ce.printStackTrace();
            }
        }
    }
}
