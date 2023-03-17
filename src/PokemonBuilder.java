import java.util.HashSet;

public class PokemonBuilder {

    private Pokemon pokemon = new Pokemon();

    public PokemonBuilder withName(String name) {
        pokemon.setName(name);
        return this;
    }

    public PokemonBuilder withHP(int HP) {
        pokemon.setHP(HP);
        return this;
    }

    public PokemonBuilder withAttack(int attack) {
        pokemon.setAttack(attack);
        return this;
    }

    public PokemonBuilder withSpecialAttack(int specialAttack) {
        pokemon.setSpecialAttack(specialAttack);
        return this;
    }

    public PokemonBuilder withDefense(int defense) {
        pokemon.setDefense(defense);
        return this;
    }

    public PokemonBuilder withSpecialDefense(int specialDefense) {
        pokemon.setSpecialDefense(specialDefense);
        return this;
    }

    public PokemonBuilder withAbility1(Ability ability) {
        pokemon.setAbility1(ability);
        return this;
    }

    public PokemonBuilder withAbility2(Ability ability) {
        pokemon.setAbility2(ability);
        return this;
    }

    public Pokemon build() {
        pokemon.setStunned(false);
        pokemon.setDodges(false);
        pokemon.setItems(new HashSet<>());
        return pokemon;
    }

}