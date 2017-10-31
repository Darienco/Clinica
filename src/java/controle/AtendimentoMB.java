package controle;
// Made by Juan Carlos Cardoso de Oliveira
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
    private Atendimento atndmnto;
    private Atendimento aux;
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
    public void preparaAlterar(Atendimento atndmto){
        setAux(atndmto);
    } 
    public void alterar() {
	dao.alterar(atndmnto);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Alteração","Atendimento alterado com sucesso!"));
    }
    public void consultar() {
	long codAtendimento = atndmnto.getCodigo();
	atndmnto = dao.buscarPorCodigo((int) codAtendimento);
	if (atndmnto == null || atndmnto.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Consulta","Atendimento não encontrado, código: "+codAtendimento));
	} listar();
    }
    public void excluir(Atendimento atndmnto) {
	dao.excluir(atndmnto);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Alteração","Atendimento excluído com sucesso!"));
        lista.remove(atndmnto);
        listar();
    }
    public void incluir() {
        atndmnto.setAnimal(getAnimalSelecionado());
	dao.inserir(atndmnto);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Alteração","Atendimento cadastrado com sucesso!"));
        lista.add(atndmnto);
        limpar();
        listar();
    }
    public void limpar() {
	atndmnto = new Atendimento();
    }
    public void listar() {
        lista = dao.listarTodos();
    }
    public Atendimento getAtendimento() {
        return atndmnto;
    }
    public List<Atendimento> getLista() {
	return lista;
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
    public Atendimento getAux() {
        return aux;
    }
    public void setAux(Atendimento aux) {
        this.aux = aux;
    }   
}