package EXPRESS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Order {

	private JFrame frame;
	private JTextField t_id;
	private JTextField t_senderName;
	private JTextField t_senderTel;
	private JTextField t_recieverName;
	private JTextField t_recieverTel;
	private JTextField t_dateTime;
	private JTextField t_volume;
	private JTextField t_weight;
	private JTextField t_price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String boxSize[]={"Mini","S","M","L","XL"};
		String statement_box_data ="select * from box";
		String statement_transporting ="select MAX(transport_id) from transport";
		Connection con = null;
		Statement st;
		ResultSet rs=null;
		int last_id;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				if(con!=null){
					System.out.println("Connected");
					rs=st.executeQuery("select max(height) as max from box;");
					last_id = rs.getInt("height");
				}

			}catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}



		frame = new JFrame();
		frame.setBounds(100, 100, 800, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOopExpress = new JLabel("OOP EXPRESS");
		lblOopExpress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOopExpress.setBounds(299, 10, 126, 40);
		frame.getContentPane().add(lblOopExpress);

		t_id = new JTextField();
		t_id.setEditable(false);
		t_id.setBounds(150, 64, 113, 29);
		frame.getContentPane().add(t_id);
		t_id.setColumns(10);

		JLabel lblSender = new JLabel("Sender Name");
		lblSender.setBounds(39, 152, 114, 14);
		frame.getContentPane().add(lblSender);
		
		JLabel lblSenderAddress = new JLabel("Sender Address");
		lblSenderAddress.setBounds(39, 189, 114, 14);
		frame.getContentPane().add(lblSenderAddress);
		
		JLabel lblSenderTel = new JLabel("Sender Tel.");
		lblSenderTel.setBounds(39, 270, 114, 14);
		frame.getContentPane().add(lblSenderTel);
		
		JLabel lblRecieverName = new JLabel("Reciever Name");
		lblRecieverName.setBounds(39, 371, 114, 14);
		frame.getContentPane().add(lblRecieverName);
		
		JLabel lblRecieverAddress = new JLabel("Reciever Address");
		lblRecieverAddress.setBounds(39, 410, 114, 14);
		frame.getContentPane().add(lblRecieverAddress);
		
		JLabel lblRecieverTel = new JLabel("Reciever Tel.");
		lblRecieverTel.setBounds(39, 490, 114, 14);
		frame.getContentPane().add(lblRecieverTel);
		
		t_senderName = new JTextField();
		t_senderName.setColumns(10);
		t_senderName.setBounds(150, 152, 172, 29);
		frame.getContentPane().add(t_senderName);
		
		JTextPane tp_senderAddress = new JTextPane();
		tp_senderAddress.setBounds(150, 196, 243, 53);
		frame.getContentPane().add(tp_senderAddress);
		
		t_senderTel = new JTextField();
		t_senderTel.setColumns(10);
		t_senderTel.setBounds(150, 262, 172, 32);
		frame.getContentPane().add(t_senderTel);
		
		t_recieverName = new JTextField();
		t_recieverName.setColumns(10);
		t_recieverName.setBounds(150, 364, 172, 29);
		frame.getContentPane().add(t_recieverName);
		
		JTextPane tp_recieverAddress = new JTextPane();
		tp_recieverAddress.setBounds(150, 410, 243, 65);
		frame.getContentPane().add(tp_recieverAddress);
		
		t_recieverTel = new JTextField();
		t_recieverTel.setColumns(10);
		t_recieverTel.setBounds(150, 485, 172, 25);
		frame.getContentPane().add(t_recieverTel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(458, 71, 77, 14);
		frame.getContentPane().add(lblDate);
		
		t_dateTime = new JTextField();
		t_dateTime.setEditable(false);
		t_dateTime.setColumns(10);
		t_dateTime.setBounds(517, 64, 130, 29);
		Calendar calen = new GregorianCalendar();
		int day = calen.get(Calendar.DAY_OF_MONTH);
		int mon = calen.get(Calendar.MONTH)+1;
		int year = calen.get(Calendar.YEAR);
		int hr = calen.get(Calendar.HOUR);
		int min = calen.get(Calendar.MINUTE);
		int sec = calen.get(Calendar.HOUR);
		String month = getMonth(mon);
		t_dateTime.setText(day+" "+month+" "+year);
		frame.getContentPane().add(t_dateTime);
		
		JLabel lblBoxSize = new JLabel("Box Size");
		lblBoxSize.setBounds(475, 293, 77, 14);
		frame.getContentPane().add(lblBoxSize);
		
		JComboBox cb_boxSize = new JComboBox(boxSize);
		cb_boxSize.setBounds(534, 285, 113, 30);
		frame.getContentPane().add(cb_boxSize);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setBounds(475, 330, 77, 14);
		frame.getContentPane().add(lblVolume);
		
		t_volume = new JTextField();
		t_volume.setEditable(false);
		t_volume.setColumns(10);
		t_volume.setBounds(534, 325, 180, 29);
		frame.getContentPane().add(t_volume);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancle.setBounds(557, 555, 89, 23);
		frame.getContentPane().add(btnCancle);
		
		t_weight = new JTextField();
		t_weight.setColumns(10);
		t_weight.setBounds(534, 364, 113, 29);
		frame.getContentPane().add(t_weight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(475, 373, 45, 14);
		frame.getContentPane().add(lblWeight);
		
		t_price = new JTextField();
		t_price.setColumns(10);
		t_price.setEditable(false);
		t_price.setBounds(534, 403, 113, 27);
		frame.getContentPane().add(t_price);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(476, 411, 45, 14);
		frame.getContentPane().add(lblPrice);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(458, 555, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(663, 555, 77, 23);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnQuit);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(67, 75, 30, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblreciever = new JLabel("RECIEVER");
		lblreciever.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblreciever.setBounds(39, 326, 114, 13);
		frame.getContentPane().add(lblreciever);
		
		JLabel lblSender_1 = new JLabel("SENDER");
		lblSender_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSender_1.setBounds(39, 119, 114, 13);
		frame.getContentPane().add(lblSender_1);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(655, 407, 100, 21);
		frame.getContentPane().add(btnCalculate);
	}
	public String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month-1];
	}
}
