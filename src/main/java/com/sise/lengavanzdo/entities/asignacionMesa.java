package com.sise.lengavanzdo.entities;
import com.sise.lengavanzdo.shared.BaseEntity;
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
@Table(name="asignacion_mesas")
public class asignacionMesa extends BaseEntity{
    @Id
    @Column(name = "id_asignacion_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsisgnacionMesa;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private ususario usuario;

    @Column(name = "turno")
    private String turno;
}
