/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclui.restful_crud_cliente;

import incli.restful.restful_crud_cliente.rest.Producto;
import inser.persistence.restful_crud.LinkedList_Producto;

/**
 *
 * @author informatica
 */
public class Restful_crud_cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean ret = true;
        inser.persistence.restful_crud.Producto producto_entidad = null;
        String [] error = { "" };
        Long filas_afectadas_num = null;
        String usuario = "jardineria";
        String contraseña = "2021jardineria";
        LinkedList_Producto linkedList_envuelta = new LinkedList_Producto();
        try {            
            Producto producto = new Producto ();
//            producto_entidad = producto.find_JSON(inser.persistence.restful_crud.Producto.class
//                    , "1", usuario, contraseña, error);
//            ret = (producto_entidad != null);
            if (ret) {
                linkedList_envuelta = producto.findLike_descripcion_JSON(linkedList_envuelta.getClass()
                        , "0", "14", "%de%", usuario, contraseña, error);
                ret = (linkedList_envuelta != null);
            }            
//            if (ret) {
//                linkedList_envuelta = producto.find_orden_JSON(linkedList_envuelta.getClass()
//                        , "0", "14", "codigoProducto", "desc", usuario, contraseña, error);
//                ret = (linkedList_envuelta != null);
//            }                        
//            if (ret) {
//                linkedList_envuelta = producto.findLike_descripcion_orden_JSON(linkedList_envuelta.getClass()
//                        , "0", "14", "Gracias%", "codigoProducto", "desc", usuario, contraseña, error);
//                ret = (linkedList_envuelta != null);
//            }                        
//            if (ret) {
//                ret = producto.remove("1", usuario, contraseña, error);
//            }
//            if (ret) {
//                ret = producto.create_JSON(producto_entidad, usuario, contraseña, error);
//            }
            if (ret) {
                filas_afectadas_num = producto.countREST(usuario, contraseña, error);
                ret = (filas_afectadas_num != null);
            }
            if (ret) {
                ret = producto.edit_JSON(producto_entidad, "1", usuario, contraseña, error);
            }
            if (ret) {
                linkedList_envuelta = producto.findRange_JSON(linkedList_envuelta.getClass(), "1", "15", usuario, contraseña, error);
                ret = (linkedList_envuelta != null);
            }            
            if (ret) {
                linkedList_envuelta = producto.findAll_JSON(linkedList_envuelta.getClass(), usuario, contraseña, error);
                ret = (linkedList_envuelta != null);
            }            
        } catch (Exception e) {
            error [0] = e.getMessage();
            if (error[0] == null) {
                error[0] = "";
            }
            error [0] = "Error en el cliente de restful_crud. " + error[0];
            ret = false;
        }
        if (ret == false) {
            System.out.println(error[0]);
        } else {
            System.out.println(producto_entidad.toString());
        }
    }
    
}
