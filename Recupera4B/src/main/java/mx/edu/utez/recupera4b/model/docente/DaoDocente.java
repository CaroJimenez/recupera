package mx.edu.utez.recupera4b.model.docente;

import mx.edu.utez.recupera4b.model.Repository;
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

public class DaoDocente implements Repository<BeanDocente> {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanDocente> findAll() {
        List<BeanDocente> docentes = new ArrayList<>();
        BeanDocente docente = null;

        try {
            conn = client.getConnection();
                String query = "SELECT * FROM docentes;";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()){
                    docente = new BeanDocente();
                        docente.setId_docente(rs.getLong("id_docente"));
                        docente.setNombre(rs.getString("nombre"));
                        docente.setApellidos(rs.getString("apellidos"));
                        docente.setFecha_nac(rs.getString("fecha_nac"));
                        docente.setCurp(rs.getString("curp"));
                        docente.setNum_empleado(rs.getString("num_empleado"));

                        docentes.add(docente);
                }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        }finally {
            client.close(conn,ps,rs);
        }
        return docentes;
        }

    @Override
    public BeanDocente findById(Long id) {
        return null;
    }

    @Override
    public Response<BeanDocente> save(BeanDocente docente) {
        try {
            conn = client.getConnection();
            String query = "INSERT INTO docentes (nombre,apellidos,fecha_nac,curp,num_empleado)VALUES(?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1,docente.getNombre());
            ps.setString(2,docente.getApellidos());
            ps.setString(3, docente.getFecha_nac());
            ps.setString(4,docente.getCurp());
            ps.setString(5,docente.getNum_empleado());

            if (ps.executeUpdate() == 1){
                return new Response<>(200,"Registrado correctamente", docente, false);
            }else{
                return new Response<>(200,"Error al registrar",docente,true);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> save: " + e.getMessage());
            return new Response<>(400, "Error con el servidor", null, true);
        } finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public Response<BeanDocente> update(BeanDocente docente) {
        try{
            conn = client.getConnection();
            String query = "UPDATE docentes set nombre= ?, apellidos=?, fecha_nac=?, curp=?,num_empleado=? WHERE id_docente=?;";
            ps = conn.prepareStatement(query);
            ps.setString(1,docente.getNombre());
            ps.setString(2,docente.getApellidos());
            ps.setString(3,docente.getFecha_nac());
            ps.setString(4,docente.getCurp());
            ps.setString(5, docente.getNum_empleado());
            ps.setLong(6,docente.getId_docente());

            if (ps.executeUpdate() == 1){
                return new Response<>(200,"Actualizado correctamente", docente, false);
            }else{
                return new Response<>(400,"Error al registrar",docente,true);
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
    public Response<BeanDocente> remove(Long id) {
        return null;
    }
}
