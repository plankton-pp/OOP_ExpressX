package EXPRESS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
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
    public Home() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 448, 408);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        btnNewDeliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order order = new Order();
                order.sendingForm();
            }
        });
        btnTracking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerTracking ct = new CustomerTracking();
                ct.Check();
            }
        });
        btnDeliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carry carry = new Carry();
                carry.Delivery();
            }
        });
    }
}