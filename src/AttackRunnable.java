import java.io.IOException;

public class AttackRunnable implements Runnable {

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private int cd1;
    private int cd2;

    public AttackRunnable(Pokemon pokemon1, Pokemon pokemon2, int cd1, int cd2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.cd1 = cd1;
        this.cd2 = cd2;
    }

    /* pokemon1 ataca pokemon2; cd1 si cd2 reprezinta cooldown-ul corespunzator
    abilitatii 1, respectiv 2 a Pokemonului pokemon1 (cel care ataca) */

    @Override
    public void run() {

        try {

            if (pokemon2.dodges()) { // nu va fi afectat de atacul celuilalt
                pokemon2.setDodges(false);
                return;
            }

            if (pokemon1.isStunned()) { // nu poate realiza un atac
                pokemon1.setStunned(false);
                return;
            }

            int attacked = 0;
            /* bucla continua pana are loc un atac; daca este generat un atac de tip abilitate si
            acesta nu este gata de a fi folosit, se va genera din nou un atac */
            while (attacked == 0) {
                int attackType = Duel.generateAttack(pokemon1);

                switch (attackType) {
                    case 1 -> {
                        /* ataca cu tipul de atac pe care il poseda: normal sau special */
                        if (pokemon1.getAttack() != 0) {
                            if (pokemon2.getDefense() <= pokemon1.getAttack())
                                pokemon2.setHP(pokemon2.getHP() - (pokemon1.getAttack() - pokemon2.getDefense()));
                            if (pokemon2.getHP() < 0)
                                pokemon2.setHP(0);
                            Logger.log(pokemon1.getName() + " used a normal attack on " + pokemon2.getName() + "\n");
                        } else {
                            if (pokemon2.getSpecialDefense() <= pokemon1.getSpecialAttack())
                                pokemon2.setHP(pokemon2.getHP() - (pokemon1.getSpecialAttack() - pokemon2.getSpecialDefense()));
                            if (pokemon2.getHP() < 0)
                                pokemon2.setHP(0);
                            Logger.log(pokemon1.getName() + " used a special attack on " + pokemon2.getName() + "\n");
                        }
                        attacked = 1;

                        /* decrementeaza cooldown-ul abilitatilor, daca acestea exista (daca Pokemonul nu este Neutrel) */
                        if (!pokemon1.getName().equals("Neutrel1") && !pokemon1.getName().equals("Neutrel2")) {
                            pokemon1.getAbility1().decCooldown();
                            pokemon1.getAbility2().decCooldown();
                        }
                    }
                    case 2 -> {
                        if (pokemon1.getAbility1().getCooldown() == 0) {
                            attacked = 1;
                            Duel.useAbility(pokemon1, pokemon2, pokemon1.getAbility1(), cd1);
                            pokemon1.getAbility2().decCooldown(); // decrementeaza cooldown-ul abilitatii 2
                        }
                    }
                    case 3 -> {
                        if (pokemon1.getAbility2().getCooldown() == 0) {
                            attacked = 1;
                            Duel.useAbility(pokemon1, pokemon2, pokemon1.getAbility2(), cd2);
                            pokemon1.getAbility1().decCooldown();  // decrementeaza cooldown-ul abilitatii 1
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
