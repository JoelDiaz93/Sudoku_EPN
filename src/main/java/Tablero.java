/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel
 */
public class Tablero {
    private int [][] sudoku = new int [9][9];
    
    public Tablero(int nivel){
        sudoku = cargarTablero(nivel);
    }
    
    public int [][] getTablero(){
        return this.sudoku;
    }
    
    public void setTablero(int nivel){
        sudoku = cargarTablero(nivel);
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
    
    public void imprimirTablero(int nivel) {

        System.out.println();
        System.out.println(" ------------------------------------- ");

        for (int f = 0; f < this.sudoku.length; f++) {

            System.out.print(" | ");

            for (int c = 0; c < sudoku.length; c++) {

                if (sudoku[f][c] != 0) {
                    System.out.print(sudoku[f][c]);
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
    
    public static boolean esValores(int fila, int columna, int[][] matriz) {

        boolean resultado = false;
        if (matriz[fila][columna] != 0) {
            resultado = true;
        }

        return resultado;
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
}
