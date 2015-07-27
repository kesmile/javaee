/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsmile.hibernite;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author kelvi
 */
@Entity
@Table(name="perfil")
public class Perfil implements java.io.Serializable {
    @Id  
    @Column(name="id_usuario")
    @GeneratedValue(generator="myGenerator")  
    @GenericGenerator(name="myGenerator", strategy="foreign", 
                      parameters=@Parameter(value="Usuario", name = "property")) 
    private int UsuariosId;
    @Column(name="nickname", nullable = true)
    private String nickname;
    @Column(name="description", nullable = true)
    private String description;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    private Usuarios Usuario;
    
    public int getUsuariosId() {
        return UsuariosId;
    }
    public void setUsuariosId(int UsuariosId) {
        this.UsuariosId = UsuariosId;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Usuarios getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuarios Usuario) {
        this.Usuario = Usuario;
    }
    
}
