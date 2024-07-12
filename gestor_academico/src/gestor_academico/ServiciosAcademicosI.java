package gestor_academico;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteYaMatriculadoException;
    void agregarCurso(Curso curso) throws CursoYaExistenteException;
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
