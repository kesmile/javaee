/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desmile.main;

import com.desmile.hibernite.dao.EntityManager;
import com.devsmile.hibernite.HibernateUtil;
import com.devsmile.hibernite.Perfil;
import com.devsmile.hibernite.Usuarios;
import java.io.Console;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author kelvi
 */
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(true){
        System.out.print("1. ver lista | 2. ingresar un usuarios | 3. test: ");
        int n = sc.nextInt();
        switch (n){
            case 1: 
                list();
            break;
            case 2:
                Usuarios user = new Usuarios();
                System.out.println("Usuario: ");
                String usuario = sc.next();
                System.out.println("Password: ");
                String password = sc.next();
                System.out.println("Email: ");
                String email = sc.next();
                int dato = 1;
                user.setUsuario(usuario);
                user.setPassword(password);
                user.setEmail(email);
                user.setEstado((byte) dato);
                
                SessionFactory sf = new HibernateUtil().getSessionFactory();
                Session session = sf.openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                session.close();
                
                System.out.println("Usuario guardado exitosamente!");
             break;
            case 3:
                byte d = 1;
                Usuarios test = new Usuarios("juan2","1234","juan2@localhost.com",d);
                Perfil perfil = new Perfil();
                perfil.setNickname("j2perez");
                perfil.setDescription("esto es un descripcion simple");
                perfil.setUsuario(test);
                test.setPerfil(perfil);
                SessionFactory sf2 = new HibernateUtil().getSessionFactory();
                Session session2 = sf2.openSession();
                session2.beginTransaction();
                session2.save(test);
                session2.getTransaction().commit();
                session2.close();
                System.out.println("Usuario guardado exitosamente!");
             break;
            case 4:
                EntityManager em = new EntityManager();
                Usuarios temp = em.getUser(2);
                System.out.print("usuario: " + temp.getUsuario());
                System.out.print(" email: " + temp.getEmail());
                Perfil p = temp.getPerfil();
                if(p != null)
                    System.out.println(" perfil: " + p.getNickname());
                else
                    System.out.println(" perfil: null");
             break;
                
        }
       }
    }
    public static void list(){
        EntityManager em = new EntityManager();
        List usuarios = em.listUsers();
        Perfil p;
        for(Iterator iterator = usuarios.iterator(); iterator.hasNext();){
            Usuarios user = (Usuarios)iterator.next();
            System.out.print("usuario: " + user.getUsuario());
            System.out.print(" email: " + user.getEmail());
            p = user.getPerfil();
            if(p != null)
                System.out.println(" perfil: " + p.getNickname());
            else
                System.out.println(" perfil: null");
        }
    }
}
