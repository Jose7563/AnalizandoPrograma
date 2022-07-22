package Utilidad;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmSeleccionPdf extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnSelecionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSeleccionPdf frame = new frmSeleccionPdf();
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
	public frmSeleccionPdf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(191, 42, 89, 23);
		contentPane.add(btnNewButton);

		btnSelecionar = new JButton("Seleccionar");
		btnSelecionar.addActionListener(this);
		btnSelecionar.setBounds(191, 100, 89, 23);
		contentPane.add(btnSelecionar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelecionar) {
			do_btnSelecionar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			File path = new File("src/ns.pdf");
			Desktop.getDesktop().open(path);

		} catch (IOException exs) {
			exs.printStackTrace();
		} catch (IllegalArgumentException es) {
			JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			es.printStackTrace();
		}

	}

	private void elegirArchivo() {
		JFileChooser elegirArchivo = new JFileChooser();
		File archivo = null;
		FileFilter tipo = new FileNameExtensionFilter("Archivos PDF", "pdf");
		elegirArchivo.addChoosableFileFilter(tipo);

		int estado = elegirArchivo.showDialog(null, "Abrir Archivo");

		if (estado == JFileChooser.APPROVE_OPTION) {
			archivo = elegirArchivo.getSelectedFile();
			System.out.print(archivo.toString());
		} else if (estado == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "No se eligio archivo", "Error", 0);
			System.exit(0);
		}
	}

	protected void do_btnSelecionar_actionPerformed(ActionEvent e) {
		elegirArchivo();
	}
}
