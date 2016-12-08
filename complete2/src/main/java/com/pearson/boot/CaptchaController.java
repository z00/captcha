package com.pearson.boot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaptchaController {

	private static final String TXT = "Hello CF!";

	@RequestMapping(value = "/captcha", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] captcha(@RequestParam(value = "text", required = false, defaultValue = TXT) String name)
			throws IOException {

		//TODO exception handling, docs & comments, better input checking, security, modular, etc...
		
		String imgStr = name;
		if (imgStr.length() > TXT.length()){
			imgStr = "Long Param";
		}
		final int width = 115;
		final int height = 36;
		final Color background = new Color(17, 160, 6);
		final Color fbl = new Color(255, 255, 255);
		final Font fnt = new Font("SansSerif", 0, 18);
		final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		final Graphics g = image.createGraphics();
		g.setColor(background);
		g.fillRect(0, 0, width, height);
		g.setColor(fbl);
		g.setFont(fnt);
		g.drawString(imgStr, 2, 26);
		g.setColor(background);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	}
}
