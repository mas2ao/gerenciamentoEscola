
import com.entity.Aluno;
import com.entity.Curso;
import com.entity.Matricula;
import com.entity.Nivel;
import com.entity.Nota;
import com.entity.Presenca;
import com.entity.Professor;
import com.entity.Turma;
import com.persist.EntityPersist;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.util.CriteriaGroup;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class main {
    public static void main(String[] args) {
        
        EntityPersist ep = new EntityPersist();
        try {
            //Alunos
            ep.save(new Aluno("marcos", new Date(1993, 02, 17), "111111111",
                    "13", "rua 11111 -111", "PR", "Maringa", 'M'));
            ep.save(new Aluno("lucas", new Date(1993, 02, 17), "222222222",
                    "29", "rua 22222 -22", "PR", "Astorga", 'F'));
            ep.save(new Aluno("alexandre", new Date(1993, 02, 17), "33333333",
                    "2", "rua 3333 3-333", "PR", "Arapongas", 'M'));
            ep.save(new Aluno("marco", new Date(1993, 02, 17), "4444444444",
                    "29", "rua 444444- -444", "PR", "Campo Mourao", 'M'));
            ep.save(new Aluno("william", new Date(1993, 02, 17), "5555555555",
                    "37", "rua 55555 -555", "PR", "Foz do Iguacu", 'M'));
            //Cursos
            ep.save(new Curso("Japones", "Um curso para o aprendizado de japones."));
            ep.save(new Curso("Ingles", "Um curso para o aprendizado de ingles."));
            ep.save(new Curso("Espanhol", "Um curso para o aprendizado de espanhol."));
            //Nivel
            ep.save(new Nivel("Japones I", "Curso basico de japones", 30, 
                    (Curso) ep.search(Curso.class, new CriteriaGroup("eq", "nome", "Japones", null)).get(0)));
            ep.save(new Nivel("Ingles I", "Curso basico de ingles", 30, 
                    (Curso) ep.search(Curso.class, new CriteriaGroup("eq", "nome", "Espanhol", null)).get(0)));
            ep.save(new Nivel("Espanhol I", "Curso basico de espanhol", 30, 
                    (Curso) ep.search(Curso.class, new CriteriaGroup("eq", "nome", "Ingles", null)).get(0)));
            //Professor
            ep.save(new Professor("Jose", "jose@algumacoisa.com", "999999999"));
            ep.save(new Professor("Makoto", "makoto@outracoisa.com", "888888888"));
            ep.save(new Professor("Smith", "smith@algumaoutracoisa.com", "777777777"));
            //Turmas
            ep.save(new Turma((Professor)ep.search(Professor.class, new CriteriaGroup("eq", "nome", "Makoto", null)).get(0), 
                    (Nivel)ep.search(Nivel.class, new CriteriaGroup("eq", "nome", "Japones I", null)).get(0), 
                    "Turma Japones Basico", "Turma de Japones basico", 30));
            ep.save(new Turma((Professor)ep.search(Professor.class, new CriteriaGroup("eq", "nome", "Jose", null)).get(0), 
                    (Nivel)ep.search(Nivel.class, new CriteriaGroup("eq", "nome", "Espanhol I", null)).get(0), 
                    "Turma Espanhol Basico", "Turma de Espanhol basico", 30));
            ep.save(new Turma((Professor)ep.search(Professor.class, new CriteriaGroup("eq", "nome", "Smith", null)).get(0), 
                    (Nivel)ep.search(Nivel.class, new CriteriaGroup("eq", "nome", "Ingles I", null)).get(0), 
                    "Turma Ingles Basico", "Turma de Ingles basico", 30));
            //Matricula
            ep.save(new Matricula((Aluno)ep.search(Aluno.class, new CriteriaGroup("eq", "nome", "marcos", null)).get(0), 
                    (Turma)ep.search(Turma.class, new CriteriaGroup("eq", "turma", "Turma Japones Basico", null)).get(0), new Date()));
            ep.save(new Matricula((Aluno)ep.search(Aluno.class, new CriteriaGroup("eq", "nome", "marcos", null)).get(0), 
                    (Turma)ep.search(Turma.class, new CriteriaGroup("eq", "turma", "Turma Ingles Basico", null)).get(0), new Date()));
            ep.save(new Matricula((Aluno)ep.search(Aluno.class, new CriteriaGroup("eq", "nome", "lucas", null)).get(0), 
                    (Turma)ep.search(Turma.class, new CriteriaGroup("eq", "turma", "Turma Espanhol Basico", null)).get(0), new Date()));
            ep.save(new Matricula((Aluno)ep.search(Aluno.class, new CriteriaGroup("eq", "nome", "marcos", null)).get(0), 
                    (Turma)ep.search(Turma.class, new CriteriaGroup("eq", "turma", "Turma Espanhol Basico", null)).get(0), new Date()));
            //Notas
            Nota nota = new Nota(10, 20, 30, 40);
            Matricula mat = ((Matricula)ep.search(Matricula.class, new CriteriaGroup("eq", "id", 1, null)).get(0));
            ep.save(nota);
            mat.setNotas((Nota)ep.search(Nota.class, new CriteriaGroup("eq", "id", 1, null)).get(0));
            ep.update(mat);
            nota = new Nota(50, 60, 70, 80);
            mat = ((Matricula)ep.search(Matricula.class, new CriteriaGroup("eq", "id", 2, null)).get(0));
            ep.save(nota);
            mat.setNotas((Nota)ep.search(Nota.class, new CriteriaGroup("eq", "id", 2, null)).get(0));
            ep.update(mat);
            nota = new Nota(90, 90, 90, 90);
            mat = ((Matricula)ep.search(Matricula.class, new CriteriaGroup("eq", "id", 3, null)).get(0));
            ep.save(nota);
            mat.setNotas((Nota)ep.search(Nota.class, new CriteriaGroup("eq", "id", 3, null)).get(0));
            ep.update(mat);
            nota = new Nota(30, 30, 30, 30);
            mat = ((Matricula)ep.search(Matricula.class, new CriteriaGroup("eq", "id", 4, null)).get(0));
            ep.save(nota);
            mat.setNotas((Nota)ep.search(Nota.class, new CriteriaGroup("eq", "id", 4, null)).get(0));
            ep.update(mat);
            
            //Presenca
            Date dat = new Date();
            Presenca presen = new Presenca();
            presen.setEstado(false);
            presen.setDia(dat);
            presen.setMatricula(mat);
            ep.save(presen);
            
                    
            //---------------------------------------------
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
