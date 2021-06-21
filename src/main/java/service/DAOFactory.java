package service;

import dao.CarDAO;
import dao.ClientDAO;
import dao.IDAOFactory;
import dao.MarkDAO;

public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory;

    private DAOFactory() {

    }

    public static synchronized IDAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }

        return factory;
    }

    @Override
    public CarDAO getCarDAO() {
        return new CarHiDao();
    }

    @Override
    public ClientDAO getClientDAO() {
        return new ClientHiDAO();
    }

    @Override
    public MarkDAO getMarkDAO() {
        return new MarkHiDAO();
    }

}
