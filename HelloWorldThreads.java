public class HelloWorldThreads {
    private static final int NUMBER_OF_THREADS = 10;

    // Função que será executada pela thread
    static class HelloWorldRunnable implements Runnable {
        private int threadId;

        public HelloWorldRunnable(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            System.out.println("Hello World. Greetings from thread " + threadId);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        // Cria e inicia as threads
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            System.out.println("Main here. Creating thread " + i);
            threads[i] = new Thread(new HelloWorldRunnable(i));
            threads[i].start();
        }

        // Aguarda todas as threads terminarem
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Erro ao esperar pela thread " + i);
            }
        }
    }
}
