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
@Table(name = "TbProprietario")

public class Proprietario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProprietario")
    private Integer IdProprietario;
    
    @Column(length = 14, name = "CPF")
    private Integer CPF;
    
    @Column(length = 150, name = "Nome")
    private String Nome;
    
    @Column(length = 500, name = "Endereco")
    private String Endereco;
    
    @Column(length = 20, name = "Telefone")
    private String Telefone;
    
    public Proprietario(){
        this.IdProprietario = 0;
        this.CPF = 0;
        this.Endereco = "";
        this.Nome = "";
        this.Telefone = "";
    }

    public Integer getCodigo() {
        return IdProprietario;
    }

    public void setCodigo(Integer IdProprietario) {
        this.IdProprietario = IdProprietario;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getCodigo());
        hash = 43 * hash + Objects.hashCode(this.getNome());
        hash = 43 * hash + Objects.hashCode(this.getCPF());
        hash = 43 * hash + Objects.hashCode(this.getEndereco());
        hash = 43 * hash + Objects.hashCode(this.getTelefone());
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
