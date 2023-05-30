package neivcs.api.pokemon.dto;

import jakarta.validation.constraints.NotNull;
import neivcs.api.pokemon.enums.Type;

public record PokemonUpdateData(

        @NotNull
        Long id,
        String race,
        Type type1,
        Type type2,
        int level,
        MovesData moves){
}
