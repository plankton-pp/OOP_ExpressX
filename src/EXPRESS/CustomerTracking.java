package EXPRESS;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		frame.setBounds(100, 100, 817, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSendingStatus = new JLabel("SENDING STATUS");
		lblSendingStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSendingStatus.setBounds(279, 26, 148, 20);
		frame.getContentPane().add(lblSendingStatus);

		JLabel lblSearch = new JLabel("Tracking NO. :");
		lblSearch.setBounds(22, 77, 85, 14);
		frame.getContentPane().add(lblSearch);

		t_search = new JTextField();
		t_search.setColumns(10);
		t_search.setBounds(119, 75, 560, 20);
		frame.getContentPane().add(t_search);

		JLabel lblID = new JLabel("ID");
		lblID.setBounds(32, 287, 46, 14);
		frame.getContentPane().add(lblID);

		t_id = new JTextField();
		t_id.setEditable(false);
		t_id.setColumns(10);
		t_id.setBounds(106, 285, 117, 20);
		frame.getContentPane().add(t_id);

		JLabel lblSenderName = new JLabel("Sender Name");
		lblSenderName.setBounds(32, 354, 98, 14);
		frame.getContentPane().add(lblSenderName);

		t_senderName = new JTextField();
		t_senderName.setEditable(false);
		t_senderName.setColumns(10);
		t_senderName.setBounds(117, 352, 184, 20);
		frame.getContentPane().add(t_senderName);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblFrom.setBounds(29, 315, 72, 14);
		frame.getContentPane().add(lblFrom);

		JTextPane tp_senderAddress = new JTextPane();
		tp_senderAddress.setEditable(false);
		tp_senderAddress.setBounds(117, 378, 231, 57);
		frame.getContentPane().add(tp_senderAddress);

		JLabel lblSenderTel = new JLabel("Sender Tel.");
		lblSenderTel.setBounds(43, 445, 98, 14);
		frame.getContentPane().add(lblSenderTel);

		t_senderTel = new JTextField();
		t_senderTel.setEditable(false);
		t_senderTel.setColumns(10);
		t_senderTel.setBounds(117, 445, 172, 20);
		frame.getContentPane().add(t_senderTel);

		JLabel lblRecieverName = new JLabel("Reciever Name");
		lblRecieverName.setBounds(403, 349, 117, 14);
		frame.getContentPane().add(lblRecieverName);

		t_recieverName = new JTextField();
		t_recieverName.setEditable(false);
		t_recieverName.setColumns(10);
		t_recieverName.setBounds(495, 346, 184, 20);
		frame.getContentPane().add(t_recieverName);

		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTo.setBounds(403, 312, 46, 14);
		frame.getContentPane().add(lblTo);

		JTextPane tp_recieverAddress = new JTextPane();
		tp_recieverAddress.setEditable(false);
		tp_recieverAddress.setBounds(495, 374, 231, 57);
		frame.getContentPane().add(tp_recieverAddress);

		JLabel lblRecieverTel = new JLabel("Reciever Tel.");
		lblRecieverTel.setBounds(403, 442, 91, 14);
		frame.getContentPane().add(lblRecieverTel);

		t_recieverTel = new JTextField();
		t_recieverTel.setEditable(false);
		t_recieverTel.setColumns(10);
		t_recieverTel.setBounds(495, 439, 184, 20);
		frame.getContentPane().add(t_recieverTel);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(32, 235, 72, 14);
		frame.getContentPane().add(lblStatus);

		t_status = new JTextField();
		t_status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		t_status.setEditable(false);
		t_status.setColumns(10);
		t_status.setBounds(106, 241, 164, 34);
		frame.getContentPane().add(t_status);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(716, 491, 77, 23);
		frame.getContentPane().add(btnQuit);

		Icon icon = new ImageIcon("../OOP_EXPRESS/src/images/search.png");
		JButton btnSearch = new JButton(icon);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(680, 74, 58, 21);
		frame.getContentPane().add(btnSearch);

		JLabel lbl_getP = new JLabel("getP");
		lbl_getP.setBounds(206, 135, 77, 52);
		frame.getContentPane().add(lbl_getP);

		JLabel lbl_sendP = new JLabel("sendP");
		lbl_sendP.setBounds(307, 135, 77, 52);
		frame.getContentPane().add(lbl_sendP);

		JLabel lbl_giveP = new JLabel("giveP");
		lbl_giveP.setBounds(407, 135, 77, 52);
		frame.getContentPane().add(lbl_giveP);

		JLabel lbl_receivedP = new JLabel("receivedP");
		lbl_receivedP.setBounds(514, 135, 77, 52);
		frame.getContentPane().add(lbl_receivedP);

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					if(!t_search.getText().equals("")){
						DB db = new DB();
						String[] data = db.query("select * from transport_detail where transport_id like \""+t_search.getText()+"\";");
						t_id.setText(data[0]);
					}
			}
		});
	}
}
