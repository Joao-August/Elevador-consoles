import java.util.concurrent.Semaphore;

public class Main extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int numAndares = 10;
	        int capacidadeElevador = 1;
	        Predio predio = new Predio(numAndares, capacidadeElevador);
	        Elevador elevador = predio.getElevador();

	        int numPassageiros = 5;
	        for (int i = 0; i < numPassageiros; i++) {
	            Passageiro passageiro = new Passageiro(elevador, i, (i + 1) % numAndares);
	            passageiro.run();
	        }
	}

}
