package dao;

public interface IDAOFactory {

    CarDAO getCarDAO();

    ClientDAO getClientDAO();

    MarkDAO getMarkDAO();
}