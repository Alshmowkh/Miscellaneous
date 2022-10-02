/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALshmowkh
 */
public class SemaphoreImply extends Thread {

    private int threadId;
    private Semaphore semaphore;

    public SemaphoreImply(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    private int random(int n) {
        return (int) Math.round(n * Math.random());
    }

    private void busyCode() throws InterruptedException {
        int sleepPeriod = random(500);
        sleep(sleepPeriod);
    }

    private void noncriticalCode() throws InterruptedException {
        busyCode();
    }

    private void criticalCode() throws InterruptedException {
        busyCode();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                semaphore.acquire();
                criticalCode();
                semaphore.release();
            } catch (InterruptedException e) {
                System.out.println("Exception " + e.toString());
            }
        }
        for (int i = 0; i < 3; i++) {
            try {
                noncriticalCode();
            } catch (InterruptedException ex) {
                Logger.getLogger(SemaphoreImply.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        final int numberOfProcesses = 3;
        final int numberOfPermits = 2;

        Semaphore semaphore = new Semaphore(numberOfPermits, true);
        SemaphoreImply p[] = new SemaphoreImply[numberOfProcesses];

        for (int i = 0; i < numberOfProcesses; i++) {
            p[i] = new SemaphoreImply(semaphore);
            p[i].setThreadId(p[i].hashCode());
            p[i].start();
        }
    }
}
