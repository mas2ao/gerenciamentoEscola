
import com.entity.Aluno;
import com.entity.Curso;
import com.entity.Professor;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
