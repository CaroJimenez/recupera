package mx.edu.utez.recupera4b.model.evaluaciones;

import mx.edu.utez.recupera4b.model.estudiante.BeanEstudiante;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanEvaluaciones {
    private long id_evaluacion;
    private String materia;
    private String calificacion;
    BeanEstudiante id_estudiante;

    public long getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(long id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public BeanEstudiante getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(BeanEstudiante id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
