//Por: Lucas Emanuel Michaelsen, Gustavo Vítor Gaida e Mauro Pellizzaro
package model;

public class Ordem_de_producao {

    private int id;
    private String modelo;
    private String marca;
    private String cor;
    private String status;
    private String setor_atual;
    

    @Override
    public String toString() {
        return "Ordem{" + "id=" + id +", \nmodelo="
                + modelo + ", \nMarca=" + marca 
                + ", \ncor=" + cor 
                + ", status=" + status + ", setor_atual=" + setor_atual + '}';
    }

    public Ordem_de_producao() {
    }

    public Ordem_de_producao(int id, String modelo, String marca, String cor, String status,
            String setor_atual) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor; 
        this.status = status;
        this.setor_atual = setor_atual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getSetor_atual() {
        return setor_atual;
    }

    public void setSetor_atual(String setor_atual) {
        this.setor_atual = setor_atual;
    }
    
   
    

}

