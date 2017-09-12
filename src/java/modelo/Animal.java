package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name = "ProprietarioAnimal")
    private Integer ProprietarioAnimal;
    
    Proprietario prop;
    public Animal(){
        prop = new Proprietario();
        ProprietarioAnimal = prop.getCodigo();
    }
}
