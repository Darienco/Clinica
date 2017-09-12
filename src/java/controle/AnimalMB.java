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
    private AnimalDao dao;
    private ProprietarioDao propDao;
    private Proprietario proprietarioSelecionado;
    private List<Proprietario> proprietarios;
    
    public AnimalMB(){
        propDao = new ProprietarioDao();
        dao = new AnimalDao();
        lista = new ArrayList<>();
        anml = new Animal();
        proprietarios = propDao.listarTodos();
        proprietarioSelecionado = new Proprietario();
        //listar();
    }
    
    public void alterar() {
	System.out.println("Alterar animal");
	getDao().alterar(getAnml());
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de animal: ",
		"Animal alterado com sucesso!"));
    }
 
    public void consultar() {
	long codAnml = getAnml().getCodigo();
	System.out.println("Consultar");
	setAnml(getDao().buscarPorCodigo((int) codAnml));
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
        System.out.println("Excluir animal");
	getDao().excluir(getAnml());
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
	System.out.println("Incluir animal"+proprietarioSelecionado.getNome());
        getAnml().setProp(proprietarioSelecionado);
	getDao().inserir(getAnml());
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de animal: ",
		"Animal incluido com sucesso!"));
    }
 
    public void limpar() {
	System.out.println("Limpar");
	System.out.println(getAnml());
	setAnml(new Animal());
    }
 
    public void listar() {
	System.out.println("Listar animal");
        lista = getDao().listarTodos();
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

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the dao
     */
    public AnimalDao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(AnimalDao dao) {
        this.dao = dao;
    }

    /**
     * @return the propDao
     */
    public ProprietarioDao getPropDao() {
        return propDao;
    }

    /**
     * @param propDao the propDao to set
     */
    public void setPropDao(ProprietarioDao propDao) {
        this.propDao = propDao;
    }

    /**
     * @return the anml
     */
    public Animal getAnml() {
        return anml;
    }

    /**
     * @param anml the anml to set
     */
    public void setAnml(Animal anml) {
        this.anml = anml;
    }
}