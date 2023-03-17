import java.io.File;
import java.io.IOException;
import java.util.*;

public class Arena {

    private Trainer trainer1;
    private Trainer trainer2;

    public Arena() {
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public void generateAdventure(Pokemon pokemon1, Pokemon pokemon2) throws IOException, InterruptedException {
        Pokemon winner = new Adventure(pokemon1, pokemon2).initAdventure();
        if (winner == null)
            Logger.log("\nDraw\n");
        else if (winner.equals(pokemon1))
            Logger.log("\n" + trainer1.getName() + " won\n");
        else
            Logger.log("\n" + trainer2.getName() + " won\n");
    }

    public Pokemon getBestPokemon(Trainer trainer) {
        List<Pokemon> pokemons = new ArrayList<>(trainer.getPokemons());
        Collections.sort(pokemons); // sorteaza Pokemonii din lista utilizand metoda compareTo
        return pokemons.get(0); // cel mai bun (cu cea mai mare suma a proprietatilor) va fi primul
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Arena arena = new Arena();

        PokemonFactory pokemonFactory = PokemonFactory.Instance();

        /* se citeste fiecare fisier din directorul "in" */
        File dir = new File("./in");
        File[] files = dir.listFiles();
        if (files == null)
            return;

        for (File file : files) {
            Scanner s = new Scanner(file);

            for (int i = 1; i <= 2; i++) {
                String trainerName = s.nextLine();
                int age = s.nextInt();
                s.nextLine();

                /* LinkedHashSet pentru a retine ordinea din fisier */
                Set<Pokemon> pokemons = new LinkedHashSet<>();

                for (int j = 1; j <= 3; j++) {
                    String pokemonName = s.nextLine();
                    Pokemon pokemon = pokemonFactory.createPokemon(pokemonName);
                    int n = s.nextInt(); // nr. de iteme ale pokemonului
                    s.nextLine();

                    for (int k = 1; k <= n; k++) {
                        String item = s.nextLine();
                        pokemon.addItem(item);
                    }

                    pokemons.add(pokemon);
                }

                if (i == 1)
                    arena.setTrainer1(new Trainer(trainerName, age, pokemons));
                else
                    arena.setTrainer2(new Trainer(trainerName, age, pokemons));
            }

            Iterator<Pokemon> iterator1 = arena.getTrainer1().getPokemons().iterator();
            Iterator<Pokemon> iterator2 = arena.getTrainer2().getPokemons().iterator();

            Pokemon pokemon1Trainer1 = iterator1.next();
            Pokemon pokemon1Trainer2 = iterator2.next();

            Pokemon pokemon2Trainer1 = iterator1.next();
            Pokemon pokemon2Trainer2 = iterator2.next();

            Pokemon pokemon3Trainer1 = iterator1.next();
            Pokemon pokemon3Trainer2 = iterator2.next();

            Logger.init(file.getName()); // "stdout" dat ca parametru pentru afisare la consola

            /* aventura intre primul Pokemon al fiecarui antrenor */
            Logger.log(Logger.participants(pokemon1Trainer1, pokemon1Trainer2));
            arena.generateAdventure(pokemon1Trainer1, pokemon1Trainer2);

            /* aventura intre al doilea Pokemon al fiecarui antrenor */
            Logger.log(Logger.participants(pokemon2Trainer1, pokemon2Trainer2));
            arena.generateAdventure(pokemon2Trainer1, pokemon2Trainer2);

            /* aventura intre al treilea Pokemon al fiecarui antrenor */
            Logger.log(Logger.participants(pokemon3Trainer1, pokemon3Trainer2));
            arena.generateAdventure(pokemon3Trainer1, pokemon3Trainer2);

            Pokemon trainer1Best = arena.getBestPokemon(arena.getTrainer1()); // cel mai bun Pokemon al antrenorului 1
            Pokemon trainer2Best = arena.getBestPokemon(arena.getTrainer2()); // cel mai bun Pokemon al antrenorului 2

            /* aventura intre cel mai bun Pokemon al fiecarui antrenor */
            Logger.log(Logger.participants(trainer1Best, trainer2Best));
            arena.generateAdventure(trainer1Best, trainer2Best);

        }

    }

}