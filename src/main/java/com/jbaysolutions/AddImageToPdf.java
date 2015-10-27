package com.jbaysolutions;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: Gus - gustavo.santos@jbaysolutions.com - http://gmsa.github.io/ - http://www.jbaysolutions.com
 * Date: 27-10-2015
 * Time: 14:52
 *
 * A sample class to add Image to PDF file using IText. Full details in http://blog.jbaysolutions.com/2015/10/27/adding-image-to-pdf-java-itext
 */
public class AddImageToPdf {
    public static void main(String[] args) throws Exception {
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        addImageToPdf(workingDir + "/document.pdf", workingDir + "/document-OUT.pdf", workingDir+"/smile.jpg");
    }

    public static void addImageToPdf(String srcPdf, String destPdf, String imagePath) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(srcPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));
        PdfContentByte content = stamper.getOverContent(1);

        Image image = Image.getInstance(imagePath);

        // scale the image to 50px height
        image.scaleAbsoluteHeight(50);
        image.scaleAbsoluteWidth((image.getWidth() * 50) / image.getHeight());

        image.setAbsolutePosition(70, 140);
        content.addImage(image);

        stamper.close();

    }
}
