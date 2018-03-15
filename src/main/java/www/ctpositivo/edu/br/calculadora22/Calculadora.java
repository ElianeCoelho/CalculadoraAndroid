package www.ctpositivo.edu.br.calculadora22;
import java.util.Scanner;

/**
 * Created by eliane on 09/03/2018.
 */

public class Calculadora {

    private double num;
    private double numAnterior;
    private String operador;


//construtor padrão
    public Calculadora(){
        num = 0;
        numAnterior = 0;
        operador = "";
    }





    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }




    private void realizarOperacaoSimples(){

        if(!operador.equals("")){
            if(operador.equals("+")){
                num = numAnterior + num;
            }else if(operador.equals("-")){
                num = numAnterior - num;
            }else if(operador.equals("*")){
                num = numAnterior * num;
            }else if (operador.equals("/")){
                if(num != 0){
                    num = numAnterior / num;
                }
            }
        }

    }













    public void realizarOperacao(String op){

    if(op .equals("%")){
        num = (numAnterior * num)/100;
    }else if(op.equals("+/-")){
        num *= -1; //ou a variavel recebe o próprio valor dela ex: -n ;
    }else if(op.equals("C")){
        num = 0;
        operador = "";
    }else if(op.equals("x2")){

      num = num * num;

    }else if(op.equals("PI")){
        num = Math.PI;

    }else if(op.equals("√")){
        num = Math.sqrt(num);

    }else if(operador.equals("POW")){

        num = Math.pow(numAnterior, num);
    }
    else{

        realizarOperacaoSimples();
        numAnterior = num;
        operador = op;

    }

    }

}
