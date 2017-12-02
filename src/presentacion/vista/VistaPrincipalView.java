package presentacion.vista;

import aplicacion.coordinadorCU.BuscarPacienteManejador;
import dominio.entidades.Sesion;
import main.Main;
import presentacion.interfaces.VistaPrincipal;
import presentacion.presentador.VistaPrincipalPresentador;

import javax.swing.*;

public class VistaPrincipalView extends javax.swing.JFrame implements VistaPrincipal {

    private Sesion sesion;
    private VistaPrincipalPresentador presentador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu;

    public VistaPrincipalView(Sesion sesion) {
        this.sesion = sesion;
        initComponents();
        presentador = new VistaPrincipalPresentador(this);
        diseñoVentana();
    }

    private void asignarTurnoSeleccionado() {
        presentador.nuevoTurno();
    }

    private void cerrarSesionSeleccion() {
        setVisible(false);
        Main.main(new String[]{});
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliniar del Pilar");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/Logo.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText(" BIENVENIDO/A " + sesion.getNombre());

        menu.setText("Menu");
        menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(226, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addContainerGap(219, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void añadirFuncionesMedico() {
        menu.removeAll();
        JMenuItem nuevaConsulta = new JMenuItem();
        nuevaConsulta.setText("Nueva Consulta");
        menu.add(nuevaConsulta);
        JMenuItem revisarConsulta = new JMenuItem();
        revisarConsulta.setText("Revisar Consulta");
        menu.add(revisarConsulta);
        JMenuItem finalizarInternacion = new JMenuItem();
        finalizarInternacion.setText("Epicrisis Paciente");
        menu.add(finalizarInternacion);
        JMenuItem gestionHC = new JMenuItem();
        gestionHC.setText("Gestion Historia Clinica");
        menu.add(gestionHC);
        JMenuItem cerrarSesion = new JMenuItem();
        cerrarSesion.setText("Cerrar Sesion");
        menu.add(cerrarSesion);
        cerrarSesion.addActionListener(evt -> cerrarSesionSeleccion());
    }

    @Override
    public void añadirFuncionesSecretaria() {
        menu.removeAll();
        JMenuItem asignarTurno = new JMenuItem();
        asignarTurno.setText("Asignar Turno");
        menu.add(asignarTurno);
        JMenuItem cerrarSesion = new JMenuItem();
        cerrarSesion.setText("Cerrar Sesion");
        menu.add(cerrarSesion);
        cerrarSesion.addActionListener(evt -> cerrarSesionSeleccion());
        asignarTurno.addActionListener(evt -> asignarTurnoSeleccionado());
    }

    @Override
    public void añadirFuncionesEnfermera() {

    }

    @Override
    public void iniciarBusquedaPaciente(BuscarPacienteManejador manejador) {
        BuscarPacienteView view = new BuscarPacienteView(sesion, manejador);
        view.setVisible(true);
    }

    private void diseñoVentana() {
        this.setExtendedState(MAXIMIZED_BOTH);
        presentador.inicializarFunciones(this.sesion);
    }
}
