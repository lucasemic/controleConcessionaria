//Por: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro
package model;

public class Usuario {

    private int id;
    private String nome;
    private String nivel_de_acesso;
    private String telefone_de_contato;
    private String email;
    private String cpf;
    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id +", \nnome="
                + nome + ", \nnivel_de_acesso=" + nivel_de_acesso + ",\n email=" + email
                + ", cpf=" + cpf + '}';
    }

    public Usuario() {
    }

    public Usuario(int id, String nome, String nivel_de_acesso, String telefone_de_contato, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nivel_de_acesso = nivel_de_acesso;
        this.telefone_de_contato = telefone_de_contato;
        this.email = email;
        this.cpf = cpf;
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
    public String getNivel_de_acesso() {
        return nivel_de_acesso;
    }

    public void setNivel_de_acesso(String nivel_de_acesso) {
        this.nivel_de_acesso = nivel_de_acesso;
    }
    
    
    public String getTelefone_de_contato() {
        return telefone_de_contato;
    }

    public void setTelefone_de_contato(String telefone_de_contato) {
        this.telefone_de_contato = telefone_de_contato;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

