package util;

import dao.ProprietarioDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Proprietario;

@FacesConverter(value = "proprietarioConverter", forClass = Proprietario.class)
public class ProprietarioConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Proprietario temp = null;
        ProprietarioDao dao = new ProprietarioDao();
        try {
            nome = value;
            temp = dao.buscarPorNome(nome);
	} catch (Exception e) {
            System.out.println("Erro ProprietarioConverter converter: "+e.toString());
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null){
            return " ";
        }
        if (obj instanceof Proprietario){
            Proprietario prop = (Proprietario)obj;
            return prop.getNome();
        }
        return "";
    }
}
