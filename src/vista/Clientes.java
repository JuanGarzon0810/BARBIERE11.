    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import dao.ClienteDAO;
import modelo.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author garzo
 */
public class Clientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Clientes.class.getName());

    /**
     * Creates new form Clientes
     */
    
public Clientes() {
    initComponents();

    txtNombre.setText("");
    txtTelefono.setText("");
    txtCorreo.setText("");
    txtDireccion.setText("");

    configurarSeleccionTabla();

    cargarClientes();
}

// ===========================
// SELECCIONAR FILA DE LA TABLA
// ===========================
private void configurarSeleccionTabla() {

    tblClientes.getSelectionModel().addListSelectionListener(evento -> {

        if (!evento.getValueIsAdjusting() && tblClientes.getSelectedRow() != -1) {

            int fila = tblClientes.getSelectedRow();

            txtNombre.setText(tblClientes.getValueAt(fila, 1).toString());
            txtTelefono.setText(tblClientes.getValueAt(fila, 2).toString());
            txtCorreo.setText(tblClientes.getValueAt(fila, 3).toString());
            txtDireccion.setText(tblClientes.getValueAt(fila, 4).toString());
        }
    });

}

private void cargarClientes() {

    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Teléfono");
    modelo.addColumn("Correo");
    modelo.addColumn("Dirección");

    ClienteDAO dao = new ClienteDAO();

    List<Cliente> lista = dao.listarClientes();

    for (Cliente cliente : lista) {

        modelo.addRow(new Object[]{
            cliente.getId(),
            cliente.getNombre(),
            cliente.getTelefono(),
            cliente.getCorreo(),
            cliente.getDireccion()
        });

    }

    tblClientes.setModel(modelo);

    
}

private void limpiarCampos() {

    txtNombre.setText("");
    txtTelefono.setText("");
    txtCorreo.setText("");
    txtDireccion.setText("");

    txtNombre.requestFocus();

}

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BARBIERE11 - Gestión de Clientes");

        jLabel1.setText("Nombre");

        jLabel2.setText("Teléfono");

        jLabel3.setText("Correo");

        jLabel4.setText("Dirección");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        jLabel5.setText("BARBIERE11 - Gestión de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel5)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    Cliente cliente = new Cliente();

    cliente.setNombre(txtNombre.getText().trim());
    cliente.setTelefono(txtTelefono.getText().trim());
    cliente.setCorreo(txtCorreo.getText().trim());
    cliente.setDireccion(txtDireccion.getText().trim());

    ClienteDAO dao = new ClienteDAO();

    if (dao.guardarCliente(cliente)) {

        JOptionPane.showMessageDialog(this, "Cliente guardado correctamente.");

        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");

        txtNombre.requestFocus();

        cargarClientes();

    } else {

        JOptionPane.showMessageDialog(this, "Error al guardar el cliente.");

    }

    }//GEN-LAST:event_btnGuardarActionPerformed

    // ===========================
    // BUSCAR CLIENTE (por nombre)
    // ===========================
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    String nombre = txtNombre.getText().trim();

    if (nombre.isEmpty()) {

        JOptionPane.showMessageDialog(this, "Escriba el nombre del cliente a buscar.",
                "Dato requerido", JOptionPane.WARNING_MESSAGE);
        return;
    }

    ClienteDAO dao = new ClienteDAO();

    Cliente cliente = dao.buscarCliente(nombre);

    if (cliente != null) {

        txtTelefono.setText(cliente.getTelefono());
        txtCorreo.setText(cliente.getCorreo());
        txtDireccion.setText(cliente.getDireccion());

    } else {

        JOptionPane.showMessageDialog(this, "No se encontró un cliente con ese nombre.",
                "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    }//GEN-LAST:event_btnBuscarActionPerformed

    // ===========================
    // ACTUALIZAR CLIENTE
    // ===========================
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    if (txtNombre.getText().trim().isEmpty()
            || txtTelefono.getText().trim().isEmpty()
            || txtCorreo.getText().trim().isEmpty()
            || txtDireccion.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                "Datos incompletos", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Cliente cliente = new Cliente();

    cliente.setNombre(txtNombre.getText().trim());
    cliente.setTelefono(txtTelefono.getText().trim());
    cliente.setCorreo(txtCorreo.getText().trim());
    cliente.setDireccion(txtDireccion.getText().trim());

    ClienteDAO dao = new ClienteDAO();

    if (dao.actualizarCliente(cliente)) {

        JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");

        limpiarCampos();
        cargarClientes();

    } else {

        JOptionPane.showMessageDialog(this, "No se pudo actualizar. Verifique que el nombre exista.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnActualizarActionPerformed

    // ===========================
    // ELIMINAR CLIENTE
    // ===========================
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    String nombre = txtNombre.getText().trim();

    if (nombre.isEmpty()) {

        JOptionPane.showMessageDialog(this, "Escriba o seleccione el nombre del cliente a eliminar.",
                "Dato requerido", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar al cliente \"" + nombre + "\"?",
            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {

        ClienteDAO dao = new ClienteDAO();

        if (dao.eliminarCliente(nombre)) {

            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");

            limpiarCampos();
            cargarClientes();

        } else {

            JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnEliminarActionPerformed

    // ===========================
    // LIMPIAR CAMPOS
    // ===========================
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    limpiarCampos();
    tblClientes.clearSelection();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Clientes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
