package step1;
/** 
 * Document Comment
 *	TV 클래스입니다.
 * 	전원 조작 기능
 *  채널 조작기능이 있습니다.
 * @author 여니
 *	@version 1.0
 */
class TV{
	// 필드 - 기본형 인스턴스 변수
	boolean power; // 전원
	int channel; // 채널 0 ~ 999
	final int maxChannel = 999;
	int volume; // 음량
	
	/**
	 * 전원을 켠다
	 */
	void powerOn(){
		power = true;
	}
	/**
	 * 전원을 끈다.
	 */
	void powerOff() {
		power = false;
	}
	/**
	 * 전원의 상태값을 반환한다.
	 * @return 전원이 켜진 상태이면 : true, 꺼진 상태이면 : false
	 */
	boolean isPower() {
		return power;
	}
	/**
	 * 채널값 반환
	 * @return
	 */
	int getChannel() {
		return channel;
	}
	/**
	 * 채널값을 조작할 수 있다.
	 * @param channel
	 */
	void setChannel(int channel) {
		//channel 제한
		this.channel = channel;
	}
	/**
	 * 채널값을 1만큼 올린다.
	 */
	void channelUp() {
		if(channel>=maxChannel) {
			channel = 0;
		}else {
			channel++;
		}
	}
	/**
	 * 채널값을 1만큼 내린다.
	 */
	void channelDown() {
		if(channel<=0) {
			channel = maxChannel;
		}else {
			channel--;
		}
	}
}
/*
 * 한 파일에 여러 클래스가 있을때, 파일이름과 같은 클래스는 public 접근 제한자를 갖는다.
 */
public class TVTest {

	public static void main(String[] args) {
		TV t; //  참조형 지역변수
		t = new TV();
		System.out.println(t.power);
		t.powerOn();
		boolean onOff = t.isPower();
		if(onOff) {
			System.out.println("전원이 켜졌습니다.");
			
			int c = t.getChannel();
			System.out.println("현재채널 : "+c);
			
			t.setChannel(11); // 채널을 11번으로 설정한다.
			System.out.println("현재 채널 : " + t.channel);
			
			for(int i = 0; i < 1000; i++) {
				t.channelUp();
			}
			System.out.println("1000번 돌린 췌널 현재 채널 : " + t.channel);
			
			for(int i = 0; i < 15; i++) {
				t.channelDown();
			}
			System.out.println("현재 채널 : " + t.channel);
			
		}else {
			System.out.println("전원이 꺼졌습니다.");
		}
			
		t.powerOff();
		System.out.println(onOff?"전원이 켜졌습니다." : "전원이 꺼졌습니다."); 
	}
}
