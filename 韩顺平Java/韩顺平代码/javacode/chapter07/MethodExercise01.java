

public class MethodExercise01 { 

	//��дһ��main����
	public static void main(String[] args) {

		AA a = new AA();
		// if(a.isOdd(2)) {//T , ������д���Ժ�ῴ���ܶ�
		// 	System.out.println("������");
		// } else {
		// 	System.out.println("��ż��");
		// }
		// 
		// 
		// ʹ��print����
		a.print(4, 4, '#');


		
	}
}
//��д��AA ����һ���������ж�һ����������odd����ż��, ����boolean
class AA {
	//˼·
	//1. �����ķ������� boolean
	//2. ���������� isOdd
	//3. �������β� (int num)
	//4. ������ , �ж�
	
	public boolean isOdd(int num) {
		// if(num % 2 != 0) {
		// 	return true;
		// } else {
		// 	return false;
		// }

		//return num % 2 != 0 ? true; false;
		//
		return num % 2 != 0;
	}

	//�����С��С��ַ���ӡ ��Ӧ�������������ַ���
	//���磺�У�4���У�4���ַ�#,���ӡ��Ӧ��Ч��
	/*
		####
		####
		####
		####
	 */
	//˼·
	//1. �����ķ������� void
	//2. ���������� print
	//3. �������β� (int row, int col, char c)
	//4. ������ , ѭ��
	public void print(int row, int col, char c) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {//���ÿһ��
				System.out.print(c);
			}
			System.out.println(); //����
		}
	}
}