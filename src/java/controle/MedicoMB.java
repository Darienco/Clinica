package controle;
// Made by Juan Carlos Cardoso de Oliveira  
import dao.MedicoDao;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Medico;
   
@ManagedBean(name="MedicoMB")
@SessionScoped
public class MedicoMB {
    private Medico med;
    private Medico aux;
    private List<Medico> lista;
    private MedicoDao dao;
    public MedicoMB() {
        med = new Medico();
        dao = new MedicoDao();
        lista = dao.listarTodos();
    } 
    public void preparaAlterar(Medico med){
        setAux(med);
    }    
    public void alterar() {
	dao.alterar(getAux());
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Alteração","Médico alterado com sucesso!"));
    }
    public void listarPorNomeParcial() {
        lista = dao.buscarPorNomeParcial(med.getNome());
    }
    public void excluir(Medico med) {
	dao.excluir(med);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Exclusão","Médico excluído com sucesso!"));
        lista.remove(med);
        listar();
    }
    public void incluir() {
	dao.inserir(med);
	FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro","Médico cadastrado com sucesso!"));
        lista.add(med);
        limpar();
        listar();
    }
    public void limpar() {
	med = new Medico();
    } 
    public void listar() {
        lista = dao.listarTodos();
    } 
    public Medico getMedico() {
        return med;
    }    
    public void setMedico(Medico med) {
        this.med = med;
    }    
    public List<Medico> getLista() {
	return lista;
    } 
    public void setLista(List<Medico> lista) {
        this.lista = lista;
    }
    public Medico getAux() {
        return aux;
    }
    public void setAux(Medico aux) {
        this.aux = aux;
    }
}