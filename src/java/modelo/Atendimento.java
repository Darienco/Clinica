package modelo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "tbAtendimento")

public class Atendimento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAtendimento")
    private Integer IdAtendimento;
    
    @ManyToOne
    @JoinColumn(name = "animal", referencedColumnName = "IdAnimal")
    private Animal animal;
    
    @Column(name = "Anotacoes")
    private String Anotacoes;
    
    @Column(name = "Data")
    private Date Data;
    
    @Column(name = "Valor")
    private Double Valor;
    
    public Atendimento(){        
        this.IdAtendimento = 0;
        this.Anotacoes = "";
        this.Valor = 0.0;
        this.animal = new Animal();
    }    

    public Integer getCodigo() {
        return IdAtendimento;
    }

    public void setCodigo(Integer IdAtendimento) {
        this.IdAtendimento = IdAtendimento;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getAnotacoes() {
        return Anotacoes;
    }

    public void setAnotacoes(String Anotacoes) {
        this.Anotacoes = Anotacoes;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getCodigo());
        hash = 43 * hash + Objects.hashCode(this.getAnimal());
        hash = 43 * hash + Objects.hashCode(this.getAnotacoes());
        hash = 43 * hash + Objects.hashCode(this.getData());
        hash = 43 * hash + Objects.hashCode(this.getValor());
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