package br.com.condominio.jdbc.teste;

import br.com.condominio.entidades.Veiculo;
import br.com.condominio.jdbc.VeiculoDAO;
import java.util.List;

/**
 * Testado
 *
 * @author João Henrique 2
 */
public class TestVeiculoDAO {

    private static void cadastrar() {
        Veiculo veiculo = new Veiculo();

        veiculo.setApartamento(1);
        veiculo.setTipo_veiculo(1);
        veiculo.setModelo("2");
        veiculo.setMarca("2");
        veiculo.setCor(1);
        veiculo.setPlaca("2");

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.cadastrar(veiculo);
    }

    private static void alterar() {
        Veiculo veiculo = new Veiculo();

        veiculo.setApartamento(1);
        veiculo.setTipo_veiculo(1);
        veiculo.setModelo("3");
        veiculo.setMarca("3");
        veiculo.setCor(1);
        veiculo.setPlaca("3");

        veiculo.setId(4);

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.alterar(veiculo);
    }

    private static void excluir() {
        Veiculo veiculo = new Veiculo();

        veiculo.setId(4);

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

    private static void buscarCor(int id) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        String nome = veiculoDAO.buscarCor(id);

        if (nome != null) {
            System.out.println("Nome da cor: " + nome);
        }
    }

    private static void buscarTipoVeiculo(int id) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        String tipo = veiculoDAO.buscarTipoVeiculo(id);

        if (tipo != null) {
            System.out.println("Tipo de Veiculo: " + tipo);
        }
    }

    public static void main(String[] args) {

//        cadastrar();
//        alterar();
//        buscarTodos();
//        buscar(4);
//        excluir();
//        buscarTipoVeiculo(1);
        buscarCor(1);

    }

}
