// Autores: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Manutencao;
import model.Usuario;

public class UsuariosDAO {
    
    public void removeById(int id) {

        String sql = "DELETE FROM usuarios WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMysql();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
    
    public void save(Usuario usuario_temp) {
        String sql = "INSERT INTO usuarios(nome, nivel_de_acesso, telefone_de_contato, email, cpf)"
                + " VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMysql();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario_temp.getNome());
            pstm.setString(2, usuario_temp.getNivel_de_acesso());
            pstm.setString(3, usuario_temp.getTelefone_de_contato());
            pstm.setString(4, usuario_temp.getEmail());
            pstm.setString(5, usuario_temp.getCpf());
            
            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões
            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
    
     public List<Usuario> getUsuarios() {
        //É uma lista de um objeto específico, nesse caso item

        String sql = "SELECT * FROM usuarios";

        List<Usuario> buscarTodos = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMysql();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setNivel_de_acesso(rset.getString("nivel_de_acesso"));
                usuario.setTelefone_de_contato(rset.getString("telefone_de_contato"));
                usuario.setEmail(rset.getString("email"));
                usuario.setCpf(rset.getString("cpf"));

                buscarTodos.add(usuario);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return buscarTodos;
    }

    public void save(Manutencao abc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
