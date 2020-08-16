package com.example.pdftablecreation;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@SpringBootApplication
public class PdfTableCreationApplication {

	public static void main(String[] args) {


		SpringApplication.run(PdfTableCreationApplication.class, args);

		try{
			// creation of the document with a certain size and certain margins
			Document document = new Document(PageSize.A4,20,20,20,20);

			// creating table and set the column width
			PdfPTable table = new PdfPTable(3);
			float widths[] = {3,6,3};
			table.setWidths(widths);
			table.setHeaderRows(1);

			// add cell of table - header cell
			PdfPCell cell = new PdfPCell(new Phrase("Emp Id"));
			cell.setBackgroundColor(new BaseColor(0,173,239));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Emp Name"));
			cell.setBackgroundColor(new BaseColor(0, 173, 239));
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Salary"));
			cell.setBackgroundColor(new BaseColor(0, 173, 239));
			table.addCell(cell);

			Phrase ph;
			// looping the table cell for adding definition
			for (int ctr = 0; ctr <= 4; ctr++) {

				cell = new PdfPCell();
				ph = new Phrase("WS-"+ctr);
				cell.addElement(ph);
				table.addCell(cell);

				cell = new PdfPCell();
				ph = new Phrase("Sandeep Sharma " + ctr);
				cell.addElement(ph);
				table.addCell(cell);

				cell = new PdfPCell();
				ph = new Phrase("2000" + ctr);
				cell.addElement(ph);
				table.addCell(cell);

			}

			// write the all into a file and save it.
			PdfWriter.getInstance(document, new FileOutputStream("EmployeeData.pdf"));
			document.open();
			document.add(table);
			document.close();
			System.out.println("Successful.");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}

}
