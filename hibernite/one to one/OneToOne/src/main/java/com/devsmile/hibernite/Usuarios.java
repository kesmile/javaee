package com.devsmile.hibernite;
// Generated 25/07/2015 04:50:45 PM by Hibernate Tools 4.3.1

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios")
public class Usuarios  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     private Integer id;
     @Column(name="usuario")
     private String usuario;
     @Column(name="password")
     private String password;
     @Column(name="email")
     private String email;
     @Column(name="estado")
     private byte estado;
     @OneToOne(mappedBy="Usuario",fetch=FetchType.EAGER) 
     private Perfil perfil;
    public Usuarios() {
    }

    public Usuarios(String usuario, String password, String email, byte estado) {
       this.usuario = usuario;
       this.password = password;
       this.email = email;
       this.estado = estado;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public byte getEstado() {
        return this.estado;
    }
    
    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
