package step1;
/** 
 * Document Comment
 *	TV Ŭ�����Դϴ�.
 * 	���� ���� ���
 *  ä�� ���۱���� �ֽ��ϴ�.
 * @author ����
 *	@version 1.0
 */
class TV{
	// �ʵ� - �⺻�� �ν��Ͻ� ����
	boolean power; // ����
	int channel; // ä�� 0 ~ 999
	final int maxChannel = 999;
	int volume; // ����
	
	/**
	 * ������ �Ҵ�
	 */
	void powerOn(){
		power = true;
	}
	/**
	 * ������ ����.
	 */
	void powerOff() {
		power = false;
	}
	/**
	 * ������ ���°��� ��ȯ�Ѵ�.
	 * @return ������ ���� �����̸� : true, ���� �����̸� : false
	 */
	boolean isPower() {
		return power;
	}
	/**
	 * ä�ΰ� ��ȯ
	 * @return
	 */
	int getChannel() {
		return channel;
	}
	/**
	 * ä�ΰ��� ������ �� �ִ�.
	 * @param channel
	 */
	void setChannel(int channel) {
		//channel ����
		this.channel = channel;
	}
	/**
	 * ä�ΰ��� 1��ŭ �ø���.
	 */
	void channelUp() {
		if(channel>=maxChannel) {
			channel = 0;
		}else {
			channel++;
		}
	}
	/**
	 * ä�ΰ��� 1��ŭ ������.
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
 * �� ���Ͽ� ���� Ŭ������ ������, �����̸��� ���� Ŭ������ public ���� �����ڸ� ���´�.
 */
public class TVTest {

	public static void main(String[] args) {
		TV t; //  ������ ��������
		t = new TV();
		System.out.println(t.power);
		t.powerOn();
		boolean onOff = t.isPower();
		if(onOff) {
			System.out.println("������ �������ϴ�.");
			
			int c = t.getChannel();
			System.out.println("����ä�� : "+c);
			
			t.setChannel(11); // ä���� 11������ �����Ѵ�.
			System.out.println("���� ä�� : " + t.channel);
			
			for(int i = 0; i < 1000; i++) {
				t.channelUp();
			}
			System.out.println("1000�� ���� ��� ���� ä�� : " + t.channel);
			
			for(int i = 0; i < 15; i++) {
				t.channelDown();
			}
			System.out.println("���� ä�� : " + t.channel);
			
		}else {
			System.out.println("������ �������ϴ�.");
		}
			
		t.powerOff();
		System.out.println(onOff?"������ �������ϴ�." : "������ �������ϴ�."); 
	}
}
