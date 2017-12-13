package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Checked_cash extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checked_cash frame = new Checked_cash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Checked_cash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("현금 출금내역");
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 18));
		label.setBounds(142, 6, 200, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("이름");
		label_1.setBounds(27, 65, 39, 16);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(66, 60, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("확인");
		button.setBounds(196, 60, 62, 29);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String name = textField.getText();
					for (Account ac : AccountManager.accountStorage) {
						if (ac.getName().equals(name)) {
							File file = new File(name+"_cash");
							Scanner scan = new Scanner(file);
							while(scan.hasNextLine()){
								Main.appendTextArea(scan.nextLine());
							}
						}
					}
				}catch (Exception e) {
					e.getMessage();
				}
				dispose();
			}
		});
		
	}

}
