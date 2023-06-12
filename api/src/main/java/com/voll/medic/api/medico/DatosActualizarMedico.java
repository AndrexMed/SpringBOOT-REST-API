package com.voll.medic.api.medico;

import com.voll.medic.api.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull Long id,
                                    String nombre,
                                    String documento,
                                    DatosDireccion direccion) {
}
