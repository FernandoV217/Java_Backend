package com.erp.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductID;
    @Column(name = "ProductName", length = 80)
    private String ProductName;
    @Column(name = "SupplierID")
    private int SupplierID;
    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private Category category;
    @Column(name = "QuantityPerUnit", length = 40)
    private String QuantityPerUnit;
    @Column(name = "UnitPrice", precision = 19, scale = 4)
    private BigDecimal UnitPrice;
    @Column(name = "UnitsInStock")
    private short UnitsInStock;
    @Column(name = "UnitsOnOrder")
    private short UnitsOnOrder;
    @Column(name = "ReorderLevel")
    private short ReorderLevel;
    @Column(name = "Discontinued")
    private boolean Discontinued;
}
