/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculdade.poo.zetalab.model;

import faculdade.poo.zetalab.model.enums.ETipoUser;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Windows 10
 */

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome, cpf, telefone, login, senha;
    @OneToMany()
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    /*@Enumerated
    private ETipoUser tipo;*/
    private int tipo; //1=cliente  ,  2=atendente   ,   3=admin
    private boolean temPlano;
    @ManyToOne()
    private Laboratorio laboratorio;

    public Usuario() {
    }

    public Usuario(int id, String nome, String cpf, String telefone, String login, String senha, int tipo, boolean temPlano, Laboratorio laboratorio) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.temPlano = temPlano;
        this.laboratorio = laboratorio;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isTemPlano() {
        return temPlano;
    }

    public void setTemPlano(boolean temPlano) {
        this.temPlano = temPlano;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    
}
