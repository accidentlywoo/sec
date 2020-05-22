package com.my.thread;

public class Share {
	int i;
	public void inc() {
		for(int i = 1; i <= 100; i++) { 
			synchronized (this) {
				this.notify(); //흐름 파악!
				System.out.println("before inc() this.i : " + this.i);
				this.i = this.i +1;// -> 공유 자원
				System.out.println("after inc() this.i = "+this.i);
			}
		}
	}
	
	public void dec() {
		for(int i = 1; i <= 100; i++) {
			synchronized (this) {
				if(this.i == 0){
					try {
						this.wait(); // Process가 끝나지 않는다.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("before dec() this.i : " + this.i);
				this.i = this.i -1;
				System.out.println("after dec() this.i = "+this.i);
			}
		}
	}
}
