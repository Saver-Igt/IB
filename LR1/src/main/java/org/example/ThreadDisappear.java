package org.example;

public class ThreadDisappear implements Runnable{
    private boolean end;
    public ThreadDisappear(String prompt) {
        System.out.print(prompt);
    }
    public void run() {
        while (end) {
            System.out.print("\010*"); // 010 - b - backspace
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void maskStart(){this.end = true;}
    public void maskEnd() {
        this.end = false;
    }
}
