package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Checked_Card extends JFrame {

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
					Checked_Card frame = new Checked_Card();
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
	public Checked_Card() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("신용카드 출금 내역 조회");
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 18));
		label.setBounds(142, 6, 201, 27);
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
							File file = new File(name+"_card");
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
