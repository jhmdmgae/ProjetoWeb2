package br.com.condominio.entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author João Henrique 2
 */
public class Funcionario {
    
    private int id;    
    private String matricula;    
    private String nome;
    private String tel_residencial;
    private String tel_celular;
    private String cep;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String rg;
    private String cpf;
    private String sexo;
    private Date data_contratacao;
    private String cargo;
    private String tipo_contrato;
    private String turno;
    private String foto;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel_residencial() {
        return tel_residencial;
    }

    public void setTel_residencial(String tel_residencial) {
        this.tel_residencial = tel_residencial;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.matricula);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.tel_residencial);
        hash = 79 * hash + Objects.hashCode(this.tel_celular);
        hash = 79 * hash + Objects.hashCode(this.cep);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + this.numero;
        hash = 79 * hash + Objects.hashCode(this.complemento);
        hash = 79 * hash + Objects.hashCode(this.bairro);
        hash = 79 * hash + Objects.hashCode(this.cidade);
        hash = 79 * hash + Objects.hashCode(this.uf);
        hash = 79 * hash + Objects.hashCode(this.rg);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.sexo);
        hash = 79 * hash + Objects.hashCode(this.data_contratacao);
        hash = 79 * hash + Objects.hashCode(this.cargo);
        hash = 79 * hash + Objects.hashCode(this.tipo_contrato);
        hash = 79 * hash + Objects.hashCode(this.turno);
        hash = 79 * hash + Objects.hashCode(this.foto);
        hash = 79 * hash + Objects.hashCode(this.observacao);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tel_residencial, other.tel_residencial)) {
            return false;
        }
        if (!Objects.equals(this.tel_celular, other.tel_celular)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.data_contratacao, other.data_contratacao)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.tipo_contrato, other.tipo_contrato)) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Funcionario[ id=" + id + " ]";
    }
    
}
