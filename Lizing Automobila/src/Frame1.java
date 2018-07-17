import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class Frame1 {

	private JFrame frame;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JComboBox comboBox;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBackground(SystemColor.text);
		frame.setBounds(100, 100, 297, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCarPrice = new JLabel("Car Price");
		lblCarPrice.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblCarPrice.setBounds(36, 35, 100, 31);
		frame.getContentPane().add(lblCarPrice);
		
		JLabel lblNewLabel = new JLabel("Participation");
		lblNewLabel.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblNewLabel.setBounds(36, 77, 100, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button1 = new JButton("Calculate ");
		button1.setFont(new Font("Square721 BT", Font.PLAIN, 16));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				double car_price, participation, rate;
				int period;
				car_price = Double.parseDouble(text1.getText());
				participation = Double.parseDouble(text2.getText());
				rate = Double.parseDouble(text3.getText());
				if(rate<=0 || rate>=100) 
					JOptionPane.showMessageDialog(frame, "Please enter valid interest rate!");
				else if(participation<(car_price*0.3) || participation >=car_price) {
					JOptionPane.showMessageDialog(frame, "Please enter valid participation!\n");
				}
				else {
					period = (Integer)comboBox.getSelectedItem();
					double monthly;
					monthly = ((car_price-participation)+((car_price-participation)*(rate)/100))/period;
					String message = "Monthly rate is " +  df2.format(monthly) + " euros";
					JOptionPane.showMessageDialog(frame, message);
				}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(frame, "Please enter valid parameters!");
				}
				
			}
		});
		button1.setBounds(36, 246, 210, 25);
		frame.getContentPane().add(button1);
		
		text1 = new JTextField();
		text1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				if(!Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) {
					arg0.consume();
				}
			}
		});
		text1.setBounds(160, 42, 100, 20);
		frame.getContentPane().add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		
		text2.setBounds(160, 81, 100, 20);
		frame.getContentPane().add(text2);
		text2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Interest rate");
		lblNewLabel_1.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 152, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Period ");
		lblNewLabel_2.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(36, 197, 112, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		text3 = new JTextField();
		text3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((text3.getText().toString()+e.getKeyChar()).matches("[0-9]*(.[0-9]*)?"))){
					   e.consume();
					}
				}
		});
		text3.setBounds(160, 151, 100, 20);
		frame.getContentPane().add(text3);
		text3.setColumns(10);
		
		JLabel lblLeasingCarCalculator = new JLabel("Leasing Car Calculator");
		lblLeasingCarCalculator.setFont(new Font("Square721 BT", Font.PLAIN, 16));
		lblLeasingCarCalculator.setBounds(59, 11, 187, 20);
		frame.getContentPane().add(lblLeasingCarCalculator);
		
		comboBox = new JComboBox();
		comboBox.addItem(12);
		comboBox.addItem(24);
		comboBox.addItem(48);
		comboBox.addItem(60);
		comboBox.setSelectedItem(null);
		
		comboBox.setBounds(204, 196, 56, 25);
		frame.getContentPane().add(comboBox);
		
		JButton btnMinimalPartitipation = new JButton("Minimal participation");
		btnMinimalPartitipation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int price = Integer.parseInt(text1.getText());
				double part = price*0.3;
				String s = String.valueOf(part);
				text2.setText(s);
				
			}
		});
		btnMinimalPartitipation.setFont(new Font("Square721 BT", Font.PLAIN, 13));
		btnMinimalPartitipation.setBounds(36, 117, 224, 23);
		frame.getContentPane().add(btnMinimalPartitipation);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblCarPrice, lblNewLabel}));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
