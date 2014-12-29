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
    private int tipoVisita;
    private int apartamento;
    private String motivoVisita;
    private Date dataHora;
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

    public int getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(int tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHhora(Date dataHora) {
        this.dataHora = dataHora;
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
        hash = 53 * hash + Objects.hashCode(this.tipoVisita);
        hash = 53 * hash + this.apartamento;
        hash = 53 * hash + Objects.hashCode(this.motivoVisita);
        hash = 53 * hash + Objects.hashCode(this.dataHora);
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
        if (!Objects.equals(this.tipoVisita, other.tipoVisita)) {
            return false;
        }
        if (this.apartamento != other.apartamento) {
            return false;
        }
        if (!Objects.equals(this.motivoVisita, other.motivoVisita)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
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
