/*
 * Classe Abstrata Poder
 * Construtor: Poder(String nome)
 * Possui gets, sets e o método abstrato ativarHabilidade()
 */


 public abstract class Poder {
    
    protected String nome;

    public Poder(String nome){
        this.nome = nome;
    }

     public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void ativarHabilidade(Jogador player){}
}