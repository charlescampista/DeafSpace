package classes;

import java.io.Serializable;

public class Elemento implements Serializable {
    private int id;
    private String nome;
    private Categoria categoria;
    private int imagem;
    private int video;

    public Elemento(int id, String nome, Categoria categoria, int imagem, int video) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.imagem = imagem;
        this.video = video;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }
}
