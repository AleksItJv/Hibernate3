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
        markDAO.add(mark1);
        markDAO.add(mark2);

        Car car1 = new Car(1);
        Car car2 = new Car(2);
        car1.setMark(mark1);
        car2.setMark(mark2);
        carDAO.add(car1);
        carDAO.add(car2);


        for(Car c : carDAO.getAll()){
            System.out.println(c);
        }

        //Car carNew = new Car(1);
        //carDAO.updateCar(1, carNew);
        //carDAO.removeCar(2);

        for(Car c : carDAO.getAll()){
            System.out.println("id:" + c.getId() + " markId:" + c.getMarkId() + " " + c.getMark());
        }

/*        MarkHiDAO markHiDAO = new MarkHiDAO();
        List<Car> markCars = markHiDAO.getCarList();

        for (Car m : markCars) {
            System.out.println(m.getMark().getPrice());
        }*/

        HibernateUtil.shutdown();

    }

}
