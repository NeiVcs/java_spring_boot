
package neivcs.api.domain.catcha;

import jakarta.validation.ValidationException;
import neivcs.api.domain.catcha.dto.CatchData;
import neivcs.api.domain.catcha.dto.CatchDataDetails;
import neivcs.api.domain.catcha.validations.CatchValidator;
import neivcs.api.domain.pokemon.Pokemon;
import neivcs.api.domain.pokemon.PokemonRepository;
import neivcs.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatchValidation {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private CatchRepository catchRepository;
    @Autowired
    private List<CatchValidator> validators;

    public void catching(CatchData data){
        //CatchDataDetails
        if(!userRepository.existsById(data.userId())){
            throw new ValidationException("Id do usuário não existe.");
        }
        if(data.pokemonId() != null && !pokemonRepository.existsById(data.pokemonId())){
            throw new ValidationException("Id do pokémon não existe.");
        }

        validators.forEach(v -> v.validate(data));

        var user = userRepository.getReferenceById(data.userId());
        var pokemon = 'a';
        chosePokemon(data);
        var catching = new Catch(null, user, null, data.catchDate());
        catchRepository.save(catching);

//        return new CatchData(catchInfo);
    }

    private Pokemon chosePokemon (CatchData data) {

        if(data.pokemonId()  == null){
            throw new ValidationException("Pokémon é obrigatório.");
        }
        return pokemonRepository.getReferenceById(data.pokemonId());
//        if(data.type() == null) {
//            throw new ValidationException("Tipo do pokémon é obrigatório se não especificar um.");
//        }

        //return pokemonRepository.choseRandomPokemon(data.type(), data.catchDate());
    }
}
