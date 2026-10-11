package org.example;

public class GifConverter implements ImageConverter{
    @Override
    public void convert(String inputfile) {
        System.out.println("Converting " + inputfile);
    }
}
