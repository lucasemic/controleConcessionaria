// Autores: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Ordem_de_producao;

public class Ordens_de_producaoDAO {

    public void removeById(int id) {

        String sql = "DELETE FROM ordens__de_producao WHERE id = ?";

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

    public void save(Ordem_de_producao ordem_de_producao_tempo) {
        String sql = "INSERT INTO ordens_de_producao(modelo, marca, cor, status, setor_atual)"
                + " VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMysql();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, ordem_de_producao_tempo.getModelo());
            pstm.setString(2, ordem_de_producao_tempo.getMarca());
            pstm.setString(3, ordem_de_producao_tempo.getCor());
            pstm.setString(4, "Iniciada");
            pstm.setString(5, "Estoque");

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

    public List<Ordem_de_producao> getOrdem_de_producaos() {
        //É uma lista de um objeto específico, nesse caso item

        String sql = "SELECT * FROM ordens_de_producao";

        List<Ordem_de_producao> buscarTodos = new ArrayList<Ordem_de_producao>();

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

                Ordem_de_producao ordem_de_producao = new Ordem_de_producao();

                ordem_de_producao.setId(rset.getInt("id"));
                ordem_de_producao.setModelo(rset.getString("modelo"));
                ordem_de_producao.setMarca(rset.getString("marca"));
                ordem_de_producao.setCor(rset.getString("cor"));
                ordem_de_producao.setStatus(rset.getString("status"));
                ordem_de_producao.setSetor_atual(rset.getString("setor_atual"));

                buscarTodos.add(ordem_de_producao);
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

    public void updateFinalizacao(int ordem) {
        String sql = "update ordens_de_producao set status = 'finalizada' where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMysql();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ordem);

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

    public void updateSetor(String setor, int id) {
        String sql = "update ordens_de_producao set setor_atual = ? where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMysql();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, setor);
            pstm.setInt(2, id);

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

    public String getNoestoque() {

        String quantos = "";

        String sql = "select count(id) from ordens_de_producao where setor_atual = 'Estoque'";

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

                Ordem_de_producao ordem_de_producao = new Ordem_de_producao();
                quantos = rset.getString(1);

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

        return quantos;
    }

    public String getNaexpedicao() {

        String quantos = "";

        String sql = "select count(id) from ordens_de_producao where setor_atual = 'Expedição'";

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

                Ordem_de_producao ordem_de_producao = new Ordem_de_producao();
                quantos = rset.getString(1);

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

        return quantos;
    }

    public String getNoprocesso() {

        String quantos = "";

        String sql = "select count(id) from ordens_de_producao where setor_atual = 'Processo'";

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

                Ordem_de_producao ordem_de_producao = new Ordem_de_producao();
                quantos = rset.getString(1);

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

        return quantos;
    }

    public String getNamontagem() {

        String quantos = "";

        String sql = "select count(id) from ordens_de_producao where setor_atual = 'Montagem'";

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

                Ordem_de_producao ordem_de_producao = new Ordem_de_producao();
                quantos = rset.getString(1);

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

        return quantos;
    }

    public String getTotal() {

        String quantos = "";

        String sql = "select count(id) from ordens_de_producao";

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

                Ordem_de_producao ordem_de_producao = new Ordem_de_producao();
                quantos = rset.getString(1);

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

        return quantos;
    }

}
