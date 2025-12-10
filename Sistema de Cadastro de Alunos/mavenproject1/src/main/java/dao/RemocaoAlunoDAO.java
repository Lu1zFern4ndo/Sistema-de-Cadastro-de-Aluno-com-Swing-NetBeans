/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Models.Aluno;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class RemocaoAlunoDAO implements AlunoDAO{
    @Override
    public List removerAluno(List<Aluno> alunos, Aluno a){
        Iterator<Aluno> iterator = alunos.iterator();
        int matRemover = a.getMatricula();
        while(iterator.hasNext()){
            Aluno alunoAtual = iterator.next();
            if(alunoAtual.getMatricula() == matRemover){
                iterator.remove();
                break;
            }     
        }
        return alunos;
    }
    
}
