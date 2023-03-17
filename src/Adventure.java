import java.io.IOException;

public class Adventure {

    Pokemon pokemon1;
    Pokemon pokemon2;

    public Adventure(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public Pokemon initBattle(Pokemon pokemon1, Pokemon pokemon2, int HP1, int HP2) throws IOException, InterruptedException {
        Logger.log("\n~ " + pokemon1.getName() + " vs " + pokemon2.getName() + " ~\n\n");
        Duel duel = new Duel(pokemon1, pokemon2);
        Pokemon winner = duel.initDuel();
        /* reseteaza HP-ul Pokemonilor dupa lupta */
        pokemon1.setHP(HP1);
        pokemon2.setHP(HP2);

        if (winner == null) // egalitate
            return null;

        winner.addPoints();

        return winner;
    }

    public Pokemon initAdventure() throws IOException, InterruptedException {
        /* se genereaza aleator un tip de eveniment; bucla se opreste in momentul in care a avut loc un eveniment
        de tipul 3, sau daca unul din Pokemonii participanti moare in lupta cu un Neutrel */
        while (true) {
            int eventType = 1 + (int) (Math.random() * 3); // va genera 1, 2 sau 3, corespunzator unui anumit tip de eveniment

            /* retine HP-urile Pokemonilor pentru a putea fi resetate dupa lupta */
            int HP1 = pokemon1.getHP();
            int HP2 = pokemon2.getHP();

            switch (eventType) {
                case 1 -> { // ambii Pokemoni se lupta cu un Pokemon de tip Neutrel1
                    Pokemon pokemon1vNeutrel1 = initBattle(pokemon1, new PokemonDirector().createNeutrel1(), HP1, 0);
                    Pokemon pokemon2vNeutrel1 = initBattle(pokemon2, new PokemonDirector().createNeutrel1(), HP2, 0);

                    if (!pokemon1vNeutrel1.equals(pokemon1) && !pokemon2vNeutrel1.equals(pokemon2)) // mor amandoi in lupta cu neutrel
                        return null;
                    if (!pokemon1vNeutrel1.equals(pokemon1)) // moare pokemon1 in lupta cu neutrel => castiga pokemon2
                        return pokemon2;
                    if (!pokemon2vNeutrel1.equals(pokemon2)) // moare pokemon2 in lupta cu neutrel => castiga pokemon1
                        return pokemon1;

                    // nu moare niciun pokemon de-al unui antrenor => continua aventura
                }
                case 2 -> { // ambii Pokemoni se lupta cu un Pokemon de tip Neutrel2
                    Pokemon pokemon1vNeutrel2 = initBattle(pokemon1, new PokemonDirector().createNeutrel2(), HP1, 0);
                    Pokemon pokemon2vNeutrel2 = initBattle(pokemon2, new PokemonDirector().createNeutrel2(), HP2, 0);

                    if (!pokemon1vNeutrel2.equals(pokemon1) && !pokemon2vNeutrel2.equals(pokemon2)) // mor amandoi in lupta cu neutrel
                        return null;
                    if (!pokemon1vNeutrel2.equals(pokemon1)) // moare pokemon1 in lupta cu neutrel => castiga pokemon2
                        return pokemon2;
                    if (!pokemon2vNeutrel2.equals(pokemon2)) // moare pokemon2 in lupta cu neutrel => castiga pokemon1
                        return pokemon1;

                    // nu moare niciun pokemon de-al unui antrenor => continua aventura
                }
                case 3 -> { // cei 2 Pokemoni se lupta intre ei
                    return initBattle(pokemon1, pokemon2, HP1, HP2);
                }
            }

        }

    }

}