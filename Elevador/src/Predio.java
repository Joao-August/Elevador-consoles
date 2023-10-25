
public class Predio {
	private Elevador elevador;
    private int andares;

    public Predio(int andares, int capacidadeElevador) {
        this.andares = andares;
        this.elevador = new Elevador(capacidadeElevador, andares);
    }

    public Elevador getElevador() {
        return elevador;
    }
}
