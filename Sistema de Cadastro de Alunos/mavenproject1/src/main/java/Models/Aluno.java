
package Models;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "alunos")

public class Aluno implements Serializable {
    
    @Id
    @Column(name = "matricula")
    private int matricula;
    
    @Column(name = "idade")
    private int idade;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    
    
    public Aluno(){
        
    }
    
     public Aluno(int matricula, int idade, String nome, String cpf, String telefone, Date dataNascimento){
         this.matricula = matricula;
         this.idade = idade;
         this.nome = nome;
         this.cpf = cpf;
         this.telefone = telefone;
         this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
   
  
}
