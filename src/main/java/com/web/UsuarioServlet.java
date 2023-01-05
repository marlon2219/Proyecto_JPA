/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
import com.service.MovimientosusuarioService;
import com.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
    MovimientosusuarioService movimientosusuarioservice;
    @Inject
    UsuarioService usuarioService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "ingresar":

                    String nombre = request.getParameter("txtusuario");
                    String contra = request.getParameter("txtpassword");

                    try {
                        //SI EL USUARIO EXISTE
                        Usuarios u = usuarioService.encontrarUsuarioPorNombrePass(nombre, contra);
                        request.setAttribute("obj", u);
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("usuario", u);
                        request.getRequestDispatcher("vistaUsuario.jsp").forward(request, response);
                    } catch (Exception e) {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }

                    break;
                case "agregar":
                    String nombree = request.getParameter("txtnombre");
                    String dni = request.getParameter("txtdocumento");
                    String correo = request.getParameter("txtcorreo");
                    String direccion = request.getParameter("txtdireccion");
                    String tlf = request.getParameter("txttelefono");
                    String pass = request.getParameter("txtpass");
                    double saldo = Double.parseDouble(request.getParameter("txtsaldo"));

                    Usuarios us = new Usuarios(nombree, dni, correo, direccion, tlf, pass, saldo);
                    usuarioService.registrarUsuario(us);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "actualizar":

                    HttpSession sesionn = request.getSession(false);
                    Usuarios u2 = (Usuarios) sesionn.getAttribute("usuario");
                    Usuarios uss = usuarioService.encontrarUsuarioPorId(u2.getIdUsuario());

                    //DATOS PARA ACUTUALIZAR RECOGIDOS DEL JSP
                    String nom = request.getParameter("txtnombre");
                    String dnii = request.getParameter("txtdocumento");
                    String cor = request.getParameter("txtcorreo");
                    String dir = request.getParameter("txtdireccion");
                    String tl = request.getParameter("txttelefono");
                    String ps = request.getParameter("txtpass");
                    double sa = Double.parseDouble(request.getParameter("txtsaldo"));
                    Usuarios objActulizado = new Usuarios(uss.getIdUsuario(), nom, dnii, cor, dir, tl, ps, sa);


                    //ACTUALIZAR
                    usuarioService.modificarUsuario(uss, objActulizado);
                    sesionn.removeAttribute("usuario");
                    sesionn.setAttribute("usuario", objActulizado);

                    request.getRequestDispatcher("vistaUsuario.jsp").forward(request, response);
                    //response.sendRedirect("LibroServlet");
                    break;
                case "eliminarCuenta":
                    HttpSession se = request.getSession();
                    usuarioService.eliminarUsuario((Usuarios) se.getAttribute("usuario"));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "ingresarSaldo":

                    HttpSession s = request.getSession();
                    Usuarios u3 = (Usuarios) s.getAttribute("usuario");
                    Usuarios uss2 = usuarioService.encontrarUsuarioPorId(u3.getIdUsuario());

                    double saldoNuevo = Double.parseDouble(request.getParameter("cantidad"));
                    double total = u3.getSaldo() + saldoNuevo;
                    Usuarios objActulizado2 = new Usuarios(u3.getIdUsuario(), u3.getNombre(), u3.getDni(), u3.getCorreo(), u3.getDireccion(), u3.getTelefono(), u3.getContrasena(), total);

                    //ACTUALIZAR
                    usuarioService.modificarUsuario(uss2, objActulizado2);
                    s.removeAttribute("usuario");
                    s.setAttribute("usuario", objActulizado2);
                    //INGRESAR MOVIMIENTO
                    Movimientosusuario mvu = new Movimientosusuario(String.valueOf("+" + saldoNuevo), "INGRESO", u3);
                    movimientosusuarioservice.agregarMovimiento(mvu);
                    request.getRequestDispatcher("vistaUsuario.jsp").forward(request, response);

                    break;
                case "restar":
                    System.out.println("entra en restar-----------------------------------------------------------------------");
                    double pre = Double.parseDouble(request.getParameter("precioLibro"));

                    HttpSession ss = request.getSession();
                    Usuarios u4 = (Usuarios) ss.getAttribute("usuario");
                    Usuarios uss3 = usuarioService.encontrarUsuarioPorId(u4.getIdUsuario());

                    double total2 = u4.getSaldo() - pre;
                    Usuarios objActulizado3 = new Usuarios(u4.getIdUsuario(), u4.getNombre(), u4.getDni(), u4.getCorreo(), u4.getDireccion(), u4.getTelefono(), u4.getContrasena(), total2);

                    //ACTUALIZAR
                    usuarioService.modificarUsuario(uss3, objActulizado3);
                    ss.removeAttribute("usuario");
                    ss.setAttribute("usuario", objActulizado3);

                    response.sendRedirect("LibroServlet");

                    break;
                case "cerrarSesion":
                    cerrarSesion(request, response);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("entramos en usarioSwrvlet");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        HttpSession sesionn = request.getSession();

        sesionn.invalidate();

        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
