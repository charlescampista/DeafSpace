package com.example.deafspace.application.utils;


import android.graphics.Bitmap;

import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.historymodule.model.History;
import com.example.deafspace.childrenspace.modules.historymodule.model.Part;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Element;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {

    //VOCABULARY MODULE
    private static List<Element> elementList;
    private static List<Category> categoryList;

    //HISTORY MODULE
    private static Bootstrap bootstrap;
    private static List<History> historyList;
    private static List<Part> partList;

    private Bootstrap() {
        if(elementList == null){

            categoryList = new ArrayList<Category>();
            //Frutas ID Categoria = 1
            Category foodCategory = new Category("3jf8u3","Food", String.valueOf(R.drawable.cutlery));
            Category toyCategory = new Category("f789je","Toy", String.valueOf(R.drawable.beachball));
            categoryList.add(foodCategory);
            categoryList.add(toyCategory);


            elementList = new ArrayList<Element>();
            Element car1 = new Element("jfsd8rd8","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.charlesteste), toyCategory);
            Element car2 = new Element("kjl26h5g2389f","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.charlesteste), toyCategory);
            Element car3 = new Element("2hj3g8","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.charlesteste), toyCategory);
            Element car4 = new Element("8jg84jf2","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.charlesteste), toyCategory);

            Element milk1 = new Element("303735jw","Milk", String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);
            Element milk2 = new Element("hjakhfq67","Milk", String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);
            Element milk3 = new Element("fdhj267f","Milk",String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);
            Element milk4 = new Element("7842hfhe7s6","Milk",String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);


            elementList.add(milk1);
            elementList.add(milk2);
            elementList.add(milk3);
            elementList.add(milk4);

            elementList.add(car1);
            elementList.add(car2);
            elementList.add(car3);
            elementList.add(car4);
        }

        //HISTORY MODULE
        if(historyList == null){
            historyList = new ArrayList<History>();
            History history = new History("ffa7ds86f","Alguma Historia","history genre", String.valueOf(R.drawable.teddybear));
            historyList.add(history);

            partList = new ArrayList<Part>();
            Part part1 = new Part("part1","Introduction",String.valueOf(R.raw.gorila),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.teddybear),1,history);
            Part part2 = new Part("part2","Introduction",String.valueOf(R.raw.abacaxi),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.bottle),2,history);
            Part part3 = new Part("part3","Introduction",String.valueOf(R.raw.cereja),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.beachball),3,history);
            Part part4 = new Part("part4","Introduction",String.valueOf(R.raw.abacate),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.cutlery),4,history);

            partList.add(part1);
            partList.add(part2);
            partList.add(part3);
            partList.add(part4);
        }


    }

    public static synchronized Bootstrap getInstance(){
        if(bootstrap == null) {
            bootstrap = new Bootstrap();
        }

        return bootstrap;
    }







    public List<Element> pegarElementos(){
        return elementList;
    }


    //VOCABULARY MODULE
    public List<Element> pegarElementos(Category categoria){
        if(categoria != null){
            List<Element> lista = new ArrayList<Element>();
            for (Element elemento: elementList) {
                if(elemento.getCategory().getUuid() == categoria.getUuid()) lista.add(elemento);
            }
            return  lista;
        }
        return null;
    }

    public List<Category> pegarCategorias(){
        return categoryList;
    }

    public Category pegarCategoria(String categoryUuid){
        for (Category categoria : categoryList) {
            if(categoria.getUuid() == categoryUuid) return categoria;
        }
        return null;
    }


    //HISTORY MODULE

    public List<Part> getParts(){
        return partList;
    }

    public List<Part> getParts(History history){
        if(history != null){
            List<Part> lista = new ArrayList<Part>();
            for (Part item : partList) {
                if(item.getHistory().getUuid() == history.getUuid()) lista.add(item);
            }
            return  lista;
        }
        return null;
    }

    public int getPartImageResource(Part part){
        return Integer.parseInt(part.getCoverFilePath());
    }

    public List<History> getHistories(){
        return historyList;
    }

    public History getHistory(String historyUuid){
        for (History item : historyList) {
            if(item.getUuid() == historyUuid) return item;
        }
        return null;
    }
}
