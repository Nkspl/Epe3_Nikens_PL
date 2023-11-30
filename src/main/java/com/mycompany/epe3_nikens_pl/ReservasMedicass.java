
package com.mycompany.epe3_nikens_pl;



class ReservasMedicass {
    private String nombreMedico;
    private String nombrePaciente;
    private String especialidad;
    private String hora;
    private double valorHora;

    public ReservasMedicass(String nombreMedico, String nombrePaciente, String especialidad, String hora, double valorHora) {
        this.nombreMedico = nombreMedico;
        this.nombrePaciente = nombrePaciente;
        this.especialidad = especialidad;
        this.hora = hora;
        this.valorHora = valorHora;
    }

    
     // Métodos getter
    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getHora() {
        return hora;
    }

    public double getValorHora() {
        return valorHora;
    }
    
    
    @Override
    public String toString() {
        return "Médico: " + nombreMedico + ", Paciente: " + nombrePaciente + ", Especialidad: " + especialidad + ", Hora: " + hora + ", Valor: " + valorHora;
    }
}