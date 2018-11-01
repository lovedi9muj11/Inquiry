package th.co.mfec.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class TestPDF {

	/** Path to the resulting PDF file. */
	public static final String RESULT = "D://hello.pdf";

	/**
	 * Creates a PDF file: hello.pdf
	 * 
	 * @param args
	 *            no arguments needed
	 */
//	   public static void main(String[] args)
//		        throws IOException, DocumentException {
//		        new TestPDF().createPdf(RESULT);
//		    }
	/**
	 * Creates a PDF with information about the movies
	 * 
	 * @param filename
	 *            the name of the PDF file that will be created.
	 * @throws DocumentException
	 * @throws IOException
	 */
	public InputStream  createPdf(String filename) throws IOException, DocumentException {
		// step 1
	    ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, out);
	    Rectangle one = new Rectangle(595,1100);
	    document.setPageSize(one.rotate());
		// step 2
		
	
		BaseFont courier = BaseFont.createFont("font/newFB.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font cellFont = new Font(courier, 16, Font.BOLD);
		// step 3

		document.open();
		// step 4
		document.add(createFirstTable());
		document.add(new Paragraph("หกาด้ฟหกด้ฟ่าหกด้า่ฟ หฟกดฟหกดฟหกดหฟกด  This paragraph uses the" + " Comic Sans MS font.",cellFont));
		// step 5
		document.close();
		return new ByteArrayInputStream(out.toByteArray());
		
	}

	/**
	 * Creates our first table
	 * 
	 * @return our first table
	 */
	public static PdfPTable createFirstTable() {
		// a table with three columns
		PdfPTable table = new PdfPTable(3);
		// the cell object
		PdfPCell cell;
		// we add a cell with colspan 3
		cell = new PdfPCell(new Phrase("Cell with colspan 3"));
		cell.setColspan(3);
		table.addCell(cell);
		// now we add a cell with rowspan 2
		cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
		cell.setRowspan(2);
		table.addCell(cell);
		// we add the four remaining cells with addCell()
		table.addCell("row 1; cell 1ashdfjkasdhfkashdfjkashdkfasfadsfห่ากดเเา่ฟหเดฟห้เกด้ฟหกด่้ฟหเดา้เ");
		table.addCell("row 1; cell 2");
		table.addCell("row 2; cell 1");
		table.addCell("row 2; cell 2");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 25; cell 15");
		table.addCell("row 25; cell 25");
		table.addCell("row 14; cell 1");
		table.addCell("row 15; cell 25");
		table.addCell("row 2; cell 1");
		
		return table;
	}
}
