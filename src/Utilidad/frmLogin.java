package Utilidad;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidad.Usuario;
import model.ModelCampeonato1;

public class frmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField textField_1;
	private JButton btnLogin;
	private JPasswordField txtPassword;
	ModelCampeonato1 mod = new ModelCampeonato1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(150, 35, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(150, 82, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(147, 141, 89, 23);
		contentPane.add(btnLogin);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(277, 82, 96, 20);
		contentPane.add(txtPassword);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			do_btnLogin_actionPerformed(e);
		}
	}
	int contador = 0;
	protected void do_btnLogin_actionPerformed(ActionEvent e) {
		
		List<Usuario> usuarios = mod.listaUsuarios();
		for (Usuario u : usuarios) {
			if (txtUsuario.getText().trim().equals(u.getUsuario())
					&& String.valueOf(txtPassword.getPassword()).trim().equals(u.getClave())) {

				frmCrudCampeonato crud = new frmCrudCampeonato();
				crud.setVisible(true);
				// crud.show();
				this.setVisible(false);
			}
		}

		contador++;
		System.out.println(contador);
		if (contador == 3) {
			JOptionPane.showMessageDialog(null, "Tuvo " + contador + " intentos erroneos. ");

			System.exit(0);
		}
		

	}
}
