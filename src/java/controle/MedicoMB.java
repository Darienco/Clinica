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
    private List<Medico> lista = new ArrayList<>();
 
    MedicoDao dao;
 
    public MedicoMB() {
        med = new Medico();
        dao = new MedicoDao();
    }
 
    public void alterar() {
	dao.alterar(med);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de médico: ",
		"Médico alterado com sucesso!"));
    }
 
    public void consultar() {
	long codMedico = med.getCodigo();
	med = dao.buscarPorCodigo((int) codMedico);
	if (med == null || med.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		"Manutenção de médico: ",
		"Médico não encontrado, código: " + codMedico + "!"));
	}
	listar();
    }
 
    public void excluir() {
	dao.excluir(med);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de médico: ",
		"Médico excluído com sucesso!"));
    }
 
    public Medico getMedico() {
        return med;
    }
 
    public List<Medico> getLista() {
	return lista;
    }
 
    public void incluir() {
	dao.inserir(med);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de médico: ",
		"Médico incluído com sucesso!"));
    }
 
    public void limpar() {
	med = new Medico();
    }
 
    public void listar() {
        lista = dao.listarTodos();
    }
 
    public void setMedico(Medico med) {
        this.med = med;
    }
 
    public void setLista(List<Medico> lista) {
        this.lista = lista;
    }
}