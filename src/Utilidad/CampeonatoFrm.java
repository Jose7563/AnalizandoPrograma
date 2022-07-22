package Utilidad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.LIbro;
import model.ModelCampeonato;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CampeonatoFrm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtAnio;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampeonatoFrm frame = new CampeonatoFrm();
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
	public CampeonatoFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(124, 29, 86, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(124, 76, 86, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(234, 28, 89, 23);
		contentPane.add(btnGuardar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}
	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		/// ya se valido
//		Campeonato ca = new Campeonato();	
//		ca.setDescripcion(txtDescripcion.getText());
//		ca.setAnio(Integer.valueOf(txtAnio.getText()));
//		
//		ModelCampeonato m = new ModelCampeonato(); 
//		int insertados =m.insertaCampeonato(ca);
//		if(insertados > 0 ) {
//			JOptionPane.showMessageDialog(null," Se Inserto correctamente");
//		}
		String descripcion = txtDescripcion.getText().trim(); 
		String anio= txtAnio.getText().trim();
		validar(descripcion, anio);
		System.out.println("Se valido");
	}
	
	public void validar(String descripcion ,String anio) {
		if(!descripcion.matches("[a-z_A-Z0-9\\s]{4,50}")) {
			JOptionPane.showMessageDialog(null,"La descripcion deser mayor a 4 carateres");
			txtDescripcion.requestFocus();
			return; 
		}
		if(!anio.matches("^[12][0-9]{4}")) {
			JOptionPane.showMessageDialog(null,"La descripcion deser digito");
			txtAnio.requestFocus();
			return; 
		}
		
	}
}
