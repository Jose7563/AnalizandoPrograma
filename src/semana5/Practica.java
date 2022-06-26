package semana5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Practica extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnGuardar;
	private JScrollPane scrollPane;
	private JTable tblDatos;
	private DefaultTableModel model;

	String[] titulos = { "Codigo", "Proucto", "Precio", "Cantidad", "Importe" };
	double subtotal = 0.0;
	double igv = 0.0;
	double total = 0.0;
	private JButton btnCalcular;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtCliente;
	private JTextField txtDireccion;
	private JTextField txtRuc;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_9;
	private JTextField txtBoleta;
	private JButton btnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica frame = new Practica();
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
	public Practica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Punto de Venta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(144, 11, 139, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(20, 151, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Producto :");
		lblNewLabel_2.setBounds(129, 151, 74, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Precio : ");
		lblNewLabel_3.setBounds(228, 151, 74, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Cantidad :");
		lblNewLabel_4.setBounds(332, 151, 57, 14);
		contentPane.add(lblNewLabel_4);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 176, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.setBounds(129, 176, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(228, 176, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(332, 176, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnGuardar = new JButton("Agregar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(548, 209, 89, 23);
		contentPane.add(btnGuardar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 219, 517, 193);
		contentPane.add(scrollPane);

		model = new DefaultTableModel(null, titulos);
		tblDatos = new JTable();
		tblDatos.setModel(model);
		scrollPane.setViewportView(tblDatos);

		JTableHeader encabezado = tblDatos.getTableHeader();
		encabezado.setBackground(new Color(0, 0, 0));
		encabezado.setForeground(new Color(255, 255, 255));

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(548, 258, 89, 23);
		contentPane.add(btnCalcular);

		lblNewLabel_5 = new JLabel("Cliente :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(21, 64, 62, 14);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Direcci\u00F2n :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(21, 100, 83, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("RUC  :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(256, 64, 46, 14);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Telefono :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(237, 100, 65, 14);
		contentPane.add(lblNewLabel_8);

		txtCliente = new JTextField();
		txtCliente.setBounds(114, 61, 86, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(114, 97, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtRuc = new JTextField();
		txtRuc.setBounds(312, 61, 86, 20);
		contentPane.add(txtRuc);
		txtRuc.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(312, 97, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		lblNewLabel_9 = new JLabel("FACTURA :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(359, 30, 129, 14);
		contentPane.add(lblNewLabel_9);

		txtBoleta = new JTextField();
		txtBoleta.setBounds(498, 29, 86, 20);
		contentPane.add(txtBoleta);
		txtBoleta.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(548, 175, 89, 23);
		contentPane.add(btnNuevo);

		codigoBoleta();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
		if (e.getSource() == btnCalcular) {
			do_btnCalcular_actionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}

	protected void do_btnGuardar_actionPerformed(ActionEvent e) {

		if (validar() == true) {
			String[] registro = new String[5];
			double importe = 0.0;
			registro[0] = txtCodigo.getText();
			registro[1] = txtProducto.getText();
			registro[2] = txtPrecio.getText();
			registro[3] = txtCantidad.getText();
			importe = (Double.parseDouble(txtCantidad.getText()) * Double.parseDouble(txtPrecio.getText()));
			registro[4] = importe + "";
			subtotal += importe;
			model.addRow(registro);

			// tblDatos.setModel(model);
			limpiar();
		}

	}

	private void limpiar() {
		txtCodigo.setText("");
		txtProducto.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtCodigo.requestFocus();

	}
	private void limpiarTodasCajas() {
		txtCliente.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtRuc.setText("");
		txtCodigo.setText("");
		txtProducto.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtCliente.requestFocus();
	}

	private void codigoBoleta() {
		txtBoleta.setText("FACT-0001");
		txtBoleta.setEditable(false);
	}

	private void codigoBoletaAutoIncremental() {
		int numero = 0;

		numero = Integer.parseInt(txtBoleta.getText().substring(8)) + 1;

		txtBoleta.setText("FACT-000" + numero);

	}

	protected void do_btnCalcular_actionPerformed(ActionEvent e) {

		if(tblDatos.getModel().getRowCount()>0) {
			String[] subtotales = new String[5];
			igv = subtotal * 0.18;
			total = subtotal + igv;
			subtotales[0] = "";
			subtotales[1] = "";
			subtotales[2] = "";
			subtotales[3] = "SUBTOTAL :";
			subtotales[4] = "$ " + subtotal;
			model.addRow(subtotales);
			subtotales[0] = "";
			subtotales[1] = "";
			subtotales[2] = "";
			subtotales[3] = "IGV :";
			subtotales[4] = "$ " + igv;
			model.addRow(subtotales);
			subtotales[0] = "";
			subtotales[1] = "";
			subtotales[2] = "";
			subtotales[3] = "TOTAL  :";
			subtotales[4] = "$ " + total;
			model.addRow(subtotales);
			// tblDatos.setModel(model);
		}else {
			JOptionPane.showMessageDialog(null, "No existen valores para calcular");
		}
		
		
	}

	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		codigoBoletaAutoIncremental();
		limpiarTodasCajas();
	}

	public String quitarEspacios(JTextField text) {
		return text.getText().trim();
	}

	public boolean validar() {
		
		Pattern pRuc = Pattern.compile("\\d{11}");
		Matcher mRuc = pRuc.matcher(quitarEspacios(txtRuc));
		//telefono
		Pattern pTelefono = Pattern.compile("\\d{9}");
		Matcher mTelefono = pTelefono.matcher(quitarEspacios(txtTelefono));
		// codigo
		Pattern pCodigo = Pattern.compile("[a-zA-Z[0-9]]{2,}");
		Matcher mCodigo = pCodigo.matcher(quitarEspacios(txtCodigo));
		//cantidad
		Pattern pCantidad = Pattern.compile("[1-9]{1,}");
		Matcher mCantidad = pCantidad.matcher(quitarEspacios(txtCantidad));
		// producto
		Pattern pProducto = Pattern.compile("[a-zA-Z]{2,}");
		Matcher mProducto = pProducto.matcher(quitarEspacios(txtProducto));
		//precio 
		Pattern pPrecio = Pattern.compile("\\d+([\\.]\\d+)?");
		Matcher mPrecio = pPrecio.matcher(quitarEspacios(txtPrecio));

		if (!mRuc.matches()) {
			txtRuc.setText("");
			JOptionPane.showMessageDialog(null, "El campo ruc solo acepta 11 digitos ");
			return false;
		}else if(quitarEspacios(txtCliente).equals("") || quitarEspacios(txtCliente) == null ) {
			txtCliente.setText("");
			JOptionPane.showMessageDialog(null, "El campo cliente debe tener texto");
			return false;
		}else if(quitarEspacios(txtDireccion).equals("") || quitarEspacios(txtDireccion) == null ) {
			txtDireccion.setText("");
			JOptionPane.showMessageDialog(null, "El campo direccion debe tener texto");
			return false;
		}else if(!mTelefono.matches()) {
			txtTelefono.setText("");
			JOptionPane.showMessageDialog(null, "El campo telefono solo numero de telefono de 9 digitos");
			return false;
		}else if(!mCodigo.matches()) {
			txtCodigo.setText("");
			JOptionPane.showMessageDialog(null, "El campo codigo solo acepta valores alfanumericos");
			return false;
		}else if(!mCantidad.matches()) {
			txtCantidad.setText("");
			JOptionPane.showMessageDialog(null, "El campo cantidad solo acepta numeros enteros y positivos");
			return false;
		}else if(!mProducto.matches()) {
			txtProducto.setText("");
			JOptionPane.showMessageDialog(null, "El campo producto solo acepta valores de a hasta z ");
			return false;
		}else if(!mPrecio.matches()) {
			txtPrecio.setText("");
			JOptionPane.showMessageDialog(null, "El campo precio solo acepta numeros enteros o decimales ");
			return false;
		}else {
			return true;
		}
	}

}
