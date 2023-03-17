import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Duel {

    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public Duel(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    /* genereaza un tip de atac: 1 - atac, 2 - abilitate 1, 3 - abilitate 2
    daca Pokemonul care realizeaza atacul este de tip Neutrel, va genera
    direct 1, deoarece nu poseda abilitati */
    public static int generateAttack(Pokemon p) {
        if (p.getName().equals("Neutrel1") || p.getName().equals("Neutrel2"))
            return 1;

        return 1 + (int) (Math.random() * 3);
    }

    /* realizeaza duelul si intoarce Pokemonul castigator */
    public Pokemon initDuel() throws IOException, InterruptedException {

        /* retine cooldown-urile corespunzatoare abilitatilor 1 si 2 ale Pokemonilor
        si le seteaza la 0 pentru a putea fi folosite */
        int cd1pokemon1 = prepareCooldown1(pokemon1);
        int cd2pokemon1 = prepareCooldown2(pokemon1);
        int cd1pokemon2 = prepareCooldown1(pokemon2);
        int cd2pokemon2 = prepareCooldown2(pokemon2);

        ExecutorService exec = Executors.newFixedThreadPool(2);

        /* cat timp Pokemonii inca sunt in viata */
        while (pokemon1.getHP() > 0 && pokemon2.getHP() > 0) {
            /* toate atacurile fiecarui Pokemon vor fi pe thread-ul corespunzator acestuia */
            exec.execute(new AttackRunnable(pokemon1, pokemon2, cd1pokemon1, cd2pokemon1)); // 1 ataca 2
            Thread.sleep(1);
            exec.execute(new AttackRunnable(pokemon2, pokemon1, cd1pokemon2, cd2pokemon2)); // 2 ataca 1
            /* afiseaza cum s-a modificat HP-ul fiecaruia */
            Logger.log(pokemon1.getName() + " HP " + pokemon1.getHP() + "\n");
            Logger.log(pokemon2.getName() + " HP " + pokemon2.getHP() + "\n");
        }
        exec.shutdown();

        /* se reseteaza valorile cooldown-urilor la cele retinute (cele implicite) */
        resetCooldown1(pokemon1, cd1pokemon1);
        resetCooldown2(pokemon1, cd2pokemon1);
        resetCooldown1(pokemon2, cd1pokemon2);
        resetCooldown2(pokemon2, cd2pokemon2);

        if (pokemon1.getHP() <= 0 && pokemon2.getHP() <= 0) // mor amandoi => draw
            return null;
        else if (pokemon2.getHP() <= 0) // moare pokemon1 => castiga pokemon2
            return pokemon1;
        else // moare pokemon2 => castiga pokemon1
            return pokemon2;
    }

    /* realizeaza modificarile necesare unui atac de tip abilitate si afiseaza un mesaj corespunzator */
    public static void useAbility(Pokemon pokemon1, Pokemon pokemon2, Ability ability, int cd) throws IOException {
        Logger.log(pokemon1.getName() + " used ability " + ability.getNr() + " on " + pokemon2.getName() +
                " which caused " + ability.getDamage() + " damage\n");

        pokemon2.setHP(pokemon2.getHP() - ability.getDamage());
        if (pokemon2.getHP() < 0)
            pokemon2.setHP(0);
        pokemon1.setDodges(ability.hasDodge());
        if (pokemon1.dodges())
            Logger.log(pokemon1.getName() + " dodges next attack\n");
        pokemon2.setStunned(ability.hasStun());
        if (pokemon2.isStunned())
            Logger.log(pokemon2.getName() + " is stunned\n");

        ability.setCooldown(cd); // a fost folosita abilitatea => se reseteaza cooldown-ul
    }

    /* intoarce cooldown-ul abilitatii 1 a Pokemonului si o seteaza 0 */
    public int prepareCooldown1(Pokemon pokemon) throws IOException {
        if (pokemon.getName().equals("Neutrel1") || pokemon.getName().equals("Neutrel2"))
            return 0;

        int cd = pokemon.getAbility1().getCooldown();
        pokemon.getAbility1().setCooldown(0);

        return cd;
    }

    /* intoarce cooldown-ul abilitatii 2 a Pokemonului si o seteaza 0 */
    public int prepareCooldown2(Pokemon pokemon) throws IOException {
        if (pokemon.getName().equals("Neutrel1") || pokemon.getName().equals("Neutrel2"))
            return 0;

        int cd = pokemon.getAbility2().getCooldown();
        pokemon.getAbility2().setCooldown(0);

        return cd;
    }

    /* reseteaza cooldown-ul abilitatii 1 dupa folosirea acesteia */
    public void resetCooldown1(Pokemon pokemon, int cd) throws IOException {
        if (pokemon.getName().equals("Neutrel1") || pokemon.getName().equals("Neutrel2"))
            return;

        pokemon.getAbility1().setCooldown(cd);
    }

    /* reseteaza cooldown-ul abilitatii 2 dupa folosirea acesteia */
    public void resetCooldown2(Pokemon pokemon, int cd) throws IOException {
        if (pokemon.getName().equals("Neutrel1") || pokemon.getName().equals("Neutrel2"))
            return;

        pokemon.getAbility2().setCooldown(cd);
    }

}