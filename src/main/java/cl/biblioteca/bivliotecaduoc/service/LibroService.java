package cl.biblioteca.bivliotecaduoc.service;
import cl.biblioteca.bivliotecaduoc.model.Libro;
import cl.biblioteca.bivliotecaduoc.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepositorio libroRepositorio;

    public List<Libro> getLibros(){
        return libroRepositorio.findAll();
    }

    public Libro saveLibro(Libro libro){
        return libroRepositorio.save(libro);

    }

    public Libro getLibroId(int id){
        return ((Optional<Libro>) libroRepositorio.findById(id)).orElse(null);
    }

    public Libro updateLibro(Libro libro){
        return libroRepositorio.save(libro);
    }
    public String deleteLibro(int id){
        libroRepositorio.deleteById(id);
        return "Producto elimminado";
    }

         // LA ACCIÓN LA HACE EL SERVICE
    public int totalLibros() {
        // return libroRepository.obtenerLibros().size();
        return (int) libroRepositorio.count();
    }

    // LA ACCIÓN LA HACE EL MODELO
    public int totalLibrosV2() {
        return libroRepositorio.totalLibros();
    
    }

    public List<Libro> buscarPorAutor(String autor) {
    return libroRepositorio.findByAutor(autor);
}









}
// service almacena datos
