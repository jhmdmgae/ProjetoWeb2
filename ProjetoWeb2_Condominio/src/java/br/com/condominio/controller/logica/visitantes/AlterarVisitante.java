package br.com.condominio.controller.logica.visitantes;

import br.com.condominio.controller.logica.veiculo.*;
import br.com.condominio.controller.logica.Logica;
import br.com.condominio.entidades.Veiculo;
import br.com.condominio.jdbc.dao.VeiculoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class AlterarVisitante implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        String id = request.getParameter("id");
        String tipo = request.getParameter("tipo");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String cor = request.getParameter("cor");
        String placa = request.getParameter("placa");
        String apartamento = request.getParameter("apartamento");

        Veiculo veiculo = new Veiculo();

        veiculo.setId(Integer.parseInt(id));
        veiculo.setApartamento(Integer.parseInt(apartamento));
        veiculo.setCor(Integer.parseInt(cor));
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setPlaca(placa);
        veiculo.setTipoVeiculo(Integer.parseInt(tipo));

        veiculoDAO.alterar(veiculo);

        return "listar_veiculos.jsp";
    }

}
