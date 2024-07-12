/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor_academico;

/**
 *
 * @author Katherin Roca
 */
public class Gestor_academico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            // Crear instancias de Estudiante y Curso
            Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", "2000-01-01", Estudiante.Estado.MATRICULADO);
            Estudiante estudiante2 = new Estudiante(2, "Ana", "Garcia", "1999-02-02", Estudiante.Estado.MATRICULADO);

            Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas básicas", 3, "1.0");
            Curso curso2 = new Curso(2, "Historia", "Curso de historia mundial", 2, "1.0");

            // Instanciar GestorAcademico
            GestorAcademico gestor = new GestorAcademico();

            // Matricular estudiantes
            gestor.matricularEstudiante(estudiante1);
            System.out.println("Estudiante matriculado: " + estudiante1.getNombre() + " " + estudiante1.getApellido());

            gestor.matricularEstudiante(estudiante2);
            System.out.println("Estudiante matriculado: " + estudiante2.getNombre() + " " + estudiante2.getApellido());

            // Agregar cursos
            gestor.agregarCurso(curso1);
            System.out.println("Curso agregado: " + curso1.getNombre());

            gestor.agregarCurso(curso2);
            System.out.println("Curso agregado: " + curso2.getNombre());

            // Inscribir estudiantes en cursos
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            System.out.println("Estudiante " + estudiante1.getNombre() + " inscrito en el curso " + curso1.getNombre());

            gestor.inscribirEstudianteCurso(estudiante2, curso2.getId());
            System.out.println("Estudiante " + estudiante2.getNombre() + " inscrito en el curso " + curso2.getNombre());

            // Desinscribir estudiante de curso
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            System.out.println("Estudiante " + estudiante1.getNombre() + " desinscrito del curso " + curso1.getNombre());

            System.out.println("Todos los métodos funcionan según las especificaciones.");
        } catch (EstudianteYaMatriculadoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CursoYaExistenteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EstudianteYaInscritoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
