import java.util.Scanner;
public class P14425_���ڿ�ã�� {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    tNode root = new tNode();
    while (n > 0) {  //Ʈ���� �ڷᱸ�� �����ϱ�
      String text = sc.next();
      tNode now = root;
      for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        // 26�� ���ĺ��� ��ġ�� �迭 index�� ��Ÿ���� ���� -'a'����
        if (now.next[c - 'a'] == null) { 
          now.next[c - 'a'] = new tNode();
        }
        now = now.next[c - 'a'];
        if (i == text.length() - 1)
          now.isEnd = true;
      }
      n--;
    }
    int count = 0;
    while (m > 0) {  //Ʈ���� �ڷᱸ�� �˻��ϱ�
      String text = sc.next();
      tNode now = root;
      for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        if (now.next[c - 'a'] == null) {  // �������̸� �ش� ���ڿ��� �������� ����
          break;
        }
        now = now.next[c - 'a'];
        if (i == text.length() - 1 && now.isEnd) // ���ڿ��� ���̰� ������� ��� ��ġ�ϸ�
          count++;  // S���տ� ���ԵǴ� ���ڿ�
      }
      m--;
    }
    System.out.println(count);
  }
}
class tNode {
  tNode[] next = new tNode[26];
  boolean isEnd;  // ���ڿ��� ������ ������ ǥ��
}
