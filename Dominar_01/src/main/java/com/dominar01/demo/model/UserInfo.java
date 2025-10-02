package com.dominar01.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class UserInfo {
    @Id
    private Integer iduser;

    @Column(nullable = false, unique = true,length = 50)
    private String username;

    @Column(nullable = false,length = 70)
    private String password;

    @Column(nullable = false,length = 20)
    private String role;
    
}
