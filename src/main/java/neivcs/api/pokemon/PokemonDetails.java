package neivcs.api.pokemon;

import neivcs.api.pokemon.Moves;

public record PokemonDetails( Long id, String race, Type type1, Type type2, int level, Moves moves) {
        public PokemonDetails(Pokemon pokemon){
                this(pokemon.getId(), pokemon.getRace(), pokemon.getType1(), pokemon.getType2(), pokemon.getLevel(), pokemon.getMoves());
        }
}
