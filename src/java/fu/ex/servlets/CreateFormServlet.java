/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.ex.servlets;

import fu.ex.daos.ComputerDAO;
import fu.ex.daos.RoomDAO;
import fu.ex.dtos.ComputerDTO;
import fu.ex.dtos.RoomDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class CreateFormServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            RoomDAO dao = new RoomDAO();
            List<RoomDTO> listRoom = dao.getAllRooms();
            request.setAttribute("listRooms", listRoom);

        } catch (Exception e) {
            e.printStackTrace();
            log("ERROR at CreateFormServlet: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("computerform.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("txtID");
            String cpu = request.getParameter("txtCPU");
            String vga = request.getParameter("txtVGA");
            String hardDisk = request.getParameter("txtHardDisk");
            String ram = request.getParameter("txtRAM");
            String monitor = request.getParameter("txtMonitor");
            String room = request.getParameter("cboRoom");
            String[] roomID = room.split("-");
            System.out.println(roomID[0]);

            if (id == null || cpu == null || vga == null || hardDisk == null || ram == null || monitor == null || room == null) {
                response.sendRedirect("CreateFormServlet?msg=can'tEmpty");
            } else {
                ComputerDAO dao = new ComputerDAO();
                RoomDAO rdao = new RoomDAO();
                RoomDTO rdto = rdao.getRoomByID(roomID[0]);
                ComputerDTO cdto = new ComputerDTO(id, cpu, hardDisk, ram, vga, monitor, rdto);
                boolean check = dao.insert(cdto);
                System.out.println(check);
                if (check == true) {
                    response.sendRedirect("LoadListComputerServlet");
                } else {
                    response.sendRedirect("CreateFormServlet?msg=Error!");
                }
            }
        } catch (Exception e) {
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
