import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class CriadorDecks {

    private ArrayList<Cartas> cartas;
    private ArrayList<Deck> decks;

    public CriadorDecks() {
        this.cartas = new ArrayList<Cartas>();
        this.decks = new ArrayList<Deck>();
    }


    public void adicionarCarta(Cartas carta) {
        this.cartas.add(carta);
    }


    public void adicionarDeck(Deck deck) {
        this.decks.add(deck);
    }


    public void InicializarCartas() {

        try {
            // Ler as cartas dentro de jsonFiles/cartas.json
            FileReader fileReader = new FileReader(
                "Projeto de MC/src/jsonFiles/cartas.json");
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            fileReader.close();
    
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject.has("cartas")) {
                    JsonArray jsonArrayCartas = jsonObject.getAsJsonArray("cartas");

                    Cartas cartaAdicionada;
                    for (JsonElement cartaElemento: jsonArrayCartas) {

                        JsonObject cartaObjeto = cartaElemento.getAsJsonObject();

                        String tipo = cartaObjeto.get("tipo").getAsString();
                        String nome = cartaObjeto.get("nome").getAsString();
                        int custo = cartaObjeto.get("custo").getAsInt();

                        if (tipo.equals("Lacaio")) {

                            int poder = cartaObjeto.get("poder").getAsInt();
                            int vida = cartaObjeto.get("vida").getAsInt();

                            cartaAdicionada = new Lacaio(nome, custo, poder, vida);
                            adicionarCarta(cartaAdicionada);

                        } else if (tipo.equals("Feitico")) {

                            String habilidade = cartaObjeto.get("habilidade").getAsString();

                            cartaAdicionada = new Feitico(nome, custo, habilidade);
                            adicionarCarta(cartaAdicionada);

                        } else {
                            System.out.println("Tipagem de carta incorreta detectada!");
                        }
                    }
                }
            }
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }


    public void adicionarDecksIniciais() {

        try {
            // Ler os decks dentro de jsonFiles/decks.json
            FileReader fileReader = new FileReader(
                "Projeto de MC/src/jsonFiles/decks.json");
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            fileReader.close();
    
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
        
                if (jsonObject.has("decks")) {
                    JsonArray jsonArrayDecks = jsonObject.getAsJsonArray("decks");

                    Deck deckAdicionado;
                    for (JsonElement deckElemento: jsonArrayDecks) {

                        JsonObject deckObjeto = deckElemento.getAsJsonObject();

                        String nome = deckObjeto.get("nome").getAsString();

                        deckAdicionado = new Deck(nome);

                        JsonArray jsonArrayNomesCartas = deckObjeto.getAsJsonArray("cartas");
                        for (JsonElement cartaNomeElemento: jsonArrayNomesCartas) {

                            for (Cartas carta: this.cartas) {
                                if (carta.getNome().equals(cartaNomeElemento.getAsString())) {
                                    deckAdicionado.adicionarCarta(carta);
                                    break;
                                }
                            }
                        }
                        adicionarDeck(deckAdicionado);
                    }
                }
            }

        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }


    // Getters e setters
    public ArrayList<Cartas> getCartas() {
        return cartas;
    }
    public ArrayList<Deck> getDecks() {
        return decks;
    }
}
