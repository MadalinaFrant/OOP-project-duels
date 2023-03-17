import java.io.IOException;

public class Ability {

    private int damage;
    private boolean stun;
    private boolean dodge;
    private int cooldown;
    private int nr; // nr poate fi 1 sau 2 (reprezinta numarul abilitatii pentru un Pokemon)
    public Observer observer = new Observer(this);

    public Ability(int damage, boolean stun, boolean dodge, int cooldown, int nr) {
        this.damage = damage;
        this.stun = stun;
        this.dodge = dodge;
        this.cooldown = cooldown;
        this.nr = nr;
    }

    public void attachObserver(Observer observer) {
        this.observer = observer;
    }

    public void notifyObserverCooldown() throws IOException {
        observer.printCooldown();
    }

    public void notifyObserverResetCooldown() throws IOException {
        observer.printResetCooldown();
    }

    public int getDamage() {
        return damage;
    }

    public boolean hasStun() {
        return stun;
    }

    public boolean hasDodge() {
        return dodge;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) throws IOException {
        this.cooldown = cooldown;
        notifyObserverResetCooldown(); // notifica Observatorul de modificare pentru a afisa un mesaj corespunzator
    }

    public void decCooldown() throws IOException {
        if (cooldown != 0)
            cooldown--;
        notifyObserverCooldown(); // notifica Observatorul de modificare pentru a afisa un mesaj corespunzator
    }

    public int getNr() {
        return nr;
    }

    @Override
    public String toString() {
        return "Ability " + getNr() +
                ": damage " + damage +
                ", stun: " + (stun ? "yes" : "no") +
                ", dodge: " + (dodge ? "yes" : "no") +
                ", cooldown " + cooldown +
                "\n";
    }

}