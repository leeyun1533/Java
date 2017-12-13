package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CashWithDraw extends JFrame {

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
					CashWithDraw frame = new CashWithDraw();
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
	public CashWithDraw() {
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
		
		JLabel label_1 = new JLabel("현금 출금");
		label_1.setBounds(191, 17, 61, 16);
		label_1.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		contentPane.add(label_1);

		textField_1 = new JTextField();
        textField_1.setBounds(126, 121, 142, 26);
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
							ac.spendCash(money);
                            File file = new File(name+"_cash");
                            FileWriter fw = new FileWriter(file,true);
                            fw.write(name+" "+ LocalDate.now()+" "+money+"\n");
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
