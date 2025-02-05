import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/5/2025 10:59 AM
 * Project: Hibernate-Start
 * --------------------------------------------
 **/

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Alice", "alice@example.com", "0777777777");

//       save customer
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Fail to save customer");
        }
    }
}














