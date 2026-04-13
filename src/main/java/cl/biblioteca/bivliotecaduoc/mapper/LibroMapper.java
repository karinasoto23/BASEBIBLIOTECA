package cl.biblioteca.bivliotecaduoc.mapper;

//import cl.biblioteca.bivliotecaduoc.dto.CreateLibroRequest;
import cl.biblioteca.bivliotecaduoc.model.Libro;
//import jakarta.validation.Valid;
import cl.biblioteca.bivliotecaduoc.dto.UpdateCreateLibroRequest;

/**
 * Mapper para convertir DTOs a modelo de dominio (Libro) Sigue el patrón de separación de
 * responsabilidades
 */
public class LibroMapper {

    /**
     * Convierte CreateLibroRequest a Libro (para POST) El ID se genera automáticamente, se pasa 0
     * temporalmente
     */
    public static Libro toModel(UpdateCreateLibroRequest request) {
        return new Libro(0, // ID temporal, será asignado por el service/repository
                request.isbn(), request.titulo(), request.editorial(), request.fechaPublicacion(),
                request.autor());
    }

    /**
     * Convierte UpdateLibroRequest a Libro (para PUT) El ID se obtiene del path parameter
     */
    public static Libro toModel(int id, UpdateCreateLibroRequest request) {
        return new Libro(id, // ID del path parameter
                request.isbn(), request.titulo(), request.editorial(), request.fechaPublicacion(),
                request.autor());
    }
}
