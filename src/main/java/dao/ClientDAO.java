package dao;

import entity.Client;
import java.util.List;

public interface ClientDAO {

    void addClient(Client client);

    Client getClient(long id);

    List<Client> getAllClients();

    void updateClient(long id, Client client);

    void deleteClient(long id);
}
