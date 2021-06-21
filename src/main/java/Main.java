import connector.HibernateUtil;
import dao.CarDAO;
import dao.ClientDAO;
import dao.IDAOFactory;
import dao.MarkDAO;
import entity.Car;
import entity.Client;
import entity.Mark;
import service.DAOFactory;
import service.MarkHiDAO;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        IDAOFactory factory = DAOFactory.getInstance();
        CarDAO carDAO = factory.getCarDAO();
        ClientDAO clientDAO = factory.getClientDAO();
        MarkDAO markDAO = factory.getMarkDAO();

/*        //---getAllClient---
        for (Client clientLoop : clientDAO.getAllClients()) {
            System.out.println(clientLoop);
        }*/

        //---addClient---
/*        Client client = new Client();
        client.setName("Jacob");
        client.setAge(20);
        client.setPhone("103");
        clientDAO.addClient(client);*/
/*
        //---updateClient age by ID
        Client clientNew = new Client("Fank", 20, "102");

        clientDAO.updateClient(2, clientNew);

        //---getClient by ID---
        System.out.println(clientDAO.getClient(1));

        //---deleteClient by ID
        clientDAO.deleteClient(11);

        //---getAllClient---
        for (Client clientLoop : clientDAO.getAllClients()) {
            System.out.println(clientLoop);
        }*/

        Mark mark1 = new Mark("Audi", "A5", "12000");
        Mark mark2 = new Mark("BMW", "X5", "15000");
        Mark mark3 = new Mark("Lamba", "L13", "35000");
        markDAO.add(mark1);
        markDAO.add(mark2);
        markDAO.add(mark3);

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Car car4 = new Car(1);
        Car car5 = new Car(2);
        carDAO.add(car1);
        carDAO.add(car2);
        carDAO.add(car3);
        carDAO.add(car4);
        carDAO.add(car5);

        for(Car c : carDAO.getAll()){
            System.out.println(c);
        }

        //Car carNew = new Car(1);
        //carDAO.updateCar(1, carNew);
        //carDAO.removeCar(2);

        for(Car c : carDAO.getAll()){
            System.out.println("Car{" +
                    "id=" + c.getId() +
                    ", mark=" + c.getMark().getMark() +
                    ", model=" + c.getMark().getModel() +
                    ", price=" + c.getMark().getPrice() +
                    '}');
        }

        HibernateUtil.shutdown();

    }

}
