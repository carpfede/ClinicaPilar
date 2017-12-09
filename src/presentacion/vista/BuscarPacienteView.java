package presentacion.vista;

import aplicacion.coordinadorCU.AsignarTurnoManejador;
import aplicacion.coordinadorCU.BuscarPacienteManejador;
import aplicacion.coordinadorCU.RegistrarPacienteManejador;
import dominio.entidades.pacientes.Paciente;
import dominio.entidades.Sesion;
import presentacion.interfaces.BuscarPaciente;
import presentacion.presentador.BuscarPacientePresentador;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BuscarPacienteView extends JFrame implements BuscarPaciente {

    BuscarPacientePresentador presentador;
    Sesion usuario;
    // Variables declaration - do not modify                     
    private JButton btnBuscar;
    private JButton btnCerrar;
    private JLabel jLabel2;
    private JTextField txtIngresarDni;

    public BuscarPacienteView(Sesion sesion, BuscarPacienteManejador manejador) {
        initComponents();
        usuario = sesion;
        presentador = new BuscarPacientePresentador(this, manejador);
        setLocationRelativeTo(this);
    }

    private void initComponents() {

        jLabel2 = new JLabel();
        txtIngresarDni = new JTextField();
        btnBuscar = new JButton();
        btnCerrar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar Paciente");

        jLabel2.setText("Ingresar dni");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(e -> btnBuscarActionPerformed(e));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(e -> btnCerrarActionPerformed(e));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIngresarDni, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCerrar)
                                        .addComponent(btnBuscar))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtIngresarDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscar))
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnBuscarActionPerformed(ActionEvent e) {
        presentador.buscarPaciente(getDni());
    }

    public void nuevaAsignacionDeTurno(Paciente paciente, AsignarTurnoManejador turnoManejador, BuscarPacienteManejador buscarPacienteManejador) {
        new NuevaAsignacionDeTurnoView(paciente, turnoManejador, buscarPacienteManejador).setVisible(true);
        disposeView();
    }

    public void registrarNuevoPaciente(String message, RegistrarPacienteManejador registrarPacienteManejador) {
        mostrarMensaje(message);
        new RegistrarPacienteView(txtIngresarDni.getText(), registrarPacienteManejador).setVisible(true);
        disposeView();
    }

    private void mostrarMensaje(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void disposeView() {
        this.setVisible(false);
    }

    private void btnCerrarActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public int getDni() {
        return Integer.parseInt(txtIngresarDni.getText());
    }
}