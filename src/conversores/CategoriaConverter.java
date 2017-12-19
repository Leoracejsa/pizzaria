package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.CategoriaDAO;
import modelo.dominio.Categoria;

@FacesConverter(value="cat-converter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		// System.out.println("CategoriaConverter.getAsObject()");
		
		Integer codigo;
		try {
			codigo = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			codigo = null;
		}
		
		if (codigo != null)
		{
			CategoriaDAO dao = new CategoriaDAO();
			// lê a categoria do banco
			Categoria cat = dao.lerPorId(codigo);
			
			return cat;  // retorna a categoria lida
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value instanceof Categoria)
		{
			Categoria cat = (Categoria) value;
			// retorna o ID do objeto como String
			return cat.getId().toString();
		}
		
		return null;
	}

}
