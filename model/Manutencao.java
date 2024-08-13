//Por: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro
package model;

public class Manutencao {

    private int id;
    private String descricao;
    private String localizacao;
    private String observacao;
    private String data_inicio;
    private String data_fim;
    private String status;
    private String horasdeclaradas;

    @Override
    public String toString() {
        return "Manutencao{" + "id=" + id + ", \ndescricao="
                + descricao + ", \nlocalizacao=" + localizacao
                + ", \ndata_inicio=" + data_inicio
                + ", data_fim=" + data_fim + ", status=" + status + '}';
    }

    public Manutencao() {
    }

    public Manutencao(int id, String descricao, String localizacao, String observacao, String data_inicio,
            String data_fim, String status, String horasdeclaradas) {
        this.id = id;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.observacao = observacao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status = status;
        this.horasdeclaradas = horasdeclaradas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getHorasdeclaradas() {
        return horasdeclaradas;
    }

    public void setHorasdeclaradas(String horasdeclaradas) {
        this.horasdeclaradas = horasdeclaradas;
    }

    
    
}
