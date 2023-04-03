package com.bumblebee.project.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class Users implements java.io.Serializable, UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USERNAME", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "STATUS", length = 100)
    private String status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USERROLE", referencedColumnName = "USERROLECODE")
    @JsonIgnore
    private com.bumblebee.project.model.Userrole userrole;

    @Column(name = "PASSWORD", length = 100)
    @JsonIgnore
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LASTUPDATEDTIME", nullable = false, length = 19)
    @UpdateTimestamp
    private Date lastupdatedtime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDTIME", nullable = false, length = 19, updatable = false)
    @CreationTimestamp
    private Date createdtime;

    public Users(String username, String status, com.bumblebee.project.model.Userrole userrole, String password, String fullname) {
        this.username = username;
        this.status = status;
        this.userrole = userrole;
        this.password = password;
    }

    //    TODO : validate this
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //    TODO : validate this
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //    TODO : validate this
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //    TODO : validate this
    @Override
    public boolean isEnabled() {
        return true;
    }

    //    TODO : validate this
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.userrole.getUserrolecode()));
    }
}
