import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CriadorDecks {

    private ArrayList<Carta> cartas;
    private ArrayList<Deck> decks;
    private ArrayList<Deck> decksUsuario;

    public CriadorDecks() {
        this.cartas = new ArrayList<Carta>();
        this.decks = new ArrayList<Deck>();
        this.decksUsuario = new ArrayList<Deck>();
    }


    public void adicionarCarta(Carta carta) {
        this.cartas.add(carta);
    }


    public void adicionarDeck(Deck deck) {
        this.decks.add(deck);
    }


    public void adicionarDeckUsuario(Deck deck) {
        this.decksUsuario.add(deck);
    }


    public void InicializarCartas() {

        String filePath = "Projeto de MC/src/jsonFiles/cartas.json";

        try {
            // Ler as cartas dentro de jsonFiles/cartas.json
            FileReader fileReader = new FileReader(filePath);
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            fileReader.close();
    
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject.has("cartas")) {
                    JsonArray jsonArrayCartas = jsonObject.getAsJsonArray("cartas");

                    Carta cartaAdicionada;
                    for (JsonElement cartaElemento: jsonArrayCartas) {

                        JsonObject cartaObjeto = cartaElemento.getAsJsonObject();

                        String tipo = cartaObjeto.get("tipo").getAsString();
                        String nome = cartaObjeto.get("nome").getAsString();
                        int custo = cartaObjeto.get("custo").getAsInt();
                        String descricao = cartaObjeto.get("descricao").getAsString();

                        if (tipo.equals("Lacaio")) {

                            int poder = cartaObjeto.get("poder").getAsInt();
                            int vida = cartaObjeto.get("vida").getAsInt();

                            cartaAdicionada = new Lacaio(nome, custo, descricao, poder, vida);
                            adicionarCarta(cartaAdicionada);

                        } else if (tipo.equals("Feitico")) {

                            cartaAdicionada = new Feitico(nome, custo, descricao);
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


    public void InicializarDecks() {

        String filePath = "Projeto de MC/src/jsonFiles/decks.json";

        try {
            // Ler os decks dentro de jsonFiles/decks.json
            FileReader fileReader = new FileReader(filePath);
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

                            for (Carta carta: this.cartas) {
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


    public void InicializarDecksUsuario() {

        String filePath = "Projeto de MC/src/jsonFiles/decksUsuario.json";

        try {
            // Ler os decks dentro de jsonFiles/decks.json
            FileReader fileReader = new FileReader(filePath);
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

                            for (Carta carta: this.cartas) {
                                if (carta.getNome().equals(cartaNomeElemento.getAsString())) {
                                    deckAdicionado.adicionarCarta(carta);
                                    break;
                                }
                            }
                        }
                        adicionarDeckUsuario(deckAdicionado);
                    }
                }
            }

        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public void exportarDeck(Deck deck) {

        String filePath = "Projeto de MC/src/jsonFiles/decksUsuario.json";

        decksUsuario.add(deck);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ArrayList <DeckWrapper> decksFormatados = new ArrayList<DeckWrapper>();
        for (Deck deckUsuario: decksUsuario) {
            decksFormatados.add(new DeckWrapper(deckUsuario));
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("decks", gson.toJsonTree(decksFormatados));

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("");
            gson.toJson(jsonObject, writer);
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }


    // Getters e setters
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    public ArrayList<Deck> getDecks() {
        return decks;
    }
    public ArrayList<Deck> getDecksUsuario() {
        return decksUsuario;
    }
}
