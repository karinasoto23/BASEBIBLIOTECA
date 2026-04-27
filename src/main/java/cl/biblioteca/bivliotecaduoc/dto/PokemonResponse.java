package cl.biblioteca.bivliotecaduoc.dto;

public class PokemonResponse {
 
 
    private Long id;
    private String name;
    private Integer base_happiness;
 
 
    private Boolean is_legendary;
 
 
    public Long getId() {
        return id;
    }
 
 
    public void setId(Long id) {
        this.id = id;
    }
 
 
    public String getName() {
        return name;
    }
 
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    public Boolean getIs_legendary() {
        return is_legendary;
    }
 
 
    public void setIs_legendary(Boolean isLegendary) {
        this.is_legendary = isLegendary;
    }

    public Integer getBase_happiness() { return base_happiness; }
    public void setBase_happiness(Integer base_happiness) { this.base_happiness = base_happiness; }

}
 
