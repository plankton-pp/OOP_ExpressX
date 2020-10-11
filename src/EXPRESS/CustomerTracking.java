package EXPRESS;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
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
	public void Check() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerTracking window = new CustomerTracking("start");
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
	public CustomerTracking(){}
	public CustomerTracking(String start) {
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

		Icon getP = new ImageIcon("../OOP_EXPRESS/src/images/package_ConvertImage.png");
		JLabel lbl_getP = new JLabel(getP);
		lbl_getP.setBounds(206, 135, 77, 52);
		frame.getContentPane().add(lbl_getP);

		Icon deliverP = new ImageIcon("../OOP_EXPRESS/src/images/deliver_ConvertImage.png");
		JLabel lbl_deliverP = new JLabel(deliverP);
		lbl_deliverP.setBounds(307, 135, 77, 52);
		frame.getContentPane().add(lbl_deliverP);

		Icon sendP = new ImageIcon("../OOP_EXPRESS/src/images/send_ConvertImage.png");
		JLabel lbl_sendP = new JLabel(sendP);
		lbl_sendP.setBounds(407, 135, 77, 52);
		frame.getContentPane().add(lbl_sendP);

		Icon receivedP = new ImageIcon("../OOP_EXPRESS/src/images/received_ConvertImage.png");
		JLabel lbl_receivedP = new JLabel(receivedP);
		lbl_receivedP.setBounds(514, 135, 77, 52);
		frame.getContentPane().add(lbl_receivedP);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(627, 492, 77, 23);
		frame.getContentPane().add(btnBack);

		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!t_search.getText().equals("")){
						DB db = new DB();
						String[] data = db.query("select * from transport_detail \n" +
								"inner join transport \n" +
								"on transport_detail.transport_id=transport.transport_id\n" +
								"where transport_detail.transport_id LIKE '" +t_search.getText().toUpperCase()+
								"';");
						t_status.setText(data[8]);
						t_id.setText(data[0]);
						t_senderName.setText(data[10]);
						tp_senderAddress.setText(data[11]);
						t_senderTel.setText(data[12]);
						t_recieverName.setText(data[13]);
						tp_recieverAddress.setText(data[14]);
						t_recieverTel.setText(data[15]);

						switch (data[8]){
							case "Picked up":lbl_getP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/package.png"));break;
							case "Transporting":lbl_getP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/package.png"));
								lbl_deliverP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/deliver.png"));
								break;
							case "Deliver":lbl_getP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/package.png"));
								lbl_deliverP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/deliver.png"));
								lbl_sendP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/send.png"));
								break;
							case "Received":lbl_getP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/package.png"));
								lbl_deliverP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/deliver.png"));
								lbl_sendP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/send.png"));
								lbl_receivedP.setIcon(new ImageIcon("../OOP_EXPRESS/src/images/received.png"));break;
						}
					}
				}catch (ArrayIndexOutOfBoundsException aobe){
					JOptionPane.showMessageDialog(new JFrame(),"Searching Not Found\nPlease Check Your Tracking No And Try Again","Searching",JOptionPane.OK_OPTION);
				}

			}
		});
	}
}
