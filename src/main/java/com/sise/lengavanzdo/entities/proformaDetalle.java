package com.sise.lengavanzdo.entities;

import com.sise.lengavanzdo.shared.BaseEntity;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="proforma_datalles")
public class proformaDetalle extends BaseEntity {
    @Id
    @Column(name = "id_proforma_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProformaDetalle;

    @ManyToOne
    @JoinColumn(name = "id_proforma")
    private proforma proforma;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_unitario")
    private Float precioUnitario;
}
