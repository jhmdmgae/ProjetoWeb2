package br.com.condominio.entidades;

import java.util.Objects;

/**
 *
 * @author João Henrique 2
 */
public class Veiculo {
    
    private int id;
    private int apartamento;
    private int tipo_veiculo;
    private String modelo;
    private String marca;
    private int cor;
    private String placa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public int getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(int tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.apartamento);
        hash = 61 * hash + Objects.hashCode(this.tipo_veiculo);
        hash = 61 * hash + Objects.hashCode(this.modelo);
        hash = 61 * hash + Objects.hashCode(this.marca);
        hash = 61 * hash + Objects.hashCode(this.cor);
        hash = 61 * hash + Objects.hashCode(this.placa);
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
        final Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.apartamento, other.apartamento)) {
            return false;
        }
        if (!Objects.equals(this.tipo_veiculo, other.tipo_veiculo)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Veiculo[ id=" + id + " ]";
    }
    
}
