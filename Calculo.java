public class Calculo extends Thread{

    private int inicio;
    private int fim;
    private double resultadoParcial;

    //Metodo setter para definir um inicio e fim do loop
    public Calculo(int inicio, int fim){
        this.inicio = inicio;
        this.fim = fim;
        this.resultadoParcial = 0.0;
    }
    //Metodo get para obter o resultado
    public double getResultadoParcial(){
        return resultadoParcial;
    }

    public void run(){
        try {
            //Lógica de Pi (Série de Leibniz)
            double soma = 0.0;
            for (long i = inicio; i < fim; i++) {
                double impar = 2.0 * i + 1;

                double termo = (1.0/impar);

                if (i % 2 == 0){
                    soma += termo;
                } else{
                    soma -= termo;
                }
            }
            this.resultadoParcial = soma;
            System.out.printf("Thread de " + inicio + " até " + fim + " terminou.\n");
        } catch (Exception e){};
    }
}

