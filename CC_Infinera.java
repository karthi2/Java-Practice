public class CC_Infinera {
	static Turn turn = Turn.PRODUCER;
	
	public static void main(String[] args) {
		Container container = new Container();
		Producer p = new Producer(container);
		Consumer c = new Consumer(container);
		Thread pro = new Thread(p);
		Thread con = new Thread(c);
		pro.start();
		con.start();
	}

	public static class Producer implements Runnable{
		Container container;
		//Turn turn;
		public Producer(Container integer) {
			this.container = integer;
			//this.turn = turn;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 10000000; i++){
				Turn temp = null;
				while(true){
					synchronized (turn) {
						temp = turn;
					}
					if(temp == Turn.PRODUCER){
						break;
					}
				}
				synchronized (turn) {
					System.out.println("Setting to consumer " + i);
					container.setI(i);
					turn = Turn.CONSUMER;
				}
			}
		}
	}
	
	public static class Consumer implements Runnable{
		Container container;
		//Turn turn;
		public Consumer(Container integer) {
			this.container = integer;
			//this.turn = turn;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 10000000; i++){
				Turn temp = null;
				while(true){
					synchronized (turn) {
						temp = turn;
					}
					if(temp == Turn.CONSUMER){
						break;
					}
				}
				synchronized (turn) {					
					System.out.println("Setting to producer " + container.getI());
					turn  = Turn.PRODUCER;
				}
			}
		}
		
	}
	
	public static class Container{
		Integer i = new Integer(0);
		

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
				
	}
	
	enum Turn{
		PRODUCER,CONSUMER;
	}
}