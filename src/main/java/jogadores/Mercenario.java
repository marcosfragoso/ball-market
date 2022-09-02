package jogadores;

public class Mercenario extends Apetite{
    public static final double PERCENTUAL_MERCENARIO = 0.8;
    private static final String NOME = "MERCENARIO";
    public Mercenario(){
        // Não quero que retorne nada
    }
    @Override
    public String getNome(){
        return NOME;
    }
}
