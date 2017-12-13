package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class Checked_bankbook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Component textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checked_bankbook frame = new Checked_bankbook();
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
	public Checked_bankbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("이름");
		label.setBounds(30, 63, 61, 16);
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(74, 58, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("통장 잔고확인");
		label_1.setBounds(164, 17, 88, 16);
		label_1.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		contentPane.add(label_1);
		
		JButton button_2 = new JButton("확인");
		button_2.setBounds(216, 62, 93, 21);
		contentPane.add(button_2);

        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String name = textField.getText();
                    for (Account ac : AccountManager.accountStorage) {
                        if (ac.getName().equals(name)) {
                            Main.appendTextArea("이름 : "+ac.getName());
                            Main.appendTextArea("잔고 : "+ac.getBalance());
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
