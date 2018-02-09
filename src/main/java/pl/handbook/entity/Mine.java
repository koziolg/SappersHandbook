package pl.handbook.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mines")
public class Mine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 200, message = "Musi byc nazwa")
    private String name;
    @ManyToOne
    private TypeOfMine typeOfMine;
    private String description;
    private String photo;
    private Boolean approved = false;
    private Double mass;
    private Double height;
    private Double diametrOfMine;
    private String body;
    private String explosiveMaterial;
    private byte[] data;


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExplosiveMaterial() {
        return explosiveMaterial;
    }

    public void setExplosiveMaterial(String explosiveMaterial) {
        this.explosiveMaterial = explosiveMaterial;
    }

    public Mine() {
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public TypeOfMine getTypeOfMine() {
        return typeOfMine;
    }

    public void setTypeOfMine(TypeOfMine typeOfMine) {
        this.typeOfMine = typeOfMine;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDiametrOfMine() {
        return diametrOfMine;
    }

    public void setDiametrOfMine(Double diametrOfMine) {
        this.diametrOfMine = diametrOfMine;
    }
}
