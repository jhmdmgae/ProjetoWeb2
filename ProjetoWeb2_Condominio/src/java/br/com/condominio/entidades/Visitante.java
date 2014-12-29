package br.com.condominio.entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author João Henrique 2
 */
public class Visitante {
    
    private int id;
    private String nome;
    private int tipo_visita;
    private int apartamento;
    private String motivo_visita;
    private Date data_hora;
    private String observacao;
    
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

    public int getTipo_visita() {
        return tipo_visita;
    }

    public void setTipo_visita(int tipo_visita) {
        this.tipo_visita = tipo_visita;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public String getMotivo_visita() {
        return motivo_visita;
    }

    public void setMotivo_visita(String motivo_visita) {
        this.motivo_visita = motivo_visita;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.tipo_visita);
        hash = 53 * hash + this.apartamento;
        hash = 53 * hash + Objects.hashCode(this.motivo_visita);
        hash = 53 * hash + Objects.hashCode(this.data_hora);
        hash = 53 * hash + Objects.hashCode(this.observacao);
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
        final Visitante other = (Visitante) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo_visita, other.tipo_visita)) {
            return false;
        }
        if (this.apartamento != other.apartamento) {
            return false;
        }
        if (!Objects.equals(this.motivo_visita, other.motivo_visita)) {
            return false;
        }
        if (!Objects.equals(this.data_hora, other.data_hora)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Visitante[ id=" + id + " ]";
    }
    
}
