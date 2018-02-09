package pl.handbook.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "typeOfMines")
public class TypeOfMine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "typeOfMine")
    private List<Mine> mine = new ArrayList<>();

    public TypeOfMine() { }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Mine> getMine() {
        return mine;
    }

    public void setMine(List<Mine> mine) {
        this.mine = mine;
    }
}
