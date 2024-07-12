package gestor_academico;

public class CursoYaExistenteException extends Exception {
    public CursoYaExistenteException(String message) {
        super(message);
    }
}