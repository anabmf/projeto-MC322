import java.util.Collections;
import java.util.List;

public class Jogador {
    private String nome;
    private int vida;
    private int manaTotal;
    private int manaDisponivel;
    private List <Cartas> mao;
    private List <Cartas> mesa;
    private Deck deck;

    public Jogador(String nome, int vida, int manaTotal, int manaDisponivel, Deck deck) {
        this.nome = nome;
        this.vida = vida;
        this.manaTotal = manaTotal;
        this.manaDisponivel= manaDisponivel;
        List <Cartas> mao = new ArrayList<>();
        this.mao = mao;
        List <Cartas> mesa = new ArrayList<>();
        this.mesa = mesa;
        this.deck = deck;
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

    public List<Cartas> getMao() {
        return mao;
    }

    public void setMao(List<Cartas> mao) {
        this.mao = mao;
    }

    public List<Cartas> getMesa() {
        return mesa;
    }

    public void setMesa(List<Cartas> mesa) {
        this.mesa = mesa;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public boolean invocar(String nome) {
        Cartas escolhida;
        for (Cartas carta: getMao()) {
            if (carta.nome.equals(nome)) {
                escolhida = carta;
                if (escolhida.custoMana > this.getManaDisponivel()) {
                    return false;
                }
                else {
                    this.getMao().remove(carta);
                    this.setManaDisponivel(this.getManaDisponivel() - escolhida.custoMana);
                    this.getMesa().add(escolhida);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean atacar(Lacaio lacaio, Lacaio alvo, Jogador inimigo) { //lacaio tem q estar na mesa
        if (inimigo.mesa.isEmpty()) {
            inimigo.setVida(inimigo.getVida() - lacaio.getPoder()); //Verficar se o jogador morreu na main
            return true;
        }
        else {
            alvo.setVida(alvo.getVida() - lacaio.getPoder());
            if (alvo.getVida() <= 0) {
                inimigo.getDeck().getCartas().remove(alvo);
            } 
            return true;
        }
    }

    public boolean comprarCarta() {
        if (getDeck().getCartas().isEmpty()) {
            this.setVida(getVida() - 1);
            return false;
        }
        this.getMao().add(getDeck().getCartas().get(0));
        return true;
    }

    public void embaralharDeck() {
        Collections.shuffle(deck.getCartas());
    }
}