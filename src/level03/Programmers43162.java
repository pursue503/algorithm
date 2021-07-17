package level03;

/**
 *
 * 네트워크
 *
 */

public class Programmers43162 {

    private int[][] netWork;
    private boolean[] visited;

    public static void main(String[] args) {
        Programmers43162 programmers43162 = new Programmers43162();

        System.out.println(programmers43162.solution(3, new int[][]{
                {1,1,0,1},
                {1,1,0,0},
                {0,0,1,0},
                {1,0,0,1}
        }));

    }

    public int solution(int n, int[][] computers) {

        int answer = 0;

        netWork = computers;
        visited = new  boolean[n +1];

        for(int i=0; i<n; i++) {
            if(!visited[i]) { // n 번쟤 컴퓨터에 방문한 기록이 없으면 true 로 dfs 실행
                dfs(i);
                answer++; // 컴퓨터에 방문을 안했따는건 연결이 안되어있다는 뜻 ++; 해줌
            }
        }
        return answer;
    }

    public boolean dfs(int x) { // 컴퓨터가 들어옴

        visited[x] = true; // 컴퓨터 방문표시

        netWork[x][x] = 0; // 자기 자신은 0 처리해줌 대각선기준 본인 0 0 , 1,1 2,2

        for(int i=0; i<netWork[x].length; i++) { // 우측으로 탐색시작. i 가 컴터임
            if(netWork[x][i] == 1 && !visited[i]) {  // ex 0,1 , 이 1인지 방문안했는지와 ,  컴퓨터가 방문했떤 기록이 있는지
                netWork[x][i] = 0; // 처음이라면 0으로 바꿔주고
                dfs(i); // 1번 컴퓨터부터 dfs 탐색시작
            } else {
                netWork[x][i] = 0; // ex) 1번 컴퓨터에 처음방문한게 아니라면 요부분만 방문처리로 0으로 바꿔줌
            }
        }

        return true;
    }


}
