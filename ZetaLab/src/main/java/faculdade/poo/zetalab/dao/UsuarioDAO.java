/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.dao;

import faculdade.poo.zetalab.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Windows 10
 */
public class UsuarioDAO extends GenericDAO<Usuario, Integer>{

    @Override
    public void inserir(Usuario obj) throws SQLException {
        con.getTransaction().begin();
        con.persist(obj);
        con.getTransaction().commit();
    }

    @Override
    public void alterar(Usuario obj) throws SQLException {
        con.getTransaction().begin();
        con.merge(obj);
        con.getTransaction().commit();
    }

    @Override
    public void apagar(Usuario obj) throws SQLException {
        con.getTransaction().begin();
        con.remove(obj);
        con.getTransaction().commit();
    }

    @Override
    public Usuario findById(Integer key) throws SQLException {
        String consulta = "select u from Usuario u where u.id = :k ";
        Query q = con.createQuery(consulta); 
        q.setParameter("k", key);
        
        try{
            return (Usuario)q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        String consulta = "select u from Usuario u ";
        Query q = con.createQuery(consulta);
        
        return q.getResultList();
    }
    
    public Usuario verificarLogin(String login, String senha) throws SQLException/*, NoSuchAlgorithmException*/{
        String consulta = "select u from Usuario u where upper(u.login) = upper(:login) and u.senha = :senha";
        Query q = con.createQuery(consulta);
        
        q.setParameter("login",login);
        q.setParameter("senha", senha);
        
        try{
            return (Usuario) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }catch(NonUniqueResultException e ){
            return (Usuario)q.getResultList().get(0);
        }
    }
    
}
