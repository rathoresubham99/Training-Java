public class Circle {

	public static void main(String[] args)
	{

		int radius[]={2,3,4,6};
		int perimeters[];
		perimeters=getPerimeter(radius);
		for(int i=0;i<radius.length;i++)
		{
			System.out.println(perimeters[i]);
		}
	}
	public static int [] getPerimeter(int []radius)
	{
		int result[]=new int[radius.length];
		for(int i=0;i<radius.length;i++)
		{
			result[i]=(int)((double)(3.14)*(double)radius[i]);
		}
		
		return result;
	}
}