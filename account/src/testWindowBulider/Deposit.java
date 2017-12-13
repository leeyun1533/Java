package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Deposit extends JFrame {

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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("이름");
		label.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		label.setBounds(81, 63, 61, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(138, 58, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("입금");
		label_1.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		label_1.setBounds(191, 17, 61, 16);
		contentPane.add(label_1);
//		JButton button_2 = new JButton("확인");
//		button_2.setBounds(288, 58, 143, 21);
//		contentPane.add(button_2);
		textField_1 = new JTextField();
		textField_1.setText("입금 금액");
		textField_1.setColumns(10);
		textField_1.setBounds(110, 179, 142, 26);
		contentPane.add(textField_1);
		JButton button_3 = new JButton("확인");
		button_3.setBounds(264, 183, 143, 21);
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                int money = Integer.parseInt(textField_1.getText());

                String balance="";
                for(Account ac : AccountManager.accountStorage){
                    if(ac.getName().equals(name)){
                        ac.depositMoney(money);
                        balance=Integer.toString(ac.getBalance());
                    }
                }
                Main.appendTextArea("이름 : "+name);
                Main.appendTextArea("잔고 : "+balance);
                dispose();
            }
        });
	}

}
