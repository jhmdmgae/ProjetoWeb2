package br.com.condominio.controller.logica;

import br.com.condominio.entidades.Funcionario;
import br.com.condominio.jdbc.FuncionarioDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String dataContratacao = request.getParameter("data_contratacao");
        String cargo = request.getParameter("cargo");
        String tipoContrato = request.getParameter("tipo_contrato");
        String turno = request.getParameter("turno");
        String foto = request.getParameter("foto");
        String observacao = request.getParameter("observacao");

        Funcionario funcionario = new Funcionario();

        funcionario.setMatricula(matricula);
        funcionario.setNome(nome);
        funcionario.setTelResidencial(telefoneResidencial);
        funcionario.setTelCelular(telefoneCelular);
        funcionario.setCep(cep);
        funcionario.setEndereco(endereco);
        funcionario.setNumero(Integer.parseInt(numero));
        funcionario.setComplemento(complemento);
        funcionario.setBairro(bairro);
        funcionario.setCidade(cidade);
        funcionario.setUf(uf);
        funcionario.setRg(rg);
        funcionario.setCpf(cpf);
        funcionario.setSexo(sexo);
        funcionario.setCargo(cargo);
        funcionario.setTurno(turno);
        funcionario.setFoto(foto);
        funcionario.setTipoContrato(tipoContrato);
        funcionario.setObservacao(observacao);

//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        funcionario.setDataContratacao(new java.util.Date(format.parse(dataContratacao).getTime()));

        funcionarioDAO.cadastrar(funcionario);
        
        return "listar_funcionarios.jsp";
    }
}
