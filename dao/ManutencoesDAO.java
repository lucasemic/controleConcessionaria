// Autores: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro.

package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Manutencao;

public class ManutencoesDAO {

    public void removeById(int id) {

        String sql = "DELETE FROM manutencoes WHERE id = ?";

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

    public void save(Manutencao manutencao_temp) {
        String sql = "INSERT INTO manutencoes(descricao, localizacao, observacao, data_inicio, status)"
                + " VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMysql();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, manutencao_temp.getDescricao());
            pstm.setString(2, manutencao_temp.getLocalizacao());
            pstm.setString(3, manutencao_temp.getObservacao());
            pstm.setString(4, manutencao_temp.getData_inicio());
            pstm.setString(5, "Em aberto");

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

    public List<Manutencao> getManutencao() {
        //É uma lista de um objeto específico, nesse caso item

        String sql = "SELECT * FROM manutencoes";

        List<Manutencao> buscarTodos = new ArrayList<Manutencao>();

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

                Manutencao manutencao = new Manutencao();

                manutencao.setId(rset.getInt("id"));
                manutencao.setDescricao(rset.getString("descricao"));
                manutencao.setLocalizacao(rset.getString("localizacao"));
                manutencao.setObservacao(rset.getString("observacao"));
                manutencao.setData_inicio(rset.getString("data_inicio"));
                manutencao.setData_fim(rset.getString("data_fim"));
                manutencao.setStatus(rset.getString("status"));
                manutencao.setHorasdeclaradas(rset.getString("horastrabalhadas"));

                buscarTodos.add(manutencao);
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

    public void ExcluiTudo() {

        String sql = "delete from manutencoes";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMysql();

            pstm = conn.prepareStatement(sql);

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

    public void Filtar_Itens_Estoque() {

        String sql = "select * from manutencoes where setor = 'Estoque'";

        //conect
        Connection conn = null;
        //prepara a cosnulta
        PreparedStatement pstm = null;
        // o try faz o programa não travar, ele avisa qualquer erro
        try {
            conn = ConnectionFactory.createConnectionToMysql();
            //cria a conexão e consulta o sql
            pstm = conn.prepareStatement(sql);

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

    public String getEstoqueAndamento() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Estoque' and status = 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getEstoqueFinalizadas() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Estoque' and status != 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getProcessoAndamento() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Processo' and status = 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getProcessoFinalizado() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Processo' and status != 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public List<Manutencao> getFiltrar(String ComandoSQL) {
        //É uma lista de um objeto específico, nesse caso item

        String sql = ComandoSQL;

        List<Manutencao> buscarTodos = new ArrayList<Manutencao>();

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

                Manutencao manutencao = new Manutencao();

                manutencao.setId(rset.getInt("id"));
                manutencao.setDescricao(rset.getString("descricao"));
                manutencao.setLocalizacao(rset.getString("localizacao"));
                manutencao.setObservacao(rset.getString("observacao"));
                manutencao.setData_inicio(rset.getString("data_inicio"));
                manutencao.setData_fim(rset.getString("data_fim"));
                manutencao.setStatus(rset.getString("status"));
                manutencao.setHorasdeclaradas(rset.getString("horastrabalhadas"));

                buscarTodos.add(manutencao);
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

    public void updateData_fim(int id, float horas) {
        String sql = "UPDATE manutencoes SET data_fim = CURDATE(), status = 'Finalizada', horastrabalhadas = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMysql();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setFloat(1, horas);
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

    public String getMontagemAndamento() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Montagem' and status = 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getMontagemFinalizado() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Montagem' and status != 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getExpedicaoAndamento() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Expedicao' and status = 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getExpedicaoFinalizado() {

        String quantos = "";

        String sql = "select count(id) from manutencoes where localizacao = 'Expedicao' and status != 'Em aberto'";

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

                Manutencao manutencao = new Manutencao();
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

    public String Manutencoes_Finalizadas() {

        String finalizadas = "";

        String sql = "select cont(id) from manutencoes where status = 'Finalizada'";

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

                Manutencao manutencao = new Manutencao();
                finalizadas = rset.getString(1);

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

        return finalizadas;
    }

    public String Manutencoes_Em_Aberto() {

        String aberto = "";

        String sql = "select count(id) from manutencoes where status = 'em aberto'";

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

                Manutencao manutencao = new Manutencao();
                aberto = rset.getString(1);

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

        return aberto;
    }

    public String getHorasexpedicao() {

        String quantos = "";

        String sql = "select sum(horastrabalhadas) from manutencoes where localizacao = 'Expedicao'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getHorasestoque() {

        String quantos = "";

        String sql = "select sum(horastrabalhadas) from manutencoes where localizacao = 'Estoque'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getHorasprocesso() {

        String quantos = "";

        String sql = "select sum(horastrabalhadas) from manutencoes where localizacao = 'Processo'";

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

                Manutencao manutencao = new Manutencao();
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

    public String getHorasmontagem() {

        String quantos = "";

        String sql = "select sum(horastrabalhadas) from manutencoes where localizacao = 'Montagem'";

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

                Manutencao manutencao = new Manutencao();
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
