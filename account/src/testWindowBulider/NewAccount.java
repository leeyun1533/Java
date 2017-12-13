package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class NewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */

	public NewAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(139, 117, 150, 45);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("새 계좌 생성");
		lblNewLabel.setBounds(182, 89, 107, 16);
		contentPane.add(lblNewLabel);
		JButton button = new JButton("등록");
		button.setBounds(152, 174, 117, 29);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				Account ac=new Account(name);
				AccountManager.accountStorage.add(new Account(name));
                File file1=new File(name+"_card");
                File file2=new File(name+"_cash");
				Main.appendTextArea("이름 : "+ac.getName());
				Main.appendTextArea("잔고 : "+Integer.toString(ac.getBalance()));
				dispose();
			}
		});
	}



}
