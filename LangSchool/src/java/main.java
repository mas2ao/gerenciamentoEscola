
import com.entity.Professor;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class main {
    public static void main(String[] args) {
        
        EntityPersist ep = new EntityPersist();
        Professor p = new Professor("Carlos", "c@a.com", "932889983");
        try {
            ep.save(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      
    }
}
