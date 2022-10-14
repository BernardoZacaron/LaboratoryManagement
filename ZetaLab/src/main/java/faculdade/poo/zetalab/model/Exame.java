/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.model;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Windows 10
 */

@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500)
    @Lob
    private String nome;
    private double custo, peridoJejum, prazoEntrega;
    @OneToMany()
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Exame() {
    }

    public Exame(int id, String nome, double custo, double peridoJejum, double prazoEntrega) {
        this.id = id;
        this.nome = nome;
        this.custo = custo;
        this.peridoJejum = peridoJejum;
        this.prazoEntrega = prazoEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getPeridoJejum() {
        return peridoJejum;
    }

    public void setPeridoJejum(double peridoJejum) {
        this.peridoJejum = peridoJejum;
    }

    public double getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(double prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
    
}
