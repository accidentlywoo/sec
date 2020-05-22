package com.my.thread;

public class Share {
	int i;
	synchronized public void inc() {
		for(int i = 1; i <= 100; i++) { 
		// critical section 처리는? 
		// -> 공유자원을 사용하는 다른 Thread에게 CPU를 뺏기지 않는 처리를 해줘야 한다. 
		// -> 동기화 // synchronize
		
			System.out.println("before inc() this.i : " + this.i);
			this.i = this.i +1;// -> 공유 자원
			System.out.println("after inc() this.i = "+this.i);
		}
	}
	
	public void dec() {
		for(int i = 1; i <= 100; i++) {
			synchronized (this) {
				System.out.println("before dec() this.i : " + this.i);
				this.i = this.i -1;
				System.out.println("after dec() this.i = "+this.i);
			}
		}
	}
}
