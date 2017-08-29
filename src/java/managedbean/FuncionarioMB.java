package managedbean;
  
import dao.FuncionarioDao;
import java.util.ArrayList;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Funcionario;
   
@ManagedBean(name="FuncionarioMB")
@SessionScoped
public class FuncionarioMB {
    private static final long serialVersionUID = 8103328274400432976L;
    private Funcionario func;
    private List<Funcionario> lista = new ArrayList<>();
 
    FuncionarioDao dao = new FuncionarioDao();
 
    public FuncionarioMB() {
        func = new Funcionario();
        listar();
    }
 
    public void alterar() {
	System.out.println("Alterar funcionário");
	dao.alterar(func);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de funcionário: ",
		"Funcionário alterado com sucesso!"));
    }
 
    public void consultar() {
	long codFunc = func.getCodigo();
	System.out.println("Consultar");
	func = dao.buscarPorCodigo((int) codFunc);
	if (func == null || func.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		"Manutenção de funcionário: ",
		"Funcionário não encontrado, código:" + codFunc + "!"));
	}
	listar();
    }
 
    public void excluir() {
        System.out.println("Excluir funcionário");
	dao.excluir(func);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de funcionário: ",
		"Funcionário excluído com sucesso!"));
    }
 
    public Funcionario getFuncionario() {
        return func;
    }
 
    public List<Funcionario> getLista() {
	return lista;
    }
 
    public void incluir() {
	System.out.println("Incluir funcionário");
	dao.inserir(func);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de funcionário: ",
		"Funcionário incluido com sucesso!"));
    }
 
    public void limpar() {
	System.out.println("Limpar");
	System.out.println(func);
	func = new Funcionario();
    }
 
    public void listar() {
	System.out.println("Listar funcionário");
        lista = dao.listarTodos();
    }
 
    public void setFuncionario(Funcionario func) {
        this.func = func;
    }
 
    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }
}