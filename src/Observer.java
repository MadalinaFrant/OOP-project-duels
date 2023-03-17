import java.io.IOException;

public class Observer {

    Ability ability; // subiect al Observatorului

    public Observer(Ability ability) {
        this.ability = ability;
        this.ability.attachObserver(this);
    }

    /* metoda apelata in decCooldown - afiseaza cooldown-ul curent al unei abilitati;
    daca este 0 atunci poate fi folosita abilitatea */
    public void printCooldown() throws IOException {
        String str;
        str = "Ability " + ability.getNr() + " has cooldown " + ability.getCooldown();
        if (ability.getCooldown() == 0) {
            str += " (is ready for use)";
        }
        str += "\n";
        Logger.log(str);
    }
    /* metoda apelata in setCooldown - afiseaza un mesaj corespunzator cand este "resetat"/"pornit"
    cooldown-ul dupa folosirea unei abilitati */
    public void printResetCooldown() throws IOException {
        Logger.log("Ability " + ability.getNr() + " cooldown was reset to " + ability.getCooldown() + "\n");
    }

}