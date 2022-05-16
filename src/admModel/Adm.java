package admModel;
import clienteModel.Cliente;

public class Adm extends Cliente {
    private String funcao;
    
    public Adm(){}
    
    public Adm(String funcao, int id, String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, int ativo, String email) {
        super(id, nome, login, senha, endereco, idade, cpf, nome_pai, nome_mae, ativo, email);
        this.funcao = funcao;
    }

    public Adm(String funcao, String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, String email) {
        super(nome, login, senha, endereco, idade, cpf, nome_pai, nome_mae, email);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
