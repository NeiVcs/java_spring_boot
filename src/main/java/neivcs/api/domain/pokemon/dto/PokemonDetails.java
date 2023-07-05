package neivcs.api.domain.pokemon.dto;

import neivcs.api.domain.pokemon.Moves;
import neivcs.api.domain.pokemon.Pokemon;
import neivcs.api.domain.pokemon.enums.Type;

public record PokemonDetails(Long id, String race, Type type1, Type type2, int level, Moves moves) {
        public PokemonDetails(Pokemon pokemon){
                this(pokemon.getId(), pokemon.getRace(), pokemon.getType1(), pokemon.getType2(), pokemon.getLevel(), pokemon.getMoves());
        }
}
