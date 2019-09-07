package game;

import java.util.Scanner;

public class TorreDeHanoi {

	// Método que realiza (imprime) o movimento
	// de um disco entre dois pinos
	public static void mover(int O, int D) {
		System.out.println(O + "-" + D);
	}

	// Método que implementa a recursão
	// O = pino origem
	// D = pino destino
	// T = pino de trabalho
	public void hanoi(int n, int O, int D, int T) {

		if (n > 0) {
			hanoi(n - 1, O, T, D);
			mover(O, D);
			hanoi(n - 1, T, D, O);
		}
	}
}