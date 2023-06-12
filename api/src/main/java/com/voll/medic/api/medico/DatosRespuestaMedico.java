package com.voll.medic.api.medico;

import com.voll.medic.api.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id,
                                   String nombre,
                                   String email,
                                   String documento,
                                   String telefono,
                                   Especialidades especialidad,
                                   DatosDireccion datosDireccion
) {
}
