package service;

import connector.HibernateUtil;
import dao.MarkDAO;
import entity.Car;
import entity.Mark;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MarkHiDAO implements MarkDAO {

    @Override
    public void add(Mark mark) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(mark);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Mark> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Mark> markList = session.createQuery("from Mark").list();

        session.getTransaction().commit();
        session.close();

        return markList;
    }

    //no read
    public List<Car> getCarList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Car.class);

        Root<Mark> root = cq.from(Car.class);

        cq.select(root);

        //этап выполнения запроса
        Query query = session.createQuery(cq);

        List<Car> bookList = query.getResultList();
        return bookList;
    }


}
