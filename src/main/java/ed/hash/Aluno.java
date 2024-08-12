package ed.hash;

import java.time.LocalDate;

public class Aluno {
    private int matricula;
    private String nome;
    private LocalDate dataDeNascimento;

    public Aluno(int matricula, String nome, LocalDate dataDeNascimento) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }    
}
