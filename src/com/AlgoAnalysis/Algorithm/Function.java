package com.AlgoAnalysis.Algorithm;

import java.util.ArrayList;

public class Function {

	//�����׼ƫ��,��׼ƫ�ӳ��ֵ�����ƽ��ֵ (mean) ����ɢ�̶ȡ�
	public static double StdDev(ArrayList<Double> sol,int n)
	{
		int i;
		double sum=0,avg;
		//����ƽ��ֵ
		for(i=0;i<n;i++)
			sum+=sol.get(i);
		avg=sum/n;
		sum=0;
		for(i=0;i<n;i++)
			sum+=(sol.get(i)-avg)*(sol.get(i)-avg);
		sum/=n;
		return Math.sqrt(sum);
	}
	//f0:����ģ�ͺ������Ǹ����庯��, �������־ֲ��Ż���������
	public static double Sphere(ArrayList<Double> sol,int n)
	{
		int j;
		double top=0;
		for(j=0;j<n;j++)
		{
			top+=sol.get(j)*sol.get(j);
		}
		return top;
	}
	//f1:����f0����Сֵ�ڹȵ�,x,y����[-5.12,5.12]
	public static double f1(ArrayList<Double> sol,int n)
	{
		double top=0;
		top+=sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1);	
		return top;
	}
	
	//f2:Quadric������СֵΪ0����ת�������庯��,�������������庯����Xi����[-100,100]
	public static double Quadric(ArrayList<Double> sol,int n)
	 {
		int i,j;
		double top,t1;
		top=0;
		for(i=0;i<n;i++){
			t1=0;
			for(j=0;j<=i;j++){
				t1+=sol.get(j);
			}
			top+=t1*t1;
		}
		return top;
	 }
	//f3:Rosenbrock ����, Ҳ���㽶(Banana)����,���Ž�Ϊ0���ֲ���[1,1,1...1]��
	//Rosenbrock������һ�����临���Ż�����,����ȫ�����ŵ�λ��һ��ƽ������������������ɽ����.���ں�������Ϊ�Ż��㷨�ṩ��
	//������Ϣ,ʹ�㷨���ѱ����������,�ҵ�ȫ����С��Ļ���΢����΢,���Rosenbrock����ͨ�����������Ż��㷨��ִ��Ч��
	public static double Rosenbrock(ArrayList<Double> sol,int n){
		int j;
		double top=0;
		for(j=0;j<n-1;j++)
		{
			top=top+100*Math.pow((sol.get(j+1)-Math.pow((sol.get(j)),(double)2)),(double)2)+Math.pow((sol.get(j)-1),(double)2);
		}
		return top;
	}
	
	//f4:Rastrigrin��������庯���������ھֲ����š�
	//���͵ķ����Զ�ģ̬����.���Ǿ��й㷺�������ռ䡢�����ľֲ���С��͸ߴ���ϰ���,ͨ������Ϊ���Ŵ��㷨���Ѵ���ĸ��Ӷ�ģ̬����
	public static double Rastrigin(ArrayList<Double> sol,int n)
	 {
		 int j;
		 double top=0;

		 for(j=0;j<n;j++)
		 {
			 top=top+(Math.pow(sol.get(j),(double)2)-10*Math.cos(2*Math.PI*sol.get(j))+10);
		 }
		 return top;
	 }
	 //f5:Griewank��������庯���������ھֲ����š�
	public static double Griewank(ArrayList<Double> sol,int n)
	 {
		 int j;
		 double top1,top2,top;
		 top=0;
		 top1=0;
		 top2=1;
		 for(j=0;j<n;j++)
		 {
			 top1=top1+Math.pow((sol.get(j)),(double)2);
			 top2=top2*Math.cos(sol.get(j)/Math.sqrt((double)(j+1)));

		 }	
		 top=(1/(double)4000)*top1-top2+1;
		 return top;
	 }
	//f6:Schaffer ������СֵΪ0��Xi����[-10,10]�����庯��
	 public static double Schaffer(ArrayList<Double> sol,int n)
	 {
		double top,t1,t2;
		t1=Math.pow(Math.sin(Math.sqrt(sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1))),(double)2)-0.5;
		t2=Math.pow(1+0.001*(sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1)),(double)2);
		top=0.5+t1/t2;
		return top;
	 }
	 //f7:��Сֵ��Bohachevsky���Ժ����������������庯�������Ž�Ϊ-0.1848���ֲ���[0,-0.23]��[0,0.23]��x,y����[-1,1]
	 public static double Bohachevsky(ArrayList<Double> sol,int n)
	 {
		double top;
		top=sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1)-0.3*Math.cos(3*Math.PI*sol.get(0))+0.3*Math.cos(4*Math.PI*sol.get(1))+0.3;
		return top;
	 }
	//f8:Shubert��760���ֲ���Сֵ�����е�18����ȫ����С����ֵΪ-186.73��x,y����[-10,10]
	public static double Shubert(ArrayList<Double> sol,int n)
	{
		double t1=0,t2=0;
		int i;
		for(i=1;i<=5;i++){
			t1+=i*Math.cos((i+1)*sol.get(0)+i);
			t2+=i*Math.cos((i+1)*sol.get(1)+i);
		}
		return t1*t2;
	 }
	 
	//f9:��СֵΪ0��Xi����[-10,10]���������������庯��
	public static double f9(ArrayList<Double> sol,int n)
	{
		double t1=0,t2=1;
		int i;
		for(i=0;i<n;i++){
			t1+=Math.abs(sol.get(i));
			t2*=Math.abs(sol.get(i));
		}	
		return t1+t2;
	}
	
	//f10:���庯��,��СֵΪ0��Xi����[-1.28,1.28]
	public static double f10(ArrayList<Double> sol,int n)
	{
		double t1=0,r;
		int i;
		for(i=0;i<n;i++){
			t1+=(i+1)*Math.pow(sol.get(i),(double)4);
		}	
		r = Math.random();
		return t1+r;
	}
	//f11:��庯��,��СֵΪ-2��Xi����[0,pi]
	public static double f11(ArrayList<Double> sol,int n)
	{
		double t1=0;
		int i;
		for(i=0;i<n;i++){
			t1+=Math.sin(sol.get(i))*Math.pow(Math.sin((i+1)*sol.get(i)*sol.get(i)/Math.PI),(double)20);
		}	
		return -t1;
	}
	//f12:��СֵΪ0��Xi����[-5,5]�����Ž���һ���ϴ��ƽ̹�Ĺȵ���
	public static double f12(ArrayList<Double> sol,int n)
	{
		double t1=0;
		int i;
		for(i=0;i<n;i++){
			t1+=Math.pow(sol.get(i),(double)4)-16*sol.get(i)*sol.get(i)+5*sol.get(i);
		}	
		return t1/n;
	}
	
	//f13:��庯��,�����ֵ��Xi����[-500,500],30άʱf(420.97)=12569.5,100άʱf(420.97)=41898.3
	public static double f13(ArrayList<Double> sol,int n)
	{
		double t1=0;
		int i;
		for(i=0;i<n;i++){
			t1+=sol.get(i)*Math.sin(Math.sqrt(Math.abs(sol.get(i))));
		}	
		return -t1;
	}
	
	//f14:Schaffer1����,ȫ�����Ž�Ϊ0���ֲ���(0,0)
	//x,y����[-5.12,5.12]
	public static double Schaffer1(ArrayList<Double> sol,int n)
	{
		double top=0;
		top=20+sol.get(0)*sol.get(0)-10*Math.cos(2*Math.PI*sol.get(0))+sol.get(1)*sol.get(1)-10*Math.cos(2*Math.PI*sol.get(1));
		return top;
	}
	
	//f15:Rana������ȫ�����Ž�ԼΪ-511.7���ֲ���(-512,-512)
	//x,y����[-512,512]
	public static double Rana(ArrayList<Double> sol,int n)
	{
		double top=0;
		top=sol.get(0)*Math.sin(Math.sqrt(Math.abs(sol.get(1)+1-sol.get(0))))*Math.cos(Math.sqrt(Math.abs(sol.get(1)+1+sol.get(0))))+(sol.get(1)+1)*Math.cos(Math.sqrt(Math.abs(sol.get(1)+1-sol.get(0))))*Math.sin(Math.sqrt(Math.abs(sol.get(1)+1+sol.get(0))));
		return top;
	}
	//f16:��״ͼ�Σ���Сֵ�ڰ���
	//x,y����[-5.12,5.12]
	public static double f16(ArrayList<Double> sol,int n)
	{
		double top;
		top=(4-2.1*(sol.get(0)*sol.get(0))+Math.pow((sol.get(0)*sol.get(0)*sol.get(0)*sol.get(0)),(double)1/3))*(sol.get(0)*sol.get(0))+sol.get(0)*sol.get(1)+(-4+4*sol.get(1)*sol.get(1))*(sol.get(1)*sol.get(1));
		return top;
	}
	
	//f17:���庯������Сֵ�ڹȵף�����ֵΪ0
	//Xi����[-100,100]
	public static double f17(ArrayList<Double> sol,int n)
	{
		double top,t1=0;
		int i;
		top=0;
		for(i=0;i<n;i++){
			t1=(sol.get(i)+0.5);
			if(t1>=0)
				t1=(int)t1;
			else
				t1=(int)(t1-1);
			top+=t1*t1;
		}
		return top;
	}
	//f18:���ֵΪ0��Xi����[-10,10],������͹�����庯��,���Ž���һ���ϴ��ƽ̹�ķ嶥��
	public static double f18(ArrayList<Double> sol,int n)
	{
		double t1=0;
		int i;
		for(i=0;i<n-1;i++){
			t1+=Math.pow((sol.get(i)*sol.get(i)-sol.get(i+1)),(double)2)+Math.pow((1-sol.get(i)),(double)2);
		}	
		return -t1;
	}
	//f19:��庯�������ĸ�ȫ�����ֵ2.118���ԳƷֲ���(0.64,0.64),(-0.64,-0.64),(0.64,-0.64),(-0.64,0.64)
	//������ֲ�����ֵ�����������м�������һȡֵ��ȫ�����ֵ�ӽ��ľֲ�����ֵ2.077͹̨
	//x,y����[-1,1]
	public static double f19(ArrayList<Double> sol,int n)
	{
		double top,t1;
		t1=1+sol.get(0)*Math.sin(4*Math.PI*sol.get(0))-sol.get(1)*Math.sin(4*Math.PI*sol.get(1)+Math.PI);
		top=Math.sin(6*Math.sqrt(sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1)))/(6*Math.sqrt(sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1)+1e-15));
		top+=t1;
		return top;
	}
	//f20:x,y����[-1,1]
	public static double f20(ArrayList<Double> sol,int n)
	{
		double top;
		top=1+sol.get(0)*Math.sin(4*Math.PI*sol.get(0))-sol.get(1)*Math.sin(4*Math.PI*sol.get(1)+Math.PI);
		return top;
	}
	
	
	//f21:Needle-in-haystack���������ֵ ����a=0.05,b=3�������Ž����Ϊ3600,�ֲ���(0,0)��4���ֲ���ֵ��Ϊ(5.12,5.12),(-5.12,-5.12),(-5.12,5.12),(5.12,-5.12)
	//x,y����[-5.12,5.12]
	public static double Needle(ArrayList<Double> sol,int n)
	{
		double top,t1,a,b;
		a=0.05;
		b=3;
		t1=b/(a+(sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1)));
		top=t1*t1+Math.pow((sol.get(0)*sol.get(0)+sol.get(1)*sol.get(1)),(double)2);
		return top;
	}
	
	//f22:Ackley��һ�����д����ֲ���С��Ķ�庯��, ��X=( 0,0,0,...,0)ʱ����ȫ�����Ž�Ϊ0
	public static double Ackley(ArrayList<Double> sol,int n)
	{
		int i;
		double top,t1=0,t2=0;
		for(i=0;i<n;i++){
			t1+=sol.get(i)*sol.get(i);
			t2+=Math.cos(2*Math.PI*sol.get(i));
		}
		top=-20*Math.exp(-0.2*Math.sqrt(t1/n))-Math.exp(t2/n)+20+Math.E;
		return top;
	}
}
