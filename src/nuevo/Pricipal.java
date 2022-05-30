package nuevo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pricipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JButton btnGrabar;
	private JButton btnPrimero;

	private int[] codigo = new int[10]; // {1,2,4,5};
	private String[] producto = new String[10];// {"re","fe","gr","tr"} ;
	private int[] cantidad = new int[10];
	private double[] precio = new double[10];
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	private int aux= 0;
	private int posicion = 0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JButton btnmodificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Pricipal frame = new Pricipal();
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
	public Pricipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("MANTENIMIENTO DE PRODUCTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(58, 29, 324, 14);
		contentPane.add(lblNewLabel);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 64, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.setBounds(120, 95, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(120, 126, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(120, 158, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(273, 81, 89, 23);
		contentPane.add(btnGrabar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(273, 125, 89, 23);
		contentPane.add(btnBuscar);

		btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(this);
		btnPrimero.setBounds(10, 258, 89, 23);
		contentPane.add(btnPrimero);

		btnNewButton = new JButton(" <-");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(120, 258, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton(" ->");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(235, 258, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Ultimo");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(345, 258, 89, 23);
		contentPane.add(btnNewButton_2);

		lblNewLabel_1 = new JLabel("Codigo :");
		lblNewLabel_1.setBounds(32, 67, 67, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Producto :");
		lblNewLabel_2.setBounds(32, 98, 78, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Cantidad :");
		lblNewLabel_3.setBounds(32, 129, 67, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Precio :");
		lblNewLabel_4.setBounds(32, 161, 67, 14);
		contentPane.add(lblNewLabel_4);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(273, 161, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnmodificar = new JButton("New button");
		btnmodificar.addActionListener(this);
		btnmodificar.setBounds(273, 196, 89, 23);
		contentPane.add(btnmodificar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnmodificar) {
			do_btnmodificar_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_2) {
			do_btnNewButton_2_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(e);
		}
	}

	protected void do_btnGrabar_actionPerformed(ActionEvent e) {

		codigo[posicion] = Integer.valueOf(txtCodigo.getText());
		producto[posicion] = txtProducto.getText();
		cantidad[posicion] = Integer.valueOf(txtCantidad.getText());
		precio[posicion] = Double.valueOf(txtPrecio.getText());

		JOptionPane.showMessageDialog(null, "Se guardo correctamente");
		limpiar();
		posicion++;
		
		
	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {

//		pos++;
//		if (pos < codigo.length && producto[pos] != null) {
//			llenadoDatos(pos);
//			btnNewButton.setEnabled(true);
//		} else {
//			JOptionPane.showMessageDialog(null, "Ya se ha recorrido el ultimo valor");
//			limpiar();
//			btnNewButton_1.setEnabled(false);
//		}

		
		if(aux<posicion-1) {

			aux= aux+1; 
			llenadoDatos(aux);
			
		}else {
//			JOptionPane.showMessageDialog(null, "Ya se ha encuentra en el ultimo");
			aux= -1;
			
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
//		pos--;
//		if (pos < 0) {
//			JOptionPane.showMessageDialog(null, "Ya no hay posiciones atras ");
//			pos = 0;
//			limpiar();
//			btnNewButton.setEnabled(false);
//			
//		} else {
//			//posicionesLlenadasDelArreglo()
//			llenadoDatos(pos);
//
//		}
		if(aux>0) {

			aux= aux-1; 
			llenadoDatos(aux);
			
		}else {
			aux=posicion;
			//JOptionPane.showMessageDialog(null, "Ya se ha encuentra en el primero");
			
		}
		
		
		
	}
//ultimo
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
//		txtCodigo.setText(codigo[posicion - 1] + "");
//		txtProducto.setText(producto[posicion- 1] + "");
//		txtCantidad.setText(cantidad[posicion - 1] +"");
//		txtPrecio.setText(precio[posicion-1]+"");
		// llenadoDatos(codigo.length - 1);
		
		//int posicionConDato = posicionesLlenadasDelArreglo();

		//System.out.println(posicion);
		llenadoDatos(posicion-1);
		aux=posicion-1; 
	}

	public int posicionesLlenadasDelArreglo() {
		int posicionConDato = 0;
		for (int i = producto.length - 1; i > 0; i--) {
			if (producto[i] == null) {
				posicionConDato = i - 1;
			}
		}
		return posicionConDato;
	}

	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		int codigoBuscar = Integer.valueOf(txtCodigo.getText());
		int encontrado = buscar(codigoBuscar);

		llenadoDatos(encontrado);
	}

	public int buscar(int numero) {
		int posicion = 0;
		for (int i = 0; i < 10; i++) {
			if (codigo[i] == numero)
				posicion = i;
		}
		return posicion;
	}

	public void llenadoDatos(int pos) {
		txtCodigo.setText(codigo[pos] + "");
		txtProducto.setText(producto[pos] + "");
		txtCantidad.setText(cantidad[pos] + "");
		txtPrecio.setText(precio[pos] + "");
	}

	public void limpiar() {
		txtCodigo.setText("");
		txtProducto.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtCodigo.requestFocus();
	}

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiar();
	}
	protected void do_btnmodificar_actionPerformed(ActionEvent e) {
		
		int codigoNuevo= Integer.valueOf(txtCodigo.getText());
		int  indice = buscar(codigoNuevo);
		codigo[indice] = codigoNuevo;
		producto[indice] = txtProducto.getText();
		cantidad[indice] = Integer.valueOf(txtCantidad.getText());
		precio[indice] = Double.valueOf(txtPrecio.getText());
		limpiar();
	}
}
