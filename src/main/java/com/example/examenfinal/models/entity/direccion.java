package com.example.examenfinal.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "direccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class direccion implements Serializable {
    private static final long serialVerisionUID= 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombreCompleto;

    @NotEmpty
    private String direccionLinea1;

    private String direccionLinea2;

    @NotEmpty
    private String ciudad;

    @NotEmpty
    private String estado;

    @NotEmpty
    private String codigoZip;

}