/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Models.Aluno;
import util.HibernateUtil; 
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AlunoHibernateDAO {
    public void salvarOuAtualizar(Aluno aluno) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            session.saveOrUpdate(aluno);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Erro ao salvar/atualizar no banco de dados.");
    } finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    
}
    public List<Aluno> ListarTodos() throws Exception{
        Session session = null;
        Transaction transaction = null;
        List<Aluno> alunos = null;
        try{
      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      alunos = session.createQuery("From Aluno", Aluno.class).list();
      transaction.commit();
      
       } catch (Exception e){
           e.printStackTrace();
           throw new Exception("Erro ao listar alunos do banco de dados: " + e.getMessage());
       } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    
         return alunos;
}
}