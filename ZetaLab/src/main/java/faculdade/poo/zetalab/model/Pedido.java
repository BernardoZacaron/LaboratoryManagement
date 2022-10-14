/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Windows 10
 */

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Exame exame;
    private String resultado;
    private boolean entregue;

    public Pedido() {
    }

    public Pedido(int id, Usuario usuario, Exame exame, String resultado) {
        this.id = id;
        this.usuario = usuario;
        this.exame = exame;
        this.resultado = resultado;
    }

    public Pedido(int id, Usuario usuario, Exame exame, String resultado, boolean entregue) {
        this.id = id;
        this.usuario = usuario;
        this.exame = exame;
        this.resultado = resultado;
        this.entregue = entregue;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
