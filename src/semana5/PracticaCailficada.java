package semana5;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PracticaCailficada extends JFrame implements ActionListener {

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
	private JScrollPane scrollPane;
	private JTable tblDatos;
	private DefaultTableModel modelo;

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
	private JTextField txtFactura;
	private JButton btnNuevo;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticaCailficada frame = new PracticaCailficada();
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
	public PracticaCailficada() {
		setTitle("Factura Productos");
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
		lblNewLabel_1.setBounds(21, 211, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Producto :");
		lblNewLabel_2.setBounds(126, 211, 74, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Precio : ");
		lblNewLabel_3.setBounds(228, 211, 74, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Cantidad :");
		lblNewLabel_4.setBounds(345, 211, 57, 14);
		contentPane.add(lblNewLabel_4);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(21, 224, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.setBounds(129, 224, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(228, 224, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(332, 224, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 255, 517, 193);
		contentPane.add(scrollPane);

		modelo = new DefaultTableModel(null, titulos);
		tblDatos = new JTable();
		tblDatos.setModel(modelo);
		scrollPane.setViewportView(tblDatos);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(548, 330, 89, 23);
		contentPane.add(btnCalcular);

		lblNewLabel_5 = new JLabel("Cliente :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(21, 64, 62, 14);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Direcci\u00F2n :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(21, 100, 83, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Ruc:");
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

		lblNewLabel_9 = new JLabel("N\u00B0 FACTURA  :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(400, 30, 102, 14);
		contentPane.add(lblNewLabel_9);

		txtFactura = new JTextField();
		txtFactura.setBounds(525, 29, 86, 20);
		contentPane.add(txtFactura);
		txtFactura.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(548, 240, 89, 23);
		contentPane.add(btnNuevo);

		txtFactura.setText("BOLT-001");
		txtFactura.setEditable(false);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(548, 284, 89, 23);
		contentPane.add(btnAgregar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
		if (e.getSource() == btnCalcular) {
			do_btnCalcular_actionPerformed(e);
		}
	}

	
	private void incrementoNFactura() {
		int indice = 0;

		indice = Integer.valueOf(txtFactura.getText().substring(7)) + 1;

		txtFactura.setText("BOLT-00" + indice);

	}
	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		incrementoNFactura();
	
		txtCodigo.setText("");
		txtProducto.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtCliente.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtRuc.setText("");
		txtCliente.requestFocus();
	}

	protected void do_btnCalcular_actionPerformed(ActionEvent e) {
	
		
		String[] sub_total = new String[5];

		igv = subtotal * 0.18;
		total = subtotal + igv;
		sub_total[0] = "";
		sub_total[1] = "";
		sub_total[2] = "";
		sub_total[3] = "SUBTOTAL :";
		sub_total[4] = "S/. " + subtotal;
		modelo.addRow(sub_total);
		sub_total[0] = "";
		sub_total[1] = "";
		sub_total[2] = "";
		sub_total[3] = "IGV :";
		sub_total[4] = "S/. " + igv;
		modelo.addRow(sub_total);
		sub_total[0] = "";
		sub_total[1] = "";
		sub_total[2] = "";
		sub_total[3] = "TOTAL  :";
		sub_total[4] = "S/. " + total;
		modelo.addRow(sub_total);
		
	}
	
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		
		if (!txtRuc.getText().trim().matches("[0-9]{11}")) {
			JOptionPane.showMessageDialog(null, "Se debe ingresar un Ruc solo acepta 11 digitos ");
			return ;
		}else if(!txtCodigo.getText().trim().matches("[0-9]{4,}")) {
			JOptionPane.showMessageDialog(null, "Codigo solo acepta digitos (4 a mas) ");
			return ;
		}else if(!txtPrecio.getText().trim().matches("[0-9]+([\\.][0-9]{2})?")) {
			JOptionPane.showMessageDialog(null, "Precio  solo acepta digitos (4 a mas) ");
			return ;
		}else if(!txtProducto.getText().trim().matches("[a-zA-Z]{4,}")) {
			JOptionPane.showMessageDialog(null, "Producto requiere letras (4 a mas) ");
			return ;
		}else
		if(!txtCantidad.getText().trim().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(null, "Cantidad solo acepta digitos (4 a mas) ");
			return ;
		}else {
			String[] fila = new String[5];
			double importe = 0.0;
			fila[0] = txtCodigo.getText();
			fila[1] = txtProducto.getText();
			fila[2] = txtPrecio.getText();
			fila[3] = txtCantidad.getText();
			importe = Double.valueOf(txtCantidad.getText()) * Double.valueOf(txtPrecio.getText());
			fila[4] = importe + "";
			subtotal += importe;
			modelo.addRow(fila);
			txtCodigo.setText("");
			txtProducto.setText("");
			txtPrecio.setText("");
			txtCantidad.setText("");
			
			txtCodigo.requestFocus();
		}
		
		
		
	}
	
	

}
