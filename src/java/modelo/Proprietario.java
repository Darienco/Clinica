package modelo;
// Made by Juan Carlos Cardoso de Oliveira
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbProprietario")
public class Proprietario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProprietario")
    private Integer IdProprietario;    
    @Column(length = 14, name = "CPF")
    private String CPF;    
    @Column(length = 150, name = "Nome")
    private String Nome;    
    @Column(length = 500, name = "Endereco")
    private String Endereco;    
    @Column(length = 20, name = "Telefone")
    private String Telefone;    
    @OneToMany(mappedBy = "prop", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animais;    
    public Proprietario(){
        this.IdProprietario = 0;
        this.CPF = "";
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
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
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
    public List<Animal> getAnimais() {
        return animais;
    }
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
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