/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.dao;

import faculdade.poo.zetalab.model.Exame;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Windows 10
 */
public class ExameDAO extends GenericDAO<Exame, Integer>{

    @Override
    public void inserir(Exame obj) throws SQLException {
        con.getTransaction().begin();
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Exame obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Exame obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Exame findById(Integer key) throws SQLException {
        String consulta = "select e from Exame e where e.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Exame)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Exame> findAll() throws SQLException {
        String consulta = "select e from Exame e ";
        Query q = con.createQuery(consulta);
        
        return q.getResultList();
    }
    
}
