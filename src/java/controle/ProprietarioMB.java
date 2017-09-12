package controle;
  
import dao.ProprietarioDao;
import java.util.ArrayList;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Proprietario;
   
@ManagedBean(name="ProprietarioMB")
@SessionScoped
public class ProprietarioMB {
    private static final long serialVersionUID = 8103328274400432976L;
    private Proprietario prop;
    private List<Proprietario> lista = new ArrayList<>();
 
    ProprietarioDao dao = new ProprietarioDao();
 
    public ProprietarioMB() {
        prop = new Proprietario();
        listar();
    }
 
    public void alterar() {
    System.out.println("Alterar Proprietário");
    dao.alterar(prop);
    listar();
    FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
            "Manutenção de Proprietário: ",
            "Proprietário alterado com sucesso!"));
    }
 
    public void consultar() {
        long codProprietario = prop.getCodigo();
        System.out.println("Consultar");
        prop = dao.buscarPorCodigo((int) codProprietario);
        if (prop == null || prop.getCodigo()== 0) {
                FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Manutenção de Proprietário: ",
            "Proprietário não encontrado, código: " + codProprietario + "!"));
        }
        listar();
    }
 
    public void excluir() {
        System.out.println("Excluir Proprietário");
    dao.excluir(prop);
    listar();
    FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
        "Manutenção de Proprietário: ",
        "Proprietário excluído com sucesso!"));
    }
 
    public Proprietario getProprietario() {
        return prop;
    }
 
    public List<Proprietario> getLista() {
        return lista;
    }
 
    public void incluir() {
    System.out.println("Incluir Proprietário");
    dao.inserir(prop);
    listar();
    FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
        "Manutenção de Proprietário: ",
        "Proprietário incluído com sucesso!"));
    }
 
    public void limpar() {
    System.out.println("Limpar");
    System.out.println(prop);
    prop = new Proprietario();
    }
 
    public void listar() {
    System.out.println("Listar Proprietário");
        lista = dao.listarTodos();
    }
 
    public void setProprietario(Proprietario prop) {
        this.prop = prop;
    }
 
    public void setLista(List<Proprietario> lista) {
        this.lista = lista;
    }
}