package usuarioView;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static usuarioController.Controller.*;
import usuarioModel.Usuario;

public class View {
    
    //se a verificaUsuario retornar true ... se não ...
    public static boolean abrirSistemaUsuario(String login, String senha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        if(verificaUsuario(login,senha)==true){
            return true;
        }else{
            return false;
        }
    }
    public static String abrirSistemaUsuario(String pai,String mae,String cpf,String login) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        return verificaUsuario(pai,mae,cpf,login);
    }
    public static Usuario pegaUsuarioController(String login) throws SQLException, ClassNotFoundException{
        Usuario usuario = pegaUsuario(login);
        return usuario;
    }
    public static List<Usuario> pegaUsuarioController(int id) throws SQLException, ClassNotFoundException{
        List<Usuario> usuario = new ArrayList<Usuario>();
        usuario = pegaUsuario(id);
        return usuario;
    }
    
    public static String enviaCadastroControllerUsuario(String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, String email,String confirmaSenha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        String str="", outPut ="dd";
        boolean cadastroCorreto =true,cadastroRepetido=true;
        
        if( nome.length() < 3 || nome.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O nome deve ter mais que 3 letras e não deve conter números";
        }
        if(login.length() <5 || login.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O login deve ter mais que 5 letras";
        }
        if(senha.length() <5 || senha.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "A senha deve ter mais que 5 letras";
        }
        if(endereco.length() <5 || endereco.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O endereço deve ter mais que 5 letras";
        }
        
        if(cpf.length() <10 || cpf.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O cpf deve ter 11 números";
        }
        if(nome_pai.length() <5 || nome_pai.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O nome do pai deve ter mais que 5 letras";
        }
        if(nome_mae.length() <5 || nome_mae.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
           return outPut = "O nome da mãe deve ter mais que 5 letras"; 
        }
        if(email.length() <5 || email.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O email deve ter mais que 10 letras";            
        
        }
        if(!confirmaSenha.equals(senha)){
            cadastroCorreto=false;
            return outPut = "As senha não coincidem";
        }
        if(cadastroCorreto!=false){
            Usuario user = new Usuario(0,  nome,  login,  senha, endereco, idade, cpf, nome_pai, nome_mae,email);
            outPut = salvaInfoCadastro(user);
        }
        return outPut;
    }
    public static String enviaCadastroAlteradoControllerUsuario(String nome, int id, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, String email,String confirmaSenha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        String str="", outPut ="dd";
        boolean cadastroCorreto =true,cadastroRepetido=true;
        
        if( nome.length() < 3 || nome.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O nome deve ter mais que 3 letras e não deve conter números";
        }
        if(login.length() <5 || login.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O login deve ter mais que 5 letras";
        }
        if(endereco.length() <5 || endereco.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O endereço deve ter mais que 5 letras";
        }
        
        if(cpf.length() <10 || cpf.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O cpf deve ter 11 números";
        }
        if(nome_pai.length() <5 || nome_pai.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O nome do pai deve ter mais que 5 letras";
        }
        if(nome_mae.length() <5 || nome_mae.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
           return outPut = "O nome da mãe deve ter mais que 5 letras"; 
        }
        if(email.length() <5 || email.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "O email deve ter mais que 10 letras";            
        
        }
        if(!confirmaSenha.equals(senha)){
            if(senha.length()<5){
                return outPut = "A senha deve ter mais do que 5 letras";    
            }else{
                return outPut = "As senha não coincidem";
            }
        }
        if(cadastroCorreto!=false){
            Usuario user = new Usuario(0,  nome,  login,  senha, endereco, idade, cpf, nome_pai, nome_mae,email);
            outPut = alteraInfoCadastro(user);
        }
        return outPut;
    }
    public static String inativaIdUsuarioEnviada(int id) throws SQLException, ClassNotFoundException{
        return inativaCadastro(id);
    }
}