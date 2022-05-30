package nuevo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Matriz {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] matriz = { { 1, 2, 3 }, { 1, 2, 3 }, { 4, 7, 9 } };
		
		System.out.println("Matriz de "+matriz.length+" filas y "+matriz[0].length+" columnas.");
		mostrarMatriz(matriz);
		System.out.println();	
		mostrarIdentidad(4,4);
		System.out.println();
		mostrarIdentidadInversa(4, 4);
		System.out.println();
		mostrarMatriz(mostrarMatrizTriagularSuperior(9, 9));
		System.out.println();
		mostrarMatriz(mostrarMatrizTriagularInferior(9, 9));

	}

	/**
	 * Método que inserta datos en una matriz[][] de valores enteros ya definida
	 **/
	public static void crearMatriz(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("Matriz [" + i + "]" + "[" + j + "] : ");
				System.out.println(mat[i][j] = entrada.nextInt());
			}
		}
	}

	/** Imprimi los valores de la amtriz pasados como parametros **/
	public static void mostrarMatriz(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Método que crea una matriz[][] identidad .Se tiene que asignar como
	 * parametros las filas y columnas valores enteros
	 */
	public static void mostrarIdentidad(int fila, int columna) {
		int[][] mat = new int[fila][columna];
		int pos = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (j == pos)
					mat[i][j] = 1;
				else
					mat[i][j] = 0;
				System.out.print(mat[i][j] + " ");
			}
			pos++;
			System.out.println();
		}
	}

	/**
	 * Método que crea una matriz[][] con una diagonal de unos de derecha a
	 * izquierda .Se tiene que asignar como parametros las filas y columnas valores
	 * enteros
	 */
	public static void mostrarIdentidadInversa(int fila, int columna) {
		int[][] mat = new int[fila][columna];
		int pos = mat[0].length - 1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				if (j == pos)
					mat[i][j] = 1;
				else
					mat[i][j] = 0;
				System.out.print(mat[i][j] + " ");
			}
			pos--;
			System.out.println();
		}
	}

	/**
	 * Método que crea una matriz[][] triangular superior con valores unos y los
	 * valores restantes de las matriz se completa con ceros .Se tiene que asignar
	 * como parametros las filas y columnas valores enteros
	 */
	public static int[][] mostrarMatrizTriagularSuperior(int fila, int columna) {

		int[][] mat = new int[fila][columna];
		int pos = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (i > 0 && j < pos)
					mat[i][j] = 0;
				else
					mat[i][j] = 1;
			}
			pos++;
		}
		return mat;
	}

	/**
	 * Método que crea una matriz[][] triangular superior con el valor cero y los
	 * valores restantes de las matriz se completa con uno .Se tiene que asignar
	 * como parametros las filas y columnas valores enteros
	 */
	public static int[][] mostrarMatrizTriagularInferior(int fila, int columna) {

		int[][] mat = new int[fila][columna];
		int pos = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (i <= pos && j <= pos)
					mat[i][j] = 1;
				else
					mat[i][j] = 0;

			}
			pos++;
		}

		return mat;
	}
}
