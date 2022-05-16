package usuarioDao;
import java.sql.*;
import usuarioModel.Usuario;
import clienteConexao.ConexaoDB;
import static encryptPass.EncryptPass.createHash;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {
    
    // salva os usuarios passados via objeto, verifica também se o mesmo não existe no sistema.
    public void save(Usuario usuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        boolean existe =false;
        List<Usuario> users = new ArrayList<Usuario>();
        users = getUsuario(0);
        Iterator<Usuario> itr = users.iterator();
        
        String QUERY="INSERT INTO usuario (nome,login,senha,endereco,idade,cpf,nome_pai,nome_mae,avalicao,email)"
                +" VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            while(itr.hasNext()){
                if(usuario.getLogin().equals(itr.next().getLogin())){
                    existe = true;
                    break;
                }
            }
            System.out.println(existe);
            
            if(existe==false){
                connection = ConexaoDB.conectaDB();
                preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
                preparedStatement.setString(1,usuario.getNome());
                preparedStatement.setString(2,usuario.getLogin());
                preparedStatement.setString(3,createHash(usuario.getSenha()));
                preparedStatement.setString(4,usuario.getEndereco());
                preparedStatement.setInt(5,usuario.getIdade());
                preparedStatement.setString(6,usuario.getCpf());
                preparedStatement.setString(7,usuario.getNome_pai());
                preparedStatement.setString(8,usuario.getNome_mae());
                preparedStatement.setInt(9,usuario.getAvalicao());
                preparedStatement.setString(10,usuario.getEmail());
                preparedStatement.execute();
                System.out.println("O Usuario foi salvo!!");
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
    public static List<Usuario> getUsuario(int id) throws SQLException, ClassNotFoundException{
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String QUERY = "SELECT * FROM usuario WHERE ativo =1";
        if(id != 0){
            QUERY = "SELECT * FROM usuario WHERE ativo =1 AND id ="+id+"";
        }
        
        System.out.println(QUERY);
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        
        try{
            connection = ConexaoDB.conectaDB();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            resultSet = preparedStatement.executeQuery(QUERY);
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setEndereco(resultSet.getString("endereco"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setNome_pai(resultSet.getString("nome_pai"));
                usuario.setNome_mae(resultSet.getString("nome_mae"));
                usuario.setAtivo(resultSet.getInt("avalicao"));
                usuario.setEmail(resultSet.getString("email"));
                usuarios.add(usuario);
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
        return usuarios;
    }
    
    //altera o usuario com as informações passadas pelo objeto "Alterea usuario". A informação que não for alterada de ser passada como null ou 0 no objeto.
    public static void alteraUsuario(Usuario alteraUsuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        List<Usuario> users = new ArrayList<>();
        try{
            System.out.println(alteraUsuario.getId());
            users = getUsuario(alteraUsuario.getId());
            Usuario a = users.get(0);
            if(alteraUsuario.getNome() == null){
                alteraUsuario.setNome(a.getNome());
            }
            if(alteraUsuario.getLogin() == null){
                alteraUsuario.setLogin(a.getLogin());
            }
            if(alteraUsuario.getSenha() == null){
                alteraUsuario.setSenha(a.getSenha());
            }
            if(alteraUsuario.getEndereco() == null){
                alteraUsuario.setEndereco(a.getEndereco());
            }
            if(alteraUsuario.getIdade() == 0){
                alteraUsuario.setIdade(a.getIdade());
            }
            if(alteraUsuario.getCpf() == null){
                alteraUsuario.setCpf(a.getCpf());
            }
            if(alteraUsuario.getNome_pai() == null){
                alteraUsuario.setNome_pai(a.getNome_pai());
            }
            if(alteraUsuario.getNome_mae() == null){
                alteraUsuario.setNome_mae(a.getNome_mae());
            }
            if(alteraUsuario.getAvalicao() == 0){
                alteraUsuario.setAvalicao(a.getAvalicao());
            }
            if(alteraUsuario.getEmail() == null){
                alteraUsuario.setEmail(a.getEmail());
            }
            String QUERY ="UPDATE usuario SET nome ='"+alteraUsuario.getNome()+"',"
                    +" senha = '"+createHash(alteraUsuario.getSenha())+"',"
                    +" endereco = '"+alteraUsuario.getEndereco()+"',"
                    +" idade = '"+alteraUsuario.getIdade()+"',"
                    +" cpf = '"+alteraUsuario.getCpf()+"',"
                    +" nome_pai = '"+alteraUsuario.getNome_pai()+"',"
                    +" nome_mae = '"+alteraUsuario.getNome_mae()+"',"
                    +" avalicao = '"+alteraUsuario.getAvalicao()+"',"
                    +" email = '"+alteraUsuario.getEmail()+"'"
                    +" WHERE id ='"+alteraUsuario.getId()+"'";
            Connection connection = ConexaoDB.conectaDB();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            System.out.println(QUERY);
            preparedStatement.executeUpdate(QUERY);
            System.out.println("Alterado com sucesso!");
        }catch(SQLException e){
        }
    }
    
    //inativa o usuario conforme a id passada
    public static void inativaUsuario(int id) throws SQLException{
        try{
            String QUERY="UPDATE usuario SET ativo = 0 WHERE id = "+id+"";
            Connection connection = ConexaoDB.conectaDB();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
        }
    }
    
}

