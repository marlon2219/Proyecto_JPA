/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.web;

import com.dominio.Compraventas;
import com.dominio.Empleados;
import com.dominio.Libros;
import com.dominio.LibrosHasUsuarios;
import com.dominio.Usuarios;
import com.service.CompraventasService;
import com.service.EmpleadoService;
import com.service.LibroHasUsuariosService;
import com.service.LibroService;
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
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
    LibroService libroService;
    @Inject
    CompraventasService compraventasService;
    @Inject
    LibroHasUsuariosService libroHasUsuariosService;
    @Inject
    UsuarioService usuarioService;
    @Inject
    EmpleadoService empleadoService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String accion = request.getParameter("accion");
        System.out.println("accionnn: " + accion);

        if (accion != null) {
            switch (accion) {
                case "insertarEmpleado":
                    String nombre = request.getParameter("nombre");
                    String dni = request.getParameter("dni");
                    String correo = request.getParameter("correo");
                    String tlf = request.getParameter("telefono");
                    String dir = request.getParameter("direccion");
                    String pas = request.getParameter("contrasena");

                    Empleados empleadoNew = new Empleados(nombre, dni, correo, tlf, dir, pas);
                    empleadoService.registrarEmpleado(empleadoNew);

                    listaEmpleados(request, response);

                    request.getRequestDispatcher("vistaRoot.jsp").forward(request, response);
                    break;
                case "editar":
                    int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    Empleados emEdit = empleadoService.encontrarEmpleadoPorId(idEmpleado);
                    request.setAttribute("empleadoEncontrado", emEdit);
                    request.getRequestDispatcher("editarEmpleado.jsp").forward(request, response);
                    break;
                case "modificarEmpleado":
                    System.out.println("entramos en mdifcar empleado");
                    int idEm = Integer.parseInt(request.getParameter("ide"));
                    Empleados e = empleadoService.encontrarEmpleadoPorId(idEm);
                    System.out.println("entramos en mdifcar empleado2222");
                    String nom = request.getParameter("nombre");
                    String docu = request.getParameter("dni");
                    String cor = request.getParameter("correo");
                    String tel = request.getParameter("telefono");
                    String di = request.getParameter("direccion");
                    String ps = request.getParameter("contrasena");
                    Empleados empleActulizado = new Empleados(e.getIdEmpleado(), nom, docu, cor, tel, di, ps);

                    empleadoService.modificarEmpleado(e, empleActulizado);

                    listaEmpleados(request, response);
                    request.getRequestDispatcher("vistaRoot.jsp").forward(request, response);

                    break;
                case "eliminar":
                    int ide = Integer.parseInt(request.getParameter("idEmpleado"));
                    Empleados emmm = empleadoService.encontrarEmpleadoPorId(ide);
                    empleadoService.eliminarEmpleado(emmm);
                    listaEmpleados(request, response);
                    request.getRequestDispatcher("vistaRoot.jsp").forward(request, response);
                    break;
                case "listarEmpleados":
                    listaEmpleados(request, response);
                    request.getRequestDispatcher("vistaRoot.jsp").forward(request, response);
                    break;
                case "listarUsuarios":
                    listaUsuarios(request, response);
                    request.getRequestDispatcher("vistaRootUsuarios.jsp").forward(request, response);

                    break;
                case "editarUsuario":
                    //BUSCA LOS DATOS DEL USUARIO
                    int ideUs = Integer.parseInt(request.getParameter("idUsuario"));

                    Usuarios usuEdit = usuarioService.encontrarUsuarioPorId(ideUs);
                    request.setAttribute("usuarioEncontrado", usuEdit);
                    request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);

                    break;
                case "modificarUsuario":
                    //ACTUALIZA EL USUARIO CON LOS DATOS TRAIDOS DEL FORMULARIO
                    int idee = Integer.parseInt(request.getParameter("ide"));
                    String nomb = request.getParameter("nombre");
                    String ddnii = request.getParameter("dni");
                    String corr = request.getParameter("correo");
                    String dirr = request.getParameter("direccion");
                    String tll = request.getParameter("telefono");
                    String pss = request.getParameter("contrasena");
                    double saa = Double.parseDouble(request.getParameter("saldo"));
                    Usuarios objActulizado = new Usuarios(idee, nomb, ddnii, corr, dirr, tll, pss, saa);

                    Usuarios usuEdit2 = usuarioService.encontrarUsuarioPorId(idee);
                    usuarioService.modificarUsuario(usuEdit2, objActulizado);

                    listaUsuarios(request, response);
                    request.getRequestDispatcher("vistaRootUsuarios.jsp").forward(request, response);

                    break;
                case "eliminarUsuario":
                    int ideUs2 = Integer.parseInt(request.getParameter("idUsuario"));
                    Usuarios uu = usuarioService.encontrarUsuarioPorId(ideUs2);
                    usuarioService.eliminarUsuario(uu);
                    listaUsuarios(request, response);
                    request.getRequestDispatcher("vistaRootUsuarios.jsp").forward(request, response);
                    break;
                    
                case "listarLibrosHasUsuarios":
                    List<LibrosHasUsuarios> listaLibrosGurdados = libroHasUsuariosService.listarLibroHasUsuario();
                    System.out.println("listaaaaa de libros guardados: "+listaLibrosGurdados.get(1).getLibros().getPrecio());
                    request.setAttribute("listadoV", listaLibrosGurdados);
                    request.getRequestDispatcher("vistaRootLibrosGuardados.jsp").forward(request, response);
                    break;
                case "listarCompraVentas":
                    double ttotal = 0;
                    List<Compraventas> cv = compraventasService.listadoCompraVentaas();
                    request.setAttribute("listadoVF", cv);
                    ttotal =  total(cv);
                    request.setAttribute("total", ttotal);
                    request.getRequestDispatcher("vistaRootVentas.jsp").forward(request, response);
                    break;
                case "listarLibros":
                    List<Libros> lb = libroService.listarLibros();
                    System.out.println("");
                    request.setAttribute("libros", lb);
                    request.getRequestDispatcher("vistaRootLibros.jsp").forward(request, response);
                    
                    break;
                case "listarBusqueda":
                    String bus = request.getParameter("busqueda");
                    List<Empleados> resultado = empleadoService.busquedaEmpleados(bus);
                    request.setAttribute("busquedaEmple", resultado);
                    request.getRequestDispatcher("vistaRoot.jsp").forward(request, response);
                    
                    break;
                case "listarUsuariosBusqueda":
                    String bus2 = request.getParameter("busqueda");
                    List<Usuarios> resul = usuarioService.listaDeBusqueda(bus2);
                    request.setAttribute("resultadoo", resul);
                    request.getRequestDispatcher("vistaRootUsuarios.jsp").forward(request, response);
                    break;
                    
                case "listarBusquedaVentas":
                    
                    
                    String busquedaa = request.getParameter("busqueda");
                    System.out.println("criteriooo: "+busquedaa);
                    List<Compraventas> l = compraventasService.BuscarPorUsuario(busquedaa);
                    System.out.println("listaaa: "+l.toString());
                    
                    
                     double total2 =  total(l);
                    request.setAttribute("total", total2);
                    request.setAttribute("listadoVFOrdenada", l);
                    request.getRequestDispatcher("vistaRootVentas.jsp").forward(request, response);
                    
                    
                    break;
                    
                case "cerrarSesionRoot":
                    cerrarSesion(request, response);
                    break;
                default:
                    break;
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void listaEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Empleados> empleados = empleadoService.listaEmpleados();
        request.setAttribute("empleados", empleados);
        request.setAttribute("totempleados", empleados.size());
    }

    public void listaUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Usuarios> usuarios = usuarioService.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("totusuarios", usuarios.size());
    }
    public Double total(List<Compraventas> ls){
        double total = 0;
            for (Compraventas venta : ls) {
            total += venta.getLibrosIdlibro().getPrecio();
        }
        return total;
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
