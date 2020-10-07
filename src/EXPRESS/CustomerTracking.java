package EXPRESS;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerTracking {

	private JFrame frame;
	private JTextField t_search;
	private JTextField t_id;
	private JTextField t_senderName;
	private JTextField t_senderTel;
	private JTextField t_recieverName;
	private JTextField t_recieverTel;
	private JTextField t_status;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerTracking window = new CustomerTracking();
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
	public CustomerTracking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 755, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSendingStatus = new JLabel("SENDING STATUS");
		lblSendingStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSendingStatus.setBounds(279, 26, 148, 20);
		frame.getContentPane().add(lblSendingStatus);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(22, 77, 57, 14);
		frame.getContentPane().add(lblSearch);
		
		t_search = new JTextField();
		t_search.setColumns(10);
		t_search.setBounds(96, 75, 117, 20);
		frame.getContentPane().add(t_search);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(22, 121, 46, 14);
		frame.getContentPane().add(lblID);
		
		t_id = new JTextField();
		t_id.setEditable(false);
		t_id.setColumns(10);
		t_id.setBounds(96, 119, 117, 20);
		frame.getContentPane().add(t_id);
		
		JLabel lblSenderName = new JLabel("Sender Name");
		lblSenderName.setBounds(25, 205, 98, 14);
		frame.getContentPane().add(lblSenderName);
		
		t_senderName = new JTextField();
		t_senderName.setEditable(false);
		t_senderName.setColumns(10);
		t_senderName.setBounds(110, 203, 184, 20);
		frame.getContentPane().add(t_senderName);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFrom.setBounds(22, 166, 72, 14);
		frame.getContentPane().add(lblFrom);
		
		JTextPane tp_senderAddress = new JTextPane();
		tp_senderAddress.setEditable(false);
		tp_senderAddress.setBounds(110, 229, 231, 57);
		frame.getContentPane().add(tp_senderAddress);
		
		JLabel lblSenderTel = new JLabel("Sender Tel.");
		lblSenderTel.setBounds(36, 296, 98, 14);
		frame.getContentPane().add(lblSenderTel);
		
		t_senderTel = new JTextField();
		t_senderTel.setEditable(false);
		t_senderTel.setColumns(10);
		t_senderTel.setBounds(110, 296, 172, 20);
		frame.getContentPane().add(t_senderTel);
		
		JLabel lblRecieverName = new JLabel("Reciever Name");
		lblRecieverName.setBounds(396, 200, 117, 14);
		frame.getContentPane().add(lblRecieverName);
		
		t_recieverName = new JTextField();
		t_recieverName.setEditable(false);
		t_recieverName.setColumns(10);
		t_recieverName.setBounds(488, 197, 184, 20);
		frame.getContentPane().add(t_recieverName);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTo.setBounds(396, 163, 46, 14);
		frame.getContentPane().add(lblTo);
		
		JTextPane tp_recieverAddress = new JTextPane();
		tp_recieverAddress.setEditable(false);
		tp_recieverAddress.setBounds(488, 225, 231, 57);
		frame.getContentPane().add(tp_recieverAddress);
		
		JLabel lblRecieverTel = new JLabel("Reciever Tel.");
		lblRecieverTel.setBounds(396, 293, 91, 14);
		frame.getContentPane().add(lblRecieverTel);
		
		t_recieverTel = new JTextField();
		t_recieverTel.setEditable(false);
		t_recieverTel.setColumns(10);
		t_recieverTel.setBounds(488, 290, 184, 20);
		frame.getContentPane().add(t_recieverTel);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(414, 77, 72, 14);
		frame.getContentPane().add(lblStatus);
		
		t_status = new JTextField();
		t_status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		t_status.setEditable(false);
		t_status.setColumns(10);
		t_status.setBounds(457, 85, 164, 34);
		frame.getContentPane().add(t_status);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(572, 398, 77, 23);
		frame.getContentPane().add(btnQuit);
		
		Icon icon = new ImageIcon("../OOP_Express/src/images/search.png");
		JButton btnSearch = new JButton(icon);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(223, 74, 33, 21);
		frame.getContentPane().add(btnSearch);
	}
}
