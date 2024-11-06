//package com.embarkx.firstjobapp.job;
//
//public class Job {
//    private Long id;
//    private  String title;
//    private  String description;
//    private  String minsalary;
//    private  String maxsalary;
//    private  String location;
//    public Job() {}
//    public Job(Long id, String title, String description, String minsalary, String maxsalary, String location) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.minsalary = minsalary;
//        this.maxsalary = maxsalary;
//        this.location = location;
//
//
//    }
//}
package com.embarkx.firstjobapp.job;

import com.embarkx.firstjobapp.company.Company;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minsalary;
    private String maxsalary;
    private String location;
    @ManyToOne
    private Company company;
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }




    // Default constructor (required for Spring Boot)

    // Parameterized constructor




    public Job() {

    }



    //     Getters and Setters for each field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}

