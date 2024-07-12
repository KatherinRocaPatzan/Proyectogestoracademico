package gestor_academico;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.estudiantesPorCurso = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaMatriculadoException {
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteYaMatriculadoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) throws CursoYaExistenteException {
        if (cursos.contains(curso)) {
            throw new CursoYaExistenteException("El curso ya existe.");
        }
        cursos.add(curso);
        estudiantesPorCurso.put(curso.getId(), new ArrayList<>());
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> listaEstudiantes = estudiantesPorCurso.get(idCurso);
        if (listaEstudiantes == null) {
            throw new IllegalArgumentException("Curso no encontrado.");
        }
        if (listaEstudiantes.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        listaEstudiantes.add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> listaEstudiantes = estudiantesPorCurso.get(idCurso);
        if (listaEstudiantes == null) {
            throw new IllegalArgumentException("Curso no encontrado.");
        }
        boolean removed = listaEstudiantes.removeIf(e -> e.getId() == idEstudiante);
        if (!removed) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
    }
}