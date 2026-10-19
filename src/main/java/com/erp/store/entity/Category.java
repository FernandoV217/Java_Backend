package com.erp.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "Categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoryID;
    @Column(name = "CategoryName")
    private String CategoryName;
    @Lob
    @Column(name = "Description", columnDefinition = "ntext")
    private String Description;
    @Lob
    @Column(name = "Picture", columnDefinition = "image")
    private byte[] Picture;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> product;
}
