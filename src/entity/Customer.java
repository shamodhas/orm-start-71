package entity;

import javax.persistence.*;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/5/2025 10:33 AM
 * Project: Hibernate-Start
 * --------------------------------------------
 **/

@Entity
@Table(name = "customer_table") // table name
public class Customer {
    @Id // primary key
//    @GeneratedValue(strategy = GenerationType.AUTO) // - auto generate id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // - manual id
    private int id;

    @Embedded
    private CustomerFullName name; // first name, last name

    @Column(name = "customer_email", nullable = false) // Specifies name and not null
    private String email;

    private String phone;

    @Transient // non-persistent
    private String visaCardNumber;

    @Lob // storing large text or binary data
    private String description;

    public Customer() {
    }

    public Customer(int id, CustomerFullName name, String email, String phone, String visaCardNumber, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.visaCardNumber = visaCardNumber;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerFullName getName() {
        return name;
    }

    public void setName(CustomerFullName name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


















