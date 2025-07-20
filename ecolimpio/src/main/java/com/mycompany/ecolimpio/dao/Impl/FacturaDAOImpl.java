package com.mycompany.ecolimpio.dao.Impl;

import com.mycompany.ecolimpio.dao.Interfce.FacturaDAO;
import com.mycompany.ecolimpio.model.Factura;
import com.mycompany.ecolimpio.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class FacturaDAOImpl implements FacturaDAO {
    @Override
    public void guardar(Factura factura) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(factura);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Factura factura) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(factura);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long idfactura) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(idfactura);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Factura buscarPorId(Long idfactura) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Factura fa = em.find(Factura.class, idfactura);
        em.close();
        return fa;
    }

    @Override
    public List<Factura> listarTodos() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Factura> Facturas = em.createQuery("FROM Factura", Factura.class).getResultList();
        em.close();
        return Facturas;
    }
}
