/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Author : Ahsan, Hasan Mobarak 
 */
package com.fk.action;
import java.io.File;
import com.fk.bean.EmpBean;
import com.fk.database.DBconnection;
import com.opensymphony.xwork2.ModelDriven;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.apache.struts2.ServletActionContext;
import static org.apache.struts2.ServletActionContext.getServletContext;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleXlsExporterConfiguration;
import org.apache.commons.lang.xwork.StringUtils;


/**
 *
 * @author Dell
 */
public class ReportAction implements ModelDriven<EmpBean>{
    
    private EmpBean eBean=new EmpBean();
    java.io.File file1 = new java.io.File("TestWindow.java");
            String path = file1.getAbsolutePath();
            //String only_path = path.substring(0,path.lastIndexOf('/'));
            String only_path[] = path.split("TestWindow.java");
            //System.out.println(only_path[0]);
    
            // String reportPath = "F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASSET_V3/web/MyReports";
            // String reportOutPutPath = "F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASSET_V3/web/jasperreport/jasperoutput"; //WINDOWS
            // webapps/inventory/MyReports/
            
            // String reportPath = "/repository/fkl_asset_mgmt/MyReports"; //linux
            // String reportOutPutPath = "/repository/fkl_asset_mgmt/jasperreport/jasperoutput"; //LINUX
            // webapps/inventory/MyReports/
            
             String reportPath = "F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASSET_V4/web/MyReports";
             String reportOutPutPath = "F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASSET_V4/web/jasperreport/jasperoutput"; //WINDOWS
            
            
            
            
           // String reportPath = "/usr/share/apache-tomcat-9.0.31/webapps/FKL_ASSET_V4/MyReports"; //linux
           // String reportOutPutPath = "/usr/share/apache-tomcat-9.0.31/webapps/FKL_ASSET_V4/jasperreport/jasperoutput"; //LINUX
            
            
            
            // F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASST_MGMT3_3T/web/MyReports
            // String reportPath = "F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASSET_V3/web/MyReports"; //WINDOWS
            // String reportOutPutPath = "F:/FKL_Project_Workspaces/Project_WorkSpace_NetBeans/FKL_Asset_Management/FKL_ASSET_V3/web/jasperreport/jasperoutput"; //WINDOWS

            
    public String showReport() throws JRException, IOException {

        try {
            
            Connection con = DBconnection.getConnection();
            if (con == null){
                return "fail";
            }
            
            System.out.println("********** showReport is Fire ***********");
            //JasperReport jr = JasperCompileManager.compileReport("/repository/fkl_asset_mgmt/MyReports/allData10.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(reportPath + "/allData10.jrxml");

            //File f = new File("/MyReports/allData10.jrxml");
            //JasperReport jr = JasperCompileManager.compileReport(f.getAbsolutePath());
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

            // Make sure the output directory exists.
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();

            // PDF Exportor.
            JRPdfExporter exporter = new JRPdfExporter();

            ExporterInput exporterInput = new SimpleExporterInput(jp);
            // ExporterInput
            exporter.setExporterInput(exporterInput);

            // ExporterOutput
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                    reportOutPutPath + "/allData10.pdf");
            // Output
            exporter.setExporterOutput(exporterOutput);
            //JasperRunManager.runReportToPdf(jr, null, con);

            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            
            HttpServletResponse res = ServletActionContext.getResponse();
            File file = new File(reportOutPutPath + "/allData10.pdf");
            res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"allData10.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());
            //JasperViewer.viewReport(jp);*/
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
    
    
    
    
    public String showReportByEmpId() throws JRException, IOException{
        
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }
            String dept_id = getDeptid(eBean.getMdept());

            Map parametersMap1 = new HashMap();
            parametersMap1.put("dept_id", dept_id);

            JasperReport jr = JasperCompileManager.compileReport(reportPath + "/dept10.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap1, con);

            File outDir = new File(reportOutPutPath);   // D:/Hasan Mobarak/FKL IT Asset Register/Source/FKL_ASST_MGMT3_3T/web/jasperreport/jasperoutput
            outDir.mkdirs();

            // PDF Exportor.
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            // ExporterInput
            exporter.setExporterInput(exporterInput);
            // ExporterOutput
            // OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("/repository/fkl_asset_mgmt/jasperreport/jasperoutput/dept10.pdf");
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath + "/dept10.pdf");
            // Output
            exporter.setExporterOutput(exporterOutput);
        //JasperRunManager.runReportToPdf(jr, null, con);

            //
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            //
            HttpServletResponse res = ServletActionContext.getResponse();

            //File file = new File("/repository/fkl_asset_mgmt/jasperreport/jasperoutput/dept10.pdf");
            File file = new File(reportOutPutPath + "/dept10.pdf");
            res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"dept10.pdf\"");
            //res.setHeader("Content-Disposition", "attachment;filename=\"dept5.pdf\"");//"inline; filename=\"dept5.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());

            //JasperViewer.viewReport(jp);
            con.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            return "fail";
        }
        //eBean.setMessage("hjgyuf");
        return "success";
    }
    
    


     public String showReport2() throws JRException, IOException{
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }
            String id;
            if (eBean.getId().length() < 6) {             
                id = StringUtils.leftPad(eBean.getId(), 6, "0");
            } else {
                id = eBean.getId();
            }
            String mtype = null;
            int utype = 0;
            if ((eBean.getId().trim().isEmpty() == false)
                    && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty())) {
                utype = 1;
            }
            if ((eBean.getId().trim().isEmpty())
                    && (eBean.getIp().trim().isEmpty() == false) && (eBean.getFklid().trim().isEmpty())) {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(empdata.emp_name) as rowcount from mdata, empdata where mdata.id=empdata.id and mdata.ip='" + eBean.getIp() + "' ");
                resultSet.next();
                utype = resultSet.getInt("rowcount");
            }
            if ((eBean.getId().trim().isEmpty())
                    && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty() == false)) {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(empdata.emp_name) as rowcount from mdata, empdata where mdata.id=empdata.id and mdata.fklid='" + eBean.getFklid() + "' ");
                resultSet.next();
                utype = resultSet.getInt("rowcount");
            }
            String mywheree = "";
            Map parametersMap = new HashMap();
            if (utype > 0) {
                if ((eBean.getId().trim().isEmpty() == false)
                        && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty())) {
                    mywheree = " empdata.id='" + id + "'";
                }

                if ((eBean.getId().trim().isEmpty())
                        && (eBean.getIp().trim().isEmpty() == false) && (eBean.getFklid().trim().isEmpty())) {
                    mywheree = " mdata.ip='" + eBean.getIp() + "'";
                }
                if ((eBean.getId().trim().isEmpty())
                        && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty() == false)) {
                    mywheree = " mdata.fklid='" + eBean.getFklid() + "'";
                }
                eBean.setMessage2(mywheree);

                  //System.out.println(mywheree);
                parametersMap.put("mywhere", mywheree);

                //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\emp10.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(reportPath + "/emp10.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap, con);
                   //JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\simple_report.pdf"); 

                // Make sure the output directory exists.
                File outDir = new File(reportOutPutPath);
                outDir.mkdirs();

                // PDF Exportor.
                JRPdfExporter exporter = new JRPdfExporter();

                ExporterInput exporterInput = new SimpleExporterInput(jp);
                // ExporterInput
                exporter.setExporterInput(exporterInput);

                // ExporterOutput
                OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath + "/emp10.pdf");
                // Output
                exporter.setExporterOutput(exporterOutput);
               //JasperRunManager.runReportToPdf(jr, null, con);

                //
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();

                //
                HttpServletResponse res = ServletActionContext.getResponse();

                File file = new File(reportOutPutPath + "/emp10.pdf");
                res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
                res.setHeader("Content-Length", String.valueOf(file.length()));
                res.setHeader("Content-Disposition", "inline; filename=\"emp10.pdf\"");
                Files.copy(file.toPath(), res.getOutputStream());

                   //JasperViewer.viewReport(jp);
                con.close();

            } else {

                if ((eBean.getIp().trim().isEmpty() == false) && (eBean.getFklid().trim().isEmpty())) {
                    mywheree = " mdata.ip='" + eBean.getIp() + "'";
                }

                if ((eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty() == false)) {
                    mywheree = " mdata.fklid='" + eBean.getFklid() + "'";
                }

                /*if((eBean.getId().trim().isEmpty()==false) && (eBean.getDept().trim().isEmpty()==false)){
                 mywheree=" empdata.id="+eBean.getId()+" and dept='"+eBean.getDept()+"'";
                 } */
                eBean.setMessage2(mywheree);

                //System.out.println(mywheree);
                parametersMap.put("mywhere", mywheree);

                //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\prnt10.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(reportPath+"/prnt10.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap, con);
                 //JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\simple_report.pdf"); 

                // Make sure the output directory exists.
                File outDir = new File(reportOutPutPath);
                outDir.mkdirs();

                // PDF Exportor.
                JRPdfExporter exporter = new JRPdfExporter();

                ExporterInput exporterInput = new SimpleExporterInput(jp);
                // ExporterInput
                exporter.setExporterInput(exporterInput);

                // ExporterOutput
                OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/prnt10.pdf");
                // Output
                exporter.setExporterOutput(exporterOutput);
             //JasperRunManager.runReportToPdf(jr, null, con);

                //
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();

                //
                HttpServletResponse res = ServletActionContext.getResponse();

                File file = new File(reportOutPutPath+"/prnt10.pdf");
                res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
                res.setHeader("Content-Length", String.valueOf(file.length()));
                res.setHeader("Content-Disposition", "inline; filename=\"prnt10.pdf\"");
                Files.copy(file.toPath(), res.getOutputStream());

                 //JasperViewer.viewReport(jp);
                con.close();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }

        //eBean.setMessage("hjgyuf");
        return "success";

    }
    
        public String showReport3() throws JRException, IOException {
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }
            String dept_id = getDeptid(eBean.getMdept());
            Map parametersMap1 = new HashMap();
            parametersMap1.put("dept_id", dept_id);
            JasperReport jr = JasperCompileManager.compileReport(reportPath+"/dept10.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap1, con);
            File outDir = new File(reportOutPutPath);   // D:/Hasan Mobarak/FKL IT Asset Register/Source/FKL_ASST_MGMT3_3T/web/jasperreport/jasperoutput
            outDir.mkdirs();

            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/dept10.pdf");
          
            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            //
            HttpServletResponse res = ServletActionContext.getResponse();

            //File file = new File("/repository/fkl_asset_mgmt/jasperreport/jasperoutput/dept10.pdf");
            File file = new File(reportOutPutPath+"/dept10.pdf");
            res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"dept10.pdf\"");
            //res.setHeader("Content-Disposition", "attachment;filename=\"dept5.pdf\"");//"inline; filename=\"dept5.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());

            //JasperViewer.viewReport(jp);
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }

        //eBean.setMessage("hjgyuf");
        return "success";

    }


    
    public String showReport4() throws JRException, IOException
    {                       
        try {
            Connection con = DBconnection.getConnection();
            if(con == null){
                return "fail";
            }
            System.out.println("parameters: "+eBean.getMtype());
            Map<String, Object> parameters = new HashMap<String, Object>(); 
            parameters.put("mtype", eBean.getMtype());
            if(eBean.getMtype().equals("Desktop")||eBean.getMtype().equals("Laptop")){               
                JasperReport jr=JasperCompileManager.compileReport(reportPath+"/type10.jrxml");
                JasperPrint jp=JasperFillManager.fillReport(jr,parameters,con);
                File outDir = new File(reportOutPutPath);
                outDir.mkdirs();
                JRPdfExporter exporter = new JRPdfExporter();
                ExporterInput exporterInput = new SimpleExporterInput(jp);
                exporter.setExporterInput(exporterInput);
                OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/type10.pdf");
                exporter.setExporterOutput(exporterOutput);
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
                HttpServletResponse res = ServletActionContext.getResponse();
                File file = new File(reportOutPutPath+"/type10.pdf");
                res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
                res.setHeader("Content-Length", String.valueOf(file.length()));
                res.setHeader("Content-Disposition", "inline; filename=\"type10.pdf\"");
                Files.copy(file.toPath(), res.getOutputStream());
                con.close();           
            }else{
                JasperReport jr=JasperCompileManager.compileReport(reportPath+"/prntype10.jrxml");
                JasperPrint jp=JasperFillManager.fillReport(jr,parameters,con);
                File outDir = new File(reportOutPutPath);
                outDir.mkdirs();
                JRPdfExporter exporter = new JRPdfExporter();
                ExporterInput exporterInput = new SimpleExporterInput(jp);
                exporter.setExporterInput(exporterInput);
                OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/prntype10.pdf");
                exporter.setExporterOutput(exporterOutput);
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
                HttpServletResponse res = ServletActionContext.getResponse();
                File file = new File(reportOutPutPath+"/prntype10.pdf");
                res.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
                res.setHeader("Content-Length", String.valueOf(file.length()));
                res.setHeader("Content-Disposition", "inline; filename=\"prntype10.pdf\"");
                Files.copy(file.toPath(), res.getOutputStream());
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }
      return "success";
    }
    
    
    
    
    
    
    public String allProductReport() throws JRException, IOException {
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }            
            String strperson7 = "UPDATE mbuydata  SET mbuydata.remlife = ( SELECT (mbuydata.prdtlife - (12 * (YEAR(sysdate()) - YEAR(buydate)) + (MONTH(sysdate()) - MONTH(buydate))))), expired=?  ";
            PreparedStatement ps7 = con.prepareStatement(strperson7);
            ps7.setString(1, "Expired");
            ps7.addBatch();
            ps7.executeBatch();
            ps7.close();
            JasperReport jr = JasperCompileManager.compileReport(reportPath + "/allProduct10.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath + "/allProduct10.pdf");
            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            HttpServletResponse res = ServletActionContext.getResponse();
            File file = new File(reportOutPutPath +"/allProduct10.pdf");
            res.setContentType("application/pdf");
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"allProduct10.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return "fail";
        }
        return "success";
    }


    
    
    
    
    public String assetTopSheet() throws JRException, IOException {
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }            
            String strperson7 
                    = "CREATE OR REPLACE VIEW topSheet AS\n" +
                            "	SELECT \n" +
                            "	    empdata.id,\n" +
                            "	    empdata.emp_name,\n" +
                            "	    empdata.emp_designation,\n" +
                            "	    empdata.dept,\n" +
                            "	    empdata.date,\n" +
                            "	    empdata.pvs_extension,\n" +
                            "	    mdata.fklid,\n" +
                            "	    mdata.dept_id,\n" +
                            "	    mdata.ip,\n" +
                            "	    mdata.hdd,\n" +
                            "	    mdata.mboard,\n" +
                            "	    mdata.ram,\n" +
                            "	    mdata.chip,\n" +
                            "	    mdata.mtype,\n" +
                            "	    mdata.pid,\n" +
                            "	    mdata.remarks,\n" +
                            "	    masgndata.mid,\n" +
                            "	    masgndata.nstatus,\n" +
                            "	    masgndata.asgn_update_date\n" +
                            "	FROM \n" +
                            "	    empdata, mdata, masgndata \n" +
                            "	WHERE \n" +
                            "	    mdata.fklid=masgndata.fklid \n" +
                            "	AND  \n" +
                            "	    masgndata.id=empdata.id ;";
            PreparedStatement ps7 = con.prepareStatement(strperson7);
            ps7.executeUpdate();
            ps7.close();
            JasperReport jr = JasperCompileManager.compileReport(reportPath + "/DepartmentWiseAssetQtyTopSheet.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath + "/DepartmentWiseAssetQtyTopSheet.pdf");
            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            HttpServletResponse res = ServletActionContext.getResponse();
            File file = new File(reportOutPutPath +"/DepartmentWiseAssetQtyTopSheet.pdf");
            res.setContentType("application/pdf");
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"DepartmentWiseAssetQtyTopSheet.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return "fail";
        }
        return "success";
    }    
    
    
    
    
    // allITAsset
    public String allITAsset() throws JRException, IOException {
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }                      
            JasperReport jr = JasperCompileManager.compileReport(reportPath + "/deptWiseAllITAsset.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath + "/deptWiseAllITAsset.pdf");
            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            HttpServletResponse res = ServletActionContext.getResponse();
            File file = new File(reportOutPutPath +"/deptWiseAllITAsset.pdf");
            res.setContentType("application/pdf");
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"deptWiseAllITAsset.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            return "fail";
        }
        return "success";
    }
    
    
    
    
    public String productReport() throws JRException, IOException, InterruptedException{

        try {
            Connection con = DBconnection.getConnection();
            if(con == null){
                return "fail";
            }
            System.out.println(eBean.getPid());
            String strperson7="UPDATE mbuydata  SET mbuydata.remlife = ( SELECT (mbuydata.prdtlife - (12 * (YEAR(sysdate()) - YEAR(buydate)) + (MONTH(sysdate()) - MONTH(buydate))))) where pid=? ";
            PreparedStatement ps7=con.prepareStatement(strperson7);        
            ps7.setInt(1,eBean.getPid());       
            ps7.addBatch();
            ps7.executeBatch();
            ps7.close();
            Map parametersMap1 = new HashMap();  
            parametersMap1.put("pid",eBean.getPid());
            JasperReport jr=JasperCompileManager.compileReport(reportPath+"/product10.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,parametersMap1,con);
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
            reportOutPutPath+"/product10.pdf");Thread.sleep(30000);
            exporter.setExporterOutput(exporterOutput);
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            HttpServletResponse res = ServletActionContext.getResponse();
        
            File file = new File(reportOutPutPath+"/product10.pdf");
            res.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"product10.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }
      return "success";
    }
    

    
    

    @Override
    public EmpBean getModel() {

        return  eBean;
    }
    
    
    public String showReportex() throws JRException, IOException
    {
      
         
        
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return "fail";
            }
            
          
           
            
            
            
            
            //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\allData10.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(reportPath+"/allData10_2.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
            // Make sure the output directory exists.
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();
            JRXlsExporter exporter2 = new JRXlsExporter();
            
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            // ExporterInput
            exporter2.setExporterInput(exporterInput);
            // ExporterOutput
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/allData10_2.xls");
            // Output
            exporter2.setExporterOutput(exporterOutput);
            //JasperRunManager.runReportToPdf(jr, null, con);
 
        //

           
        
 
       
 
        //
        SimpleXlsExporterConfiguration configuration = new SimpleXlsExporterConfiguration();
        exporter2.setConfiguration(configuration);
        exporter2.exportReport();
        
       //
        HttpServletResponse res = ServletActionContext.getResponse();
        
        File file = new File(reportOutPutPath+"/allData10_2.xls");
	res.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
	res.setHeader("Content-Length", String.valueOf(file.length()));
        res.setHeader("Content-Disposition", "inline; filename=\"allData10_2.xls\"");
	Files.copy(file.toPath(), res.getOutputStream());
        
            
            //JasperViewer.viewReport(jp);*/
            
          
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }
      return "success";
        
    }
    
    
    
    public String showReport6() throws JRException, IOException, InterruptedException
    {               
        System.out.println("test.......");
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return "fail";
            }
           String mywheree="";
           Map parametersMap = new HashMap(); 
           if((eBean.getDept().trim().isEmpty()==false ) && (eBean.getMdept().trim().isEmpty()==false)){               
               eBean.setMdept("");
               System.out.println("test..blanking mdept");           
           }

           if((eBean.getMtype().trim().isEmpty()==false) 
                && (eBean.getMdept().trim().isEmpty()|| eBean.getMdept().equals("") ) && (eBean.getDept().trim().isEmpty() || eBean.getDept().equals(""))   
             ){
               System.out.println("test..only mtype"+eBean.getMtype()); 
               mywheree=" mdata.mtype='"+eBean.getMtype()+"'";
           }
           
           if((eBean.getMtype().trim().isEmpty()==false) 
                && (eBean.getMdept().trim().isEmpty() || eBean.getMdept().equals("") ) && (eBean.getDept().trim().isEmpty()==false ||  !eBean.getDept().equals(""))   
             ){
               
               System.out.println("test.. mtype with dept"); 
                mywheree="  empdata.dept='"+eBean.getDept()+"' and mdata.mtype='"+eBean.getMtype()+"'  ";
           }
           
           if((eBean.getMtype().trim().isEmpty()==false ) 
                && (eBean.getMdept().trim().isEmpty()==false || !eBean.getMdept().equals("")) && (eBean.getDept().trim().isEmpty() || eBean.getDept().equals(""))    
             ){
               
               System.out.println("test.. mtype with mdept"); 
               
               String dept_id=getDeptid(eBean.getMdept());
               
                mywheree=" mdata.mtype='"+eBean.getMtype()+"' and  mdata.dept_id='"+dept_id+"'  ";
           } 
            eBean.setMessage2(mywheree);
            parametersMap.put("mywhere", mywheree);
            Map parametersMap1 = new HashMap();  
            parametersMap1.put("mtype",eBean.getMtype());
            JasperReport jr=JasperCompileManager.compileReport(reportPath+"/mtype10.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,parametersMap,con);
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();            
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);            
            exporter.setExporterInput(exporterInput);
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/mtype10.pdf");
            exporter.setExporterOutput(exporterOutput);            
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            HttpServletResponse res = ServletActionContext.getResponse();
            File file = new File(reportOutPutPath+"/mtype10.pdf");
            res.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"mtype10.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            return "fail";
        }
      return "success";        
    }
    
    
    
    
    
    
    
    public String showReportHis1() throws JRException, IOException
    {
      
         
        
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return "fail";
            }
            
            // to make inputed id in 6 digit if it is less then 6 digit
            String id;
            
            if(eBean.getId().length()<6){
                //id="000000".substring(eBean.getId().length()) + eBean.getId();
                id=StringUtils.leftPad(eBean.getId(), 6,"0");
            }else{
                id=eBean.getId();
            }
            
            
            
            //get the machine type
            String mtype=null;
            
            if((eBean.getId().trim().isEmpty()==false) 
                && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty())   
             ){
                mtype="Desktop";
                
            }

            if((eBean.getId().trim().isEmpty()) 
                 && (eBean.getIp().trim().isEmpty()==false) && (eBean.getFklid().trim().isEmpty())   
              ){
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select distinct mtype from history where ip='"+eBean.getIp()+"' ");
                
                resultSet.next();
                mtype= resultSet.getString("mtype");
               
               } 

            if((eBean.getId().trim().isEmpty()) 
                 && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty()==false)   
              ){
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select distinct mtype from history where fklid='"+eBean.getFklid()+"' ");
                resultSet.next();
                mtype= resultSet.getString("mtype");
                
               }

           String mywheree="";
           Map parametersMap = new HashMap(); 

           if(mtype.equals("Desktop")|| mtype.equals("Laptop")){
           
                  if((eBean.getId().trim().isEmpty()==false) 
                    && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty())   
                        ){
                           mywheree=" history.id='"+id+"'";
                  }

                  if((eBean.getId().trim().isEmpty()) 
                       && (eBean.getIp().trim().isEmpty()==false) && (eBean.getFklid().trim().isEmpty())   
                    ){
                       mywheree=" history.ip='"+eBean.getIp()+"'";
                  } 

                  if((eBean.getId().trim().isEmpty()) 
                       && (eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty()==false)   
                    ){
                       mywheree=" history.fklid='"+eBean.getFklid()+"'";
                  } 

                  eBean.setMessage2(mywheree);

                  //System.out.println(mywheree);

                  parametersMap.put("mywhere",mywheree);

                   //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\emp10.jrxml";
                   JasperReport jr=JasperCompileManager.compileReport(reportPath+"/his1.jrxml");
                   JasperPrint jp=JasperFillManager.fillReport(jr,parametersMap,con);
                   //JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\simple_report.pdf"); 

                   // Make sure the output directory exists.
              File outDir = new File(reportOutPutPath);
               outDir.mkdirs();

               // PDF Exportor.
               JRPdfExporter exporter = new JRPdfExporter();

               ExporterInput exporterInput = new SimpleExporterInput(jp);
               // ExporterInput
               exporter.setExporterInput(exporterInput);

               // ExporterOutput
               OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                       reportOutPutPath+"/his1.pdf");
               // Output
               exporter.setExporterOutput(exporterOutput);
               //JasperRunManager.runReportToPdf(jr, null, con);

               //
               SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
               exporter.setConfiguration(configuration);
               exporter.exportReport();

              //
               HttpServletResponse res = ServletActionContext.getResponse();

               File file = new File(reportOutPutPath+"/his1.pdf");
               res.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
               res.setHeader("Content-Length", String.valueOf(file.length()));
               res.setHeader("Content-Disposition", "inline; filename=\"his1.pdf\"");
               Files.copy(file.toPath(), res.getOutputStream());

                   con.close();
           }else{

                if((eBean.getIp().trim().isEmpty()==false) && (eBean.getFklid().trim().isEmpty())   
                  ){
                     mywheree=" history.ip='"+eBean.getIp()+"'";
                } 

                if((eBean.getIp().trim().isEmpty()) && (eBean.getFklid().trim().isEmpty()==false)   
                  ){
                     mywheree=" history.fklid='"+eBean.getFklid()+"'";
                } 

                /*if((eBean.getId().trim().isEmpty()==false) && (eBean.getDept().trim().isEmpty()==false)){
                 mywheree=" empdata.id="+eBean.getId()+" and dept='"+eBean.getDept()+"'";
                } */
                eBean.setMessage2(mywheree);

                //System.out.println(mywheree);

                parametersMap.put("mywhere",mywheree);

                 //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\prnt10.jrxml";
                 JasperReport jr=JasperCompileManager.compileReport(reportPath+"/his3.jrxml");
                 JasperPrint jp=JasperFillManager.fillReport(jr,parametersMap,con);
                 //JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\simple_report.pdf"); 

                 // Make sure the output directory exists.
            File outDir = new File(reportOutPutPath);
             outDir.mkdirs();

             // PDF Exportor.
             JRPdfExporter exporter = new JRPdfExporter();

             ExporterInput exporterInput = new SimpleExporterInput(jp);
             // ExporterInput
             exporter.setExporterInput(exporterInput);

             // ExporterOutput
             OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                     reportOutPutPath+"/his3.pdf");
             // Output
             exporter.setExporterOutput(exporterOutput);
             //JasperRunManager.runReportToPdf(jr, null, con);

             //
             SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
             exporter.setConfiguration(configuration);
             exporter.exportReport();

            //
             HttpServletResponse res = ServletActionContext.getResponse();

             File file = new File(reportOutPutPath+"/his3.pdf");
             res.setHeader("Content-Type",    getServletContext().getMimeType(file.getName()));
             res.setHeader("Content-Length", String.valueOf(file.length()));
             res.setHeader("Content-Disposition", "inline; filename=\"his3.pdf\"");
             Files.copy(file.toPath(), res.getOutputStream());

                 con.close();
           
           
           }
           
           
          
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }
        

        //eBean.setMessage("hjgyuf");
      return "success";
        
    }
    
     public String showReportHis2() throws JRException, IOException {

        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }

            String mywheree =  eBean.getDate1();
            String mywheree2 = eBean.getDate2();
                           // SELECT * FROM history WHERE  DATE BETWEEN '2017-12-31' AND '2018-07-23';
            System.out.println("******************************* Date BETWEEN Result : "+mywheree+" and "+mywheree2);
            Map parametersMap = new HashMap();

            parametersMap.put("mywhere", mywheree);
            parametersMap.put("mywheree2", mywheree2);

            //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\emp10.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath+"/his2.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap, con);
                   //JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\simple_report.pdf"); 

            // Make sure the output directory exists.
            File outDir = new File(reportOutPutPath);
            outDir.mkdirs();

            // PDF Exportor.
            JRPdfExporter exporter = new JRPdfExporter();

            ExporterInput exporterInput = new SimpleExporterInput(jp);
            // ExporterInput
            exporter.setExporterInput(exporterInput);

            // ExporterOutput
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                    reportOutPutPath+"/his2.pdf");
            // Output
            exporter.setExporterOutput(exporterOutput);
               //JasperRunManager.runReportToPdf(jr, null, con);

            //
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            //
            HttpServletResponse res = ServletActionContext.getResponse();

            File file = new File(reportOutPutPath+"/his2.pdf");
            res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"his2.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());

            //JasperViewer.viewReport(jp);
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
 
        public String showReport7() throws JRException, IOException {

        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }
            String dept = eBean.getDept();
            System.out.println("   *************** Sub Depertment Value pass : "+dept);
            Map parametersMap1 = new HashMap();
            parametersMap1.put("dept", dept);

            //String path="C:\\Users\\Dell\\JaspersoftWorkspace\\MyReports\\subdept10.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath+"/subdept10.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap1, con);

            // Make sure the output directory exists.
            File outDir = new File(reportOutPutPath);
            System.out.println("   *************** System parse MkDire ********: "+dept); // 
            outDir.mkdirs();

            // PDF Exportor.
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            // ExporterInput
            exporter.setExporterInput(exporterInput);
            // ExporterOutput
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath+"/subdept10.pdf");
            System.out.println("   *************** System parse exporterOutput ********: "+dept);
            // Output
            exporter.setExporterOutput(exporterOutput);
            //JasperRunManager.runReportToPdf(jr, null, con);

            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            //
            HttpServletResponse res = ServletActionContext.getResponse();

            File file = new File(reportOutPutPath+"/subdept10.pdf");
            System.out.println("   *************** System parse and Create File ********: "+dept);
            res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"subdept10.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());

            //JasperViewer.viewReport(jp);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            return "fail";
        }
        //eBean.setMessage("hjgyuf");
        return "success";
    }


    
    public String getDeptid(String mdept){
        
        String dept_id=null;
        
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return "fail";
            }
            
            
        //get dept_id from main_deptlist 
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select dept_id from main_deptlist where dept_name='"+mdept+"' ");
        resultSet.next();
        dept_id= resultSet.getString("dept_id");
        resultSet.close();
        con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        return dept_id;
    }
    
    
    public String getDeptForSubDeptRteport(String mdept){
        
        String subdept=null;
        
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return "fail";
            }
            
            
        //get subdept name from main_deptlist 
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select dept_id from main_deptlist where dept_name='"+mdept+"' ");
        resultSet.next();
        subdept= resultSet.getString("dept_id");
        resultSet.close();
        con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        return subdept;
    }
    
    
        public String testFunctionOfSubDepartmant() throws JRException, IOException {
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return "fail";
            }
            //String subdept = getDeptid(eBean.getMdept());
            String subdept = eBean.getDept();
            System.out.println("testFunctionOfSubDepartmant() get value of subdept :"+subdept);
            Map parametersMap1 = new HashMap();
            parametersMap1.put("subdept", subdept);

            JasperReport jr = JasperCompileManager.compileReport(reportPath + "/subdept10.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametersMap1, con);

            File outDir = new File(reportOutPutPath);   // D:/Hasan Mobarak/FKL IT Asset Register/Source/FKL_ASST_MGMT3_3T/web/jasperreport/jasperoutput
            outDir.mkdirs();

            // PDF Exportor.
            JRPdfExporter exporter = new JRPdfExporter();
            ExporterInput exporterInput = new SimpleExporterInput(jp);
            // ExporterInput
            exporter.setExporterInput(exporterInput);
            // ExporterOutput
            // OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("/repository/fkl_asset_mgmt/jasperreport/jasperoutput/dept10.pdf");
            OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(reportOutPutPath + "/subdept10.pdf");
            // Output
            exporter.setExporterOutput(exporterOutput);
            //JasperRunManager.runReportToPdf(jr, null, con);

            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            //
            HttpServletResponse res = ServletActionContext.getResponse();

            //File file = new File("/repository/fkl_asset_mgmt/jasperreport/jasperoutput/dept10.pdf");
            File file = new File(reportOutPutPath + "/subdept10.pdf");
            res.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
            res.setHeader("Content-Length", String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "inline; filename=\"subdept10.pdf\"");
            //res.setHeader("Content-Disposition", "attachment;filename=\"dept5.pdf\"");//"inline; filename=\"dept5.pdf\"");
            Files.copy(file.toPath(), res.getOutputStream());

            //JasperViewer.viewReport(jp);
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "fail";
        }

        //eBean.setMessage("hjgyuf");
        return "success";

    }

}
