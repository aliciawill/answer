import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P1219_�������ǰ�� {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M, sCity, eCity;
  static long distance[],cityMoney[];
  static Edge_1219 Edge_1219s[];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    sCity = Integer.parseInt(st.nextToken());
    eCity = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Edge_1219s = new Edge_1219[M];
    distance = new long[N];
    cityMoney = new long[N];
    Arrays.fill(distance, Long.MIN_VALUE); // �ִܰŸ� �迭 �ʱ�ȭ
    for (int i = 0; i < M; i++) { // ���� ����Ʈ�� ������ �����ϱ�
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int price = Integer.parseInt(st.nextToken());
      Edge_1219s[i] = new Edge_1219(start, end, price);
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cityMoney[i] = Long.parseLong(st.nextToken());
    }
    distance[sCity] = cityMoney[sCity]; // ������ �������� �˰��� ����
    for (int i = 0; i <= N + 100; i++) { // �������Ŭ�� ���ĵǵ��� ����� ū ���� �ݺ��ϱ�
      for (int j = 0; j < M; j++) {
        int start = Edge_1219s[j].start;
        int end = Edge_1219s[j].end;
        int price = Edge_1219s[j].price;
        if (distance[start] == Long.MIN_VALUE) continue; // ���۳�尡 �̹湮 ����̸� skip
        // ���� ��尡 �������Ŭ�� ����� ����� ���� ��嵵 ���� ���� ����
        else if (distance[start] == Long.MAX_VALUE)
          distance[end] = Long.MAX_VALUE;
        // �� ���� ���� ���� �ִ� ���ο� ��ΰ� �߰ߵ� ��� ���ο� ��� ������ ����
        else if (distance[end] < distance[start] + cityMoney[end] - price) {
          distance[end] = distance[start] + cityMoney[end] - price;
          // N-1 �ݺ� ���� ���ŵǴ� ���� ���� �������Ŭ ���� ���� ����
          if (i >= N - 1)
            distance[end] = Long.MAX_VALUE;
        }
      }
    }
    if (distance[eCity] == Long.MIN_VALUE) System.out.println("gg"); // ���� �Ұ���
    else if (distance[eCity] == Long.MAX_VALUE) System.out.println("Gee"); // �������Ŭ ����
    else System.out.println(distance[eCity]); //�� �̿��� ���
  }
}
class Edge_1219 { // ��������Ʈ�� ���ϰ� �ٷ�� ���� Ŭ������ ���� ����
  int start, end, price; // ������, ������, �ɸ��� �ð�
  public Edge_1219(int start, int end, int price) {
    this.start = start;
    this.end = end;
    this.price = price;
  }
}
