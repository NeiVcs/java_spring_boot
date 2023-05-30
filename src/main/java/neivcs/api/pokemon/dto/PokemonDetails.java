package neivcs.api.pokemon.dto;

import neivcs.api.pokemon.Moves;
import neivcs.api.pokemon.Pokemon;
import neivcs.api.pokemon.enums.Type;

public record PokemonDetails(Long id, String race, Type type1, Type type2, int level, Moves moves) {
        public PokemonDetails(Pokemon pokemon){
                this(pokemon.getId(), pokemon.getRace(), pokemon.getType1(), pokemon.getType2(), pokemon.getLevel(), pokemon.getMoves());
        }
}
