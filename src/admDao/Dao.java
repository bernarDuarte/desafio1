package admDao;

import admModel.Adm;
import clienteConexao.ConexaoDB;
import encryptPass.EncryptPass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static encryptPass.EncryptPass.createHash;
import java.security.NoSuchAlgorithmException;
public class Dao{
    
    
    
    // salva os usuarios passados via objeto, verifica também se o mesmo não existe no sistema.
        public void save(Adm adm) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        boolean existe =false;
        List<Adm> adms = new ArrayList<Adm>();
        adms = getAdm(0);
        Iterator<Adm> itr = adms.iterator();
        String QUERY="INSERT INTO administrador (nome,login,senha,endereco,idade,cpf,nome_pai,nome_mae,funcao,email)"
                +" VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            while(itr.hasNext()){
                if(adm.getLogin().equals(itr.next().getLogin())){
                    System.out.println(adm.getLogin());
                    System.out.println(itr.next().getLogin());
                    existe = true;
                }
            }
            if(existe==false){
            connection = ConexaoDB.conectaDB();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.setString(1,adm.getNome());
            preparedStatement.setString(2,adm.getLogin());
            preparedStatement.setString(3,createHash(adm.getSenha()));
            preparedStatement.setString(4,adm.getEndereco());
            preparedStatement.setInt(5,adm.getIdade());
            preparedStatement.setString(6,adm.getCpf());
            preparedStatement.setString(7,adm.getNome_pai());
            preparedStatement.setString(8,adm.getNome_mae());
            preparedStatement.setString(9,adm.getFuncao());
            preparedStatement.setString(10,adm.getEmail());               
            preparedStatement.execute();
            System.out.println("O administrador foi salvo!");    
            }else{
                System.out.println("Este login já existe, por gentileza insira outro login");
            }
        }catch(SQLException e){
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try{
                if(preparedStatement !=null){
                preparedStatement.close();
            }
            if(connection !=null){
                connection.close();
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
        
    //Retorna uma lista de usuarios caso a id seja 0 e retorna o usuario caso a id seja passada por parametro
    public static List<Adm> getAdm(int id) throws SQLException, ClassNotFoundException{
        String QUERY = "SELECT * FROM administrador WHERE ativo = 1";
        if (id != 0){
            QUERY = "SELECT * FROM administrador WHERE ativo =1 AND id ="+id+"";
        }
        List<Adm> adms = new ArrayList<Adm>();
        
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        try{
            connection = ConexaoDB.conectaDB();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            resultSet = preparedStatement.executeQuery(QUERY);
            while(resultSet.next()){
                Adm adm = new Adm();
                
                adm.setId(resultSet.getInt("id"));
                adm.setNome(resultSet.getString("nome"));
                adm.setLogin(resultSet.getString("login"));
                adm.setSenha(resultSet.getString("senha"));
                adm.setEndereco(resultSet.getString("endereco"));
                adm.setIdade(resultSet.getInt("idade"));
                adm.setCpf(resultSet.getString("cpf"));
                adm.setNome_pai(resultSet.getString("nome_pai"));
                adm.setNome_mae(resultSet.getString("nome_mae"));
                adm.setFuncao(resultSet.getString("funcao"));
                adm.setEmail(resultSet.getString("email"));
                adms.add(adm);
                
            }
        }catch(SQLException e){
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return adms;
    }
    
    //altera o usuario com as informações passadas pelo objeto "Alterea usuario". A informação que não for alterada de ser passada como null ou 0 no objeto.
    public static void alteraAdm(Adm alteraAdm) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        List<Adm> adms = new ArrayList<Adm>();
        try {
            System.out.println(alteraAdm.getId());
            adms = getAdm(alteraAdm.getId());
            Adm a = adms.get(0);
            if(alteraAdm.getNome() == null){
                alteraAdm.setNome(a.getNome());
            }
            if(alteraAdm.getLogin() == null){
                alteraAdm.setLogin(a.getLogin());
            }
            if(alteraAdm.getSenha() == null){
                alteraAdm.setSenha(a.getSenha());
            }
            if(alteraAdm.getEndereco() == null){
                alteraAdm.setEndereco(a.getEndereco());
            }
            if(alteraAdm.getIdade() == 0){
                alteraAdm.setIdade(a.getIdade());
            }
            if(alteraAdm.getCpf() == null){
                alteraAdm.setCpf(a.getCpf());
            }
            if(alteraAdm.getNome_pai() == null){
                alteraAdm.setNome_pai(a.getNome_pai());
            }
            if(alteraAdm.getNome_mae() == null){
                alteraAdm.setNome_mae(a.getNome_mae());
            }
            if(alteraAdm.getFuncao() == null){
                alteraAdm.setFuncao(a.getFuncao());
            }
            if(alteraAdm.getEmail() == null){
                alteraAdm.setEmail(a.getEmail());
            }
            
            String QUERY="UPDATE administrador SET nome = '"+alteraAdm.getNome()+"',"
                    +" login = '"+alteraAdm.getLogin()+"',"
                    +" senha = '"+createHash(alteraAdm.getSenha())+"',"
                    +" endereco = '"+alteraAdm.getEndereco()+"',"
                    +" idade = '"+alteraAdm.getIdade()+"',"
                    +" cpf ='"+alteraAdm.getCpf()+"',"
                    +" nome_pai ='"+alteraAdm.getNome_pai()+"',"
                    +" nome_mae ='"+alteraAdm.getNome_mae()+"',"
                    +" funcao ='"+alteraAdm.getFuncao()+"',"
                    +" email = '"+alteraAdm.getEmail()+"'"
                    +" WHERE id = '"+alteraAdm.getId()+"'";
            Connection connection = ConexaoDB.conectaDB();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.executeUpdate(QUERY);
            System.out.println("Administrador Atualizado!");
        }catch (ClassNotFoundException ex) {
           }
        }
    
    //inativa o usuario conforme a id passada
    public static void inativaAdm(int id) throws ClassNotFoundException, SQLException{
        String QUERY ="UPDATE administrador SET ativo =0 WHERE id ='"+id+"'";
        Connection connection = ConexaoDB.conectaDB();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.executeUpdate();
    }
}
