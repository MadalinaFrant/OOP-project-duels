import java.util.Set;

public class Trainer {

    private String name;
    private int age;
    private Set<Pokemon> pokemons; // Set deoarece nu poate avea 2 Pokemoni de acelasi tip

    public Trainer(String name, int age, Set<Pokemon> pokemons) {
        this.name = name;
        this.age = age;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

}