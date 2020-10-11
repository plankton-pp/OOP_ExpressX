package EXPRESS;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public void run() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home("start");
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
    public Home(){}
    public Home(String start) {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 448, 408);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JButton btnNewDeliver = new JButton("New Deliver");
        btnNewDeliver.setBounds(168, 110, 113, 32);
        frame.getContentPane().add(btnNewDeliver);

        JButton btnTracking = new JButton("Tracking");
        btnTracking.setBounds(168, 175, 113, 32);
        frame.getContentPane().add(btnTracking);

        JButton btnDeliver = new JButton("Deliver");
        btnDeliver.setBounds(168, 235, 113, 32);
        frame.getContentPane().add(btnDeliver);

        JButton btnQuit = new JButton("Quit");
        btnQuit.setBounds(315, 322, 89, 23);
        frame.getContentPane().add(btnQuit);

        JLabel lblOopExpress = new JLabel("OOP EXPRESS");
        lblOopExpress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblOopExpress.setBounds(166, 43, 126, 23);
        frame.getContentPane().add(lblOopExpress);

        JLabel pic1 = new JLabel("pic1");
        pic1.setBounds(90, 119, 46, 14);
        frame.getContentPane().add(pic1);

        JLabel pic2 = new JLabel("pic2");
        pic2.setBounds(90, 184, 46, 14);
        frame.getContentPane().add(pic2);

        JLabel pic3 = new JLabel("pic3");
        pic3.setBounds(90, 244, 46, 14);
        frame.getContentPane().add(pic3);


        JLabel lblBinIcon = new JLabel(new ImageIcon("../OOP_EXPRESS/src/images/garbage.png"));
        lblBinIcon.setBounds(23, 306, 46, 46);
        frame.getContentPane().add(lblBinIcon);

        JLabel lblDeleteDatabase = new JLabel("Clear Database");
        lblDeleteDatabase.setBounds(79, 326, 99, 14);
        frame.getContentPane().add(lblDeleteDatabase);

        lblBinIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblBinIcon.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/garbage.png"));
                ClearDB db = new ClearDB();
                db.Clear();
                JOptionPane.showMessageDialog(new JFrame(),"DataBase Has Been Cleaned up !","DB: Alert",JOptionPane.PLAIN_MESSAGE);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                lblBinIcon.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/garbage.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblBinIcon.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/garbageBig.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblBinIcon.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/garbage.png"));
            }
        });

        btnNewDeliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order order = new Order();
                order.sendingForm();
                frame.dispose();
            }
        });
        btnTracking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerTracking ct = new CustomerTracking();
                ct.Check();
                frame.dispose();
            }
        });
        btnDeliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carry carry = new Carry();
                carry.Delivery();
                frame.dispose();
            }
        });
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}