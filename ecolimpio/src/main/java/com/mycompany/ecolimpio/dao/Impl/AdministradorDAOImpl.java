package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.AdministradorDAO;
import com.mycompany.ecolimpio.model.Administrador;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AdministradorDAOImpl implements AdministradorDAO {


    @Override
    public void guardar(Administrador administrador) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(administrador);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Administrador administrador) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(administrador);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idadministrador) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(idadministrador);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Administrador buscarPorId(Long idadministrador) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Administrador ad = em.find(Administrador.class, idadministrador);
        em.close();
        return ad;
    }

    @Override
    public List<Administrador> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Administrador> administradores = em.createQuery("FROM Administrador", Administrador.class).getResultList();
        em.close();
        return administradores;
    }
}
