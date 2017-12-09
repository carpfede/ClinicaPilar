package presentacion.vista;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import dominio.entidades.EEspecialidades;
import dominio.entidades.turnos.Medico;
import dominio.entidades.pacientes.Paciente;
import dominio.entidades.turnos.Turno;
import presentacion.interfaces.AsignarTurno;
import presentacion.presentador.AsignarTurnoPresentador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Date;

public class NuevaAsignacionDeTurnoView extends javax.swing.JFrame implements AsignarTurno {

    public AsignarTurnoPresentador presentador;
    private Paciente paciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<EEspecialidades> cbEspecialidad;
    private javax.swing.JComboBox<Turno> cbTurnos;
    private javax.swing.JComboBox<Medico> cbMedico;
    private com.toedter.calendar.JDateChooser dcFechaTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEspecialidad;
    private javax.swing.JLabel jLabelFechaTurno;
    private javax.swing.JLabel jLabelHoraTurno;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumAfiliado;
    private javax.swing.JLabel jLabelNumAfiliado1;
    private javax.swing.JLabel jLabelNumTurno;
    private javax.swing.JLabel jLabelObraSocial;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbDomicilio;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNumAfiliado;
    private javax.swing.JLabel lbNumTurno;
    private javax.swing.JLabel lbObraSocial;
    private javax.swing.JLabel lbTelefono;
    public NuevaAsignacionDeTurnoView(Paciente paciente, AsignarTurnoManejador turnoManejador, BuscarPacienteManejador buscarPacienteManejador) {
        initComponents();
        this.paciente = paciente;
        presentador = new AsignarTurnoPresentador(this, turnoManejador, buscarPacienteManejador);
        presentador.cargarVista();
        diseñoVentana();
    }

    private void diseñoVentana() {
        setLocationRelativeTo(this);
        setResizable(false);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        jLabelObraSocial = new javax.swing.JLabel();
        lbObraSocial = new javax.swing.JLabel();
        jLabelNumAfiliado = new javax.swing.JLabel();
        lbNumAfiliado = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jLabelNumAfiliado1 = new javax.swing.JLabel();
        lbDomicilio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNumTurno = new javax.swing.JLabel();
        lbNumTurno = new javax.swing.JLabel();
        jLabelEspecialidad = new javax.swing.JLabel();
        jLabelMedico = new javax.swing.JLabel();
        jLabelHoraTurno = new javax.swing.JLabel();
        jLabelFechaTurno = new javax.swing.JLabel();
        cbEspecialidad = new javax.swing.JComboBox<>();
        cbMedico = new javax.swing.JComboBox<>();
        dcFechaTurno = new com.toedter.calendar.JDateChooser();
        cbTurnos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignacion de Turno");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        lbNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelApellido.setText("Apellido");

        lbApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefono.setText("Telefono");

        lbTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelObraSocial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelObraSocial.setText("Obra Social");

        lbObraSocial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelNumAfiliado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumAfiliado.setText("N° Afiliado");

        lbNumAfiliado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdad.setText("Edad");

        jLabelNumAfiliado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumAfiliado1.setText("Domicilio");

        lbDomicilio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelNumAfiliado1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelObraSocial, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelNumAfiliado, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbObraSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbNumAfiliado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNombre)
                                        .addComponent(lbNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelApellido)
                                        .addComponent(lbApellido))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTelefono)
                                        .addComponent(lbTelefono))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEdad)
                                        .addComponent(lbEdad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelObraSocial)
                                        .addComponent(lbObraSocial))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNumAfiliado)
                                        .addComponent(lbNumAfiliado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNumAfiliado1)
                                        .addComponent(lbDomicilio))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNumTurno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumTurno.setText("Número");

        lbNumTurno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEspecialidad.setText("Especialidad");

        jLabelMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMedico.setText("Medico");

        jLabelHoraTurno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraTurno.setText("Hora");

        jLabelFechaTurno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFechaTurno.setText("Fecha");

        cbEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEspecialidad.addActionListener(e -> seleccionDeEspecialidad());
        cbMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbMedico.addActionListener(e -> seleccionMedcio(e));
        cbTurnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelFechaTurno, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelMedico, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelHoraTurno, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelNumTurno, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbNumTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dcFechaTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                        .addComponent(cbTurnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNumTurno)
                                        .addComponent(lbNumTurno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEspecialidad)
                                        .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMedico)
                                        .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelFechaTurno)
                                        .addComponent(dcFechaTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelHoraTurno)
                                        .addComponent(cbTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(e -> btnGuardarSeleccionado(e));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarSeleccionado(e));

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(e -> btnCerrarSeleccion(e));

        dcFechaTurno.addPropertyChangeListener("date", evt -> seleccionFecha(evt));

        jLabel1.setText("Datos del paciente");

        jLabel2.setText("Datos del turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(btnGuardar)
                                                .addGap(42, 42, 42)
                                                .addComponent(btnCancelar)
                                                .addGap(38, 38, 38)
                                                .addComponent(btnCerrar))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel1))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(25, 25, 25)
                                                        .addComponent(jLabel2))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnCerrar)
                                        .addComponent(btnGuardar))
                                .addGap(32, 32, 32))
        );
        pack();
    }

    private void seleccionMedcio(ActionEvent e) {
        cbTurnos.removeAllItems();
    }

    private void btnCancelarSeleccionado(ActionEvent e) {
        clear();
    }

    private void btnGuardarSeleccionado(ActionEvent e) {
        Turno turno = (Turno) cbTurnos.getSelectedItem();
        presentador.guardarTurno(paciente, turno);
        this.setVisible(false);
    }

    private void btnCerrarSeleccion(ActionEvent e) {
        this.setVisible(false);
    }

    private void seleccionFecha(PropertyChangeEvent evt) {
        Medico medico = (Medico) cbMedico.getSelectedItem();
        Date fecha = (Date) evt.getNewValue();
        presentador.seleccionDeFecha(medico.idPersonal(), fecha);
    }

    public void mostrarMensaje(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    private void clear() {
        cbMedico.removeAllItems();
        cbTurnos.removeAllItems();
    }

    @Override
    public void cargarEspecialidades() {
        cbEspecialidad.setModel(new DefaultComboBoxModel<>(EEspecialidades.values()));
    }

    private void seleccionDeEspecialidad() {
        EEspecialidades item = (EEspecialidades) cbEspecialidad.getSelectedItem();
        presentador.especialidadSeleccionada(item);
    }

    @Override
    public void cargarMedicos(ArrayList<Medico> medicos) {
        cbMedico.removeAllItems();
        cbTurnos.removeAllItems();
        for (Medico medico : medicos) {
            cbMedico.addItem(medico);
        }
    }

    @Override
    public void cargarTurnos(ArrayList<Turno> turnos) {
        cbTurnos.removeAllItems();
        for (Turno t : turnos) {
            cbTurnos.addItem(t);
        }
    }

    @Override
    public void mostrarPaciente(int numeroTurno) {
        lbNombre.setText(paciente.getNombre());
        lbApellido.setText(paciente.getApellido());
        lbTelefono.setText(String.valueOf(paciente.getTelefono()));
        lbEdad.setText(String.valueOf(paciente.getEdad()));
        lbDomicilio.setText(paciente.getDomicilio());
        lbObraSocial.setText(paciente.getObraSocial());
        lbNumAfiliado.setText(String.valueOf(paciente.getNumeroAfiliado()));
        lbNumTurno.setText(String.valueOf(numeroTurno));
    }
}
