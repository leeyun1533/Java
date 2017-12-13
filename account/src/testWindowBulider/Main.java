package testWindowBulider;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextArea textArea;

	static Main frame;

	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AccountManager accountManager = AccountManager.createManagerInst();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Main();
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
	public static void appendTextArea(String content){
		textArea.append("\n"+content);
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(22, 33, 206, 208);
		contentPane.add(scrollPane);
		textArea.setColumns(10);


		JButton btn1 = new JButton("새 계좌 만들기");
		btn1.setAction(action_1);
		btn1.setBounds(240, 41, 190, 36);
		contentPane.add(btn1);
		JButton btn2 = new JButton("입금");
		btn2.setAction(action_2);
		btn2.setBounds(436, 41, 190, 36);
		contentPane.add(btn2);
		JButton btn3 = new JButton("카드 출금");
		btn3.setAction(action_3);
		btn3.setBounds(240, 89, 190, 42);
		contentPane.add(btn3);
		JButton btn4 = new JButton("현금 출금");
		btn4.setAction(action_4);
		btn4.setBounds(436, 91, 190, 38);
		contentPane.add(btn4);
		JButton btn5 = new JButton("카드 출금내역");
		btn5.setAction(action_5);
		btn5.setBounds(240, 143, 190, 43);
		contentPane.add(btn5);
		JButton btn6 = new JButton("현금 출금내역");
		btn6.setAction(action_6);
		btn6.setBounds(436, 143, 190, 43);
		contentPane.add(btn6);
		JButton btn7 = new JButton("통장 잔고 조회");
		btn7.setAction(action_7);
		btn7.setBounds(240, 198, 190, 43);
		contentPane.add(btn7);
		JButton btn8 = new JButton("종료");
		btn8.setAction(action_8);
		btn8.setBounds(436, 198, 190, 43);
		contentPane.add(btn8);
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "새 계좌 생성");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			NewAccount newAccount = new NewAccount();
			newAccount.setVisible(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "입금");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Deposit deposit = new Deposit();
			deposit.setVisible(true);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "신용카드 출금");
			putValue(SHORT_DESCRIPTION, "신용카드 출금");
		}
		public void actionPerformed(ActionEvent e) {
			CardWithDraw cardwithdraw = new CardWithDraw();
			cardwithdraw.setVisible(true);
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "현금 출금");
			putValue(SHORT_DESCRIPTION, "현금 출금");
		}
		public void actionPerformed(ActionEvent e) {
			CashWithDraw cashWithDraw = new CashWithDraw();
			cashWithDraw.setVisible(true);
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "신용카드 출금내역 ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		    Checked_Card checked_card = new Checked_Card();
		    checked_card.setVisible(true);
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "현금 출금내역 ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Checked_cash checkedcash = new Checked_cash();
			checkedcash.setVisible(true);
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "통장 잔고 조회 ");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Checked_bankbook checked_bankbook=new Checked_bankbook();
			checked_bankbook.setVisible(true);
		}
	}

	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "종료");
			putValue(SHORT_DESCRIPTION, "종료");
		}
		public void actionPerformed(ActionEvent e) {
            AccountManager.storeToFile();
		    System.exit(0);
		}
	}
}
