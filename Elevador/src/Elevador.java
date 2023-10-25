import java.util.concurrent.Semaphore;

public class Elevador {
	private int andarAtual;
    private int capacidade;
    private int numPassageiros;
    private Semaphore semaforoPassageiros;
    private Semaphore semaforoMovimento;
    private int numAndares;

    public Elevador(int capacidade, int numAndares) {
        this.capacidade = capacidade;
        this.numAndares = numAndares;
        this.andarAtual = 0;
        this.numPassageiros = 0;
        this.semaforoPassageiros = new Semaphore(capacidade);
        this.semaforoMovimento = new Semaphore(1);
    }

    public void abrirPorta() {
        System.out.println("Elevador abriu a porta no andar " + andarAtual);
    }

    public void fecharPorta() {
        System.out.println("Elevador fechou a porta no andar " + andarAtual);
    }

    public void visitarAndar(int andar) {
        if (andar >= 0 && andar < numAndares) {
            try {
                semaforoMovimento.acquire();
                if (andar > andarAtual) {
                    while (andarAtual < andar) {
                        andarAtual++;
                        abrirPorta();
                        fecharPorta();
                    }
                } else if (andar < andarAtual) {
                    while (andarAtual > andar) {
                        andarAtual--;
                        abrirPorta();
                        fecharPorta();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaforoMovimento.release();
            }
        }
    }

    public void entradaPassageiro() {
        try {
            semaforoPassageiros.acquire();
            if (numPassageiros < capacidade) {
                numPassageiros++;
                System.out.println("Passageiro entrou no elevador no andar " + andarAtual);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforoPassageiros.release();
        }
    }

    public void saidaPassageiro() {
        if (numPassageiros > 0) {
            numPassageiros--;
            System.out.println("Passageiro saiu do elevador no andar " + andarAtual);
        }
    }

    public void moverPassageiro(int andarDestino) {
        if (andarDestino != andarAtual) {
            visitarAndar(andarDestino);
        }
    }
}
