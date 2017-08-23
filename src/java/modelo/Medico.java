package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TbMedico")

<<<<<<< HEAD
public class Medico implements Serializable {
=======
public class Medico implements Serializable{
>>>>>>> master
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMedico")
    private Integer IdMedico;
    
    @Column(length = 150, name = "nome")
    private String nome;
    
    @Column(length = 50, name = "CRMV")
    private Integer CRMV;    
    
    public Medico(){
        this.CRMV = 0;
        this.IdMedico = 0;
        this.nome = "";
    }
    
    public Integer getCodigo(){
        return IdMedico;
    }

    public void setCodigo(Integer IdMedico) {
        this.IdMedico = IdMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCRMV() {
        return CRMV;
    }

    public void setCRMV(Integer CRMV) {
        this.CRMV = CRMV;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getCodigo());
        hash = 43 * hash + Objects.hashCode(this.getNome());
        hash = 43 * hash + Objects.hashCode(this.getCRMV());
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