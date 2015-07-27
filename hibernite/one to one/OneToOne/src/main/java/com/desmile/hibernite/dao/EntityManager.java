/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desmile.hibernite.dao;

import com.devsmile.hibernite.HibernateUtil;
import com.devsmile.hibernite.Usuarios;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author kelvi
 */
public class EntityManager {
    public List listUsers(){
        SessionFactory sf = new HibernateUtil().getSessionFactory();
        Session session = sf.openSession();
        try {
            List lista = session.createQuery("from Usuarios").list();
            session.close();
            return lista;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Usuarios getUser(int id){
        SessionFactory sf = new HibernateUtil().getSessionFactory();
        Session session = sf.openSession();
        try {
            Usuarios user;
            user = session.get(Usuarios.class, id);
            session.close();
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
