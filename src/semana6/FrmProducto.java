package semana6;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmProducto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JButton btnBuscar;

	private JButton btnPrimero;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	
	Connection con ;
	PreparedStatement ps; 
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("    Consulta de Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(92, 11, 189, 32);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo: ");
		lblNewLabel_1.setBounds(27, 75, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Producto :");
		lblNewLabel_2.setBounds(27, 106, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Precio :");
		lblNewLabel_3.setBounds(27, 140, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Stock :");
		lblNewLabel_4.setBounds(27, 165, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(117, 72, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(117, 103, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(117, 134, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(117, 162, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(314, 71, 89, 23);
		contentPane.add(btnBuscar);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(this);
		btnPrimero.setBounds(23, 208, 89, 23);
		contentPane.add(btnPrimero);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(129, 208, 89, 23);
		contentPane.add(btnAtras);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(this);
		btnSiguiente.setBounds(235, 208, 89, 23);
		contentPane.add(btnSiguiente);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.addActionListener(this);
		btnUltimo.setBounds(335, 208, 89, 23);
		contentPane.add(btnUltimo);
		
		muestra();
	}

	public void muestra() {
		
		
		String database="bdprueba";
		String url = "jdbc:mysql://localhost:3306/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "root";
		
		String consulta = "select * from tbproductos";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url,user,password);
				
				ps= con.prepareStatement(consulta,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
				rs=ps.executeQuery();
				if(rs.next()) {
					mostrarRegistro();
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public void mostrarRegistro() {
		try {
			
			txtCodigo.setText(rs.getInt("codigo")+"");
			txtProducto.setText(rs.getString("producto"));
			txtPrecio.setText(rs.getDouble("precio")+"");
			txtStock.setText(rs.getInt("stock")+"");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAtras) {
			do_btnAtras_actionPerformed(e);
		}
		if (e.getSource() == btnSiguiente) {
			do_btnSiguiente_actionPerformed(e);
		}
		if (e.getSource() == btnPrimero) {
			do_btnPrimero_actionPerformed(e);
		}
		if (e.getSource() == btnUltimo) {
			do_btnUltimo_actionPerformed(e);
		}
	}
	protected void do_btnUltimo_actionPerformed(ActionEvent e) {
		try {
			rs.last();
			mostrarRegistro();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	protected void do_btnPrimero_actionPerformed(ActionEvent e) {
		try {
			rs.first();
			mostrarRegistro();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	protected void do_btnSiguiente_actionPerformed(ActionEvent e) {
		try {
			rs.next();
			mostrarRegistro();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	protected void do_btnAtras_actionPerformed(ActionEvent e) {
		try {
			rs.previous();;
			mostrarRegistro();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}
