import java.util.Scanner;
public class P1717_������ǥ�� {
  public static int[] parent;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) { // ��ǥ ��带 �ڱ� �ڽ����� �ʱ�ȭ �ϱ�
      parent[i] = i;
    }
    for (int i = 0; i < M; i++) {
      int question = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (question == 0) { // ������ġ��
        union(a, b);
      } else { // ���� ������ �������� Ȯ���ϱ�
        if (checkSame(a, b)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }
  public static void union(int a, int b) { // union ���� : �ٷ� ������ �ƴ� ��ǥ ��峢�� �����Ͽ� ��
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }
  public static int find(int a) { // find ����
    if (a == parent[a])
      return a;
    else
      return parent[a] = find(parent[a]); // ����Լ��� ���·� ����
  }
  public static boolean checkSame(int a, int b) { // �� ���Ұ� ���� �������� Ȯ��
    a = find(a);
    b = find(b);
    if (a == b) {
      return true;
    }
    return false;
  }
}