/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Frontera.Frameprincipal.sistema;
import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zamir
 */
public class TestLogin {
    
    public TestLogin() {
        
    }
    
    @BeforeClass
     public static void initData(){
        UsuarioDAO dao=new UsuarioDAO();
        ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        for (Usuario u:usuarios) {
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("----------------");
            dao.crear(u);
        }
    }
    public static void setUpClass() {
     
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    private static ValidarLogin validarLogin= new ValidarLogin();
    private String LONG_NOMBRE_INCORRECTA = "longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA =   "longitud contraseña incorrecta";
    private String DATOS_INCORRECTOS ="datos incorrectos";
    private String USUAARIO_AUTORIZADO="Bienvenido";
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testLongitudNombre() {
            Usuario u = new Usuario();
            u.setNombre("R");
            u.setPassword("123456");
            assertEquals(validarLogin.VerificarLogin(u), LONG_NOMBRE_INCORRECTA);
     }
     @Test
     public void testLongitudcontrasenia(){
         Usuario u= new Usuario();
         u.setNombre("Pepe");
         u.setPassword("12");
         assertEquals(validarLogin.VerificarLogin(u), LONG_PASSWORD_INCORRECTA);
         
         u.setNombre("Pepe");
         u.setPassword("123456");
         assertEquals(validarLogin.VerificarLogin(u), LONG_PASSWORD_INCORRECTA);
         
         
        
     }
     @Test
     public void testNombre(){
         Usuario u = new Usuario();
         u.setNombre("Henry");
         u.setPassword("12345");
         assertEquals(validarLogin.VerificarLogin(u), DATOS_INCORRECTOS);
     }
     @Test
     public void testContrasenia(){
         Usuario u = new Usuario();
         u.setNombre("maria");
         u.setPassword("1234");
         assertEquals(validarLogin.VerificarLogin(u), DATOS_INCORRECTOS);
     }
     @Test
     public void testDatos(){
         Usuario u = new Usuario();
         u.setNombre("Henry");
         u.setPassword("A234");
         assertEquals(validarLogin.VerificarLogin(u), DATOS_INCORRECTOS);
     }
     @Test
     public void testTodocorecto(){
         Usuario u = new Usuario();
         u.setNombre("juan");
         u.setPassword("1234");
         assertEquals(validarLogin.VerificarLogin(u), USUAARIO_AUTORIZADO);
     
         u.setNombre("pedro");
         u.setPassword("123");
         assertEquals(validarLogin.VerificarLogin(u), USUAARIO_AUTORIZADO);
         
         u.setNombre("maria");
         u.setPassword("12345");
         assertEquals(USUAARIO_AUTORIZADO,validarLogin.VerificarLogin(u) );
     }
}
