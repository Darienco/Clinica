package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TbAnimal")

public class Animal implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAnimal")
    private Integer IdAnimal;
    
    @Column(length = 150, name = "Nome")
    private String Nome;
    
    @Column(length = 100, name = "Especie")
    private String Especie;
    
    @Column(length = 100, name = "Raca")
    private String Raca;
   
    @ManyToOne
    @JoinColumn(name = "prop", referencedColumnName = "IdProprietario")
    private Proprietario prop;
    
    public Animal(){        
        this.IdAnimal = 0;
        this.Especie = "";
        this.Nome = "";
        this.Raca = "";
        this.prop = new Proprietario();
    }

    public Integer getCodigo() {
        return IdAnimal;
    }

    public void setCodigo(Integer IdAnimal) {
        this.IdAnimal = IdAnimal;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public Proprietario getProp() {
        return prop;
    }

    public void setProp(Proprietario prop) {
        this.prop = prop;
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getCodigo());
        hash = 43 * hash + Objects.hashCode(this.getNome());
        hash = 43 * hash + Objects.hashCode(this.getRaca());
        hash = 43 * hash + Objects.hashCode(this.getEspecie());
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        return true;
    }
}