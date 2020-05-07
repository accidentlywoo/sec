package dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {
	interface Post{
		void postOn(SNS sns);
		}
	static class Text implements Post{
		public void postOn(SNS sns) {
			sns.post(this);
		}
	}
	static class Picture implements Post{
		public void postOn(SNS sns) {
			sns.post(this);
		}
	}
	interface SNS{
		void post(Text post);
		void post(Picture post);
	}
	static class Facebook implements SNS{
		public void post(Text post) {
			System.out.println("text -> facebook");
		}
		public void post(Picture post) {
			System.out.println("post -> facebook");
		}
	};
	static class Twitter implements SNS{
		public void post(Text post) {
			System.out.println("text -> Twitter");
		}
		public void post(Picture post) {
			System.out.println("post -> Twitter");
		}
	};
	static class GooglePlus implements SNS{
		public void post(Text post) {
			System.out.println("text -> GooglePlus");
		}
		public void post(Picture post) {
			System.out.println("post -> GooglePlus");
		}
	};
	
	public static void main(String[] args) {
		List<Post> posts = Arrays.asList(new Text(),new Picture());
		List<SNS> snss = Arrays.asList(new Facebook(), new Twitter(), new GooglePlus());
	
		/*
		 * 
		 */
		posts.forEach(p->snss.forEach((SNS s)->p.postOn(s)));
	}
}
