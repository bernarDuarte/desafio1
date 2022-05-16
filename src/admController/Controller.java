package admController;
    
import java.sql.*;
import admModel.Adm;
import admDao.Dao;
import static encryptPass.EncryptPass.createHash;
import java.security.NoSuchAlgorithmException;
import static admDao.Dao.*;
import java.util.ArrayList;
import java.util.List;
import usuarioModel.Usuario;

public class Controller {
    public static boolean verificaAdm(String login, String senha) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        boolean user = false;
        for(admModel.Adm adm : getAdm(0)){
                if(adm.getLogin().equals(login) && adm.getSenha().equals(createHash(senha))){
                    user =true;
                    break;
                }    
        }
        return user;
    }
    public static String verificaAdm(String pai, String mae,String cpf,String login) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        for(admModel.Adm adm : getAdm(0)){
                if(adm.getLogin().equals(login) && adm.getNome_pai().equals((pai))&& adm.getCpf().equals(cpf) && adm.getNome_mae().equals(mae)){
                    return "Bem vindo !!";
                }    
        }
        return "not found";
    }
    public static Adm pegaAdm(String login) throws SQLException, ClassNotFoundException{
        Adm a = new Adm();
        for(admModel.Adm adm : getAdm(0)){
                if(adm.getLogin().equals(login)){
                    a = adm;
                }
        }
        return a;
    }
    public static List<Adm> pegaAdm(int id) throws SQLException, ClassNotFoundException{
        List<Adm> adm = new ArrayList<Adm>();
        Adm a = new Adm();
        if(id ==0){
            adm = getAdm(0);
        }else{
            for(admModel.Adm admin : getAdm(0)){
                if(admin.getId() == id){
                    a = admin;
                    adm.add(a);
                }
            }    
        }
        return adm;
    }
    
    public static String salvaInfoCadastro(Adm adm) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        Dao dao = new Dao();
        try{
            dao.save(adm);    
            return "O Administrador foi salvo";
        }catch(SQLException e){
            return "Erro ao salvar";
        }
    }
    public static String alteraInfoCadastro(Adm adm) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        Dao dao = new Dao();
        try{
            dao.alteraAdm(adm);    
            return "Administrador alterado com sucesso!";
        }catch(SQLException e){
            return "Administrador não foi alterado!";
        }
    }
    public static String inativaCadastro(int id) throws SQLException, ClassNotFoundException{
        Dao dao = new Dao();
        try{
            dao.inativaAdm(id);    
            return "O administrador foi inativado!";
        }catch(SQLException e){
            return "O administrador não pode ser inativado!";
        }
    }
}
