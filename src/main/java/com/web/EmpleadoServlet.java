/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dominio.Compraventas;
import com.dominio.Empleados;
import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import com.dominio.Libroscargados;
import com.dominio.Movimientosusuario;
import com.dominio.Usuarios;
import com.service.CompraventasService;
import com.service.EmpleadoService;
import com.service.LibroCargadoService;
import com.service.LibroHasUsuariosService;
import com.service.LibroService;
import com.service.MovimientosusuarioService;
import com.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

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
    LibroHasUsuariosService libroHasUsuariosService;
    @Inject
    CompraventasService compraventasService;
    @Inject
    UsuarioService usuarioService;
    @Inject
    LibroCargadoService librocargadoservice;
    @Inject
    LibroService libroService;
    @Inject
    EmpleadoService empleadoService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "ingresarEmpleado":
                    String nom = request.getParameter("txtusuario");
                    String pas = request.getParameter("txtpassword");

                    if (nom.equalsIgnoreCase("root") && pas.equalsIgnoreCase("123")) {
                        System.out.println("somos root");
                    }

                    //Si el empleado exsite, y pone bien sus datos
                    try {
                        Empleados em = empleadoService.encontrarEmpleadoPorNombrePass(nom, pas);
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("empleado", em);
                        if (em.getNombre().equalsIgnoreCase("root")) {
                            //ADMNISTRADOR
                            List<Empleados> empleados = empleadoService.listaEmpleados();
                            request.setAttribute("empleados", empleados);
                            request.setAttribute("totempleados", empleados.size());
                            request.getRequestDispatcher("vistaRoot.jsp").forward(request, response);
                        }
                        //LISTA DE LIBROS (EMPLEADO)
                        List<Libros> libros = libroService.listarLibros();
                        request.setAttribute("libros", libros);
                        request.setAttribute("totLibros", libros.size());
                        request.getRequestDispatcher("vistaEmpleado.jsp").forward(request, response);
                    } catch (Exception e) {
                        request.getRequestDispatcher("loginEmpleado.jsp").forward(request, response);
                    }

                    break;
                case "listar":
                    List<Libros> libros2 = libroService.listarLibros();
                    request.setAttribute("libros", libros2);
                    request.setAttribute("totLibros", libros2.size());
                    request.getRequestDispatcher("vistaEmpleado.jsp").forward(request, response);
                    break;

                case "listarPorIdEmpleado":
                    System.out.println("estamos dentr");
                    HttpSession sesionn = request.getSession(false);
                    Empleados emm = (Empleados) sesionn.getAttribute("empleado");
                    System.out.println("empleado: "+emm);
                    
                    
                    List<Libroscargados> lbs = librocargadoservice.librosPorEmpleado(emm.getIdEmpleado());

                    request.setAttribute("librosPorEmpleado", lbs);

                    request.getRequestDispatcher("vistaEmpleadoMisLibros.jsp").forward(request, response);

                    break;
                case "generarVenta":
                    //DATOS DEL FOMRULARIO
                    int idLibro = Integer.parseInt(request.getParameter("codLibro"));
                    int idU = Integer.parseInt(request.getParameter("codUsuario"));
                    //USUARIO
                    Usuarios u = usuarioService.encontrarUsuarioPorId(idU);

                    //EMPLEADO DE LA SESION
                    HttpSession s = request.getSession(false);
                    Empleados e = (Empleados) s.getAttribute("empleado");
                    //LIBRO
                    Libros l = libroService.buscarLibroPorId(idLibro);

                    //AGREGAR ACCION A LIBROS_HAS_USUARIOS Y MOVIEMINTOS USUARIOS
                    Movimientosusuario mvu = new Movimientosusuario(String.valueOf("-" + l.getPrecio()), "COMPRA/" + l.getTitulo(), u); //OBJ para agregar a movimientos
                    LibrosHasUsuarios lhu = new LibrosHasUsuarios(u.getIdUsuario(), idLibro);
                    libroHasUsuariosService.registrarLibroHasUsuario(lhu);
                    movimientosusuarioservice.agregarMovimiento(mvu);

                    Compraventas cv = new Compraventas(e, l, u);
                    compraventasService.registrarCompraventas(cv);
                    request.getRequestDispatcher("vistaEmpleadoGenerarVenta.jsp").forward(request, response);
                    break;
                case "registrarUsuarioDesdeEmpleado":

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
                case "cerrarSesion":
                    cerrarSesion(request, response);
                    break;
                default:
                    break;

            }
        } else {
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
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EmpleadoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
