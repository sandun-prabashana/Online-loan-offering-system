package com.bumblebee.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userrole")
public class Userrole implements Serializable {

    @Id
    @Column(unique = true, nullable = false, length = 16)
    private String userrolecode;

    private String status;

    @Column( length = 64)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column( nullable = false, length = 19)
    @UpdateTimestamp
    private Date lastupdatedtime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false, length = 19)
    private Date createdtime;

//    @OneToOne(mappedBy = "userrole", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Users user;

    public Userrole(String userrolecode, String status, String description) {
        this.userrolecode = userrolecode;
        this.status = status;
        this.description = description;
    }
}
