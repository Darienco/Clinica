package controle;
  
import dao.ProprietarioDao;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Proprietario;
   
@ManagedBean(name="ProprietarioMB")
@SessionScoped
public class ProprietarioMB {
    private Proprietario prop;
    private Proprietario aux;
    private List<Proprietario> lista;
    private ProprietarioDao dao;
    public ProprietarioMB() {
        prop = new Proprietario();
        dao = new ProprietarioDao();
        lista = dao.listarTodos();
    }
    public void preparaAlterar(Proprietario prop){
        setAux(prop);
    } 
    public void alterar() {
        dao.alterar(prop);
        FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração",
		"Proprietário alterado com sucesso!"));
    }
    public void listarPorNomeParcial() {
        lista = dao.buscarPorNomeParcial(prop.getNome());
        for(Proprietario n: lista){
        System.out.println(n.getNome());}
    }
    public void excluir(Proprietario prop) {
        dao.excluir(prop);
        FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão",
		"Proprietário excluído com sucesso!"));
        lista.remove(prop);
        listar();
    }
    public void incluir() {
        dao.inserir(prop);
        FacesContext.getCurrentInstance().addMessage( null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro",
            "Proprietário incluído com sucesso!"));
        lista.add(prop);
        limpar();
        listar();
    } 
    public void limpar() {
        prop = new Proprietario();
    } 
    public void listar() {
        lista = dao.listarTodos();
    }
    public Proprietario getProprietario() {
        return prop;
    } 
    public void setProprietario(Proprietario prop) {
        this.prop = prop;
    } 
    public List<Proprietario> getLista() {
        return lista;
    }
    public void setLista(List<Proprietario> lista) {
        this.lista = lista;
    }
    public Proprietario getAux() {
        return aux;
    }
    public void setAux(Proprietario aux) {
        this.aux = aux;
    }
}