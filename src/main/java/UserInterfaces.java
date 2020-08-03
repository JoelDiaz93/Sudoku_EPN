
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joel
 */
public class UserInterfaces {

    private Scanner scanner;
    public int nivel = 1;

    public UserInterfaces(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        Tablero sudoku = new Tablero(nivel);
        int fila = 0, columna = 0, valor = 0;
        saludo();
        scanner.nextLine();

        while (true) {
            sudoku.imprimirTablero(nivel);

            System.out.println("Ingrese posicion (fila/columna): ");
            System.out.print("[fila]: ");
            fila = Integer.valueOf(scanner.nextLine());
            System.out.print("[columna]: ");
            columna = Integer.valueOf(scanner.nextLine());
            System.out.print("[valor]: ");
            valor = Integer.valueOf(scanner.nextLine());
            if (!Tablero.validarPosicion(fila)) {
                mensajeError("El valor de la fila no es correcto..");
            } else if (!sudoku.validarPosicion(columna)) {
                mensajeError("El valor de la columna no es correcto.");
            } else if (!sudoku.validarValor(valor)) {
                mensajeError("El valor introducido no es valido..");
            } else if (sudoku.esValores((fila - 1), (columna - 1), sudoku.cargarTablero(nivel))) {
                mensajeError("Ese valor es predeterminado del juego...");
            } else if (sudoku.siExisteFila(valor, fila, sudoku.getTablero())) {
                mensajeError("[X] El valor " + valor + " ya ha sido usado en la fila..");

            } else if (sudoku.siExisteColumna(valor, columna, sudoku.getTablero())) {
                mensajeError("[X] El valor " + valor + " ya ha sido usado en la columna..");
            } else if (sudoku.existeCaja3x3(valor, fila, columna, sudoku.getTablero())) {
                mensajeError("[X] El valor ya existe en la caja..");
            } else {
                sudoku.getTablero()[(fila - 1)][(columna - 1)] = valor;
                mensajeError("[" + fila + "," + columna + "]=" + valor + " Correcto.");
            }

            System.out.println("Presiona ENTER para continuar..");
            scanner.nextLine();

            if (juegoTerminado(sudoku.getTablero())) {
                mensajeError("   FELICIDADES!!");
                System.out.println("   !! EL JUEGO ACABO !!");
                sudoku.imprimirTablero(nivel);
                System.out.println("Presiona ENTER para continuar con el siguiente nivel..");
                scanner.nextLine();
                nivel++;
                sudoku.setTablero(nivel);
                mensajeError("SUDOKU NIVEL " + nivel);
            }
        }

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
    
    public static void saludo() {
        System.out.println();
        System.out.println("       ¡¡ B I E N V E D I N D O !!");
        System.out.println("           ¡¡ A   S U D O K U !!");
        System.out.println();
        System.out.println(" Presione ENTER para JUGAR..");
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
}
