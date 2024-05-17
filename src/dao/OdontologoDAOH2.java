package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{

    private static final Logger logger=Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_CREATE_ONE="INSERT INTO ODONTOLOGOS (NUMERO_MATRICULA, NOMBRE, APELLIDO) "+
            "VALUES (?,?,?)";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Iniciando la operación de creación");
        Connection connection=null;
        try{
            connection=BD.getConnection();
            Statement statement=connection.createStatement();
            PreparedStatement psCreate= connection.prepareStatement(SQL_CREATE_ONE);
            psCreate.setInt(1,odontologo.getNumeroMatricula());
            psCreate.setString(2,odontologo.getNombre());
            psCreate.setString(3,odontologo.getApellido());

            psCreate.execute();

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            }
            catch (Exception e){
                logger.error(e.getMessage());
            }
        }

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
    public void actualizar(Odontologo odontologos) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Iniciando la operación de busqueda");
        Connection connection=null;

        List<Odontologo> listadoOdontologos= new ArrayList<>();

        try{
            connection=BD.getConnection();
            Statement statement=connection.createStatement();
            PreparedStatement psSelectAll= connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs=psSelectAll.executeQuery();

            while(rs.next()){
            listadoOdontologos.add(new Odontologo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            }
            catch (Exception e){
                logger.error(e.getMessage());
            }
        }
        return listadoOdontologos;
    }

}
