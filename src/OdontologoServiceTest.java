import dao.BD;

import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoServiceTest {
    OdontologoService os=new OdontologoService();
    @Test
    public void buscarOdontologos(){
        BD.crearTablas();
        List<Odontologo> listaOdontologos=os.buscarOdontologos();
        Assertions.assertTrue(listaOdontologos.size()>0);
    }

    @Test
    public void crearOdontologo(){
        BD.crearTablas();
        Odontologo odontologo=new Odontologo(123124,"Fulanito","Detal");
        Odontologo odontologoCreado=os.crearOdontologos(odontologo);
        Assertions.assertTrue(odontologoCreado !=null);
    }
    @Test
    public void crearOdontologoMemoria(){
        BD.crearTablas();
        Odontologo odontologo=new Odontologo(123124,"Fulanito2","Detal2");
        Odontologo odontologoCreado=os.crearOdontologosMemoria(odontologo);
        Assertions.assertTrue(odontologoCreado !=null);
    }
    @Test
    public void buscarOdontologosMemoria(){
        List<Odontologo> listaOdontologos=os.buscarOdontologosMemoria();
        Assertions.assertTrue(listaOdontologos.size()>0);
    }
}
