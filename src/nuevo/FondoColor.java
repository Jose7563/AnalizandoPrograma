package nuevo;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FondoColor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	private Color azul= new Color(0, 0, 255);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FondoColor frame = new FondoColor();
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
	public FondoColor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);

		mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Rojo");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Verde");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Azul");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_2);
		
	}

//	public void actionPerformed(ActionEvent  e) {
//		Container f = this.getContentPane();
//		if (e.getSource() == mntmNewMenuItem) {
//			f.setBackground(new Color(255, 0, 0));
//		}
//	}
//		if (e.getSource() == mi2) {
//			f.setBackground(new Color(0, 255, 0));
//		}
//		if (e.getSource() == mi3) {
//			f.setBackground(new Color(0, 0, 255));
//		}
//	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_2) {
			do_mntmNewMenuItem_2_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			do_mntmNewMenuItem_1_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(e);
			
		}
	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		Container f = this.getContentPane();
		f.setBackground(new Color(255, 0, 0));
	}
	
	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {
		this.getContentPane().setBackground(new Color(0, 255, 0));
	}
	
	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {
		dandoColorContexto(azul);
	}
	
	
	public void dandoColorContexto(Color c) {
		this.getContentPane().setBackground(c);
	}
}
