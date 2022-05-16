package clienteModel;
public class Cliente {
    protected int id;
    protected String nome;
    protected String login;
    protected String senha;
    protected String endereco;
    protected int idade;
    protected String cpf;
    protected String nome_pai;
    protected String nome_mae;
    protected int ativo;
    protected String email;
    
    public Cliente(){}
    
    public Cliente(int id,String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, int ativo,String email) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.ativo = ativo;
        this.email = email;
    }
  
    public Cliente(String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae,String email) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }
}
