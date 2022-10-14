/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.dao;

import faculdade.poo.zetalab.model.Laboratorio;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Windows 10
 */
public class LaboratorioDAO extends GenericDAO<Laboratorio, Integer>{

    @Override
    public void inserir(Laboratorio obj) throws SQLException {
        con.getTransaction().begin();
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Laboratorio obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Laboratorio obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Laboratorio findById(Integer key) throws SQLException {
        String consulta = "select l from Laboratorio l where l.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Laboratorio)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Laboratorio> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
