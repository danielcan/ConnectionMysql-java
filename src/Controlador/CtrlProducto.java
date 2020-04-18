/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProductos;
import Modelo.Producto;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC LIFE
 */
public class CtrlProducto implements ActionListener {

    private final Producto mod;
    private final ConsultasProductos modC;
    private final frmProducto frm;

    public CtrlProducto(Producto mod, ConsultasProductos modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Producto");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));

            try {
                if (modC.registrar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardado");
                    limpiar();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == frm.btnModificar) {
            try {
                mod.setId(Integer.parseInt(frm.txtId.getText()));
                mod.setCodigo(frm.txtCodigo.getText());
                mod.setNombre(frm.txtNombre.getText());
                mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
                mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));

                if (modC.Modificar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));

            try {
                if (modC.Eliminar(mod)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar");
                    limpiar();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == frm.btnBuscar) {
            //  frm.txtId.setVisible(true);
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());

            try {
                if (modC.Buscar(mod)) {
                    frm.txtId.setText(String.valueOf(mod.getId()));
                    frm.txtCodigo.setText(mod.getCodigo());
                    frm.txtNombre.setText(mod.getNombre());
                    frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                    frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro registro");
                    limpiar();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }

    }

    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
    }

}
