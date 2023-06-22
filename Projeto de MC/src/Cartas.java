/*
 * Classe abstrata Cartas
 * Construtor: Cartas(String nome, int custoMano)
 * possui gets e sets, além do método ativarHabilidade() que será implementado nas classes fihas
 */

public abstract class Cartas{
    
    protected String nome;
    protected int custoMana;

    public Cartas(String nome, int custoMana){
        
        //Construtor da classe

        this.custoMana = custoMana;
        this.nome = nome;
    }

    //Getters e setters
    public int getCustoMana(){
        return custoMana;
    }
    public void setCustoMana(int custo){
        this.custoMana = custo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void ativarHabilidade(){}//método abstrato
}