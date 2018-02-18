package th.co.maximus.report.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EpisReportController {
	@SuppressWarnings("unchecked")
	@RequestMapping("/previewPaymentEpisOffline.html") 
	public void previewReturnStockBySerialHTML(HttpServletRequest request, HttpServletResponse response, Model model,String stockId) throws Exception {
		String JASPER_JRXML_FILENAME = "InvEpisPayment";
		request.setAttribute("documentReport", "-1");
//		inquiryReturnStockController.inquiryReturnStockBySerialJSONHandler(request, response, model);
//		List<InventoryReturnStockBySerialTO> collections = (List<InventoryReturnStockBySerialTO>)request.getAttribute("inquiryReturnStockBySerial");
//		if(AppUtil.isCollectionHasValue(collections)) {
//			previewReturnStockBySerial(request, response, collections, JASPER_JRXML_FILENAME,stockId);
//		}
	}
	
//	private void  previewReturnStockBySerialDetail(HttpServletRequest request, HttpServletResponse response, List<InventoryReturnStockByDetailTO> collections, final String JASPER_JRXML_FILENAME) throws Exception {
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		List<InventoryReturnStockByDetailTO> printCollections = new ArrayList<InventoryReturnStockByDetailTO>();
//		InventoryReturnStockByDetailTO serialObject = (InventoryReturnStockByDetailTO) collections.get(0);
//		serialObject.setImagePathRpt(context.getRealPath("images") + File.separatorChar + "CATTelecom_Logo.png");
//		serialObject.setDocumentDate(new SimpleDateFormat(DateUtil.STANDARD_DATE_TIME_PATTERN, ENGLISH).format(new java.util.Date()));
//		serialObject.setDocumentCreatedDt(new SimpleDateFormat(DateUtil.STANDARD_DATE_PATTERN, ENGLISH).format(serialObject.getCreatedDate()));
////		serialObject.setBranchCode((String)request.getSession().getAttribute(AUTHENTICATED_BRANCODE));
//		serialObject.setBranchCode((String)request.getSession().getAttribute(AUTHENTICATED_BRANCHBP));//Edit By Nick 2016/11/22
//		String branchCode = (String)request.getSession().getAttribute(AUTHENTICATED_BRANCHBP);
//		String branchName = (String)request.getSession().getAttribute(AUTHENTICATED_BRANNAME);
//		if(branchCode.equals("00000")){
//			if(branchName.equals(messages.getMessage("rpt.text.bpl", null, null))){
//				serialObject.setBranchName((String)request.getSession().getAttribute(AUTHENTICATED_BRANNAME));
//			}else{
//				serialObject.setBranchName(messages.getMessage("rpt.text.bpl", null, null) + " "  + (String)request.getSession().getAttribute(AUTHENTICATED_BRANNAME));
//			}	
//		}else{
//			serialObject.setBranchName((String)request.getSession().getAttribute(AUTHENTICATED_BRANNAME));
//		}
//		serialObject.setBelongName((String)request.getSession().getAttribute(AUTHENTICATED_BELONGNAME));//Edit By Nick 2016/11/22
//		serialObject.setUserName((String)  request.getSession().getAttribute(AUTHENTICATED_REALNAME));
//		serialObject.setCompanyName(((MgCompanydetail) request.getSession().getAttribute(AUTHENTICATED_CATNAME)).getCompName());
//		
////		String owners = "";
////		if("L".equals(serialObject.getSegment())){
////			owners = " " + messages.getMessage("0000", null, "", null) + " " + messages.getMessage(serialObject.getOwners(), null, "", null);
////		}
////		serialObject.setToStockName(serialObject.getToStockName() + owners);
//		serialObject.setToStockName(findBranchDisplay(serialObject.getToStockCode(),serialObject.getOwners()));
//		
//		Integer sumSerialCount = 0;
//		
//		List<String> listContaining = new ArrayList<String>();
//		for(InventoryReturnStockByDetailTO inventoryReportTO : collections) {
//			listContaining.add(inventoryReportTO.getProductCode());
//		}
//		Iterator<String> listContainingDuplicates = findDuplicates(listContaining);
//		while(listContainingDuplicates.hasNext()) {
//			boolean openSubSummaryRow = false;
//			int countSubRows = 0;
//			Integer sumSubSerialCount = 0;
//			
//			String productCodeTemp = (String)listContainingDuplicates.next();
//			for(InventoryReturnStockByDetailTO inventoryReportTO1 : collections) {
//				if(productCodeTemp.equals(inventoryReportTO1.getProductCode())) {
//					if(countSubRows == 0) {
//						InventoryReturnStockByDetailTO inventoryReportTO2 = new InventoryReturnStockByDetailTO();
//						inventoryReportTO2.setProductCode(inventoryReportTO1.getProductCode());
//						inventoryReportTO2.setProductName(inventoryReportTO1.getProductName());
//						inventoryReportTO2.setInitSerial("Y");
//						printCollections.add(inventoryReportTO2);
//					}
//					countSubRows++;
//					openSubSummaryRow = true;
//					sumSubSerialCount = sumCount(sumSubSerialCount, inventoryReportTO1.getSerialCountInteger());
//					printCollections.add(inventoryReportTO1);
//				}
//			}
//			if(openSubSummaryRow) {
//				InventoryReturnStockByDetailTO inventoryReportTO3 = new InventoryReturnStockByDetailTO();
//				inventoryReportTO3.setLotCountInteger(countSubRows);
//				inventoryReportTO3.setSumSerialCountInteger(sumSubSerialCount);
//				inventoryReportTO3.setEndSerial("Y");
//				printCollections.add(inventoryReportTO3);
//			}
//			sumSerialCount = sumCount(sumSerialCount, sumSubSerialCount);
//		}
//		serialObject.setLotCountInteger(collections.size());
//		serialObject.setSumSerialCountInteger(sumSerialCount);
//		
//		parameters.put("ReportSource", serialObject);
//		
//		response.setContentType("application/pdf");
//		
//		JasperReport jasperReport = JasperCompileManager.compileReport(context.getRealPath(JASPER_JRXML_PATH) + File.separatorChar + JASPER_JRXML_FILENAME + FILE_TYPE_JRXML);
//		JRDataSource jrDataSource = (printCollections != null && !printCollections.isEmpty()) ? new JRBeanCollectionDataSource(printCollections) : new JREmptyDataSource();
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
//		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		
//	}

}
