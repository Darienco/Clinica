package util;

import dao.AnimalDao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import modelo.Animal;

@FacesConverter(value = "animalConverter", forClass = Animal.class)
public class AnimalConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Animal temp = null;
        AnimalDao anmlDao = new AnimalDao();
        try {
            nome = value;
            temp = anmlDao.buscarPorNome(nome);
	} catch (Exception e) {
            System.out.println("Erro AnimalConverter: "+e.toString());
	} 
 	return temp;
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null){
            return "";
        } 
        if (obj instanceof Animal) {
            Animal anml = (Animal)obj;
            return anml.getNome();
        } else {
            throw new ConverterException(new FacesMessage(obj + " is not a valid Animal"));
        }
    }
}
