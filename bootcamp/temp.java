package bootcamp;


	import java.io.File;
	import java.io.IOException;
	  
	import org.apache.pdfbox.pdmodel.PDDocument; 
	import org.apache.pdfbox.pdmodel.PDPage; 
	import org.apache.pdfbox.pdmodel.PDPageContentStream; 
	import org.apache.pdfbox.pdmodel.font.PDType1Font;


	public class temp {
	public static void main(String[] args) throws IOException {
		String a1="Bhavik Kumar N",a2="Drawing",a3="BS-03",a4="2",a5="12/02/2021",a6="14:00",a7="12/02/2021",a8="16:00";
		File file = new File("D://ticket.pdf");
	      PDDocument document = PDDocument.load(file);
	       
	      //Retrieving the pages of the document 
	      PDPage page = document.getPage(0);
	      PDPageContentStream contentStream = new PDPageContentStream(document, page);
	      
	      //Begin the Content stream 
	      contentStream.beginText(); 
	       
	      //Setting the font to the Content stream  
	      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

	    //Setting the leading
	      contentStream.setLeading(14.5f);
	      
	      //Setting the position for the line 
	      contentStream.newLineAtOffset(25, 725);
	      
	      String text1="Name: "+a1,text2="Event Name: "+a2,text3="Location: "+a3,text4="Seat Number: "+a4,text5="Start-Date: "+a5,text6="Start-Time: "+a6,text7="End-Date: "+a7,text8="End-Time: "+a8;

	      //Adding text in the form of string 
	      contentStream.showText(text1);
	      contentStream.newLine();
	      contentStream.showText(text2);
	      contentStream.newLine();
	      contentStream.showText(text3);
	      contentStream.newLine();
	      contentStream.showText(text4);
	      contentStream.newLine();
	      contentStream.showText(text5);
	      contentStream.newLine();
	      contentStream.showText(text6);
	      contentStream.newLine();
	      contentStream.showText(text7);
	      contentStream.newLine();
	      contentStream.showText(text8);
	      contentStream.newLine();
	      //Ending the content stream

	      System.out.println("Content added");

	      //Closing the content stream
	      contentStream.close();

	      //Saving the document
	      document.save(new File("D://ticket.pdf"));

	      //Closing the document
	      document.close();
	}

}
