package classes;

import java.io.Serializable;

public class Categoria implements Serializable {
    private int id;
    private String nome;
    private int imagem;

    public Categoria(int id, String nome, int imagem) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }
}
