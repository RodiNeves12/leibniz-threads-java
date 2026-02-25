public class ProgramaConcorrente {

    public static final int TOTAL = 2000000000;
    public static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        System.out.println("----TRABALHO 2 (Versão Concorrente)----");
        System.out.println("Calculando Pi com " + TOTAL + " termos.");
        System.out.println("---------------------------------------");

        long inicioT = System.currentTimeMillis();

        //Arrays para cada objeto das Threads
        Thread[] threads = new Thread[NUM_THREADS];
        Calculo[] calculoConcorrente = new Calculo[NUM_THREADS];

        //Calculo da divisão de partes das threads
        int fatia = TOTAL / NUM_THREADS;

        //Instancia as threads fazendo a divisão correta e as executa
        for (int i = 0; i < NUM_THREADS; i++) {
            int inicioIntervalo = i * fatia;
            int fimIntervalo = (i + 1) * fatia;

            if (i == NUM_THREADS - 1) fimIntervalo = TOTAL;

            calculoConcorrente[i] = new Calculo(inicioIntervalo, fimIntervalo);
            threads[i] = new Thread(calculoConcorrente[i]);
            threads[i].start();
        }

        //Bloqueia as threads até que terminem
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }

        //Soma dos termos para obter o resultado
        double somaConcorrente = 0.0;
        for (int i = 0; i < NUM_THREADS; i++) {
            somaConcorrente += calculoConcorrente[i].getResultadoParcial();
        }

        // Multiplica a soma por 4, para satisfazer a formula
        double piConcorrente = somaConcorrente * 4;

        long finalT = System.currentTimeMillis();
        float tempo = (float) (finalT-inicioT)/1000;
        System.out.printf("\nResultado da execucao concorrente: %.10f%n", piConcorrente);
        System.out.printf("\nTempo da execucao concorrente: %f segundos", tempo);

    }
}