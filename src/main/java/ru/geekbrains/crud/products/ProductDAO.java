package ru.geekbrains.crud.products;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {
    private SessionFactory factory;
    public void init(){
        factory =new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }
    public void shutdown() {
        factory.close();
    }
    public void showAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> product = session.createQuery("from Product ").getResultList();
            System.out.println(product + "\n");
            session.getTransaction().commit();
        }
    }

    public void selectByID(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public void deleteByID(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void createNewProduct() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product("Bin", 1);
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public void updateProduct(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product= session.get(Product.class, id);
            product.setCost(15);
            session.getTransaction().commit();
        }
    }
}
