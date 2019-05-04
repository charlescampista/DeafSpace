package classes;

import com.charlescampista.deafspace.R;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {

    private static List<Elemento> listaElementos;
    private static List<Categoria> listaCategorias;
    private static Bootstrap bootstrap;

    private Bootstrap() {
        if(listaElementos == null){

            listaCategorias = new ArrayList<Categoria>();
            //Frutas ID Categoria = 1
            Categoria categoriaFrutas = new Categoria(1,"frutas", R.drawable.categoria_fruta);
            Categoria categoriaAnimais = new Categoria(2,"animais", R.drawable.categoria_animal);
            listaCategorias.add(categoriaAnimais);
            listaCategorias.add(categoriaFrutas);


            listaElementos = new ArrayList<Elemento>();
            Elemento abacate = new Elemento(0,"abacate",categoriaFrutas,R.drawable.abacate,R.raw.abacate);
            Elemento abacaxi = new Elemento(1,"abacaxi",categoriaFrutas,R.drawable.abacaxi,R.raw.abacaxi);
            Elemento cereja = new Elemento(2,"cereja",categoriaFrutas,R.drawable.cereja,R.raw.cereja);
            Elemento morango = new Elemento(3,"morango",categoriaFrutas,R.drawable.morango,R.raw.morango);
            Elemento pera = new Elemento(4,"pera",categoriaFrutas,R.drawable.pera,R.raw.pera);
            Elemento banana = new Elemento(4,"banana",categoriaFrutas,R.drawable.banana,R.raw.banana);

            Elemento gorila = new Elemento(5,"gorila",categoriaAnimais,R.drawable.gorila,R.raw.gorila);
            Elemento polvo = new Elemento(6,"polvo",categoriaAnimais,R.drawable.polvo,R.raw.polvo);
            Elemento rinoceronte = new Elemento(7,"rinoceronte",categoriaAnimais,R.drawable.rinoceronte,R.raw.rinoceronte);
            Elemento zebra = new Elemento(8,"zebra",categoriaAnimais,R.drawable.zebra,R.raw.zebra);
            Elemento girafa = new Elemento(9,"girafa",categoriaAnimais,R.drawable.girafa,R.raw.girafa);
            Elemento tubarao = new Elemento(10,"tubarao",categoriaAnimais,R.drawable.tubarao,R.raw.tubarao);

            listaElementos.add(abacate);
            listaElementos.add(abacaxi);
            listaElementos.add(cereja);
            listaElementos.add(morango);
            listaElementos.add(pera);
            listaElementos.add(banana);
            listaElementos.add(gorila);
            listaElementos.add(polvo);
            listaElementos.add(rinoceronte);
            listaElementos.add(zebra);
            listaElementos.add(girafa);
            listaElementos.add(tubarao);

        }


    }

    public static synchronized Bootstrap getInstance(){
        if(bootstrap == null) {
            bootstrap = new Bootstrap();
        }

        return bootstrap;
    }

    public List<Elemento> pegarElementos(){
        return listaElementos;
    }

    public List<Elemento> pegarElementos(Categoria categoria){
        if(categoria != null){
            List<Elemento> lista = new ArrayList<Elemento>();
            for (Elemento elemento: listaElementos) {
                if(elemento.getCategoria().getId() == categoria.getId()) lista.add(elemento);
            }
            return  lista;
        }
        return null;
    }

    public List<Categoria> pegarCategorias(){
        return listaCategorias;
    }

    public Categoria pegarCategoria(int idCategoria){
        for (Categoria categoria : listaCategorias) {
            if(categoria.getId() == idCategoria) return categoria;
        }
        return null;
    }
}
