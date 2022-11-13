package mx.edu.utez.recupera4b.model.estudiante;

import mx.edu.utez.recupera4b.model.Repository;
import mx.edu.utez.recupera4b.model.docente.BeanDocente;
import mx.edu.utez.recupera4b.model.docente.DaoDocente;
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

public class DaoEstudiante implements Repository<BeanEstudiante> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanEstudiante> findAll() {
        List<BeanEstudiante> estudiantes = new ArrayList<>();
        BeanEstudiante estudiante= null;
        try{
            conn = client.getConnection();
            String query = "SELECT * FROM estudiantes;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                estudiante = new BeanEstudiante();
                estudiante.setId_estudiante(rs.getLong("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setFecha_nac(rs.getString("fecha_nac"));
                estudiante.setCurp(rs.getString("curp"));
                estudiante.setMatricula(rs.getString("matricula"));

                estudiantes.add(estudiante);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        }finally {
            client.close(conn,ps,rs);
        }
        return estudiantes;
    }

    @Override
    public BeanEstudiante findById(Long id) {
        return null;
    }

    @Override
    public Response<BeanEstudiante> save(BeanEstudiante estudiante) {
        try{
            conn = client.getConnection();
            String query = "INSERT INTO estudiantes (nombre,apellidos,fecha_nac,curp,matricula)VALUES(?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellidos());
            ps.setString(3, estudiante.getFecha_nac());
            ps.setString(4,estudiante.getCurp());
            ps.setString(5,estudiante.getMatricula());

            if (ps.executeUpdate() == 1){
                return new Response<>(200,"Registrado correctamente", estudiante, false);
            }else{
                return new Response<>(200,"Error al registrar",estudiante,true);
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> save: " + e.getMessage());
            return new Response<>(400, "Error con el servidor", null, true);
        } finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public Response<BeanEstudiante> update(BeanEstudiante estudiante) {
        try{
            conn = client.getConnection();
            String query = "UPDATE estudiantes set nombre= ?, apellidos=?, fecha_nac=?, curp=?,matricula=? WHERE id_estudiante=?;";
            ps = conn.prepareStatement(query);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellidos());
            ps.setString(3,estudiante.getFecha_nac());
            ps.setString(4,estudiante.getCurp());
            ps.setString(5,estudiante.getMatricula());
            ps.setLong(6,estudiante.getId_estudiante());

            if (ps.executeUpdate() == 1){
                return new Response<>(200,"Actualizado correctamente", estudiante, false);
            }else{
                return new Response<>(400,"Error al registrar",estudiante,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> save: "+e.getMessage());
            return new Response<>(400, "Error con el servidor", null, true);
        }finally {
            client.close(conn,ps,rs);
        }
    }

    @Override
    public Response<BeanEstudiante> remove(Long id) {
        return null;
    }
}
