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


    Category foodCategory = new Category("1","Food", String.valueOf(R.drawable.food));
    Category beachCategory = new Category("2","Toy", String.valueOf(R.drawable.beachcover));

    private Bootstrap() {
        if(elementList == null){

            categoryList = new ArrayList<Category>();
            //Frutas ID Categoria = 1

            categoryList.add(foodCategory);
            categoryList.add(beachCategory);


            elementList = new ArrayList<Element>();
            Element ball = new Element("jfsd8rd8","Ball", String.valueOf(R.drawable.balls),String.valueOf(R.raw.charlesteste), beachCategory);
            Element beachwatermelon = new Element("kjl26h5g2389f","Watermelon", String.valueOf(R.drawable.beachwatermelon),String.valueOf(R.raw.charlesteste), beachCategory);
            Element boat = new Element("2hj3g8","Boat", String.valueOf(R.drawable.boat),String.valueOf(R.raw.charlesteste), beachCategory);
            Element icecream = new Element("8jg84jf2","Ice Cream", String.valueOf(R.drawable.icecream),String.valueOf(R.raw.charlesteste), beachCategory);
            Element island = new Element("8jg84jf2","Island", String.valueOf(R.drawable.island),String.valueOf(R.raw.charlesteste), beachCategory);
            Element juice = new Element("8jg84jf2","Juice", String.valueOf(R.drawable.juice),String.valueOf(R.raw.charlesteste), beachCategory);
            Element lighthouse = new Element("8jg84jf2","Lighthouse", String.valueOf(R.drawable.lighthouse),String.valueOf(R.raw.charlesteste), beachCategory);
            Element sandals = new Element("8jg84jf2","Sandals", String.valueOf(R.drawable.sandals),String.valueOf(R.raw.charlesteste), beachCategory);
            Element sun= new Element("8jg84jf2","Sun", String.valueOf(R.drawable.sun),String.valueOf(R.raw.charlesteste), beachCategory);
            Element sunglasses= new Element("0fjklsd","Sunglasses", String.valueOf(R.drawable.sunglasses),String.valueOf(R.raw.charlesteste), beachCategory);
            Element surfboard = new Element("8jg84jf2","Surfboard", String.valueOf(R.drawable.surfboard),String.valueOf(R.raw.charlesteste), beachCategory);
            Element umbrella = new Element("8jg84jf2","Umbrella", String.valueOf(R.drawable.umbrella),String.valueOf(R.raw.charlesteste), beachCategory);

            Element apple = new Element("303735jw","apple", String.valueOf(R.drawable.apple),String.valueOf(R.raw.charlesteste), foodCategory);
            Element banana = new Element("303735jw","banana", String.valueOf(R.drawable.banana),String.valueOf(R.raw.charlesteste), foodCategory);
            Element carrot = new Element("303735jw","carrot", String.valueOf(R.drawable.carrot),String.valueOf(R.raw.charlesteste), foodCategory);
            Element cherry = new Element("303735jw","cherry", String.valueOf(R.drawable.chery),String.valueOf(R.raw.charlesteste), foodCategory);
            Element egg = new Element("303735jw","egg", String.valueOf(R.drawable.egg),String.valueOf(R.raw.charlesteste), foodCategory);
            Element eggplant = new Element("303735jw","eggplant", String.valueOf(R.drawable.eggplant),String.valueOf(R.raw.charlesteste), foodCategory);
            Element fish = new Element("303735jw","fish", String.valueOf(R.drawable.fish),String.valueOf(R.raw.charlesteste), foodCategory);
            Element mushroom = new Element("303735jw","mushroom", String.valueOf(R.drawable.mushroom),String.valueOf(R.raw.charlesteste), foodCategory);
            Element orange = new Element("303735jw","orange", String.valueOf(R.drawable.orange),String.valueOf(R.raw.charlesteste), foodCategory);
            Element pear = new Element("303735jw","pear", String.valueOf(R.drawable.pear),String.valueOf(R.raw.charlesteste), foodCategory);
            Element pumpkin = new Element("303735jw","pumpkin", String.valueOf(R.drawable.pumpkin),String.valueOf(R.raw.charlesteste), foodCategory);
            Element strawberry = new Element("303735jw","strawberry", String.valueOf(R.drawable.strawberry),String.valueOf(R.raw.charlesteste), foodCategory);
            Element tomato = new Element("303735jw","tomato", String.valueOf(R.drawable.tomato),String.valueOf(R.raw.charlesteste), foodCategory);
            Element watermelon = new Element("303735jw","watermelon", String.valueOf(R.drawable.watermelon),String.valueOf(R.raw.charlesteste), foodCategory);
            /*Element milk2 = new Element("hjakhfq67","Milk", String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);
            Element milk3 = new Element("fdhj267f","Milk",String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);
            Element milk4 = new Element("7842hfhe7s6","Milk",String.valueOf(R.drawable.bottle),String.valueOf(R.raw.charlesteste), foodCategory);*/


            elementList.add(apple);
            elementList.add(banana);
            elementList.add(carrot);
            elementList.add(cherry);
            elementList.add(egg);
            elementList.add(eggplant);
            elementList.add(fish);
            elementList.add(mushroom);
            elementList.add(orange);
            elementList.add(pear);
            elementList.add(pumpkin);
            elementList.add(strawberry);
            elementList.add(tomato);
            elementList.add(watermelon);

            elementList.add(ball);
            elementList.add(beachwatermelon);
            elementList.add(boat);
            elementList.add(icecream);
            elementList.add(island);
            elementList.add(juice);
            elementList.add(lighthouse);
            elementList.add(sandals);
            elementList.add(sun);
            elementList.add(sunglasses);
            elementList.add(surfboard);
            elementList.add(umbrella);


        }

        //HISTORY MODULE
        if(historyList == null){
            historyList = new ArrayList<History>();
            History history = new History("ffa7ds86f","Alguma Historia","history genre", String.valueOf(R.drawable.teddybear));
            historyList.add(history);

            partList = new ArrayList<Part>();
            Part part1 = new Part("part1","Introduction",String.valueOf(R.raw.parte1),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa1),1,history);
            Part part2 = new Part("part2","Introduction",String.valueOf(R.raw.parte2),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa2),2,history);
            Part part3 = new Part("part3","Introduction",String.valueOf(R.raw.parte3),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa3),3,history);
            Part part4 = new Part("part4","Introduction",String.valueOf(R.raw.parte4),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa4),4,history);
            Part part5 = new Part("part1","Introduction",String.valueOf(R.raw.parte5),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa5),5,history);
            Part part6 = new Part("part2","Introduction",String.valueOf(R.raw.parte6),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa6),6,history);
            Part part7 = new Part("part3","Introduction",String.valueOf(R.raw.parte7),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa7),7,history);
            Part part8 = new Part("part4","Introduction",String.valueOf(R.raw.parte8),String.valueOf(R.raw.rinoceronte),String.valueOf(R.drawable.capa8),8,history);

            partList.add(part1);
            partList.add(part2);
            partList.add(part3);
            partList.add(part4);
            partList.add(part5);
            partList.add(part6);
            partList.add(part7);
            partList.add(part8);
        }


    }

    public static synchronized Bootstrap getInstance(){
        if(bootstrap == null) {
            bootstrap = new Bootstrap();
        }

        return bootstrap;
    }


    public List<Element> pegarElementosBeach(){
        List<Element> list = new ArrayList<Element>();
        for ( Element item : elementList) {
            if(item.getCategory() == beachCategory){
                list.add(item);
            }
        }
        return list;
    }

    public List<Element> pegarElementosFood(){
        List<Element> list = new ArrayList<Element>();
        for ( Element item : elementList) {
            if(item.getCategory() == foodCategory){
                list.add(item);
            }
        }
        return list;
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
