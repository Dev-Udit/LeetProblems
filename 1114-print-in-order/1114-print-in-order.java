import java.util.concurrent.Semaphore;

class Foo {

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s1.release(); // allow second()
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire(); // wait for first()
        printSecond.run();
        s2.release(); // allow third()
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire(); // wait for second()
        printThird.run();
    }
}
