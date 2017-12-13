package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Date;

public class CardWithDraw extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public CardWithDraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("이름");
		label.setBounds(81, 63, 61, 16);
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(138, 58, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("카드 출금");
		label_1.setBounds(154, 17, 114, 16);
		label_1.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 121, 142, 26);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		JButton button = new JButton("확인");
		button.setBounds(288, 125, 90, 21);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String name = textField.getText();
					int money = Integer.parseInt(textField_1.getText());
					String balance = "";
					for (Account ac : AccountManager.accountStorage) {
						if (ac.getName().equals(name)) {
							ac.spendCard(money);
							File file = new File(name+"_card");
							FileWriter fw = new FileWriter(file,true);
							fw.write(name+" "+LocalDate.now()+" "+money+"\n");
							fw.close();
							balance = Integer.toString(ac.getBalance());
						}
					}
					Main.appendTextArea("이름 : " + name);
					Main.appendTextArea("잔고 : " + balance);
				}catch (Exception e) {
					e.getMessage();
				}
				dispose();
			}
		});
	}

}
