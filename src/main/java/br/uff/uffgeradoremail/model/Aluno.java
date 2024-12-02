package br.uff.uffgeradoremail.model;

public class Aluno {
    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String uffmail;
    private String status;

    public Aluno(String nome, String matricula, String telefone, String email, String uffmail, String status) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.uffmail = uffmail;
        this.email = email;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getUffmail() {
        return uffmail;
    }

    public void setUffmail(String uffmail) {
        this.uffmail = uffmail;
    }

    public String getStatus() {
        return status;
    }
}
