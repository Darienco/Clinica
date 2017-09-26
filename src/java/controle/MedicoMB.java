package controle;
  
import dao.MedicoDao;
import java.util.ArrayList;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Medico;
   
@ManagedBean(name="MedicoMB")
@SessionScoped
public class MedicoMB {
    private static final long serialVersionUID = 8103328274400432976L;
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
	FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração",
		"Médico alterado com sucesso!"));
    }
    public void consultarPorCodigo() {
	long codMedico = med.getCodigo();
	med = dao.buscarPorCodigo((int) codMedico);
	if (med == null || med.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consulta",
		"Médico não encontrado, código: " + codMedico + "!"));
	} listar();
    }
    public void consultarPorNome() {
	String nomeMedico = med.getNome();
	med = dao.buscarPorNome(nomeMedico);
	if (med == null) {
            FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consulta",
		"Médico não encontrado, nome: " + nomeMedico + "!"));
	} listar();
    }
    public void excluir(Medico med) {
	dao.excluir(med);
	FacesContext.getCurrentInstance().addMessage( null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão",
		"Médico excluído com sucesso!"));
        lista.remove(med);
        listar();
    }
    public void incluir() {
	dao.inserir(med);
	FacesContext.getCurrentInstance().addMessage( null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro",
            "Médico incluído com sucesso!"));
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