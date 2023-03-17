public class PokemonFactory {

    private static PokemonFactory uniqueInstance;

    private PokemonFactory() {
    }

    public static PokemonFactory Instance() {
        if (uniqueInstance == null)
            uniqueInstance = new PokemonFactory();
        return uniqueInstance;
    }

    /* intoarce Pokemonul creat in functie de numele dat */
    public Pokemon createPokemon(String type) {
        switch (type) {
            case "Neutrel1" -> {
                return new PokemonDirector().createNeutrel1();
            }
            case "Neutrel2" -> {
                return new PokemonDirector().createNeutrel2();
            }
            case "Pikachu" -> {
                return new PokemonDirector().createPikachu();
            }
            case "Bulbasaur" -> {
                return new PokemonDirector().createBulbasaur();
            }
            case "Charmander" -> {
                return new PokemonDirector().createCharmander();
            }
            case "Squirtle" -> {
                return new PokemonDirector().createSquirtle();
            }
            case "Snorlax" -> {
                return new PokemonDirector().createSnorlax();
            }
            case "Vulpix" -> {
                return new PokemonDirector().createVulpix();
            }
            case "Eevee" -> {
                return new PokemonDirector().createEevee();
            }
            case "Jigglypuff" -> {
                return new PokemonDirector().createJigglypuff();
            }
            case "Meowth" -> {
                return new PokemonDirector().createMeowth();
            }
            case "Psyduck" -> {
                return new PokemonDirector().createPsyduck();
            }
        }
        throw new IllegalArgumentException("Tipul de pokemon " + type + " nu este cunoscut.");
    }

}