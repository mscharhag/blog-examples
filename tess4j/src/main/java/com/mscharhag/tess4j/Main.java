package com.mscharhag.tess4j;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {

        File tmpFolder = LoadLibs.extractTessResources("win32-x86-64"); // Change this argument, depending on your platform
        System.setProperty("java.library.path", tmpFolder.getPath());
        System.out.println("native libraries extracted to: " + tmpFolder.getPath());

        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("deu");
        tesseract.setOcrEngineMode(1);

        Path dataDirectory = Paths.get(ClassLoader.getSystemResource("data").toURI());
        tesseract.setDatapath(dataDirectory.toString());

        BufferedImage image = ImageIO.read(Main.class.getResourceAsStream("/ocrexample.jpg"));
        String result = tesseract.doOCR(image);

        System.out.println(result);
    }
}
