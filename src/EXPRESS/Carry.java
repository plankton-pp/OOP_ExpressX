package EXPRESS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Carry {
    private JFrame frame;
    private JTextArea status;

    /**
     * Launch the application.
     */
    public void Delivery() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Carry window = new Carry("start");
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Carry(){};
    public Carry(String start) {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 643, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        String[] transport_type = {"Both (E & N)","Emergency Packages","Normal Packages"};
        JComboBox type = new JComboBox(transport_type);
        type.setBounds(88, 137, 146, 23);
        frame.getContentPane().add(type);

        JButton btn_send = new JButton("Send");
        btn_send.setBounds(98, 209, 123, 42);
        frame.getContentPane().add(btn_send);

        status = new JTextArea();
        status.setEditable(false);
        status.setBounds(314, 65, 264, 293);
        status.setColumns(10);

        JButton btn_back = new JButton("Back");
        btn_back.setBounds(374, 386, 89, 23);
        frame.getContentPane().add(btn_back);

        JButton btn_quit = new JButton("Quit");
        btn_quit.setBounds(489, 386, 89, 23);
        frame.getContentPane().add(btn_quit);

        JLabel lblCarryOutDelivery = new JLabel("Carry out delivery");
        lblCarryOutDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCarryOutDelivery.setBounds(233, 26, 146, 20);
        frame.getContentPane().add(lblCarryOutDelivery);

        JScrollPane scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getViewport().add(status);
        scroll.setBounds(314, 65, 264, 293);
        frame.getContentPane().add(scroll);


        btn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.getSelectedItem().toString().contains("Both")){
                    System.out.println(type.getSelectedItem().toString());
                    Deliver del1 = new Deliver("N");
                    Deliver del2 = new Deliver("E");
                    del1.start();
                    del2.start();
                }else{
                    String check = type.getSelectedItem().toString();
                    System.out.println(check);
                    if(check.contains("Normal")){
                        Deliver del1 = new Deliver("N");
                        del1.start();
                    }else{
                        Deliver del1 = new Deliver("E");
                        del1.start();
                    }
                }
                Thread anouce = new Thread(){
                    @Override
                    public void run() {

                        Connection con = null;
                        Statement st;
                        ResultSet rs=null;
                        try{
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
                                st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                if(con!=null){
                                    System.out.println("Connected From updateDB");
                                }

                                long i=0;
                                for (;;){
                                    try{
                                        rs = st.executeQuery("select * from updatedb;");
                                        String line = "";
                                        while (rs.next()){
                                            line += rs.getString("dashboard")+"\n";
                                        }
                                        status.append(line);
                                    }catch (SQLException sqle2){

                                    }
                                    i++;
                                }

                            }catch (SQLException sqle){
                                JOptionPane.showMessageDialog(new JFrame(),"Query Fail","Alert From Carry",JOptionPane.WARNING_MESSAGE);
                                sqle.printStackTrace();
                            }
                        }catch(Exception ec){
                            ec.printStackTrace();
                        }

                    }

                };
                anouce.start();
            }
        });
        btn_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Home h = new Home();
                h.main();
            }
        });
    }
}
