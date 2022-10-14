/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.dao;

import faculdade.poo.zetalab.model.Pedido;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Windows 10
 */
public class PedidoDAO extends GenericDAO<Pedido, Integer>{

    @Override
    public void inserir(Pedido obj) throws SQLException {
        con.getTransaction().begin();
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Pedido obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Pedido obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Pedido findById(Integer key) throws SQLException {
        String consulta = "select p from Pedido p where p.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Pedido)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Pedido> findAll() throws SQLException {
        String consulta = "select p from Pedido p ";
        Query q = con.createQuery(consulta);
        
        return q.getResultList();
    }
    
    public List<Pedido> findMeusPedidos(int idUsuario) throws SQLException {
        String consulta = "select p from Pedido p where p.usuario.id = :idUsuario";
        Query q = con.createQuery(consulta);
        
        q.setParameter("idUsuario", idUsuario);
        
        return q.getResultList();
    }
}
