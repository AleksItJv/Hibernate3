package service;

import connector.HibernateUtil;
import dao.ClientDAO;
import entity.Client;
import org.hibernate.Session;
import java.util.List;

public class ClientHiDAO implements ClientDAO {

    @Override
    public void addClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Client getClient(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Client client = session.get(Client.class, id);

        session.close();
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Client> clientList = session.createQuery("from Client").list();

        session.getTransaction().commit();
        session.close();

        return clientList;
    }

    @Override
    public void updateClient(long id, Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Client clientEnt;
        if ((clientEnt = session.get(Client.class, id)) != null) {
            clientEnt.setName(client.getName());
            clientEnt.setAge(client.getAge());
            clientEnt.setPhone(client.getPhone());

            session.saveOrUpdate(clientEnt);
        }
        session.getTransaction().commit();
    }

    @Override
    public void deleteClient(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Client client;
        if((client = session.get(Client.class, id)) != null){
            session.delete(client);
        }
        session.getTransaction().commit();
        session.close();
    }
}
