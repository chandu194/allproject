package org.example;

public class PngConverter implements ImageConverter{
    @Override
    public void convert(String inputfile) {
        System.out.println("Converting " + inputfile);
    }
}
