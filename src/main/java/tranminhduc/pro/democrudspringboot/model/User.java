package tranminhduc.pro.democrudspringboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String address;
    private String Age;
    public User(){

    }
    public User(Long id, String name, String email, String address, String Age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.Age = Age;
    }

    public Long getId() {
        return id;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

  