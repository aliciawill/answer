import java.util.*;
public class P2775_�γ�ȸ����_���׾� {
  static int T, N, K;
  static int[][] D;
  public static void main(String[] args) throws Exception {
    D = new int[15][15];
    for (int i = 0; i < 15; i++) { //�ʱ�ȭ
      D[i][1] = 1;
      D[0][i] = i;
    }
    for (int i = 1; i < 15; i++) {
      for (int j = 2; j < 15; j++) {
        D[i][j] = D[i][j-1] + D[i-1][j];  // ��ȭ��
      }
    }
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    for(int i=0; i<T; i++) // D�迭�� ��� ���س��� �� ���� ���
    {
      K = sc.nextInt();
      N = sc.nextInt();
      System.out.println(D[K][N]);
    }
  }
}
