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

        veiculo.setNumero(3);
        veiculo.setBloco(3);
        veiculo.setProprietario("3");
        veiculo.setLocatario("3");

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.cadastrar(veiculo);
    }

    private static void alterar() {
        Veiculo veiculo = new Veiculo();

        veiculo.setNumero(4);
        veiculo.setBloco(4);
        veiculo.setProprietario("4");
        veiculo.setLocatario("4");

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
            System.out.println("Achado " + veiculo.getNumero());
        }
    }

    public static void main(String[] args) {

//        cadastrar();
//        alterar();
//        buscarTodos();
        buscar(3);
//        excluir();

    }
    
}
