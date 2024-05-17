package service;
import dao.OdontologoDAOH2;
import dao.OdontologoDAOMemoria;
import dao.iDao;
import model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;
    private iDao<Odontologo> odontologoiDaoMemoria;
    public OdontologoService() {
        odontologoiDao=new OdontologoDAOH2();
        odontologoiDaoMemoria=new OdontologoDAOMemoria();
    }
    public List<Odontologo> buscarOdontologos(){
        return odontologoiDao.buscarTodos();
    }
    public Odontologo crearOdontologos(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }
    public Odontologo crearOdontologosMemoria(Odontologo odontologo){
        return odontologoiDaoMemoria.guardar(odontologo);
    }
    public List<Odontologo> buscarOdontologosMemoria(){
        return odontologoiDaoMemoria.buscarTodos();
    }
}
