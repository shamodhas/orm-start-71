import config.FactoryConfiguration;
import entity.Customer;
import entity.CustomerFullName;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
    private static FactoryConfiguration factory;

    public static void main(String[] args) {
        factory = FactoryConfiguration.getInstance();

        CustomerFullName customerFullName = new CustomerFullName("John", "Doe");
        Customer customer1 = new Customer(9, customerFullName, "grace@gmail.com", "0777777777", "987654678908765", "");
//        Customer customer2 = new Customer(2, "Alice", "alice@gmail.com", "0777777777");
//        Customer customer3 = new Customer(3, "John", "john@gmail.com", "0777777777");
//        Customer customer4 = new Customer(4, "Eva", "eva@gmail.com", "0777777777");
//        Customer customer5 = new Customer(5, "Bob", "bob@gmail.com", "0777777777");
//
        saveCustomer(customer1);
//        saveCustomer(customer2);
//        saveCustomer(customer3);
//        saveCustomer(customer4);
//        saveCustomer(customer5);

//        Customer customerById = getCustomerById(1);
//        System.out.println(customerById);

//        deleteCustomer(9);

//        updateCustomer(5, new Customer(
//                5,
//                "hello",
//                "hello@gmail.com",
//                "0888888888"
//        ));
//        List<Customer> allCustomer = getAllCustomer();
//        for (Customer customer : allCustomer) {
//            System.out.println(customer);
//        }
    }

    public static List<Customer> getAllCustomer() {
        Session session = factory.getSession();

        // HQL - Hibernate Query Language
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
        session.close();
        return customers;
    }

    public static boolean updateCustomer(int id, Customer newCustomerData) {
        Session session = factory.getSession();
        try {
            Customer customerById = session.get(Customer.class, id);
            Transaction transaction = session.beginTransaction();

            customerById.setName(newCustomerData.getName());
            customerById.setEmail(newCustomerData.getEmail());
            customerById.setPhone(newCustomerData.getPhone());
//            session.update(newCustomerData); don't use
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail to update customer");
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean deleteCustomer(int id) {
        Session session = factory.getSession();
        try {
            // id 5 item
            // id 5 customer
            Customer customerById = getCustomerById(id);
            Transaction transaction = session.beginTransaction();
            session.delete(customerById);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Customer not found");
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static Customer getCustomerById(int id) {
        Session session = factory.getSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public static boolean saveCustomer(Customer customer) {
        Session session = factory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}














