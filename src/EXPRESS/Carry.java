package EXPRESS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Carry {
    private JFrame frame;
    private JTextField status;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Carry window = new Carry();
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
    public Carry() {
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

        status = new JTextField();
        status.setEditable(false);
        status.setBounds(314, 65, 264, 293);
        frame.getContentPane().add(status);
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

        btn_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.getSelectedItem().toString().contains("Both")){
                    Deliver dv1 = new Deliver("E");
                    //Deliver dv2 = new Deliver("N");
                }
            }
        });
        btn_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
