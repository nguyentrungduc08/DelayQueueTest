package delayqueue;


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
public class DelayQueueConsumer {
	private String name;
	
    private BlockingQueue<DelayObject> queue;

	public DelayQueueConsumer(String name, BlockingQueue<DelayObject> queue) {
		super();
		this.name = name;
		this.queue = queue;
	}
	
	private Thread consumerThread =  new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    // Take elements out from the DelayQueue object.
                    DelayObject object = queue.take();
                    System.out.printf("[%s] - Take object = %s%n",
                            Thread.currentThread().getName(), object);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
	
	public void start(){
		this.consumerThread.setName(name);
		this.consumerThread.start();
	}

}
