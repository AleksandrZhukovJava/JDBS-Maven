
import org.hibernate.Session;

public class Application {
    public static Session session = HibernateSessionUtil.getSessionFactory().openSession();


    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
            //даже не знаю что сюда писать теперь когда тесты есть
    }
}
