package neivcs.api.controller;

import jakarta.validation.Valid;
import neivcs.api.pokemon.Pokemon;
import neivcs.api.pokemon.PokemonData;
import neivcs.api.pokemon.PokemonRepository;
import neivcs.api.pokemon.PokemonUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid PokemonData data) {
        repository.save(new Pokemon(data));
    }

    @GetMapping
    public Page<Pokemon> get(@PageableDefault(size = 10, sort = {"race"}) Pageable pagination) {
        return repository.findAll(pagination);
    }
    //return repository.findAll().map(PokemonDataList::new);

    @PutMapping
    @Transactional
    public void put(@RequestBody @Valid PokemonUpdateData data) {
        var pokemon = repository.getReferenceById(data.id());
        pokemon.updateData(data);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        repository.deleteById((id));
    }
}
