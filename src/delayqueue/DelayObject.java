package delayqueue;


import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trungduc
 */
public class DelayObject implements Delayed {
	private String data;
		private long startTime;

		public DelayObject(String data, long delayInMilliseconds) {
			this.data = data;
			this.startTime = System.currentTimeMillis() + delayInMilliseconds;
		}

		@Override
		public long getDelay(TimeUnit tu) {
			long diff = startTime - System.currentTimeMillis();
			return tu.convert(diff, TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.startTime < ((DelayObject) o).startTime) {
				return -1;
			}
			if (this.startTime > ((DelayObject) o).startTime) {
				return 1;
			}
			return 0;
		}
		
		@Override
		public String toString() {
			return "{" + "data='" + data + '\'' +
					", startTime=" + startTime +
					'}';
		}
}
