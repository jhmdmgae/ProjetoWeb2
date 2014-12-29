package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Veiculo;
import br.com.condominio.jdbc.VeiculoDAO;
import java.util.List;

/**
 *
 * @author João Henrique 2
 */
public class TestVeiculoDAO {

    private static void cadastrar() {
        Veiculo veiculo = new Veiculo();

        veiculo.setApartamento(1);
        veiculo.setTipoVeiculo(1);
        veiculo.setModelo("1");
        veiculo.setMarca("1");
        veiculo.setCor(1);
        veiculo.setPlaca("1");

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.cadastrar(veiculo);
    }

    private static void alterar() {
        Veiculo veiculo = new Veiculo();

        veiculo.setApartamento(1);
        veiculo.setTipoVeiculo(1);
        veiculo.setModelo("1");
        veiculo.setMarca("1");
        veiculo.setCor(1);
        veiculo.setPlaca("1");

        veiculo.setId(5);

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.alterar(veiculo);
    }

    private static void excluir() {
        Veiculo veiculo = new Veiculo();

        veiculo.setId(5);

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.excluir(veiculo);
    }

    private static void buscarTodos() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> buscarTodos = veiculoDAO.buscarTodos();

        for (Veiculo veiculo : buscarTodos) {
            System.out.println(veiculo.getId());
        }
    }

    private static void buscar(int id) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = veiculoDAO.buscar(id);

        if (veiculo != null) {
            System.out.println("Achado " + veiculo.getMarca());
        }
    }

    public static void main(String[] args) {

        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(3);
//        excluir();

    }

}
