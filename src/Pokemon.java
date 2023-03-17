import java.io.IOException;
import java.util.Objects;
import java.util.Set;

public class Pokemon implements Comparable<Pokemon> {

    private String name;
    private int HP;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private boolean isStunned;
    private boolean dodges;
    private Ability ability1;
    private Ability ability2;
    private Set<String> items; // Set deoarece nu poate avea 2 obiecte de acelasi tip

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    public boolean dodges() {
        return dodges;
    }

    public void setDodges(boolean dodges) {
        this.dodges = dodges;
    }

    public Ability getAbility1() {
        return ability1;
    }

    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }

    public Set<String> getItems() {
        return items;
    }

    public void setItems(Set<String> items) {
        this.items = items;
    }

    /* adauga obiectul Pokemonului, apeland metoda corespunzatoare din ItemAdder */
    public void addItem(String type) {
        if (getItems().size() >= 3) // poate avea maxim 3 obiecte
            return;
        switch (type) {
            case "Scut" -> ItemAdder.addScut(this);
            case "Vesta" -> ItemAdder.addVesta(this);
            case "Sabiuta" -> ItemAdder.addSabiuta(this);
            case "BaghetaMagica" -> ItemAdder.addBaghetaMagica(this);
            case "Vitamine" -> ItemAdder.addVitamine(this);
            case "BradDeCraciun" -> ItemAdder.addBradDeCraciun(this);
            case "Pelerina" -> ItemAdder.addPelerina(this);
        }
    }

    /* adauga 1 la toate proprietatile (metoda va fi apelata pentru Pokemonul castigator)
    si afiseaza un mesaj corespunzator */
    public void addPoints() throws IOException {
        HP++;
        if (attack != 0)
            attack++;
        else
            specialAttack++;
        defense++;
        specialDefense++;

        Logger.log("\n" + this.name + " won => +1\n" + this + "\n");
    }

    /* este suprascrisa metoda equals astfel incat verificarea egalitatii sa se faca doar dupa
    numele Pokemonului */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Pokemon pokemon = (Pokemon) o;
        return name.equals(pokemon.name);
    }

    /* este suprascrisa metoda hashCode astfel incat hash-ul sa fie generat doar dupa
    numele Pokemonului */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /* este suprascrisa metoda compareTo care va fi apelata in momentul sortarii unei liste
    de Pokemoni; compararea se face dupa suma proprietatilor */
    @Override
    public int compareTo(Pokemon p) {
        int sumThis = HP + attack + specialAttack + defense + specialDefense;
        int sumP = p.HP + p.attack + p.specialAttack + p.defense + p.specialDefense;
        int res = sumP - sumThis;

        if (res == 0)
            return name.compareTo(p.name);

        return res;
    }

    @Override
    public String toString() {
        return name + "\nwith properties: " +
                "HP " + HP + ", " +
                ((attack != 0) ? ("attack " + attack) : ("specialAttack " + specialAttack)) +
                ", defense " + defense +
                ", specialDefense " + specialDefense +
                "\nand abilities:\n" +
                ability1 + ability2 +
                "and items: " + items +
                "\n";
    }

}