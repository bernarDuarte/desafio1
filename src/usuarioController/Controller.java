package usuarioController;
import static admDao.Dao.getAdm;
import java.sql.*;
import clienteConexao.ConexaoDB;
import usuarioModel.Usuario;
import usuarioDao.Dao;
import static usuarioDao.Dao.*;
import static encryptPass.EncryptPass.createHash;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    
    public static boolean verificaUsuario(String login, String senha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        boolean user = false;
        for(usuarioModel.Usuario usuario : getUsuario(0)){
                if(usuario.getLogin().equals(login) && usuario.getSenha().equals(createHash(senha))){
                    user =true;
                    break;
                }    
        }
        return user;
    }
    public static String verificaUsuario(String pai, String mae,String cpf,String login) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        for(usuarioModel.Usuario usuario : getUsuario(0)){
                if(usuario.getNome_mae().equals(mae) && usuario.getNome_pai().equals(pai)&& usuario.getCpf().equals(cpf) && usuario.getLogin().equals(login)){
                    return "Bem vindo !!";
                }    
        }
        return "not found";
    }
    
    public static Usuario pegaUsuario(String login) throws SQLException, ClassNotFoundException{
        Usuario a = new Usuario();
        for(Usuario usuario : getUsuario(0)){
                if(usuario.getLogin().equals(login)){
                    a = usuario;
                }
        }
        return a;
    }
    public static List<Usuario> pegaUsuario(int id) throws SQLException, ClassNotFoundException{
        List<Usuario> usuario = new ArrayList<Usuario>();
        Usuario a = new Usuario();
        if(id == 0){
            return getUsuario(0);
        }else{
            for(Usuario user : getUsuario(0)){
                if(user.getId()==id){
                    a = user;
                    usuario.add(a);
                    break;
                }
            }    
        }
        return usuario;
    }
    
    public static String salvaInfoCadastro(Usuario usuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        Dao dao = new Dao();
        try{
            dao.save(usuario);    
            return "O usuario foi salvo";
        }catch(SQLException e){
            return "Erro ao salvar";
        }
    }
    public static String alteraInfoCadastro(Usuario usuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        Dao dao = new Dao();
        try{
            dao.alteraUsuario(usuario);    
            return "Usuario alterado com sucesso!";
        }catch(SQLException e){
            return "Usuario não foi alterado!";
        }
    }
    public static String inativaCadastro(int id) throws SQLException, ClassNotFoundException{
        Dao dao = new Dao();
        try{
            dao.inativaUsuario(id);    
            return "O usuario foi inativado!";
        }catch(SQLException e){
            return "O usuario não foi inativado!";
        }
    }
}
