package Utilidad;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entidad.Campeonato1;
import model.ModelCampeonato1;

public class frmCrudCampeonato extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtDes;
	private JTextField txtAnio;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable table;

	ModelCampeonato1 mod = new ModelCampeonato1();
	int idSeleccionado = -1;
	private JLabel lblNewLabel_2;
	private JComboBox cboFiltro;
	private JTextField txtFiltro;
	private JButton btnBuscarFechas;
	private JDateChooser txtFecha;
	private JDateChooser txtFechaInicio;
	private JDateChooser txtFechaFin;
	private JButton btnBuscar;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCrudCampeonato frame = new frmCrudCampeonato();
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
	public frmCrudCampeonato() {
		setTitle("Mantenimiento Campeonato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDes = new JTextField();
		txtDes.setBounds(156, 26, 86, 20);
		contentPane.add(txtDes);
		txtDes.setColumns(10);

		txtAnio = new JTextField();
		txtAnio.setBounds(156, 67, 86, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(299, 25, 89, 23);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(299, 66, 89, 23);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(299, 100, 89, 23);
		contentPane.add(btnEliminar);

		lblNewLabel = new JLabel("Nombre : ");
		lblNewLabel.setBounds(33, 29, 86, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("A\u00F1o : ");
		lblNewLabel_1.setBounds(33, 70, 46, 14);
		contentPane.add(lblNewLabel_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 259, 418, 162);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "NOMBRE", "A\u00F1o", "FECHA" }));
		scrollPane.setViewportView(table);

		lblNewLabel_2 = new JLabel("FILTRAR :");
		lblNewLabel_2.setBounds(33, 134, 86, 14);
		contentPane.add(lblNewLabel_2);

		cboFiltro = new JComboBox();
		cboFiltro.setModel(new DefaultComboBoxModel(new String[] { "Nombre" }));
		cboFiltro.setBounds(33, 159, 121, 22);
		contentPane.add(cboFiltro);

		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(189, 160, 199, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);

		btnBuscarFechas = new JButton("fechas");
		btnBuscarFechas.addActionListener(this);
		btnBuscarFechas.setBounds(299, 134, 89, 23);
		contentPane.add(btnBuscarFechas);

		txtFecha = new JDateChooser();
		txtFecha.setBounds(156, 103, 104, 20);
		contentPane.add(txtFecha);

		txtFechaInicio = new JDateChooser();
		txtFechaInicio.setBounds(33, 224, 121, 20);
		contentPane.add(txtFechaInicio);

		txtFechaFin = new JDateChooser();
		txtFechaFin.setBounds(233, 224, 103, 20);
		contentPane.add(txtFechaFin);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(365, 224, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(33, 104, 46, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("HASTA");
		lblNewLabel_4.setBounds(177, 230, 46, 14);
		contentPane.add(lblNewLabel_4);
		listadoCampeonato(mod.listaCampeonato());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarFechas) {
			do_btnBuscarFechas_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {

		String descripcio = txtDes.getText();
		String anio = txtAnio.getText();
		String fecha = Util.fechaFormatoMySQl(txtFecha);

		Campeonato1 c = new Campeonato1();
		c.setDescripcion(descripcio);
		c.setAnio(Integer.parseInt(anio));
		c.setFecha(Date.valueOf(fecha));
		mod.insertaCampeonato(c);
		listadoCampeonato(mod.listaCampeonato());

	}

	public void listadoCampeonato(List<Campeonato1> list) {
		List<Campeonato1> data = list;

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		for (Campeonato1 c : data) {
			Object[] fila = { c.getIdcampeonato(), c.getDescripcion(), c.getAnio(),
					Util.fechaFormatoDiaMesAnio(c.getFecha()) };
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_table_mouseClicked(MouseEvent e) {

		int fila = table.getSelectedRow();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();

		idSeleccionado = (Integer) dtm.getValueAt(fila, 0);
		String nom = (String) dtm.getValueAt(fila, 1);
		int anio = (Integer) dtm.getValueAt(fila, 2);

		String fecha = (String) dtm.getValueAt(fila, 3);

		System.out.println(idSeleccionado);
		System.out.println(nom);
		System.out.println(anio);
		// System.out.println(String.valueOf(dtm.getValueAt(fila, 3)));
		txtDes.setText(nom);
		txtAnio.setText(String.valueOf(anio));
		txtFecha.setDateFormatString(fecha);
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar el registro ") == JOptionPane.YES_NO_OPTION) {
			mod.eliminaCampeonato(idSeleccionado);
			listadoCampeonato(mod.listaCampeonato());
			limpiar();
		}

	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {

		String des = txtDes.getText();
		String anio = txtAnio.getText();
		String fecha = Util.fechaFormatoMySQl(txtFecha);
		Campeonato1 c = new Campeonato1();
		c.setDescripcion(des);
		c.setAnio(Integer.parseInt(anio));
		c.setIdcampeonato(idSeleccionado);
		c.setFecha(Date.valueOf(fecha));
		mod.actualizaCampeonato(c);
		limpiar();
		listadoCampeonato(mod.listaCampeonato());
	}

	public void limpiar() {
		txtAnio.setText("");
		txtDes.setText("");
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltro) {
			do_txtFiltro_keyReleased(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void do_txtFiltro_keyReleased(KeyEvent e) {

		String nombre = cboFiltro.getSelectedItem().toString().toLowerCase();
		String busqueda = txtFiltro.getText().trim();
		// listadoCampeonato(mod.listaFiltro(nombre, busqueda));

	}

	protected void do_btnBuscarFechas_actionPerformed(ActionEvent e) {
//
//		String fechInicio =Util.fechaFormatoMySQl(txtFechaInicio);
//		String fechFin =Util.fechaFormatoMySQl(txtFechaFin);
//			
		

	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		

//		if(txtFechaInicio.getDate() != null || txtFechaFin.getDate()!=null) {
//			String fechaInicio =  Util.fechaFormatoMySQl(txtFechaInicio);
//			String fechaFin = Util.fechaFormatoMySQl(txtFechaFin);
//			listadoCampeonato(mod.listaFiltroBetween(fechaInicio, fechaFin));
//		}else {
//			Util.mensajeExito("Revisar la fechas pueden estar vacias ");
//		}
	
		System.out.println(txtFechaInicio.getDate());
		
//		System.out.println(fechaInicio);
//		System.out.println(fechaFin);
//		System.out.println("SELECT idCampeonato,nombre ,anio, fecha FROM campeonato_one where fecha BETWEEN '"+fechaInicio+"'" +" and"+" '"+fechaFin+"' ");
		
	}
}
