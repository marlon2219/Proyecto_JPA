/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dominio.Compraventas;
import com.dominio.Empleados;
import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
import com.service.CompraventasService;
import com.service.EmpleadoService;
import com.service.LibroHasUsuariosService;
import com.service.LibroService;
import com.service.MovimientosusuarioService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pc
 */
@WebServlet(name = "LibroHasUsuariosServlet", urlPatterns = {"/LibroHasUsuariosServlet"})
public class LibroHasUsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Inject 
    LibroService libroservice;
    @Inject
    EmpleadoService empleadosService;
    @Inject
    CompraventasService compraventasService;
    @Inject 
    MovimientosusuarioService movimientosusuarioservice;
    @Inject
    LibroHasUsuariosService libroHasUsuariosService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    double precioLibro = Double.parseDouble(request.getParameter("precioLibro"));
                  
                    Date ts = new Timestamp(new Date().getTime());
                    System.out.println("tiempo------------------------------------------------------------------------------------------------------: " + ts);
                    int idLibro = Integer.parseInt(request.getParameter("libro"));
                    HttpSession sesion = request.getSession(true);
                    Usuarios u = (Usuarios) sesion.getAttribute("usuario");
                    LibrosHasUsuarios lhu = new LibrosHasUsuarios(u.getIdUsuario(),idLibro);
                    //LibrosHasUsuarios l = new LibrosHasUsuarios(ts, idLibro, u.getIdUsuario());  OBJ CREADO CON FECHA *NO FUNCIONA*
                    //NO SE REGISTRA CON FECHA
                    //COMPROBAMOS SI TIENE SALDO SUFICIENTE
                    if(precioLibro <= u.getSaldo()){
                        Libros l = libroservice.buscarLibroPorId(idLibro);
                        Movimientosusuario mvu = new Movimientosusuario(String.valueOf("-"+precioLibro),"COMPRA/"+l.getTitulo(),u); //OBJ para agregar a movimientos
                        libroHasUsuariosService.registrarLibroHasUsuario(lhu);
                        movimientosusuarioservice.agregarMovimiento(mvu);
                        //DATOS PARA REGISTRO EN COMPRAVENTAS
                        Empleados em = empleadosService.encontrarEmpleadoPorId(2);
                        Compraventas cv = new Compraventas(em, l, u);
                        compraventasService.registrarCompraventas(cv);
                        response.sendRedirect("UsuarioServlet?accion=restar&precioLibro="+precioLibro);
                    }else{
                        response.sendRedirect("LibroServlet?accion=listar");
                    }
                    
                  

                    //response.sendRedirect("LibroServlet");
                    //request.getRequestDispatcher("vistaUsuarioLibros.jsp").forward(request, response);
                    break;
                case "eliminarLibroHasUsuario":
                    int idLi = Integer.parseInt(request.getParameter("idLibro"));
                     HttpSession s = request.getSession(true);
                    Usuarios u2 = (Usuarios) s.getAttribute("usuario");
                    LibrosHasUsuarios objEliminar = new LibrosHasUsuarios(u2.getIdUsuario(),idLi);
                    libroHasUsuariosService.EliminarLibroHasUsu(objEliminar);
                    response.sendRedirect("LibroServlet?accion=listar");
                    
                    break;
                default:
                    break;
            }
        } else {
            request.getRequestDispatcher("vistaUsuarioMisLibros.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
