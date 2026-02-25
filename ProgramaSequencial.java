public class ProgramaSequencial {

    //Definição de Constantes
    public static final int TOTAL = 2000000000;

    public static void main(String[] args) {
        System.out.println("-----TRABALHO 2 (Versão Sequencial)----");
        System.out.println("Calculando Pi com " + TOTAL + " termos.");
        System.out.println("---------------------------------------");

        Calculo calculoSequencial = new Calculo(0, TOTAL);

        //Começa a contagem de tempo e executa a sequencia
        long inicioT = System.currentTimeMillis();
        calculoSequencial.run();

        // Pega o resultado da soma dos termos e multiplica o final por 4 para obter o resultado de Pi
        double somaSequencial = calculoSequencial.getResultadoParcial();
        double piSequencial = somaSequencial * 4;

        //Calcula o tempo de execucao
        long finalT = System.currentTimeMillis();
        float tempo = (float) (finalT-inicioT)/1000;
        System.out.printf("\nResultado da execucao sequencial: %.10f%n", piSequencial);
        System.out.printf("\nTempo da execucao sequencial: %f segundos", tempo);

    }
}