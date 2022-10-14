/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome = "Zelta Lab";
    @OneToMany()
    private ArrayList<Usuario> users = new ArrayList<Usuario>();

    public Laboratorio() {
    }
    
    public double calcularGanhosTotais(List<Pedido> todosPedidos){
        double total = 0;
        
        for(Pedido p: todosPedidos){
            total+= p.getExame().getCusto();
        }
        
        return total;
    }
    
    public double calcularGanhosPlano(List<Pedido> todosPedidos){
        double total = 0;
        
        for(Pedido p: todosPedidos){
            if(p.getUsuario().isTemPlano())
                total+= p.getExame().getCusto();
        }
        
        return total;
    }

    public ArrayList<Usuario> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }
}
