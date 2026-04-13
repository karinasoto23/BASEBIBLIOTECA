package cl.biblioteca.bivliotecaduoc.model;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//@Data // genera getters setters toString equals hashCode y un constructor vacio
//@AllArgsConstructor // genera constructor con todos los campos
//@NoArgsConstructor // genera constructor sin campos
@Entity // mapea la clase a una tabla de la base de datos
@Table(name = "librosK") // mapea la clase a la tabla libros de la base de datos

public class Libro {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mapea el campo id a la columna id de la tabla libros
    private int id;//parte en id porque es nuestra private key de la base de datos

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "fecha_publicacion")
    private int fechaPublicacion;

    @Column(name = "autor") 
    private String autor;

    // Constructor sin argumentos (requerido por JPA/Hibernate)
    public Libro() {}

    // Constructor completo
    public Libro(int id, String isbn, String titulo, String editorial, int fechaPublicacion,
            String autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }

    // Getters y Setters (manuales porque Lombok no está funcionando)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}


