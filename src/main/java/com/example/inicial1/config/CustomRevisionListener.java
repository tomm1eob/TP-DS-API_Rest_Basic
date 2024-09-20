package com.example.inicial1.config;

import com.example.inicial1.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

// Implementa la interfaz RevisionListener para manejar eventos de auditoría.
public class CustomRevisionListener implements RevisionListener {

    // Este metodo se invoca cada vez que se crea una nueva revisión.
    public void newRevision(Object revisionEntity) {
        // Convierte el objeto revisionEntity a una instancia de la clase Revision.
        final Revision revision = (Revision) revisionEntity;
        // Aquí podrías agregar lógica personalizada, como asignar valores adicionales a la revisión.
        // Por ejemplo, podrías registrar el usuario que realizó el cambio:
        // revision.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
