package com.dominar01.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    
    @Id
    private Integer idCategory;

    @Column(name = "category_name", length = 50, nullable = false)
    private String name;
    
}
