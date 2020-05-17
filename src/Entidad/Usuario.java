package Entidad;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
        

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    private String nombre;
    private String password;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    public Usuario(){  
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String password) {
        this.nombre = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
