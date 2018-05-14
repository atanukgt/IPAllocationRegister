/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Souvik
 */
@WebServlet(name = "printjspf", urlPatterns = {"/printjspf"})
public class printjspf extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
            
        try{
            
JasperReport jasperReport = null;
JasperDesign jasperDesign = null;
Map parameters = new HashMap();
Connection conn = ConnectionManager.getConnection();
//String path = getServletContext().getRealPath("/WEB-INF/");
jasperDesign = JRXmlLoader.load("E:\\Final project\\IPallocationregister\\src\\Xmldocs\\IPAllocationRegisterReport.jrxml");
jasperReport = JasperCompileManager.compileReport(jasperDesign);
byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);
OutputStream outStream = response.getOutputStream();
response.setContentType("application/pdf");
response.setContentLength(byteStream.length);
outStream.write(byteStream, 0, byteStream.length);


//          JavaCallJasperReport jrs = new JavaCallJasperReport();
                
//        Connection conn = ConnectionManager.getConnection();
//        String report="E:\\Final project\\IPallocationregister\\src\\Xmldocs\\IPAllocationRegisterReport.jrxml";
//        JasperReport jr=JasperCompileManager.compileReport(report);
//        JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
//        JasperViewer.viewReport(jp);
                
//        // Make sure the output directory exists.
//        File outDir = new File("C:/jasperoutput");
//        outDir.mkdirs();
// 
//        // PDF Exportor.
//        JRPdfExporter exporter = new JRPdfExporter();
// 
//        ExporterInput exporterInput = new SimpleExporterInput(jp);
//        // ExporterInput
//        exporter.setExporterInput(exporterInput);
// 
//        // ExporterOutput
//        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
//                "C:/jasperoutput/FirstJasperReport.pdf");
//        // Output
//        exporter.setExporterOutput(exporterOutput);
// 
//        //
//        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//        exporter.setConfiguration(configuration);
//        exporter.exportReport();

            }catch(Exception e)
            {
                System.out.println("Exception is ;"+e);
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet printjspf</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet printjspf at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
