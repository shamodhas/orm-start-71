package entity;

import javax.persistence.Embeddable;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/5/2025 2:39 PM
 * Project: Hibernate-Start
 * --------------------------------------------
 **/

@Embeddable
public class CustomerFullName {
    private String firstName;
    private String lastName;

    public CustomerFullName() {
    }

    public CustomerFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
