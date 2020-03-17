package synchronizedTest;

public class T {

    static volatile int i = 0;

    public static void n() {
        i++;
    }

    public static synchronized void m() {
    }

    public  void x(){
        synchronized (this){
            System.out.println("synchronized");
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 1000_000; j++) {
            m();
            n();
        }
    }
}