package Utilidad;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Util {

	public  Icon icono(String path) {
	String ruta="/src/imagenes/"+path;
		Icon img = new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(40,40,java.awt.Image.SCALE_SMOOTH));
		
		return img;
	}
	
	public static void mensaje(String mensaje, Icon icon) {
		JOptionPane.showMessageDialog(null, mensaje,"",JOptionPane.PLAIN_MESSAGE ,icon);
	}
	public static void limpiarCajaTexto(JTextField textField) {
		textField.setText("");
	}

	public static String obtenerTexto(JTextField textField) {
		return textField.getText().trim();
	}

	public static Date obtenerFechaDate(JDateChooser textField) {
		return textField.getDate();
	}

	public static int obtenerNumeroEntero(JTextField textField) {
		return Integer.parseInt(textField.getText().trim());
	}

	public static double obtenerNumeroDecimal(JTextField textField) {
		return Double.parseDouble(textField.getText().trim());
	}

	public static void mensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public static void limpiarCajasTexto(JPanel panel) {
		for (int i = 0; panel.getComponents().length > i; i++) {
			if (panel.getComponents()[i] instanceof JTextField) {
				((JTextField) panel.getComponents()[i]).setText("");
			}
		}

	}

	public static void limpiarCajasTexto(JPanel panel, JTextField text) {
		for (int i = 0; panel.getComponents().length > i; i++) {
			if (panel.getComponents()[i] instanceof JTextField) {
				((JTextField) panel.getComponents()[i]).setText("");
			}
			text.requestFocus();
		}

	}
	
	public static String fechaFormatoDiaMesAnio(Date txtFecha) {
		
		String fechaFormateada = "";
		String fecha = txtFecha.toString();
		fechaFormateada = fecha.substring(8,10) + "/" + fecha.substring(5, 7) + "/"
				+ fecha.substring(0,4);
		return fechaFormateada;
	}

	public static String fechaFormatoMySQl(JDateChooser txtFecha) {
		String fecha = "";
		String fechaFormateada = "";
		fecha = ((JTextField) txtFecha.getDateEditor().getUiComponent()).getText();
		fechaFormateada = fecha.substring(6, fecha.length()) + "-" + fecha.substring(3, 5) + "-"
				+ fecha.substring(0, 2);

		return fechaFormateada;
	}
	public static String fechaFormatoMySQl(Date txtFecha) {
		String fecha = "";
		String fechaFormateada = "";
		//fecha = ((JTextField) txtFecha;
		fechaFormateada = fecha.substring(6, fecha.length()) + "-" + fecha.substring(3, 5) + "-"
				+ fecha.substring(0, 2);

		return fechaFormateada;
	}

	public static String fechaHoraMinutoSegundo(LocalDateTime lo) {
		DateTimeFormatter dtformath = DateTimeFormatter.ofPattern("HH:mm:ss");
		return lo.format(dtformath).toString();

	}

	public static String fechaDiaMesAnio(LocalDate lo) {
		String fecha = "";
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fecha = lo.format(dtformat).toString();
		return fecha;
	}

	public static String fechaAnioMesDia(Date date) {
		String fecha = "";
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate local = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		fecha = local.format(dtformat).toString();
		return fecha;
	}

	public static void validarCajaTexto(KeyEvent e) {
		// condicion que nos permite ingresar datos numericos con punto decimal
		char car = e.getKeyChar();

		if (!Character.isDigit(car) && (car != (char) KeyEvent.VK_BACK_SPACE)) {
			e.consume();
			JOptionPane.showMessageDialog(null, "Solo se admiten números enteros", "Validar Números",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}

}
