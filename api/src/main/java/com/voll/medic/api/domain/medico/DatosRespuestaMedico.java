package com.voll.medic.api.domain.medico;

import com.voll.medic.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id,
                                   String nombre,
                                   String email,
                                   String documento,
                                   String telefono,
                                   Especialidades especialidad,
                                   DatosDireccion datosDireccion
) {
}
