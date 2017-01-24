
public class CheckTriangle {
	public static final int ACUTE_TRI = 2;
	public static final int RIGHT_ANGLED_TRI = 1;
	public static final int OBTUSE_TRI = 3;
	public static final double TINY_DIFF = 0.0001;
	public static final int NOT_TRI = 0;

	/** @param ls : double array
	 * @return returns true if all values are greater than 0**/
	public static boolean isGreater(double[] ls){
		for(int i=0;i<ls.length;i++)
			if(ls[i]<0)
				return false;
		return true;
	}
	/** @param ls : double array
	 * @return returns true if all values are greater than 0,3 vertices and 2*c<a+b+c**/
	public static boolean form_triangle(double[] ls)
	{
		if(ls.length==3&&isGreater(ls)){//if it is a threesided shape and all values are greater than 0
			sort(ls);
			if(2*max(ls) < sum(ls))
				return true;
		}
		return false;
	}
	/** @param ls : double array
	 * @return ls: as a sorted array**/
	public static void sort(double [] ls){
		int i;
		double temp;
		for(int j=1;j<ls.length;j++){
			i=j-1;
			while(i>=0&&ls[i]>ls[i+1]){
				temp=ls[i];
				ls[i]=ls[i+1];
				ls[i+1]=temp;
				i-=1;	
			}
		}
	}
	/** @param ls : double array
	 * @return returns the type of triangle ie. Rightangled,obtuse,acute **/
	public static int kind_triangle(double[] ls)
	{
		if(!form_triangle(ls))
			return NOT_TRI;
		else{
			sort(ls);
			double sum= Math.pow(max(ls),2)-(Math.pow(min(ls),2)+Math.pow(ls[1], 2));
			if(sum==0)
				return RIGHT_ANGLED_TRI;
			else if(sum>0)
				return OBTUSE_TRI;
			else 
				return ACUTE_TRI;
		}
	}
	/** @param ls : double array
	 * @return returns sum**/
	public static double sum(double[] arr)
	{
		double sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		return sum;
	}
	/** @param ls : double array
	 * @return returns max value**/
	public static double max(double[] arr)
	{
		sort(arr);
		return arr[arr.length-1];
	}
	/** @param ls : double array
	 * @return returns min value**/
	public static double min(double[] arr)
	{
		sort(arr);
		return arr[0];
	}
}

