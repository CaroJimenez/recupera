package mx.edu.utez.recupera4b.model.estudiante;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanEstudiante {
    private long id_estudiante;
    private String nombre;
    private String apellidos;
    private String fecha_nac;
    private String curp;
    private String matricula;

    public long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
