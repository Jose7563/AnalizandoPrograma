package nuevo;

import java.util.Random;
import java.util.Scanner;

public class Matriz {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] matriz = { { 1, 2, 3 }, { 1, 2, 3 }, { 4, 7, 9 } };

//		System.out.println("Matriz de " + matriz.length + " filas y " + matriz[0].length + " columnas.");
//		mostrarMatriz(matriz);
//		System.out.println("Matriz Identidad");
//		crearMatrizIdentidad(4, 4);
//		System.out.println("Matriz Identidad inversa");
//		crearMatrizIdentidadInversa(4, 4);
//		System.out.println("Matriz Triangular Superior");
//		mostrarMatriz(crearMatrizTriagularSuperior(9, 9));
//		System.out.println("Matriz Triangular Inferior");
//		mostrarMatriz(crearMatrizTriagularInferior(9, 9));
//		System.out.println("Matriz aleatorio con diagonal 20 ");
//		mostrarMatriz(crearMatrizAleatorioDiagonal20(9, 9, 8));
//		System.out.println("Matriz escalera: ");
//		crearMatrizEscalera(9, 9);
//		System.out.println("Suma de Matrices : ");
//		mostrarMatriz(sumaMatrices(matriz, matriz));
//		System.out.println("Matriz escalera  : ");
//		mostrarMatriz(crearMatrizEsacaleraString(4, 4));
//		System.out.println("Matriz Abecedario :"); //String.valueOf((char) 90)
//		mostrarMatriz(crearAbecedarioMayusculas(6, 5));
//		 String str3 = "name";
//		 String st = new String("name");
//		 System.out.println( str3.equals(st)?"si":"no");
//		 int d =Character.digit('4',5);
//		 System.out.println(d);
		 
		 String reg="\\d+";
		 String digit="3i";
		 System.out.println(digit.matches(reg)?"si cumple":"no cumple+");
		 
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
	public static void crearMatrizIdentidad(int fila, int columna) {
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
	public static void crearMatrizIdentidadInversa(int fila, int columna) {
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
	public static int[][] crearMatrizTriagularSuperior(int fila, int columna) {

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
	public static int[][] crearMatrizTriagularInferior(int fila, int columna) {

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

	public static int[][] crearMatrizAleatorioDiagonal20(int fila, int columna, int numeroFinAleatorio) {

		int[][] mat = new int[fila][columna];
		int pos = 0;
		Random generador = new Random();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (j == pos)
					mat[i][j] = 20;
				else
					mat[i][j] = generador.nextInt(numeroFinAleatorio);
			}
			pos++;
		}

		return mat;
	}

	/***/
	public static void crearMatrizEscalera(int fila, int columna) {
		int[][] mat = new int[fila][columna];
		int pos = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (j == pos)
					mat[i][j] = pos + 1;
				else
					mat[i][j] = 0;
				System.out.print(mat[i][j] + " ");
			}
			pos++;
			System.out.println();
		}

	}

	public static int[][] sumaMatrices(int[][] mat, int[][] pat) {
		int[][] matrix = new int[3][3];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				matrix[i][j] = mat[i][j] + pat[i][j];
			}
		}
		return matrix;
	}

	public static void mostrarMatriz(String[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static String[][] crearMatrizEsacaleraString(int fila, int columna) {

		String[][] mat = new String[fila][columna];
		int pos = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				if (j == pos)
					mat[i][j] = (pos + 1) + "";
				else
					mat[i][j] = "A";
			}
			pos++;
		}
		return mat;

	}

	/***/
	public static String[][] crearAbecedarioMayusculas(int fila, int columna) {

		String[][] mat = new String[fila][columna];
		int pos = 65;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (pos <= 90) {
					// n 78
					mat[i][j] = String.valueOf((char) pos);
					pos++;
				} else
					mat[i][j] = "";

			}

		}
		return mat;

	}

}
