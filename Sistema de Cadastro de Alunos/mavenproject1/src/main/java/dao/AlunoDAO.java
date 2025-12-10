
package dao;

import Models.Aluno;
import java.util.List;


public interface AlunoDAO {
    public List removerAluno(List<Aluno> alunos, Aluno a);
}
