/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlProducto;
import Modelo.ConsultasProductos;
import Modelo.Producto;

/**
 *
 * @author PC LIFE
 */
public class Main {

    public static void main(String args[]) {

        Producto mod = new Producto();
        ConsultasProductos modC = new ConsultasProductos();
        frmProducto frm = new frmProducto();
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);

    }
}
