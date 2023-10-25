
public class Passageiro {
	 private Elevador elevador;
	    private int andarOrigem;
	    private int andarDestino;

	    public Passageiro(Elevador elevador, int andarOrigem, int andarDestino) {
	        this.elevador = elevador;
	        this.andarOrigem = andarOrigem;
	        this.andarDestino = andarDestino;
	    }

	    public void run() {
	        elevador.visitarAndar(andarOrigem);
	        elevador.abrirPorta();
	        elevador.entradaPassageiro();
	        elevador.fecharPorta();
	        elevador.moverPassageiro(andarDestino);
	        elevador.abrirPorta();
	        elevador.saidaPassageiro();
	        elevador.fecharPorta();
	    }
}
