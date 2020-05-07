package dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {
	interface Post{
		void postOn(Facebook sns);
		void postOn(Twitter sns);
		}
	static class Text implements Post{
		public void postOn(Facebook sns) {
			System.out.println("text -> facebook");
		}
		public void postOn(Twitter sns) {
			System.out.println("text -> twitter");
		}
	}
	static class Picture implements Post{
		public void postOn(Facebook sns) {
			System.out.println("text -> facebook");
		}
		public void postOn(Twitter sns) {
			System.out.println("text -> twitter");
		}
	}
	interface SNS{}
	static class Facebook implements SNS{};
	static class Twitter implements SNS{};
	
	public static void main(String[] args) {
		List<Post> posts = Arrays.asList(new Text(),new Picture());
		List<SNS> snss = Arrays.asList(new Facebook(), new Twitter());
	
		// 컴파일 시점에서 매개변수 타입체크에 걸려서 더블 디스패칭을 할 수 없다.
		// Override 되지 않고, Overload를 사용했기 때문에!!!!
		posts.forEach(p->snss.forEach((SNS s)->p.postOn(s)));
	}
}
