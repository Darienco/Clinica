package controle;
  
import dao.FuncionarioDao;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Funcionario;
   
@ManagedBean(name="FuncionarioMB")
@SessionScoped
public class FuncionarioMB {
    private Funcionario func;
    private Funcionario aux;
    private List<Funcionario> lista;
    private FuncionarioDao dao;
    public FuncionarioMB() {
        func = new Funcionario();
        dao = new FuncionarioDao();
        lista = dao.listarTodos();
    }
    public void preparaAlterar(Funcionario func){
        setAux(func);
    } 
    public void alterar() {
	dao.alterar(func);
	FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração",
		"Funcionário alterado com sucesso!"));
    }
    public void listarPorNomeParcial() {
        lista = dao.buscarPorNomeParcial(func.getNome());
        for(Funcionario n: lista){
        System.out.println(n.getNome());}
    } 
    public void excluir(Funcionario func) {
	dao.excluir(func);
	FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração",
		"Funcionário excluído com sucesso!"));
        lista.remove(func);
        listar();
    } 
    public void incluir() {
	dao.inserir(func);
	FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração",
		"Funcionário incluido com sucesso!"));
        lista.add(func);
        limpar();
        listar();
    } 
    public Funcionario getFuncionario() {
        return func;
    } 
    public List<Funcionario> getLista() {
	return lista;
    }
    public void limpar() {
	func = new Funcionario();
    } 
    public void listar() {
	lista = dao.listarTodos();
    } 
    public void setFuncionario(Funcionario func) {
        this.func = func;
    } 
    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }
    public Funcionario getAux() {
        return aux;
    }
    public void setAux(Funcionario aux) {
        this.aux = aux;
    }   
}