package hisab;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class ReportGenerator {
    Connection conn=DatabaseHandler.getConection();
    public  void generateReport(String reportFileName,String reportQuery) {
        try {
            
           String report=".\\src\\hisab\\report\\"+reportFileName+"";
           
           JasperDesign jd=JRXmlLoader.load(report);
           String query=reportQuery;
         
           JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(query);
            jd.setQuery(newQuery);
           JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
            
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
}
