package br.com.condominio.entidades;

import java.util.Objects;

/**
 *
 * @author João Henrique 2
 */
public class Documento {
    
    private int id;
    private String titulo;
    private String descricao;
    private String categoria;
    private String autor;
    private String arquivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.titulo);
        hash = 73 * hash + Objects.hashCode(this.descricao);
        hash = 73 * hash + Objects.hashCode(this.categoria);
        hash = 73 * hash + Objects.hashCode(this.autor);
        hash = 73 * hash + Objects.hashCode(this.arquivo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Documento other = (Documento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.arquivo, other.arquivo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Documento[ id=" + id + " ]";
    }
    
}
