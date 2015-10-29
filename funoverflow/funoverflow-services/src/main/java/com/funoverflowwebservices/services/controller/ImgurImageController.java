package com.funoverflowwebservices.services.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/ImgurImage")
public class ImgurImageController extends AbstractController {

	public static void main(String args[])
	{
		System.out.println("test");
		BufferedImage image = new BufferedImage(200, 200, 1);
		ImgurImageController imgurImageController = new ImgurImageController();
		try {
			imgurImageController.upload(image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void upload(BufferedImage image) throws Exception {
	    String IMGUR_POST_URI = "http://api.imgur.com/2/upload.xml";
	    String IMGUR_API_KEY = "57d002ed250f982";

	    String file = "C:\\code\\image.jpg";
	    try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        System.out.println("Writing image...");
	        ImageIO.write(image, "png", baos);
	        URL url = new URL(IMGUR_POST_URI);
	        System.out.println("Encoding...");

	        String data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(Base64.encodeBase64(baos.toByteArray()).toString(), "UTF-8");
	        data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(IMGUR_API_KEY, "UTF-8");
	        System.out.println("Connecting...");

	        URLConnection conn = url.openConnection();
	        conn.setDoOutput(true);
	        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	        System.out.println("Sending data...");
	        wr.write(data);
	        wr.flush();
	        System.out.println("Finished.");
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
