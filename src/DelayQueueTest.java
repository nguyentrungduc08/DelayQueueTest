/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import delayqueue.DelayObject;
import delayqueue.DelayQueueConsumer;
import delayqueue.DelayQueueProducer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
/**
 *
 * @author trungduc
 */
public class DelayQueueTest {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// Creates an instance of blocking queue using the DelayQueue.
		BlockingQueue<DelayObject> queue = new DelayQueue<DelayObject>();
		
		// Starting DelayQueue Producer to push some delayed objects to the queue 
		new DelayQueueProducer(queue).start();
		
		// Starting DelayQueue Consumer to take the expired delayed objects from the queue
		new DelayQueueConsumer("Consumer Thread-1", queue).start();

	}
	
}
