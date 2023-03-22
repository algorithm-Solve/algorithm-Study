// 해당 대회는 1대1로 진행되기 때문에, 나오는 음식들을 /2해줘야 한다.(음식의 종류와 양이 동일하기 때문)
// 중간에 들어가는 0(물)을 기준으로 왼쪽에 놓여질 음식의 배치를 구해주고, 그걸 뒤집어서 오른쪽을 구해준다음 더해준다고 판단(0을 기준으로 배치가 대칭)

class 프로그래머스_푸드파이트대회 {
    public String solution(int[] food) {

        StringBuilder answer = new StringBuilder(); // 답을 구할 answer
        StringBuilder left = new StringBuilder(); // 왼쪽 배치를 구할 left

        // 왼쪽 배치를 구할 for문
        for (int i = 1; i < food.length; i++) { // 0번째는(물) 제외하고 1번째부터(음식) food의 길이까지 for문을 돌려준다.
            for (int j = 0; j < food[i] / 2; j++) { // food[i]값을 2로 나눈만큼
                left.append(i); // left에 i를 더해줌 → 만약 food[1](첫번째 음식)가 7일때, j = 0; j < 3; 까지니까 0,1,2 총 3번의 1을 더해줘야 하는 것
            }
        }
        return (answer.append(left).append("0").append(left.reverse())).toString(); // StringBulider에 left값 + "0" + left값을 뒤집은 값(=right)을 return
    }
}
