package mx.edu.utez.recupera4b.model.evaluaciones;

import mx.edu.utez.recupera4b.model.Repository;
import mx.edu.utez.recupera4b.model.estudiante.BeanEstudiante;
import mx.edu.utez.recupera4b.utils.MySQLConnection;
import mx.edu.utez.recupera4b.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEvaluaciones implements Repository<BeanEvaluaciones> {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanEvaluaciones> findAll() {

        List<BeanEvaluaciones> calificaciones = new ArrayList<>();
        BeanEvaluaciones calificacion = null;
        BeanEstudiante estudiante = null;
        try{
            conn = client.getConnection();
            String query = "SELECT evaluaciones.*, estudiantes.* FROM evaluaciones INNER JOIN estudiantes ON evaluaciones.id_est=estudiantes.id_estudiante;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                calificacion = new BeanEvaluaciones();
                estudiante = new BeanEstudiante();
                calificacion.setId_evaluacion(rs.getLong("id_evaluacion"));
                calificacion.setMateria(rs.getString("materia"));
                calificacion.setCalificacion(rs.getString("calificacion"));
                calificacion.setId_estudiante(estudiante);
                estudiante.setId_estudiante(rs.getLong("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setFecha_nac(rs.getString("fecha_nac"));
                estudiante.setCurp(rs.getString("curp"));
                estudiante.setMatricula(rs.getString("matricula"));
                calificaciones.add(calificacion);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoEvaluaciones.class.getName())
                    .log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        }finally {
            client.close(conn,ps,rs);
        }
        return calificaciones;
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
