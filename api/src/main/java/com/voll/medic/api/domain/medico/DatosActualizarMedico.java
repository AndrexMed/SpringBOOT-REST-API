package com.voll.medic.api.domain.medico;

import com.voll.medic.api.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id,
                                    String nombre,
                                    String documento,
                                    DatosDireccion direccion) {
}
