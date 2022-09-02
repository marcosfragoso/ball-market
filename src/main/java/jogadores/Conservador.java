package jogadores;


public class Conservador extends Apetite {
    public static final double PERCENTUAL_CONSERVADOR = 0.4;
    private static final String NOME = "CONSERVADOR";

    public Conservador() {
        // Não quero que retorne nada
    }
    @Override
    public String getNome(){
        return NOME;
    }


}
