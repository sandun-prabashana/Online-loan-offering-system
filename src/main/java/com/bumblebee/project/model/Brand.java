package com.bumblebee.project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    private String brandName;

    private String status;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column( nullable = false, length = 19)
//    @UpdateTimestamp
//    private Date lastupdatedtime;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false, length = 19, updatable = false)
//    @CreationTimestamp
//    private Date createdtime;

}
