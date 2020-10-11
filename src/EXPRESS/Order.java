package EXPRESS;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.DateFormatSymbols;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Order {

	private JFrame frame;
	private JTextField t_id;
	private JTextField t_senderName;
	private JTextField t_senderAddress;
	private JTextField t_senderTel;
	private JTextField t_receiverName;
	private JTextField t_receiverAddress;
	private JTextField t_receiverTel;
	private JTextField t_volume;
	private JTextField t_weight;
	private JTextField t_price;
	private JTextField t_Time;




	/**
	 * Launch the application.
	 */
	public void sendingForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order("run");
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
	public Order(){

	}
	public Order(String start)
	{
		if(start.equals("run"))
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String[] boxSize ={"","mini","S","M","L","XL"};
		Connection con;
		Statement st;
		ResultSet rs;
		int lastID=2;
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/OOPExpress","root","");
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				System.out.println("Connected");
				rs=st.executeQuery("select max(package_id) as lastID from transport;");
				while(rs.next()){
					if(rs==null){
						System.out.print("Here is last");
					}else{
						lastID = rs.getInt("lastID");
						System.out.println("Line 78 LastID is "+lastID);
					}
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
				t_id.setText(String.format("%d",lastID+1));
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

				t_senderAddress = new JTextField();
				t_senderAddress.setBounds(150, 196, 243, 53);
				frame.getContentPane().add(t_senderAddress);

				t_senderTel = new JTextField();
				t_senderTel.setColumns(10);
				t_senderTel.setBounds(150, 262, 172, 32);
				frame.getContentPane().add(t_senderTel);

				t_receiverName = new JTextField();
				t_receiverName.setColumns(10);
				t_receiverName.setBounds(150, 364, 172, 29);
				frame.getContentPane().add(t_receiverName);

				t_receiverAddress = new JTextField();
				t_receiverAddress.setBounds(150, 410, 243, 65);
				frame.getContentPane().add(t_receiverAddress);

				t_receiverTel = new JTextField();
				t_receiverTel.setColumns(10);
				t_receiverTel.setBounds(150, 485, 172, 25);
				frame.getContentPane().add(t_receiverTel);

				JLabel lblDate = new JLabel("Date");
				lblDate.setBounds(458, 71, 77, 14);
				frame.getContentPane().add(lblDate);

				JTextField t_date = new JTextField();
				t_date.setEditable(false);
				t_date.setColumns(10);
				t_date.setBounds(517, 64, 130, 29);
				Calendar calen = new GregorianCalendar();
				int day = calen.get(Calendar.DAY_OF_MONTH);
				int mon = calen.get(Calendar.MONTH)+1;
				int year = calen.get(Calendar.YEAR);
				String month = getMonth(mon);
				t_date.setText(day+" "+month+" "+year);
				frame.getContentPane().add(t_date);

				JLabel lblTime = new JLabel("Time");
				lblTime.setBounds(458, 114, 77, 14);
				frame.getContentPane().add(lblTime);

				t_Time = new JTextField();
				t_Time.setEditable(false);
				t_Time.setColumns(10);
				t_Time.setBounds(517, 112, 130, 29);
				frame.getContentPane().add(t_Time);

				JLabel lblBoxSize = new JLabel("Box Size");
				lblBoxSize.setBounds(475, 293, 77, 14);
				frame.getContentPane().add(lblBoxSize);

				JComboBox cb_boxSize = new JComboBox(boxSize);
				cb_boxSize.setBounds(534, 285, 113, 30);
				frame.getContentPane().add(cb_boxSize);

				JComboBox cb_Type = new JComboBox(new String[]{"Normal","Emergency"});
				cb_Type.setBounds(534, 404, 113, 27);
				frame.getContentPane().add(cb_Type);

				JButton btnCancle = new JButton("Cancel");
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						t_senderName.setText("");
						t_senderAddress.setText("");
						t_senderTel.setText("");

						t_receiverName.setText("");
						t_receiverAddress.setText("");
						t_receiverTel.setText("");

						t_volume.setText("");
						t_price.setText("");
						cb_boxSize.setSelectedIndex(0);

						t_id.setText(String.format("%d",Integer.parseInt(t_id.getText())));
					}
				});
				btnCancle.setBounds(557, 555, 89, 23);
				frame.getContentPane().add(btnCancle);

				t_volume = new JTextField();
				t_volume.setColumns(10);
				t_volume.setEditable(false);
				t_volume.setBounds(534, 325, 113, 29);
				frame.getContentPane().add(t_volume);

				JLabel lblunit = new JLabel("inches");
				lblunit.setBounds(670, 325, 113, 29);
				frame.getContentPane().add(lblunit);

				t_weight = new JTextField();
				t_weight.setColumns(10);
				t_weight.setBounds(534, 364, 113, 29);
				frame.getContentPane().add(t_weight);


				JLabel lblVolume = new JLabel("Volume");
				lblVolume.setBounds(475, 330, 45, 14);
				frame.getContentPane().add(lblVolume);

				JLabel lblbaht = new JLabel("Baht");
				lblbaht.setBounds(670, 444, 113, 29);
				frame.getContentPane().add(lblbaht);

				JLabel lblgram = new JLabel("gram");
				lblgram.setBounds(670, 364, 113, 29);
				frame.getContentPane().add(lblgram);

				JLabel lblWeight = new JLabel("Weight");
				lblWeight.setBounds(475, 373, 45, 14);
				frame.getContentPane().add(lblWeight);

				t_price = new JTextField();
				t_price.setColumns(10);
				t_price.setEditable(false);
				t_price.setBounds(534, 444, 113, 27);
				frame.getContentPane().add(t_price);

				JLabel lblType = new JLabel("Type");
				lblType.setBounds(476, 413, 45, 14);
				frame.getContentPane().add(lblType);

				JLabel lblPrice = new JLabel("Price");
				lblPrice.setBounds(476, 443, 45, 14);
				frame.getContentPane().add(lblPrice);

				clock();

				JButton btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Check Price
						try{
							Integer.parseInt(t_weight.getText());
							//Cal Price by DATA_TYPE
							EvaluateSize esize = new EvaluateSize(cb_boxSize.getSelectedItem().toString());
							EvaluateType etype = new EvaluateType(cb_Type.getSelectedIndex());
							EvaluateWeight eweight = new EvaluateWeight(Double.parseDouble(t_weight.getText()));

							//SET SUMMARY PRICE: From GET METHOD
							SumPrice sum = new SumPrice();
							sum.setPriceOfSize(esize.getPrice());
							sum.setPriceWeight(eweight.getPriceOfWeight());
							sum.setPriceofType(etype.getPriceOfType());

							t_price.setText(String.format("%.2f",sum.getTotalPrice()));
						}catch (NumberFormatException nfe){
							JOptionPane.showMessageDialog(frame,"Invalid Type of Weight !","Warning",JOptionPane.WARNING_MESSAGE);
							t_price.setText(null);
						}


							if(t_price.getText().equals("")==true){
								JOptionPane.showMessageDialog(frame,"Invalid Weight !","Warning",JOptionPane.WARNING_MESSAGE);
							}else {
								if (cb_boxSize.getSelectedIndex() == 0) {
									JOptionPane.showMessageDialog(frame, "Invalid Size of Box !", "Warning", JOptionPane.WARNING_MESSAGE);
								} else {
									//Check Sender Information
									if (t_senderName.getText().equals("") || t_senderAddress.getText().equals("") || t_senderTel.getText().equals("")) {
										JOptionPane.showMessageDialog(frame, "Invalid of Sender Information", "Warning", JOptionPane.WARNING_MESSAGE);
									} else {
										//Check Receiver Infomation
										if (t_receiverName.getText().equals("") || t_receiverAddress.getText().equals("") || t_receiverTel.getText().equals("")) {
											JOptionPane.showMessageDialog(frame, "Invalid of Receiver Information", "Warning", JOptionPane.WARNING_MESSAGE);
										} else {
											System.out.println("Complete");
											BoxFac fac = new BoxFac();
											char code = cb_Type.getSelectedItem().toString().charAt(0);
											String data2[] = {day + "-" + mon + "-" + year, t_Time.getText(), t_price.getText(),String.format("%c",code).toUpperCase()};
											//Data from FORM for Insert on DATABASE
											String data[] = {t_id.getText(), t_senderName.getText(), t_senderAddress.getText(), t_senderTel.getText()
													, t_receiverName.getText(), t_receiverAddress.getText(), t_receiverTel.getText(),String.format("%c",code).toUpperCase()};
											//Create Instance of DB Class
											DB db = new DB();
											//If Insertion were "Successfull" alert msg
											int object = JOptionPane.showConfirmDialog(frame, "Insertion Confirm", "Warning", JOptionPane.OK_CANCEL_OPTION);
											//Insert
											if (object == JOptionPane.OK_OPTION) {
												Box box = fac.createBox(Integer.parseInt(t_id.getText()), cb_boxSize.getSelectedItem().toString(), Integer.parseInt(t_weight.getText()), cb_Type.getSelectedItem().toString());
												db.insert_transport_detail(data2, box);
												System.out.println("inserted");
												db.insert_transport(data);
												t_senderName.setText("");
												t_senderAddress.setText("");
												t_senderTel.setText("");

												t_receiverName.setText("");
												t_receiverAddress.setText("");
												t_receiverTel.setText("");
												t_weight.setText(null);
												t_volume.setText(null);
												t_price.setText(null);
												cb_boxSize.setSelectedIndex(0);

												if (db.checkerror > 0) {
													t_id.setText(String.format("%d", Integer.parseInt(t_id.getText())));
													t_senderName.setText(null);
													t_senderAddress.setText(null);
													t_senderTel.setText(null);

													t_receiverName.setText(null);
													t_receiverAddress.setText(null);
													t_receiverTel.setText("");

													t_weight.setText(null);
													t_volume.setText(null);
													t_price.setText(null);
													cb_boxSize.setSelectedIndex(0);
												}else {
													t_id.setText(String.format("%d", Integer.parseInt(t_id.getText())+1));
													t_senderName.setText(null);
													t_senderAddress.setText(null);
													t_senderTel.setText(null);

													t_receiverName.setText(null);
													t_receiverAddress.setText(null);
													t_receiverTel.setText("");

													t_weight.setText(null);
													t_volume.setText(null);
													t_price.setText(null);
													cb_boxSize.setSelectedIndex(0);
												}
											}else {
												t_senderName.setText(null);
												t_senderAddress.setText(null);
												t_senderTel.setText(null);

												t_receiverName.setText(null);
												t_receiverAddress.setText(null);
												t_receiverTel.setText(null);
												t_weight.setText(null);
												t_volume.setText(null);
												t_price.setText(null);
												cb_boxSize.setSelectedIndex(0);
											}
										}

									}

								}

							}
					}
				});

				btnAdd.setBounds(458, 555, 89, 23);
				frame.getContentPane().add(btnAdd);

				JButton btnQuit = new JButton("Quit");
				btnQuit.setBounds(663, 555, 77, 23);
				btnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
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
				btnCalculate.setBounds(655, 364, 100, 21);

				ResultSet rs2 = null;
				rs2 = st.executeQuery("select * from box order by width;");
				int width[] = new int[5];
				int height[] = new int[5];
				int depth[] = new int[5];
				ArrayList<String> size = new ArrayList<String>();
				int i = 0;
				while (rs2.next()){
					size.add(rs2.getString("size"));
					width[i]=rs2.getInt("width");
					height[i]=rs2.getInt("height");
					depth[i]=rs2.getInt("depth");

					i++;
				}
				cb_boxSize.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						switch (cb_boxSize.getSelectedItem().toString()){
							case "Mini":t_volume.setText(width[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]+" x "
									+height[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]
									+" x "+depth[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]);break;
							case "S":t_volume.setText(width[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]+" x "
									+height[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]
									+" x "+depth[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]);break;
							case "M":t_volume.setText(width[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]+" x "
									+height[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]
									+" x "+depth[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]);break;
							case "L":t_volume.setText(width[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]+" x "
									+height[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]
									+" x "+depth[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]);break;
							case "XL":t_volume.setText(width[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]+" x "
									+height[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]
									+" x "+depth[size.indexOf(cb_boxSize.getSelectedItem().toString().toLowerCase())]);break;
							default:t_volume.setText(null);break;
						}
					}
				});

				t_weight.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!t_weight.getText().equals("")){
							t_price.setText(t_weight.getText());
						}else {
							t_price.setText("");
						}
					}
				});


			}catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month-1];
	}
	public void clock(){
		Thread clock = new Thread(){
			@Override
			public void run() {
				for(;;){
					LocalTime now = LocalTime.now();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
					t_Time.setText(dtf.format(now));
					frame.getContentPane().add(t_Time);

				}
			}
		};
		clock.start();

	}
}
