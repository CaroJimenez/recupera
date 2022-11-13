package mx.edu.utez.recupera4b.model;

import mx.edu.utez.recupera4b.model.evaluaciones.BeanEvaluaciones;
import mx.edu.utez.recupera4b.utils.MySQLConnection;
import mx.edu.utez.recupera4b.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class DaoPromedio implements Repository<BeanEvaluaciones> {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanEvaluaciones> findAll() {
/*
        List<BeanEvaluaciones> calificaciones = new ArrayList<>();
        try{
            conn = client.getConnection();
            String query = "SELECT AVG(calificacion) from evaluaciones;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        }catch (SQLException e){
            Logger.getLogger(DaoEvaluaciones.class.getName())
                    .log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        }finally {
            client.close(conn,ps,rs);
        }
        return calificaciones;*/
        return null;
    }

    @Override
    public BeanEvaluaciones findById(Long id) {
        return null;
    }

    @Override
    public Response<BeanEvaluaciones> save(BeanEvaluaciones object) {
        return null;
    }

    @Override
    public Response<BeanEvaluaciones> update(BeanEvaluaciones object) {
        return null;
    }

    @Override
    public Response<BeanEvaluaciones> remove(Long id) {
        return null;
    }
}
