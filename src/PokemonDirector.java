public class PokemonDirector {

    /* metode pentru generarea unui anumit tip de Pokemon */

    public Pokemon createNeutrel1() {
        return new PokemonBuilder()
                .withName("Neutrel1")
                .withHP(10)
                .withAttack(3)
                .withSpecialAttack(0)
                .withDefense(1)
                .withSpecialDefense(1)
                .withAbility1(null)
                .withAbility2(null)
                .build();
    }

    public Pokemon createNeutrel2() {
        return new PokemonBuilder()
                .withName("Neutrel2")
                .withHP(20)
                .withAttack(4)
                .withSpecialAttack(0)
                .withDefense(1)
                .withSpecialDefense(1)
                .withAbility1(null)
                .withAbility2(null)
                .build();
    }

    public Pokemon createPikachu() {
        return new PokemonBuilder()
                .withName("Pikachu")
                .withHP(35)
                .withAttack(0)
                .withSpecialAttack(4)
                .withDefense(2)
                .withSpecialDefense(3)
                .withAbility1(new Ability(6, false, false, 4, 1))
                .withAbility2(new Ability(4, true, true, 5, 2))
                .build();
    }

    public Pokemon createBulbasaur() {
        return new PokemonBuilder()
                .withName("Bulbasaur")
                .withHP(42)
                .withAttack(0)
                .withSpecialAttack(5)
                .withDefense(3)
                .withSpecialDefense(1)
                .withAbility1(new Ability(6, false, false, 4, 1))
                .withAbility2(new Ability(5, false, false, 3, 2))
                .build();
    }

    public Pokemon createCharmander() {
        return new PokemonBuilder()
                .withName("Charmander")
                .withHP(50)
                .withAttack(4)
                .withSpecialAttack(0)
                .withDefense(3)
                .withSpecialDefense(2)
                .withAbility1(new Ability(4, true, false, 4, 1))
                .withAbility2(new Ability(7, false, false, 6, 2))
                .build();
    }

    public Pokemon createSquirtle() {
        return new PokemonBuilder()
                .withName("Squirtle")
                .withHP(60)
                .withAttack(0)
                .withSpecialAttack(3)
                .withDefense(5)
                .withSpecialDefense(5)
                .withAbility1(new Ability(4, false, false, 3, 1))
                .withAbility2(new Ability(2, true, false, 2, 2))
                .build();
    }

    public Pokemon createSnorlax() {
        return new PokemonBuilder()
                .withName("Snorlax")
                .withHP(62)
                .withAttack(3)
                .withSpecialAttack(0)
                .withDefense(6)
                .withSpecialDefense(4)
                .withAbility1(new Ability(4, true, false, 5, 1))
                .withAbility2(new Ability(0, false, true, 5, 2))
                .build();
    }

    public Pokemon createVulpix() {
        return new PokemonBuilder()
                .withName("Vulpix")
                .withHP(36)
                .withAttack(5)
                .withSpecialAttack(0)
                .withDefense(2)
                .withSpecialDefense(4)
                .withAbility1(new Ability(8, true, false, 6, 1))
                .withAbility2(new Ability(2, false, true, 7, 2))
                .build();
    }

    public Pokemon createEevee() {
        return new PokemonBuilder()
                .withName("Eevee")
                .withHP(39)
                .withAttack(0)
                .withSpecialAttack(4)
                .withDefense(3)
                .withSpecialDefense(3)
                .withAbility1(new Ability(5, false, false, 3, 1))
                .withAbility2(new Ability(3, true, false, 3, 2))
                .build();
    }

    public Pokemon createJigglypuff() {
        return new PokemonBuilder()
                .withName("Jigglypuff")
                .withHP(34)
                .withAttack(4)
                .withSpecialAttack(0)
                .withDefense(2)
                .withSpecialDefense(3)
                .withAbility1(new Ability(4, true, false, 4, 1))
                .withAbility2(new Ability(3, true, false, 4, 2))
                .build();
    }

    public Pokemon createMeowth() {
        return new PokemonBuilder()
                .withName("Meowth")
                .withHP(41)
                .withAttack(3)
                .withSpecialAttack(0)
                .withDefense(4)
                .withSpecialDefense(2)
                .withAbility1(new Ability(5, false, true, 4, 1))
                .withAbility2(new Ability(1, false, true, 3, 2))
                .build();
    }

    public Pokemon createPsyduck() {
        return new PokemonBuilder()
                .withName("Psyduck")
                .withHP(43)
                .withAttack(3)
                .withSpecialAttack(0)
                .withDefense(3)
                .withSpecialDefense(3)
                .withAbility1(new Ability(2, false, false, 4, 1))
                .withAbility2(new Ability(2, true, false, 5, 2))
                .build();
    }

}