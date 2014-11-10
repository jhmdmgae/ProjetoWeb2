package br.com.condominio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public interface Logica {

    /**
     *
     * @param request
     * @param response
     * @return jsp de dispatch
     * @throws Exception
     */
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception;
}
