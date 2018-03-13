package com.mygdx.game.widget.arcmenu;

public class Eclipse {
	private double a;//长半轴
	private double b;//短半轴
	private double x;//中心横坐标
	private double y;//中心纵坐标
	final double PI=3.14159265f;
	public Eclipse(double dblA,double dblB,double dblX,double dblY){
		a=dblA;
		b=dblB;
		x=dblX;
		y=dblY;
	}
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	
	/*
	*函数返回从角度为startAngle到角度为endAngle的椭圆弧的弧长
	*使用定积分计算时每次角度是增加step
	*/
	public double getArkLength(double startAngle,double endAngle,double step){
		double len=0;
		for(double agl=startAngle;agl<endAngle;agl+=step){
			double ark=agl*PI/180;//角度转化为弧度数
			double r=Math.sqrt(a*a*Math.cos(ark)*Math.cos(ark)+b*b*Math.sin(ark)*Math.sin(ark));
			len+=r*step*PI/180;
		}
		return len;
	}//getArkLength
	
	/*
	*微积分只能近似计算
	*郁闷，计算误差好大呀
	*/
	public double getCircleLength(){//椭圆圆周总长
		double l1,l2,l3;
		double len=0;
		//步长0.05度
		l1=4*getArkLength(0,90,0.05);	
		l2=2*getArkLength(0,180,0.05);	
		l3=getArkLength(0,360,0.05);
		/*System.out.println("步长0.05度时三次计算椭圆周总长结果分别为:");
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println("本次计算平均值："+((l1+l2+l3)/3));
		len+=(;*/
		return (l1+l2+l3)/3;
		/*
		//步长0.1度
		l1=4*getArkLength(0,90,0.1);	
		l2=2*getArkLength(0,180,0.1);	
		l3=getArkLength(0,360,0.1);
		System.out.println("步长0.1度时三次计算椭圆周总长结果分别为:");
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println("本次计算平均值："+((l1+l2+l3)/3));
		len+=(l1+l2+l3)/3;

		//步长0.2度
		l1=4*getArkLength(0,90,0.2);	
		l2=2*getArkLength(0,180,0.2);	
		l3=getArkLength(0,360,0.2);
		System.out.println("步长0.2度时三次计算椭圆周总长结果分别为:");
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println("本次计算平均值："+((l1+l2+l3)/3));
		len+=(l1+l2+l3)/3;
		
		return len/3;
		*/
	}//getCircleLength

	/*
	*n:等分数
	*起始等分点对应角度数
	*积分步长
	*/
	public double[] getAngles(int n,double startAngle,double step){
		double curLen=0;//每次积分后当前的弧长度
		double[] angles=new double[n];
		double l=getCircleLength();
		//System.out.println("getAngles()中椭圆周长为："+l);
		int i=0;
		angles[i]=startAngle;
		for(double agl=startAngle;agl<360+startAngle;agl+=step){
			double ark=agl*PI/180;//角度转化为弧度数
			double r=Math.sqrt(a*a*Math.cos(ark)*Math.cos(ark)+b*b*Math.sin(ark)*Math.sin(ark));
			curLen+=r*step*PI/180;
			if(Math.abs(curLen-l*(i+1)/n)<0.01){
				if((i%2==0&&curLen>l*(i+1)/n)||(i%2==1&&curLen<l*(i+1)/n)){
					angles[++i]=agl;
					//System.out.println("i="+i);
					if((i+1)==n) break;
				}
			}
		}
		for(int j=0;j<n;j++){
			System.out.println("第"+(j+1)+"个分割点角度数:"+angles[j]);
		}
		return angles;
	}//getAngles
	
	/*
	*参数同上
	*/
	public double[][] getPoints(int n,double startAngle,double step){
		double points[][]=new double[n][2];
		double angles[]=getAngles(n,startAngle,step);//获取分割点与椭圆中心的连线与x轴正反向的夹角度数
				for(int i=0;i<n;i++){
			points[i][0]=x+a*Math.cos(angles[i]*PI/180);
			points[i][1]=y+b*Math.sin(angles[i]*PI/180);
		}
		return points;
	}//getPoints
	public void displayPoints(double p[][],int n){
		for(int i=0;i<n;i++){
//			System.out.format("第%d个分割点坐标:(%.3f,%.3f)\n",(i+1),p[i][0],p[i][1]);
			eclipseCallBack.eclipsecall(i,p[i][0],p[i][1]);
		}
	}//displayPoint
	public interface EclipseCallBack{
		public void eclipsecall(int i,double x,double y);
	}
	public EclipseCallBack eclipseCallBack;
	public void setCallBack(EclipseCallBack eclipseCallBack){
		this.eclipseCallBack=eclipseCallBack;
	}
}
