package cn.lxy.utils;

public class MyTest5 {

	public static void main(String[] args) {
		
		double l1 = 110.92276d;
		double l2 = 21.676476d;
		
		double l3 = 110.92275d;
		double l4 = 21.676216d;
		
		algorithm(l1, l2, l3, l4);
		
	}
	public static double algorithm(double longitude1, double latitude1, double longitude2, double latitude2) {
        double Lat1 = rad(latitude1); // γ��
        double Lat2 = rad(latitude2);
        double a = Lat1 - Lat2;//����γ��֮��
        double b = rad(longitude1) - rad(longitude2); //����֮��
        double s = 2 * Math.asin(Math
                      .sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(Lat1) * Math.cos(Lat2) * Math.pow(Math.sin(b / 2), 2)));//�����������Ĺ�ʽ
        s = s * 6378137.0;//�����˵���뾶���뾶Ϊ�ף�
        s = Math.round(s * 10000d) / 10000d;//��ȷ�������ֵ
        System.out.println(s);
        return s;
	}

	private static double rad(double d) {
	        return d * Math.PI / 180.00; //�Ƕ�ת���ɻ���
	}
}
