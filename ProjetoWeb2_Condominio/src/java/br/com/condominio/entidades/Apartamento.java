package br.com.condominio.entidades;

import java.util.Objects;

/**
 *
 * @author João Henrique 2
 */
public class Apartamento {

    private int id;
    private int numero;
    private int bloco;
    private String proprietario;
    private String locatario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBloco() {
        return bloco;
    }

    public void setBloco(int bloco) {
        this.bloco = bloco;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getLocatario() {
        return locatario;
    }

    public void setLocatario(String locatario) {
        this.locatario = locatario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + this.numero;
        hash = 71 * hash + this.bloco;
        hash = 71 * hash + Objects.hashCode(this.proprietario);
        hash = 71 * hash + Objects.hashCode(this.locatario);
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
        final Apartamento other = (Apartamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.bloco != other.bloco) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        if (!Objects.equals(this.locatario, other.locatario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Apartamento[ id=" + id + " ]";
    }
    
}
