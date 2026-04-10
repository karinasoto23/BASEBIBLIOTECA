package cl.biblioteca.bivliotecaduoc.mapper;

import cl.biblioteca.bivliotecaduoc.dto.ClientRequest;
import cl.biblioteca.bivliotecaduoc.model.*;

public class LibroMapper {

    public static Libro toModel(ClientRequest request) {
        return new Libro(
            request.getId(),
            request.getIsbn(),
            request.getTitulo(),
            request.getEditorial(),
            request.getFechaPublicacion(),
            request.getAutor()
        );
    }
}
