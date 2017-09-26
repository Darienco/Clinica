package controle;

import dao.AnimalDao;
import dao.AtendimentoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;
import modelo.Atendimento;

@ManagedBean(name="AtendimentoMB")
@SessionScoped
public class AtendimentoMB {
    private static final long serialVersionUID = 8103328274400432976L;
    private Atendimento atndmnto;
    private List<Atendimento> lista;
    private AtendimentoDao dao;
    private AnimalDao anmlDao;
    private Animal animalSelecionado;
    private List<Animal> animais;
    public AtendimentoMB() {
        atndmnto = new Atendimento();
        dao = new AtendimentoDao();
        anmlDao = new AnimalDao();
        lista = new ArrayList<>();
        animais = anmlDao.listarTodos();
        animalSelecionado = new Animal();
    } 
    public void alterar() {
	dao.alterar(atndmnto);
	listar();
	       FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de atendimento: ",
		"Atendimento alterado com sucesso!"));
    }
    public void consultar() {
	long codAtendimento = atndmnto.getCodigo();
	atndmnto = dao.buscarPorCodigo((int) codAtendimento);
	if (atndmnto == null || atndmnto.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		"Manutenção de atendimento: ",
		"Atendimento não encontrado, código: " + codAtendimento + "!"));
	} listar();
    }
    public void excluir() {
	dao.excluir(atndmnto);
	listar();
	FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de atendimento: ",
		"Atendimento excluído com sucesso!"));
    }
    public Atendimento getAtendimento() {
        return atndmnto;
    }
    public List<Atendimento> getLista() {
	return lista;
    }
    public void incluir() {
        atndmnto.setAnimal(getAnimalSelecionado());
	dao.inserir(atndmnto);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de atendimento: ",
		"Atendimento incluído com sucesso!"));
    }
    public void limpar() {
	atndmnto = new Atendimento();
    }
    public void listar() {
        lista = dao.listarTodos();
    }
    public void setAtendimento(Atendimento atndmnto) {
        this.atndmnto = atndmnto;
    }
    public void setLista(List<Atendimento> lista) {
        this.lista = lista;
    }    
    public Animal getAnimalSelecionado() {
        return animalSelecionado;
    }
    public void setAnimalSelecionado(Animal animalSelecionado) {
        this.animalSelecionado = animalSelecionado;
    }
    public List<Animal> getAnimais() {
        return animais;
    }
    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
}