package br.com.condominio.entidades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LOURIVALDO
 */
public class Usuario {

    private Integer id;
    private String login;
    private String senha;
    private String SenhaHash;
    private String nome;
    private String perfil;
    private String telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * @return retorna hash MD5 da senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param hash hash md5 da senha do usuario 
     */
    public void setSenhaHash(String hash) {
        this.senha = hash;
    }

    /**
     *
     * @param senha senha do usuario para conversao em hash MD5
     */
    public void setSenha(String senha) {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(), 0, senha.length());
            this.senha = new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
