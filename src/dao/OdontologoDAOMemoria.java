package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOMemoria implements iDao<Odontologo>{
    private static final Logger logger=Logger.getLogger(OdontologoDAOH2.class);
    private static List<Odontologo> listadoOdontologosMemoria=new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando en memoria odontologo");
        this.listadoOdontologosMemoria.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }
    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Buscando en memoria odontologos");
        return this.listadoOdontologosMemoria;
    }
}
