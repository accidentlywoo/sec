package algorithm;

public class TruckBungBung {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
         * bridge_length = 2
         * weight = 10
         */
        int len = truck_weights.length;
        int tool = 0;
        int answer = 0;
        
        for(int i = 0; i < len; i++){
            if(truck_weights[i] >= weight){
                answer += bridge_length;
            }else if((truck_weights[i]+truck_weights[i+1])>=weight){
                answer += bridge_length;
            }
            answer += len;
        }

        
        return answer;
    }
}
class Main{
	public static void main(String[] args) {
		
	}
}
