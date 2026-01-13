package com.vitalclinic.vitalclinic.config;

import com.vitalclinic.vitalclinic.entity.Odontologo;
import com.vitalclinic.vitalclinic.entity.Paciente;
import com.vitalclinic.vitalclinic.entity.Turno;
import com.vitalclinic.vitalclinic.repository.OdontologoRepository;
import com.vitalclinic.vitalclinic.repository.PacienteRepository;
import com.vitalclinic.vitalclinic.repository.TurnoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final PacienteRepository pacienteRepository;
    private final OdontologoRepository odontologoRepository;
    private final TurnoRepository turnoRepository;

    public DataLoader(PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository, TurnoRepository turnoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
        this.turnoRepository = turnoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // cargamos datos si la base de datos esta vacia
        if (odontologoRepository.count() == 0) {
            
            // 1. Crear Odontólogo
            Odontologo o1 = new Odontologo("Pedro", "Gomez", "MP-9988");
            odontologoRepository.save(o1);

            // 2. Crear Paciente
            Paciente p1 = new Paciente("Lucia", "Martinez", "33445566", LocalDate.now());
            pacienteRepository.save(p1);

            // 3. Crear Turnos
            Turno t1 = new Turno(p1, o1, LocalDateTime.now().plusDays(1).withHour(10).withMinute(0)); // Mañana 10 AM
            Turno t2 = new Turno(p1, o1, LocalDateTime.now().plusDays(2).withHour(15).withMinute(30)); // Pasado mañana 15:30 PM
            
            turnoRepository.save(t1);
            turnoRepository.save(t2);

            System.out.println("DATOS DE PRUEBA CARGADOS: 1 Paciente, 1 Odontólogo, 2 Turnos.");
        }
    }
}