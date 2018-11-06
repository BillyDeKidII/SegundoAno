public class Fracao{
    // instance variables - replace the example below with your own
    int numerador;
    int denominador;
    
    public Fracao(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }
    
    public Fracao somar(Fracao fracao){
        if(fracao.denominador == this.denominador){
            return new Fracao(this.numerador + fracao.numerador, this.denominador);
        }else{
            return null;
        }
    }
    
    public Fracao soma(int i){
        return null;
    }
    
    //faz um método pra calcular mmc
    public int mmc(){
        return 0;
    }
    
    public Fracao subtrair(Fracao fracao){
        return null;
    }
    
    public Fracao multiplicar(Fracao fracao){
        return null;        
    }
    
    public Fracao dividir(Fracao fracao){
        return null;
    }
    
    public Fracao subtrair(int i){
        return null;
    }
    
    public Fracao multiplicar(int i){
        return null;
    }
    
    public Fracao dividir(int i){
        return null;
    }
    
}
