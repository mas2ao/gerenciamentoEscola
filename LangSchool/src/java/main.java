
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class main {
    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session sessao = factory.openSession();
        sessao.close();
    }
}
