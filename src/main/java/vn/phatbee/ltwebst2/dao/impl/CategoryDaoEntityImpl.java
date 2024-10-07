package vn.phatbee.ltwebst2.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.phatbee.ltwebst2.configs.JPAConfig;
import vn.phatbee.ltwebst2.dao.ICategoryDaoEntity;
import vn.phatbee.ltwebst2.entity.Category;

import java.util.List;

public class CategoryDaoEntityImpl implements ICategoryDaoEntity {

    @Override
    public void insert(Category category) {
        EntityManager emma = JPAConfig.getEntityManager();
        EntityTransaction trans = emma.getTransaction();

        try {
            trans.begin();
            // Gọi phương thức insert
            emma.persist(category);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emma.close();
        }
    }

    @Override
    public void update(Category category) {
        EntityManager emma = JPAConfig.getEntityManager();
        EntityTransaction trans = emma.getTransaction();

        try {
            trans.begin();
            // Gọi phương thức Update
            emma.merge(category);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emma.close();
        }

    }

    @Override
    public void delete(int cateid) throws Exception {
        EntityManager emma = JPAConfig.getEntityManager();
        EntityTransaction trans = emma.getTransaction();

        try {
            trans.begin();
            Category category = emma.find(Category.class, cateid);
            if (category != null) {
                // Gọi phương thức delete
                emma.remove(category);
            } else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            emma.close();
        }

    }

    @Override
    public Category findById(int id) {
        EntityManager emma = JPAConfig.getEntityManager();
        Category category =emma.find(Category.class, id);
        emma.close();
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager emma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = emma.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    @Override
    public List<Category> findByCategoryName(String catName) {
        EntityManager emma = JPAConfig.getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.categoryname = :catName";
        TypedQuery<Category> query = emma.createQuery(jpql, Category.class);
        query.setParameter("catName", catName);
        return query.getResultList();
    }

    @Override
    public List<Category> findAll(int page, int size) {
        EntityManager emma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = emma.createNamedQuery("Category.findAll", Category.class);
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public int count() {
        EntityManager emma = JPAConfig.getEntityManager();
        String jpql = "SELECT COUNT(c) FROM Category c";
        Query query = emma.createQuery(jpql);
        return ((Long) query.getSingleResult()).intValue();
    }
}
