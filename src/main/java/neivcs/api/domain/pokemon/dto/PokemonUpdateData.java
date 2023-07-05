package neivcs.api.domain.pokemon.dto;

import jakarta.validation.constraints.NotNull;
import neivcs.api.domain.pokemon.enums.Type;

public record PokemonUpdateData(

        @NotNull
        Long id,
        String race,
        Type type1,
        Type type2,
        int level,
        MovesData moves){
}
