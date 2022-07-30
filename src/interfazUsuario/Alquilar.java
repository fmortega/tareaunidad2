package alquilerVehiculos;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Alquilar extends javax.swing.JPanel {

    static int dias;
    String matricula;
    double preciovehiculo;
    DefaultTableModel model;
    String tipo;
    Vehiculo vehiculo;
    double preciofinal;
    double preciomicrobus = 2;

    public Alquilar() {

        initComponents();
        model = (DefaultTableModel) tablaReporte.getModel();

        desabilitarCompenentes();
    }

    public void limpiar() {
        txtDias.setText("");
        txtMatricula.setText("");
        combo.setSelectedIndex(0);
    }

    public boolean validacion() {
        return !(txtDias.getText().isEmpty() || txtMatricula.getText().isEmpty());

    }

    public void guardar() {
        matricula = txtMatricula.getText();
        dias = Integer.parseInt(txtDias.getText());
        tipo = (String) combo.getSelectedItem();

        switch (tipo) {
            case "Coche":
                vehiculo = new Coche(matricula, tipo, dias, 1.5);
                vehiculo.setTipoVehiculo("Coche");
                preciofinal = vehiculo.calculaPrecio(1.5, dias);
                break;
            case "Microbus":
                vehiculo = new Microbus(2, matricula, tipo, dias);
                vehiculo.setTipoVehiculo("Microbus");
                preciofinal = vehiculo.calculaPrecio(1.5 + preciomicrobus, dias);

                break;
            case "Furgoneta Carga":
                vehiculo = new Furgoneta(matricula, tipo, dias);
                vehiculo.setTipoVehiculo("Furgoneta Carga");

                preciofinal = vehiculo.calculaPrecio(dias);
                break;
            case "Camion":  
                vehiculo = new Camion(matricula, tipo, dias);
                vehiculo.setTipoVehiculo("Camion");

                preciofinal = vehiculo.calculaPrecio(dias);

                break;
            default:

                break;
        }

        vehiculo.setDias(dias);
        vehiculo.setMatricula(matricula);
        Object[] fila = new Object[4];
       try{
        fila[0] = vehiculo.getTipoVehiculo();

        fila[1] = vehiculo.getMatricula();

        fila[2] = vehiculo.getDias();

        fila[7] = preciofinal;
        model.addRow(fila);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();

        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaReporte.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaReporte.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaReporte.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaReporte.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);

        limpiar();
        btnGuardar.setEnabled(false);
       }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
       }
    }

    public void habilitarComponentes() {

        txtdias2.setEnabled(true);
        txtmatricula2.setEnabled(true);
        txtvehiculo2.setEnabled(true);
        txtprecio2.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }

    public void desabilitarCompenentes() {
        btnGuardar.setEnabled(false);
        txtdias2.setEnabled(false);
        txtmatricula2.setEnabled(false);
        txtvehiculo2.setEnabled(false);
        txtprecio2.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        lblerror = new javax.swing.JLabel();
        txtmatricula2 = new javax.swing.JTextField();
        txtvehiculo2 = new javax.swing.JTextField();
        txtprecio2 = new javax.swing.JTextField();
        txtdias2 = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReporte = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setName("alquila"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alquiler de vehiculos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel1.setAlignmentY(5.0F);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Coche", "Microbus", "Furgoneta Carga", "Camion" }));
        combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboMouseClicked(evt);
            }
        });

        jLabel1.setText("Tipo Vehiculo");

        btnGuardar.setText("Guargar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Matricula");

        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });

        jLabel3.setText("Dias");

        txtDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasKeyTyped(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBorrar.setText("X");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtvehiculo2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmatricula2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdias2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 220, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtmatricula2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtvehiculo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdias2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtprecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(btnModificar)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        tablaReporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaReporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehiculo", "Matricula", "Dias", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaReporte.setAlignmentX(10.0F);
        tablaReporte.setAlignmentY(5.0F);
        tablaReporte.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablaReporte.setRowHeight(25);
        tablaReporte.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReporteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        guardar();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDias.requestFocus();

        }

        if (validacion()) {
            btnGuardar.setEnabled(true);
        } else {
            btnGuardar.setEnabled(false);
        }

    }//GEN-LAST:event_txtMatriculaKeyReleased

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
        if (txtMatricula.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtMatriculaKeyTyped

    private void txtDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasKeyReleased

        if (validacion()) {
            btnGuardar.setEnabled(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnGuardar.doClick();

            }
        } else {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_txtDiasKeyReleased

    private void comboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboMouseClicked
        if (validacion()) {
            btnGuardar.setEnabled(true);
        } else {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_comboMouseClicked

    private void txtDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtDiasKeyTyped

    private void tablaReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReporteMouseClicked
        String valores = "";
        if (evt.getClickCount() == 2) {
            int fila = tablaReporte.getSelectedRow();

            habilitarComponentes();

            if (fila != -1) {
                String vehiculo = (String) model.getValueAt(fila, 0);
                String matricula = (String) model.getValueAt(fila, 1);
                Integer dias = (Integer) model.getValueAt(fila, 2);
                double precio = (double) model.getValueAt(fila, 3);
                txtvehiculo2.setText(vehiculo);
                txtmatricula2.setText(matricula);
                txtdias2.setText("" + dias);
                txtprecio2.setText("" + precio);

            } else {
                JOptionPane.showInternalMessageDialog(null, "Seleccione fila");
            }

        }
    }//GEN-LAST:event_tablaReporteMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int fila = tablaReporte.getSelectedRow();

        habilitarComponentes();
        try {

            if (fila != -1) {

                model.setValueAt(txtvehiculo2.getText(), fila, 0);
                model.setValueAt(txtmatricula2.getText(), fila, 1);
                model.setValueAt((Integer.parseInt(txtdias2.getText())), fila, 2);
                model.setValueAt((Double.parseDouble(txtprecio2.getText())), fila, 3);

            }

            txtvehiculo2.setText("");
            txtmatricula2.setText("");
            txtdias2.setText("");
            txtprecio2.setText("");
            desabilitarCompenentes();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error  " + e);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtvehiculo2.setText("");
        txtmatricula2.setText("");
        txtdias2.setText("");
        txtprecio2.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblerror;
    private javax.swing.JTable tablaReporte;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtdias2;
    private javax.swing.JTextField txtmatricula2;
    private javax.swing.JTextField txtprecio2;
    private javax.swing.JTextField txtvehiculo2;
    // End of variables declaration//GEN-END:variables
}
