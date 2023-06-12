package com.voll.medic.api.domain.medico;

public record DatosListadoMedico(Long id,
                                 String nombre,
                                 String especialidad,
                                 String documento,
                                 String email) {

    //Constructor
    public DatosListadoMedico(Medico medico){
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
