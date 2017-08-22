package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TbProprietario")

public class Proprietario implements Serializable{
    
    private Integer codigo;
    private Integer CPF;
    private String Nome;
    private String Endereco;
    private String Telefone;
    
    public Proprietario(){
        this.codigo = 0;
        this.CPF = 0;
        this.Endereco = "";
        this.Nome = "";
        this.Telefone = "";
    }
    
}
