package managedbean;
  
import dao.MedicoDao;
import java.sql.SQLException;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Medico;
   
@ManagedBean(name="MedicoMB")
@SessionScoped
public class MedicoMB {
    Medico med = new Medico();   
    
    public String cadastraMedico() {
        MedicoDao medDao = new MedicoDao();         
        if (medDao.inserir(med)) {
            FacesContext.getCurrentInstance().addMessage(
            null, new FacesMessage(FacesMessage.SEVERITY_INFO,
            "Sucesso!", "Usuário cadastrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
            null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!", 
            "Erro ao cadastrar usuário!"));
        }
        return "";
    }
}