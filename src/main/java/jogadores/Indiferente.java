package jogadores;

public class Indiferente extends Apetite {
    private static final String NOME = "INDIFERENTE";
    public Indiferente(){
        // Não quero que retorne nada
    }
    @Override
    public String getNome(){
        return NOME;
    }


}
