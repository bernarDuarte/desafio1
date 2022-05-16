package usuarioModel;

import clienteModel.Cliente;

public class Usuario extends Cliente{
    private int avalicao;
    
    
    public Usuario(){};
    
    public Usuario(int avalicao, int id, String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, int ativo, String email) {
        super(id, nome, login, senha, endereco, idade, cpf, nome_pai, nome_mae, ativo, email);
        this.avalicao = avalicao;
    }

    public Usuario(int avalicao, String nome, String login, String senha, String endereco, int idade, String cpf, String nome_pai, String nome_mae, String email) {
        super(nome, login, senha, endereco, idade, cpf, nome_pai, nome_mae, email);
        this.avalicao = avalicao;
    }
    
    

    public int getAvalicao() {
        return avalicao;
    }

    public void setAvalicao(int avalicao) {
        this.avalicao = avalicao;
    }
}
