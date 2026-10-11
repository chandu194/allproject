package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageConversionService {
    private Map<String,ImageConverter> convertMap;

    public ImageConversionService(){
        convertMap=new HashMap<>();
        convertMap.put("PNG", new PngConverter());
        convertMap.put("GIF", new GifConverter());
    }
    public void convert(String inputFile, List<String> format){
        for(String format:)
    }

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    executorService.submit(new ImageConverter());

    executorService.shutdown();
    //    public ImageConversionService(List<ImageConverter> converters) {
//        this.converters = converters;
//    }
//    public void convertTOAllFormat(String inputFile){
//        for(ImageConverter converter : converters){
//            converter.convert(inputFile);
//        }

//    }
}
