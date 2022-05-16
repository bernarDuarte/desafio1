package admView;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import static admController.Controller.*;
import static admDao.Dao.getAdm;
import admModel.Adm;
import java.util.ArrayList;
import java.util.List;
import static usuarioController.Controller.verificaUsuario;

public class View {
    //se a verificaUsuario retornar true ... se não ...
    public static boolean abrirSistemaAdm(String login, String senha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        boolean user = false;
            if(verificaAdm(login,senha)==true){
                user = true;
            }
            System.out.println(user);
        return user;
    }
    public static String abrirSistemaAdm(String pai, String mae, String cpf, String login) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        return verificaAdm(pai,mae,cpf,login);
    }
    public static Adm pegaAdmController(String login) throws SQLException, ClassNotFoundException{
        Adm adm = pegaAdm(login);
        return adm;
    }
    public static List<Adm> pegaAdmController(int id) throws SQLException, ClassNotFoundException{
        List<Adm> adm = new ArrayList<Adm>();
        adm = pegaAdm(id);
        return adm;
    }
    public static String enviaCadastroControllerAdm(String funcao, String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, String email,String confirmaSenha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        String str="", outPut ="";
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
        if(funcao.length() <5 || funcao.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "A função deve ter mais que 5 letras";
        }
        if(!confirmaSenha.equals(senha)){
            cadastroCorreto=false;
            return outPut = "As senha não coincidem";
        }
        if(cadastroCorreto!=false){
            Adm adm = new Adm(funcao,  nome,  login,  senha, endereco, idade, cpf, nome_pai, nome_mae,email);
            outPut = salvaInfoCadastro(adm);
        }
        return outPut;
    }
    public static String enviaCadastroAlteradoControllerAdm(String funcao, int id, String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, String email,String confirmaSenha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        String str="", outPut ="";
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
        if(funcao.length() <5 || funcao.getClass().getSimpleName()!= str.getClass().getSimpleName()){
            cadastroCorreto=false;
            return outPut = "A função deve ter mais que 5 letras";
        }
        if(!confirmaSenha.equals(senha)){
            if(senha.length()<5){
                return outPut = "A senha deve ter mais do que 5 letras";    
            }else{
                return outPut = "As senha não coincidem";
            }
        }
        if(cadastroCorreto!=false){
            Adm adm = new Adm(funcao,id,  nome,  login,  senha, endereco, idade, cpf, nome_pai, nome_mae,1,email);
            outPut = alteraInfoCadastro(adm);
        }
        return outPut;
    }
    public static String inativaIdAdmEnviada(int id) throws SQLException, ClassNotFoundException{
        return inativaCadastro(id);
    }
    
}
