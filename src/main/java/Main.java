
//JUEGO EDITADO (PARA PRESENTAR) 
import java.util.Scanner;

public class Main {

    public static int nivel = 1;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        int fila = 0;
        int columna = 0;
        int valor = 0;
        int penitencia = 0;
        saludo();
        scanner.nextLine();

        sudoku = cargarTablero(nivel);

        while (true) {
            imprimirTablero(sudoku);

            System.out.println("Ingrese posicion (fila/columna): ");
            System.out.print("[fila]: ");
            fila = Integer.valueOf(scanner.nextLine());
            System.out.print("[columna]: ");
            columna = Integer.valueOf(scanner.nextLine());
            System.out.print("[valor]: ");
            valor = Integer.valueOf(scanner.nextLine());
            if (!validarPosicion(fila)) {
                mensajeError("El valor de la fila no es correcto..");
            } else if (!validarPosicion(columna)) {
                mensajeError("El valor de la columna no es correcto.");
            } else if (!validarValor(valor)) {
                mensajeError("El valor introducido no es valido..");
            } else if (esValores((fila - 1), (columna - 1), cargarTablero(nivel))) {
                mensajeError("Ese valor es predeterminado del juego...");
            } else if (siExisteFila(valor, fila, sudoku)) {
                mensajeError("[X] El valor " + valor + " ya ha sido usado en la fila..");

            } else if (siExisteColumna(valor, columna, sudoku)) {
                mensajeError("[X] El valor " + valor + " ya ha sido usado en la columna..");
            } else if (existeCaja3x3(valor, fila, columna, sudoku)) {
                mensajeError("[X] El valor ya existe en la caja..");
            } else {
                sudoku[(fila - 1)][(columna - 1)] = valor;
                mensajeError("[" + fila + "," + columna + "]=" + valor + " Correcto.");
            }

            System.out.println("Presiona ENTER para continuar..");
            scanner.nextLine();

            if (juegoTerminado(sudoku)) {
                mensajeError("   FELICIDADES!!");
                System.out.println("   !! EL JUEGO ACABO !!");
                imprimirTablero(sudoku);
                System.out.println("Presiona ENTER para continuar con el siguiente nivel..");
                scanner.nextLine();
                nivel++;
                sudoku = cargarTablero(nivel);
                mensajeError("SUDOKU NIVEL " + nivel);
            }

        }

    }

    public static int[][] cargarTablero(int nivel) {

        int[][] matriz = new int[9][9];

        switch (nivel) {

            case 2:

                matriz[0][0] = 7;
                matriz[0][4] = 5;
                matriz[0][6] = 4;
                matriz[1][0] = 4;
                matriz[1][3] = 1;
                matriz[1][4] = 9;
                matriz[1][6] = 6;
                matriz[1][7] = 2;
                matriz[1][8] = 7;
                matriz[2][2] = 6;
                matriz[2][8] = 9;
                matriz[3][0] = 9;
                matriz[3][2] = 3;
                matriz[3][6] = 8;
                matriz[4][3] = 4;
                matriz[4][5] = 3;
                matriz[5][2] = 8;
                matriz[5][6] = 5;
                matriz[5][8] = 2;
                matriz[6][0] = 5;
                matriz[6][6] = 2;
                matriz[7][0] = 2;
                matriz[7][1] = 9;
                matriz[7][2] = 1;
                matriz[7][4] = 4;
                matriz[7][5] = 7;
                matriz[7][8] = 8;
                matriz[8][2] = 7;
                matriz[8][4] = 1;
                matriz[8][8] = 5;

                break;

            case 1:
            default:

                matriz[0][2] = 9;
                matriz[0][5] = 8;
                matriz[0][6] = 5;
                matriz[0][7] = 4;
                matriz[1][8] = 7;
                matriz[2][1] = 5;
                matriz[2][2] = 4;
                matriz[2][4] = 9;
                matriz[2][6] = 1;
                matriz[3][5] = 6;
                matriz[3][6] = 3;
                matriz[3][7] = 2;
                matriz[4][1] = 8;
                matriz[4][2] = 2;
                matriz[4][6] = 4;
                matriz[4][7] = 1;
                matriz[5][1] = 3;
                matriz[5][2] = 5;
                matriz[5][3] = 2;
                matriz[6][2] = 7;
                matriz[6][4] = 3;
                matriz[6][6] = 2;
                matriz[6][7] = 5;
                matriz[7][0] = 9;
                matriz[8][1] = 4;
                matriz[8][2] = 3;
                matriz[8][3] = 8;
                matriz[8][7] = 9;

                break;

        }

        return matriz;
    }
    
    public static boolean esValores(int fila, int columna, int[][] matriz) {

        boolean resultado = false;
        if (matriz[fila][columna] != 0) {
            resultado = true;
        }

        return resultado;

    }

    public static boolean juegoTerminado(int[][] matriz) {

        boolean resultado = true;

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] == 0) {
                    resultado = false;
                }
            }
        }

        return resultado;

    }

    public static void mensajeError(String mensaje) {

        System.out.println();
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < (mensaje.length() + 20); i++) {
            System.out.print("=");
        }
        System.out.print("\n");

        System.out.print("|          ");
        System.out.print(mensaje);
        System.out.print("          |\n");

        System.out.print(" ");
        for (int i = 0; i < (mensaje.length() + 20); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println();
    }

    public static void imprimirTablero(int[][] matriz) {

        System.out.println();
        System.out.println(" ------------------------------------- ");

        for (int f = 0; f < matriz.length; f++) {

            System.out.print(" | ");

            for (int c = 0; c < matriz.length; c++) {

                if (matriz[f][c] != 0) {
                    System.out.print(matriz[f][c]);
                } else {
                    System.out.print(" ");
                }

                if (esValores(f, c, cargarTablero(nivel))) {
                    System.out.print(" ");
                } else {
                    System.out.print(" ");
                }

                if (c == 2 || c == 5) {
                    System.out.print("| ");
                } else {
                    System.out.print("| ");
                }

            }
            System.out.println();
            if (f != 2 && f != 5) {
                System.out.print(" ------------------------------------- ");
            } else {
                System.out.print(" ------------------------------------- ");
            }
            System.out.println();
        }
    }

    public static boolean siExisteFila(int numero, int fila, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[(fila - 1)][i] == numero) {
                resultado = true;
                break;
            }
        }

        if (numero == 0) {
            resultado = false;
        }

        return resultado;

    }

    public static boolean siExisteColumna(int numero, int columna, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][(columna - 1)] == numero) {
                resultado = true;
                break;
            }
        }
  
        if (numero == 0) {
            resultado = false;
        }

        return resultado;

    }

    public static boolean validarPosicion(int indice) {

        if (indice >= 1 && indice <= 9) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validarValor(int valor) {

        if (valor > 0 && valor < 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean existeCaja3x3(int valor, int fila, int columna, int[][] matriz) {

        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        if (fila > 0 && fila < 4) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila > 3 && fila < 7) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        if (columna > 0 && columna < 4) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna > 3 && columna < 7) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }
        
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (matriz[f][c] == valor) {
                    resultado = true;
                    break;

                }
            }
        }

        if (valor == 0) {
            resultado = false;
        }

        return resultado;

    }

    public static void saludo() {
        System.out.println();
        System.out.println("       ¡¡ B I E N V E D I N D O !!");
        System.out.println("           ¡¡ A   S U D O K U !!");
        System.out.println();
        System.out.println(" Presione ENTER para JUGAR..");
    }
}
