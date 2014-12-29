package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Apartamento;
import br.com.condominio.entidades.Funcionario;
import br.com.condominio.jdbc.ApartamentoDAO;
import br.com.condominio.jdbc.FuncionarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LOURIVALDO
 */
public class CadastrarFuncionario implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        String telefoneResidencial = request.getParameter("telefone_residencial");
        String telefoneCelular = request.getParameter("telefone_celular");
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String data_contratacao = request.getParameter("data_contratacao");
        String cargo = request.getParameter("cargo");
        String tipo_contrato = request.getParameter("tipo_contrato");
        String turno = request.getParameter("turno");
        String foto = request.getParameter("foto");
        String observacao = request.getParameter("observacao");

        Funcionario funcionario = new Funcionario();
//        funcionario.setNumero(Integer.parseInt(numero));

//        funcionarioDAO.cadastrar(funcionario);

        return "apartamentos.jsp";
    }
}
