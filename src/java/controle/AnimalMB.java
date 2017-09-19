package controle;

import dao.AnimalDao;
import dao.ProprietarioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;
import modelo.Proprietario;

@ManagedBean(name="AnimalMB")
@SessionScoped
public class AnimalMB implements Serializable {
    private static long serialVersionUID = 8103328274400432976L;
    private Animal anml;
    private List<Animal> lista;
    private AnimalDao anmlDao;
    private ProprietarioDao propDao;
    private Proprietario proprietarioSelecionado;
    private List<Proprietario> proprietarios;
    
    public AnimalMB(){
        propDao = new ProprietarioDao();
        anmlDao = new AnimalDao();
        lista = new ArrayList<>();
        anml = new Animal();
        proprietarios = propDao.listarTodos();
        proprietarioSelecionado = new Proprietario();
    }
    
    public void alterar() {
	anmlDao.alterar(getAnml());
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de animal: ",
		"Animal alterado com sucesso!"));
    }
 
    public void consultar() {
	long codAnml = getAnml().getCodigo();
	setAnml(anmlDao.buscarPorCodigo((int) codAnml));
	if (getAnml() == null || getAnml().getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		"Manutenção de animal: ",
		"Animal não encontrado, código:" + codAnml + "!"));
	}
	listar();
    }
 
    public void excluir() {
	anmlDao.excluir(getAnml());
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de animal: ",
		"Animal excluído com sucesso!"));
    }
 
    public Animal getAnimal() {
        return getAnml();
    }
 
    public List<Animal> getLista() {
	return lista;
    }
 
    public void incluir() {
        getAnml().setProp(proprietarioSelecionado);
	anmlDao.inserir(getAnml());
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de animal: ",
		"Animal incluido com sucesso!"));
    }
 
    public void limpar() {
	setAnml(new Animal());
    }
 
    public void listar() {
        lista = anmlDao.listarTodos();
    }
 
    public void setFuncionario(Animal anml) {
        this.setAnml(anml);
    }
 
    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }

    public Proprietario getProprietarioSelecionado() {
        return proprietarioSelecionado;
    }

    public void setProprietarioSelecionado(Proprietario proprietarioSelecionado) {
        this.proprietarioSelecionado = proprietarioSelecionado;
    }
    
    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Proprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }

    public Animal getAnml() {
        return anml;
    }

    public void setAnml(Animal anml) {
        this.anml = anml;
    }
}
