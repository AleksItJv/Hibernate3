package service;


import connector.HibernateUtil;
import dao.CarDAO;
import entity.Car;
import entity.Client;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class CarHiDao implements CarDAO {

    @Override
    public void add(Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Car> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Car> carList = session.createQuery("from Car").list();

        session.getTransaction().commit();
        session.close();

        return carList;
    }

    @Override
    public Car getById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Car car = session.get(Car.class, id);

        session.close();
        return car;
    }

    @Override
    public void updateCar(long id, Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Car carEnt;
        if ((carEnt = session.get(Car.class, id)) != null) {
            carEnt.setMarkId(car.getMarkId());
            //carEnt.setMark(car.getMark());

            session.saveOrUpdate(carEnt);
        }
        session.getTransaction().commit();
    }

    @Override
    public void removeCar(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Car car;
        if((car = session.get(Car.class, id)) != null){
            session.delete(car);
        }
        session.getTransaction().commit();
        session.close();
    }

}
