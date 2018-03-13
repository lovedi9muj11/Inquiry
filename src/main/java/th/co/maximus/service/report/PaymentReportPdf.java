package th.co.maximus.service.report;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import th.co.maximus.bean.ReportPaymentBean;

@Service("paymentReportPdf")
public class PaymentReportPdf {
	public byte[] jasperGanarationPDF(String fileName , List<ReportPaymentBean> date, Map<String, Object> params) throws JRException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JRPdfExporter exporter = new JRPdfExporter();
        JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(date));
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        exporter.exportReport();
		return outputStream.toByteArray();
	}

}
