import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P11657_Ÿ�Ӹӽ� {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static long distance[];
  static Edge edges[];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    edges = new Edge[M + 1];
    distance = new long[N + 1];
    Arrays.fill(distance, Integer.MAX_VALUE); // �ִܰŸ� �迭 �ʱ�ȭ
    for (int i = 0; i < M; i++) { // ���� ����Ʈ�� ������ �����ϱ�
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(start, end, time);
    }
    // �������� �˰��� ����
    distance[1] = 0;
    for (int i = 1; i < N; i++) {  //N���� �ϳ� ���� ����ŭ �ݺ�
      for (int j = 0; j < M; j++) {
        Edge edge = edges[j];
        // �� ���� �ִܰŸ� �� �ִ� ��� ����
        if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
          distance[edge.end] = distance[edge.start] + edge.time;
        }
      }
    }
    boolean mCycle = false;
    for (int i = 0; i < M; i++) { // ���� cycle Ȯ��
      Edge edge = edges[i];
      if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
        mCycle = true;
      }
    }
    if (!mCycle) { // ���� cycle�� ���� ���
      for (int i = 2; i <= N; i++) {
        if (distance[i] == Integer.MAX_VALUE)
          System.out.println("-1");
        else
          System.out.println(distance[i]);
      }
    } else { // ���� cycle�� �ִ� ���
      System.out.println("-1");
    }
  }
}
class Edge { // ��������Ʈ�� ���ϰ� �ٷ�� ���� Ŭ������ ���� ����
  int start, end, time;  // ������, ������, �ɸ��� �ð�
  public Edge(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}
