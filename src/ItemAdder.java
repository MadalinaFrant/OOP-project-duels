public class ItemAdder {

    /* metode pentru adaugarea obiectului corespunzator: se adauga in lista obiectelor ale unui
    Pokemon daca nu exista deja, realizand modificarile necesare asupra proprietatilor Pokemonului
    ca urmare a obtinerii unui obiect */

    public static void addScut(Pokemon pokemon) {
        if (!pokemon.getItems().add("Scut"))
            return;
        pokemon.setDefense(pokemon.getDefense() + 2);
        pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 2);
    }

    public static void addVesta(Pokemon pokemon) {
        if (!pokemon.getItems().add("Vesta"))
            return;
        pokemon.setHP(pokemon.getHP() + 10);
    }

    public static void addSabiuta(Pokemon pokemon) {
        if (!pokemon.getItems().add("Sabiuta"))
            return;
        if (pokemon.getAttack() != 0)
            pokemon.setAttack(pokemon.getAttack() + 3);
    }

    public static void addBaghetaMagica(Pokemon pokemon) {
        if (!pokemon.getItems().add("BaghetaMagica"))
            return;
        if (pokemon.getSpecialAttack() != 0)
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 3);
    }

    public static void addVitamine(Pokemon pokemon) {
        if (!pokemon.getItems().add("Vitamine"))
            return;
        pokemon.setHP(pokemon.getHP() + 2);
        if (pokemon.getAttack() != 0)
            pokemon.setAttack(pokemon.getAttack() + 2);
        if (pokemon.getSpecialAttack() != 0)
            pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 2);
    }

    public static void addBradDeCraciun(Pokemon pokemon) {
        if (!pokemon.getItems().add("BradDeCraciun"))
            return;
        if (pokemon.getAttack() != 0)
            pokemon.setAttack(pokemon.getAttack() + 3);
        pokemon.setDefense(pokemon.getDefense() + 1);
    }

    public static void addPelerina(Pokemon pokemon) {
        if (!pokemon.getItems().add("Pelerina"))
            return;
        pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 3);
    }

}