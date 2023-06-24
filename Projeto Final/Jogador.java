import java.util.Collections;
import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int vida;
    private int manaTotal;
    private int manaDisponivel;
    private ArrayList <Cartas> mao;
    private ArrayList <Lacaio> mesa;
    private Deck deck;
    private Poder poder;

    public Jogador(String nome, int vida, int manaTotal, int manaDisponivel, Deck deck, Poder poder) {
        this.nome = nome;
        this.vida = vida;
        this.manaTotal = manaTotal;
        this.manaDisponivel= manaDisponivel;
        ArrayList <Cartas> mao = new ArrayList<>();
        this.mao = mao;
        ArrayList <Lacaio> mesa = new ArrayList<>();
        this.mesa = mesa;
        this.deck = deck;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getManaTotal() {
        return manaTotal;
    }

    public void setManaTotal(int manaTotal) {
        this.manaTotal = manaTotal;
    }

    public int getManaDisponivel() {
        return manaDisponivel;
    }

    public void setManaDisponivel(int manaDisponivel) {
        this.manaDisponivel = manaDisponivel;
    }

    public ArrayList<Cartas> getMao() {
        return mao;
    }

    public void setMao(ArrayList<Cartas> mao) {
        this.mao = mao;
    }

    public ArrayList<Lacaio> getMesa() {
        return mesa;
    }

    public void setMesa(ArrayList<Lacaio> mesa) {
        this.mesa = mesa;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Poder getPoder() {
        return poder;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }

    public Cartas acharCarta(String nome) {
        for (Cartas carta: getMao()) {
            if (carta.nome.equals(nome)) {
                return carta;
            }
        }
        return null;
    }

    public boolean invocar(String nome) {
        Cartas escolhida = acharCarta(nome);
        if (escolhida instanceof Lacaio) {
            Lacaio lacaio = (Lacaio) escolhida;
            if (escolhida.custoMana > this.getManaDisponivel()) {
                return false;
            }
            else {
                this.getMao().remove(escolhida); //Talvez falhe
                this.setManaDisponivel(this.getManaDisponivel() - escolhida.custoMana);
                this.getMesa().add(lacaio);
                return true;
            }
        }
        return false;
    }

    public void castar(Feitico magia, Jogador alvo) {
        magia.ativarHabilidade(alvo);
        this.setManaDisponivel(this.getManaDisponivel() - magia.custoMana);
    }

    public void castar(Feitico magia, Jogador inimigo, Lacaio alvo) {
        magia.ativarHabilidade(inimigo, alvo);
        this.setManaDisponivel(this.getManaDisponivel() - magia.custoMana);
    }

    public boolean atacar(Lacaio lacaio, Lacaio alvo, Jogador inimigo) { 
            alvo.setVida(alvo.getVida() - lacaio.getPoder());
            System.out.println("\nO lacaio " + lacaio.getNome() + " deu " + lacaio.getPoder() + " pontos de dano no " + alvo.getNome());
            if (alvo.getVida() <= 0) {
                inimigo.getMesa().remove(alvo);
            } 
            return true;
    }

    public boolean atacar(Lacaio lacaio, Jogador inimigo) {
        inimigo.setVida(inimigo.getVida() - lacaio.getPoder());
        System.out.println("\nO lacaio " + lacaio.getNome() + " deu " + lacaio.getPoder() + " pontos de dano no " + inimigo.getNome());
        return true;
    }

    public boolean comprarCarta() {
        if (getDeck().getCartas().isEmpty()) {
            this.setVida(getVida() - 1);
            return false;
        }
        Cartas compra = getDeck().getCartas().get(0);
        this.getMao().add(compra);
        this.getDeck().getCartas().remove(compra);
        return true;
    }

    public void embaralharDeck() {
        Collections.shuffle(deck.getCartas());
    }

    public void ativarPoder(Jogador player){
        if (poder instanceof PoderDano){
            PoderDano poderDano = (PoderDano) poder;
            poderDano.ativarHabilidade(player);
        }
        if (poder instanceof PoderCura){
            PoderCura poderCura = (PoderCura) poder;
            poderCura.ativarHabilidade(player);
        }
        if (poder instanceof PoderCompra){
            PoderCompra poderCompra = (PoderCompra) poder;
            poderCompra.ativarHabilidade(player);
        }
    }   
}