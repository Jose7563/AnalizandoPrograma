package nuevo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Factura extends JFrame implements ActionListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factura frame = new Factura();
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
	public Factura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Punto de Venta");
		lblNewLabel.setBounds(145, 33, 139, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(21, 90, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Producto :");
		lblNewLabel_2.setBounds(21, 127, 74, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Precio : ");
		lblNewLabel_3.setBounds(21, 166, 74, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Cantidad :");
		lblNewLabel_4.setBounds(21, 211, 57, 14);
		contentPane.add(lblNewLabel_4);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(126, 87, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.setBounds(126, 127, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(126, 163, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(126, 208, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(290, 123, 89, 23);
		contentPane.add(btnGuardar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 255, 510, 193);
		contentPane.add(scrollPane);

		model = new DefaultTableModel(null, titulos);
		tblDatos = new JTable();
		tblDatos.setModel(model);
		scrollPane.setViewportView(tblDatos);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(290, 162, 89, 23);
		contentPane.add(btnCalcular);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalcular) {
			do_btnCalcular_actionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
	}

	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		String[] registro = new String[5];
		// String[] importe = new String[4];
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

	private void limpiar() {
		txtCodigo.setText("");
		txtProducto.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");

	}

	protected void do_btnCalcular_actionPerformed(ActionEvent e) {

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
	}
}
