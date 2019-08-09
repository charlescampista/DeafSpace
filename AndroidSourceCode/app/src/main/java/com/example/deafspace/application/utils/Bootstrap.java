package com.example.deafspace.application.utils;


import com.example.deafspace.R;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Category;
import com.example.deafspace.childrenspace.modules.vocabularymodule.model.Element;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {

    private static List<Element> elementList;
    private static List<Category> categoryList;
    private static Bootstrap bootstrap;

    private Bootstrap() {
        if(elementList == null){

            categoryList = new ArrayList<Category>();
            //Frutas ID Categoria = 1
            Category foodCategory = new Category("3jf8u3","Food", String.valueOf(R.drawable.cutlery));
            Category toyCategory = new Category("f789je","Toy", String.valueOf(R.drawable.beachball));
            categoryList.add(foodCategory);
            categoryList.add(toyCategory);


            elementList = new ArrayList<Element>();
            Element car1 = new Element("jfsd8rd8","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.gorila), toyCategory);
            Element car2 = new Element("kjl26h5g2389f","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.gorila), toyCategory);
            Element car3 = new Element("2hj3g8","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.gorila), toyCategory);
            Element car4 = new Element("8jg84jf2","Car", String.valueOf(R.drawable.car),String.valueOf(R.raw.gorila), toyCategory);

            Element milk1 = new Element("303735jw","Milk", String.valueOf(R.drawable.bottle),String.valueOf(R.raw.gorila), foodCategory);
            Element milk2 = new Element("hjakhfq67","Milk", String.valueOf(R.drawable.bottle),String.valueOf(R.raw.gorila), foodCategory);
            Element milk3 = new Element("fdhj267f","Milk",String.valueOf(R.drawable.bottle),String.valueOf(R.raw.gorila), foodCategory);
            Element milk4 = new Element("7842hfhe7s6","Milk",String.valueOf(R.drawable.bottle),String.valueOf(R.raw.gorila), foodCategory);


            elementList.add(milk1);
            elementList.add(milk2);
            elementList.add(milk3);
            elementList.add(milk4);

            elementList.add(car1);
            elementList.add(car2);
            elementList.add(car3);
            elementList.add(car4);

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
}
