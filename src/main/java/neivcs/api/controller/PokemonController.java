package neivcs.api.controller;

import jakarta.validation.Valid;
import neivcs.api.pokemon.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid PokemonData data, UriComponentsBuilder uriBuilder) {
        var pokemon = new Pokemon(data);
        repository.save(pokemon);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(pokemon.getId()).toUri();
        return ResponseEntity.created(uri).body(pokemon);
    }

    @GetMapping
    public ResponseEntity<Page<Pokemon>> get(@PageableDefault(size = 10, sort = {"race"}) Pageable pagination) {
        var page = repository.findAll(pagination);
        return ResponseEntity.ok(page);
    }
    //return repository.findAll().map(PokemonDataList::new);

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        var pokemon = repository.getReferenceById((id));
        return ResponseEntity.ok(new PokemonDetails(pokemon));
    }

    @PutMapping
    @Transactional
    public ResponseEntity put(@RequestBody @Valid PokemonUpdateData data) {
        var pokemon = repository.getReferenceById(data.id());
        pokemon.updateData(data);
        return ResponseEntity.ok(new PokemonDetails(pokemon));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable long id) {
        repository.deleteById((id));
        return ResponseEntity.noContent().build();
    }
}
