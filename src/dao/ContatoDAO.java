/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contato;

/**
 *
 * @author Programador-03
 */
public class ContatoDAO {
    
    private final Conexao conexao = new Conexao();
    private final PreparedStatement preparedStatement = null;
    private final ResultSet rs = null;

    public void Salvar(Contato contato) {

        String sql = "INSERT INTO contatos(nome,end,cidade) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            //Cria uma conexão com o banco
            preparedStatement = conexao.connection.prepareStatement("SELECT * FROM bancos");
                    
            //Cria um PreparedStatment, classe usada para executar a query
            
            //Adiciona o valor do primeiro parâmetro da sql
            preparedStatement.setString(1, contato.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            preparedStatement.setString(2, contato.getEnd());
            //Adicionar o valor do terceiro parâmetro da sql
            preparedStatement.setString(3, contato.getCidade());

            //Executa a sql para inserção dos dados
            preparedStatement.execute();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões
            try {
                if (preparedStatement != null) {

                    preparedStatement.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

}
