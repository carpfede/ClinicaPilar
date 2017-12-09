package presentacion.vista;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import aplicacion.coordinadorCU.RegistrarPacienteManejador;
import dominio.entidades.pacientes.AfiliacionObraSocial;
import dominio.entidades.pacientes.ObraSocial;
import dominio.entidades.pacientes.Paciente;
import presentacion.interfaces.RegistrarPaciente;
import presentacion.presentador.RegistrarPacientePresentador;

import javax.swing.*;
import java.util.ArrayList;

public class RegistrarPacienteView extends javax.swing.JFrame implements RegistrarPaciente {

    private RegistrarPacientePresentador presentador;
    private ButtonGroup sexoRadioButton;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbEstadoCivil;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ObraSocial> cbNombreObraSocial;
    private javax.swing.JComboBox<String> cbOcupacion;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEstadoCivil;
    private javax.swing.JLabel jLabelFechaNacimiento;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumAfiliado;
    private javax.swing.JLabel jLabelOcupacion;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbSexoF;
    private javax.swing.JRadioButton rbSexoM;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumAfiliado;
    private javax.swing.JTextField txtTelefono;
    public RegistrarPacienteView(String dni, RegistrarPacienteManejador registrarPacienteManejador) {
        initComponents(dni);
        presentador = new RegistrarPacientePresentador(this, registrarPacienteManejador);
        presentador.cargarObrasSociales();
    }

    private void initComponents(String dni) {

        sexoRadioButton = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelFechaNacimiento = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabelSexo = new javax.swing.JLabel();
        rbSexoM = new javax.swing.JRadioButton();
        rbSexoF = new javax.swing.JRadioButton();
        jLabelEdad = new javax.swing.JLabel();
        jLabelEstadoCivil = new javax.swing.JLabel();
        jLabelOcupacion = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        cbOcupacion = new javax.swing.JComboBox<>();
        txtEdad = new javax.swing.JTextField();
        jLabelApellido2 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cbNombreObraSocial = new javax.swing.JComboBox<>();
        jLabelNumAfiliado = new javax.swing.JLabel();
        txtNumAfiliado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Paciente");

        sexoRadioButton.add(rbSexoF);
        sexoRadioButton.add(rbSexoM);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelApellido.setText("Apellido");

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelDni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDni.setText("DNI");

        txtDNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefono.setText("Telefono");

        jLabelFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFechaNacimiento.setText("Fec. Nacimiento");

        jLabelSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSexo.setText("Sexo");

        rbSexoM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbSexoM.setText("Masculino");

        rbSexoF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbSexoF.setText("Femenino");

        jLabelEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdad.setText("Edad");

        jLabelEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEstadoCivil.setText("Estado Civil");

        jLabelOcupacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelOcupacion.setText("Ocupacion");

        cbEstadoCivil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"", "Soltero/a", "Casado/a", "Viudo/a"}));

        cbOcupacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbOcupacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"", "Desocupado/a", "Trabajador/a", "Estudiante", "Jubilado/a"}));
        cbOcupacion.setMinimumSize(new java.awt.Dimension(85, 23));
        cbOcupacion.setPreferredSize(new java.awt.Dimension(85, 23));

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelApellido2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelApellido2.setText("Domicilio");

        txtDomicilio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelEstadoCivil)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jLabelOcupacion)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelSexo)
                                                                        .addComponent(jLabelEdad))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelTelefono)
                                                                        .addComponent(jLabelFechaNacimiento)
                                                                        .addComponent(jLabelDni)
                                                                        .addComponent(jLabelApellido2)
                                                                        .addComponent(jLabelApellido)
                                                                        .addComponent(jLabelNombre))
                                                                .addGap(10, 10, 10)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(rbSexoM)
                                                                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rbSexoF))
                                                        .addComponent(txtTelefono)
                                                        .addComponent(txtDNI)
                                                        .addComponent(txtDomicilio)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNombre)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelApellido)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelApellido2)
                                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDni)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTelefono)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelFechaNacimiento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSexo)
                                        .addComponent(rbSexoM)
                                        .addComponent(rbSexoF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEdad)
                                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEstadoCivil)
                                        .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelOcupacion)
                                        .addComponent(cbOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbNombreObraSocial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelNumAfiliado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumAfiliado.setText("N° Afiliado");

        txtNumAfiliado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelNumAfiliado)
                                        .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbNombreObraSocial, 0, 153, Short.MAX_VALUE)
                                        .addComponent(txtNumAfiliado))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbNombreObraSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNumAfiliado)
                                        .addComponent(txtNumAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(evt -> btnGuardarActionPerformed(evt));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> btnCancelarActionPerformed(evt));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(evt -> btnCerrarActionPerformed(evt));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Datos del paciente");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Datos de la obra social");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Registrar Paciente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnGuardar)
                                .addGap(80, 80, 80)
                                .addComponent(btnCancelar)
                                .addGap(74, 74, 74)
                                .addComponent(btnCerrar)
                                .addGap(32, 32, 32))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(136, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnCerrar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        diseñoPantalla(dni);
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        agregarNuevoPaciente();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        clear();
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    // End of variables declaration//GEN-END:variables
    private void diseñoPantalla(String dni) {
        setResizable(false);
        setLocationRelativeTo(this);
        cargarDniPaciente(dni);
    }

    @Override
    public void cargarObrasSociales(ArrayList<ObraSocial> obrasSociales) {
        for (ObraSocial o : obrasSociales) {
            cbNombreObraSocial.addItem(o);
        }
    }

    @Override
    public void cargarDniPaciente(String dni) {
        txtDNI.setText(dni);
    }

    private void agregarNuevoPaciente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String domicilio = txtDomicilio.getText();
        int dni = Integer.parseInt(txtDNI.getText());
        long telefono = Long.parseLong(txtTelefono.getText());
        int edad = Integer.parseInt(txtEdad.getText());
        ObraSocial obraSocial = (ObraSocial) cbNombreObraSocial.getSelectedItem();
        int nroAfiliado = Integer.parseInt(txtNumAfiliado.getText());
        AfiliacionObraSocial afiliacionObraSocial = new AfiliacionObraSocial(obraSocial, nroAfiliado);
        presentador.registrarPaciente(nombre, apellido, domicilio, dni, telefono, edad, afiliacionObraSocial);
    }

    private void clear() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDomicilio.setText("");
        txtDNI.setText("");
        txtTelefono.setText("");
        dcFechaNacimiento.setDate(null);
        rbSexoF.setSelected(false);
        rbSexoM.setSelected(false);
        txtEdad.setText("");
        cbEstadoCivil.setSelectedIndex(0);
        cbOcupacion.setSelectedIndex(0);
        cbNombreObraSocial.setSelectedIndex(0);
    }

    public void nuevoTurno(Paciente p, AsignarTurnoManejador turnoManejador, BuscarPacienteManejador buscarPacienteManejador) {
        new NuevaAsignacionDeTurnoView(p, turnoManejador, buscarPacienteManejador).setVisible(true);
        this.setVisible(false);
    }
}
