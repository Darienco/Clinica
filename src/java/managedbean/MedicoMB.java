package managedbean;
  
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
 
    MedicoDao dao = new MedicoDao();
 
    public MedicoMB() {
        med = new Medico();
        listar();
    }
 
    public void alterar() {
	System.out.println("Alterar medico");
	dao.alterar(med);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de usuário: ",
		"Usuario alterado com sucesso!"));
    }
 
    public void consultar() {
	long matriculaConsulta = med.getCodigo();
	System.out.println("Consultar");
	med = dao.buscarPorCodigo((int) matriculaConsulta);
	if (med == null || med.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		"Manutenção de usuário: ",
		"Usuario não encontrado matrícula:" + matriculaConsulta + "!"));
	}
	listar();
    }
 
    public void excluir() {
        System.out.println("Excluir aluno");
	dao.excluir(med);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de usuário: ",
		"Usuario excluído com sucesso!"));
    }
 
    public Medico getMedico() {
        return med;
    }
 
    public List<Medico> getLista() {
	return lista;
    }
 
    public void incluir() {
	System.out.println("Incluir medico");
	dao.inserir(med);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de usuário: ",
		"Usuario incluido com sucesso!"));
    }
 
    public void limpar() {
	System.out.println("Limpar");
	System.out.println(med);
	med = new Medico();
    }
 
    public void listar() {
	System.out.println("Listar aluno");
        lista = dao.listarTodos();
    }
 
    public void setMedico(Medico med) {
        this.med = med;
    }
 
    public void setLista(List<Medico> lista) {
        this.lista = lista;
    }
}