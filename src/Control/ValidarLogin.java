
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import Frontera.Frameprincipal;

public class ValidarLogin {

    private UsuarioDAO dao = new UsuarioDAO();
    
    public ValidarLogin() {
    }
    
    public String VerificarLogin(Usuario usuario){
        if (!verificarLongitudNombre(usuario.getNombre())) {
            return("longitud nombre incorrecta");
        }
        if (!verificarLongitudPassword(usuario.getPassword())) {
            return("longitud contraseña incorrecta");
        }
        /*for (Usuario u: sistema.getUsuarios()) {
            if (u.getNombre().equals(usuario.getNombre()) && u.getPassword().equals(usuario.getPassword())) {
              return ("Bienvenido");  
            }
            
        }*/
        if(dao.leer(usuario)!=null){
            return("Bienvenido");
        }
        return ("datos incorrectos");
    }
    
    public boolean verificarLongitudNombre(String nombre){
        
        return (nombre.length()>1 && nombre.length()<=6);
    }
    
    public boolean verificarLongitudPassword(String password){
        return (password.length()>=3&& password.length()<6) ;
    }
    
}
