package util;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@SuppressWarnings({"rawtypes","unchecked"})
public class reportUtil implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public byte[] geraRelatorioPDF(List listaDados, String nomeRelatorio, HashMap<String, Object> params, ServletContext servletContext) throws Exception {
		
		 /* cria a lista de dados que vem do nosso SQL da consulta feita*/
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaDados);
		
		String caminhoJasper = servletContext.getRealPath("relatorio") + File.separator + nomeRelatorio + ".jasper";
		
		JasperPrint impressoraJasper = JasperFillManager.fillReport(caminhoJasper, params, jrbcds);
		
		return JasperExportManager.exportReportToPdf(impressoraJasper);
		
	}

	public byte[] geraRelatorioPDF(List listaDados, String nomeRelatorio, ServletContext servletContext) throws Exception {
		
		 /* cria a lista de dados que vem do nosso SQL da consulta feita*/
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaDados);
		
		String caminhoJasper = servletContext.getRealPath("relatorio") + File.separator + nomeRelatorio + ".jasper";
		
		JasperPrint impressoraJasper = JasperFillManager.fillReport(caminhoJasper, new HashMap(), jrbcds);
		
		return JasperExportManager.exportReportToPdf(impressoraJasper);
		
	}
	
}
