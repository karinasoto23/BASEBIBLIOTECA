package cl.biblioteca.bivliotecaduoc.controller;

import cl.biblioteca.bivliotecaduoc.model.Libro;
import cl.biblioteca.bivliotecaduoc.service.LibroService;
import cl.biblioteca.bivliotecaduoc.dto.PokemonResponse;
import cl.biblioteca.bivliotecaduoc.dto.UpdateCreateLibroRequest;
import cl.biblioteca.bivliotecaduoc.mapper.LibroMapper;
import cl.biblioteca.bivliotecaduoc.exception.*;

//import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1/librosk")

public class LibroController {

    private final LibroService libroService;
    private final WebClient pokeApiWebClient;

     // Constructor injection (mejor práctica 2026)
        public LibroController(LibroService libroService,WebClient pokeApiWebClient) {
                this.libroService = libroService;
                this.pokeApiWebClient = pokeApiWebClient;
        }
    
    
    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public ResponseEntity<?> agregarLibro(@Valid @RequestBody UpdateCreateLibroRequest request, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(libroService.saveLibro(LibroMapper.toModel(request)));
    }

    @GetMapping("{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id){
        Libro libro = libroService.getLibroId(id);
        
        if (libro == null) {
            throw new ResourceNotFoundException("Libro no encontrado para id: " + id);
        }
        
        return ResponseEntity.ok(libro);
    }

    @PutMapping ("{id}")
    public Libro actualizaLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable int id){
    Libro libro = libroService.getLibroId(id);

    if (libro == null) {
    throw new ResourceNotFoundException("Libro no encontrado para id: " + id);
    }

    libroService.deleteLibro(id);
    return ResponseEntity.ok("Libro eliminado correctamente, id: " + id);
    }
    
    @GetMapping("/total")
        public ResponseEntity<Integer> totalLibros() {
                int total = libroService.totalLibrosV2();
                return ResponseEntity.ok(total);
        }



    @GetMapping("/autor/{autor}")
    public List<Libro> buscarPorAutor(@PathVariable("autor") String autor) {
        return libroService.buscarPorAutor(autor);
         }

    @GetMapping("/pokeapi")
    public ResponseEntity<PokemonResponse> consultarPokemon(
                    @RequestParam(name = "nombre") String nombre) {


            PokemonResponse pokemon = pokeApiWebClient.get()
                            .uri("/pokemon-species/{nombre}", nombre) // Endpoint más simple
                            .retrieve().bodyToMono(PokemonResponse.class).block();


            return ResponseEntity.ok(pokemon);
    }

}
