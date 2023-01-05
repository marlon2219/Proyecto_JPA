/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dominio.Empleados;
import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import com.dominio.Libroscargados;
import com.dominio.Usuarios;
import com.service.LibroCargadoService;
import com.service.LibroHasUsuariosService;
import com.service.LibroService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "LibroServlet", urlPatterns = {"/LibroServlet"})
public class LibroServlet extends HttpServlet {

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
    LibroCargadoService librocargadoservice;

    @Inject
    LibroService libroService;

    @Inject
    LibroHasUsuariosService librohasUsuariosService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    List<Libros> libros = libroService.listarLibros();
                    request.setAttribute("libros", libros);
                    request.getRequestDispatcher("vistaUsuarioLibros.jsp").forward(request, response);

                    break;
                case "listarPorIdUsuario":
                    HttpSession sesion = request.getSession(false);
                    Usuarios u = (Usuarios) sesion.getAttribute("usuario");
                    List<LibrosHasUsuarios> librosPorId = librohasUsuariosService.encontrarLibroPorIdUsuario(u.getIdUsuario());
                    request.setAttribute("librosPorId", librosPorId);
                    request.getRequestDispatcher("vistaUsuarioMisLibros.jsp").forward(request, response);
                    break;
                case "buscar":
                    String b = request.getParameter("busqueda");
                    List<Libros> librosEncontrados = libroService.busquedaInexacta(b);
                    System.out.println("lista " + librosEncontrados);
                    request.setAttribute("librosEncontrados", librosEncontrados);
                    request.getRequestDispatcher("vistaUsuarioLibros.jsp").forward(request, response);
                    break;
                case "ingresarLibroDesdeEmpleado":
                    //SESION PARA RECOGER EL EMPLEADO Y CREAR UN OBJ LIBROSCARGADOS
                    HttpSession sesionn = request.getSession(false);
                    Empleados em = (Empleados) sesionn.getAttribute("empleado");

                    //DATOS DEL LIBRO
                    String titulo = request.getParameter("titulo");
                    String autor = request.getParameter("autor");
                    String genero = request.getParameter("genero");
                    int paginas = Integer.parseInt(request.getParameter("paginas"));
                    double precio = Double.parseDouble(request.getParameter("precio"));

                    //AGREGA A LA TABLA LIBRO
                    Libros l = new Libros(titulo, autor, genero, paginas, precio);
                    libroService.agregarLibro(l);

                    System.out.println("libro: " + l.getIdlibro());
                    System.out.println("empleado: " + em.getIdEmpleado());

                    //AGREGA A LIBROS CARGADOS
                    Libroscargados lc = new Libroscargados(l.getIdlibro(), em.getIdEmpleado());
                    librocargadoservice.insertarLibroCargado(lc);

                    response.sendRedirect("EmpleadoServlet?accion=listar");

                    break;
                case "editar":

                    int idL = Integer.parseInt(request.getParameter("idLibro"));
                    Libros libroEdit = libroService.buscarLibroPorId(idL);
                    request.setAttribute("libroEncontrado", libroEdit);
                    request.getRequestDispatcher("editarLibro.jsp").forward(request, response);

                    break;
                case "eliminar":
                    int idLi = Integer.parseInt(request.getParameter("idLibro"));
                    Libros libroDelete = libroService.buscarLibroPorId(idLi);
                    libroService.eliminarLibro(libroDelete);
                    response.sendRedirect("EmpleadoServlet?accion=listar");
                    break;

                case "procesoEditar":

                    int id = Integer.parseInt(request.getParameter("ide"));
                    String titulo2 = request.getParameter("titulo");
                    String autor2 = request.getParameter("autor");
                    String genero2 = request.getParameter("genero");
                    int paginas2 = Integer.parseInt(request.getParameter("paginas"));
                    double precio2 = Double.parseDouble(request.getParameter("precio"));
                    
                    Libros lbencontrado = libroService.buscarLibroPorId(id);
                    Libros actualizado = new Libros(titulo2,autor2,genero2,paginas2,precio2);
                    
                    libroService.modificarLibro(lbencontrado, actualizado);
                    response.sendRedirect("EmpleadoServlet?accion=listarPorIdEmpleado");
                    
                    break;
                default:
                    break;
            }
        } else {
            List<Libros> libros = libroService.listarLibros();
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("vistaUsuarioLibros.jsp").forward(request, response);
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
