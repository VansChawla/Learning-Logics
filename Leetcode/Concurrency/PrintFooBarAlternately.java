import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately {
    class FooBar {
        private int n;

        private Semaphore fooTurn = new Semaphore(1);
        private Semaphore barTurn = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            
            for (int i = 0; i < n; i++) {
                fooTurn.acquire();
                printFoo.run();
                barTurn.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            
            for (int i = 0; i < n; i++) {
                barTurn.acquire();
                printBar.run();
                fooTurn.release();
            }
        }
    }
}
