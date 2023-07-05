

public class produtos {
    String produto;
    Double quantidade;
    Double saldo;
    String tipo ; 

    public Double somaProduto(Double valor){
        this.saldo += valor;
        return this.saldo;
        }
    }

