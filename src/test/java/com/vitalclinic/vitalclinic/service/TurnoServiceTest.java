package com.vitalclinic.vitalclinic.service;

// Imports de tus entidades y repositorios
import com.vitalclinic.vitalclinic.entity.Odontologo;
import com.vitalclinic.vitalclinic.entity.Paciente;
import com.vitalclinic.vitalclinic.entity.Turno;
import com.vitalclinic.vitalclinic.repository.OdontologoRepository;
import com.vitalclinic.vitalclinic.repository.PacienteRepository;
import com.vitalclinic.vitalclinic.repository.TurnoRepository;

// Imports de Testing (JUnit 5 y Mockito)
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TurnoServiceTest {

    @Mock
    private TurnoRepository turnoRepository;
    @Mock
    private PacienteRepository pacienteRepository;
    @Mock
    private OdontologoRepository odontologoRepository;

    @InjectMocks
    private TurnoService turnoService;

    @Test
    public void registrarTurno_DatosValidos_DeberiaGuardarTurno() {
        // GIVEN
        Paciente pacienteMock = new Paciente("Thiago", "Poletti", "123456", null);
        pacienteMock.setId(1L);

        Odontologo odontologoMock = new Odontologo("Juan", "Perez", "MN-123");
        odontologoMock.setId(1L);

        Turno turnoSolicitud = new Turno(pacienteMock, odontologoMock, LocalDateTime.now().plusDays(1));

        Mockito.when(pacienteRepository.findById(1L)).thenReturn(Optional.of(pacienteMock));
        Mockito.when(odontologoRepository.findById(1L)).thenReturn(Optional.of(odontologoMock));
        Mockito.when(turnoRepository.save(Mockito.any(Turno.class))).thenReturn(turnoSolicitud);

        // WHEN
        Turno resultado = turnoService.registrarTurno(turnoSolicitud);

        // THEN
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Thiago", resultado.getPaciente().getNombre());
    }

    @Test
    public void registrarTurno_FechaPasada_DeberiaLanzarExcepcion() {
        Turno turnoInvalido = new Turno(new Paciente(), new Odontologo(), LocalDateTime.now().minusDays(1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            turnoService.registrarTurno(turnoInvalido);
        });
    }
}