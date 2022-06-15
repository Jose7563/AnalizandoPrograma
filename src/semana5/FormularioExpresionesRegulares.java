package semana5;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioExpresionesRegulares extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtNum1;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioExpresionesRegulares frame = new FormularioExpresionesRegulares();
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
	public FormularioExpresionesRegulares() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNum = new JTextField();
		txtNum.setBounds(63, 11, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);

		txtNum1 = new JTextField();
		txtNum1.setBounds(63, 42, 86, 20);
		contentPane.add(txtNum1);
		txtNum1.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(60, 85, 89, 23);
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			do_btnProcesar_actionPerformed(e);
		}
	}

	protected void do_btnProcesar_actionPerformed(ActionEvent e) {
		Pattern patron = Pattern.compile("a*b");
		Matcher encaja = patron.matcher(txtNum.getText());
		String res = encaja.replaceAll("-");
		txtNum1.setText(res);
	}
}
