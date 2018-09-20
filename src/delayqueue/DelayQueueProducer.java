package delayqueue;


import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trungduc
 */
public class DelayQueueProducer {
	    // Creates an instance of blocking queue using the DelayQueue.
    private BlockingQueue<DelayObject> queue;

	private final Random random = new Random();
	
	public DelayQueueProducer(BlockingQueue<DelayObject> queue) {
		super();
		this.queue = queue;
	}
	
	private Thread producerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                  
                    // Put some Delayed object into the DelayQueue. UUID.randomUUID().toString()
                    int delay = random.nextInt(10000);
                    DelayObject object = new DelayObject(
                          "hello"  , delay);

                    System.out.printf("Put object = %s%n", object);
                    queue.put(object);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }, "Producer Thread");
	
	public void start(){
		this.producerThread.start();
	}
}
