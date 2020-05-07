package dispatch;

import java.util.*;

public class Dispatch {
	static class Service{
		void run() {
			// 메소드는 컴파일 시점에서 어떤 메소드 호출할지 결정된다.
			// static dispatching
			System.out.println("run()");
		}
		
		void run(String msg) {
			// 역시 static dispatching
			System.out.println("run(msg)");
		}
	}
	
	static abstract class AbsService{
		abstract void run();
	}
	static class MyService1 extends AbsService{
		@Override
		void run() {
			System.out.println("run1");
		}
		
	}
	
	static class MyService2 extends AbsService{
		@Override
		void run() {
			System.out.println("run2");
		}
		
	}
	
	public static void main(String[] args) {
		MyService1 svc1 = new MyService1();
		svc1.run();
		MyService2 svc2 = new MyService2();
		svc2.run();
		
		// 컴파일 시점에서 어떤 구현체를 호출할지 모른다.
		AbsService svc3 = new MyService1();
		// Dynamic Dispatching
		svc3.run();
		/* 메소드 호출과정에서 첫번째로 호출되는 receiver parameter
		 * (receiver parameter -> this 에 해당하는 것)
		 */
		List<AbsService> svc = Arrays.asList(new MyService1(), new MyService2());
		//svc.forEach(s->s.run());
		svc.forEach(AbsService::run);
	}
}
