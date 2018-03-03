package chapter17;

/**
 * Question 17.21
 * @author Gili
 *
 */
public class VolumeOfHistogram {
	
	public static class Bar {
		int index;
		int height;
		
		public Bar(int height, int index){
			this.height = height;
			this.index = index;
		}
	}

	public static void main(String[] args){
		int[] a = {0, 0 ,4, 0, 0, 6,0,0,3,0,5,0,1,0,0,0};
		System.out.println(getVolume(a));
	}
	
	public static int getVolume(int[] bars){
		return getVolume(bars, 0, bars.length-1);
	}
	
	public static int getVolume(int[] bars, int fromIndex, int toIndex){
		if (fromIndex >= toIndex)
			return 0;
		
		Bar max = getMax(bars, fromIndex, toIndex);
		Bar leftMax = getMax(bars, fromIndex, max.index-1);
		Bar rightMax = getMax(bars, max.index+1, toIndex);
		
		int currVol=getVolBetween(bars, leftMax, max)+getVolBetween(bars, max, rightMax);

		if (leftMax!=null)
			currVol+=getVolume(bars, fromIndex, leftMax.index);
		
		if (rightMax!=null)
			currVol+=getVolume(bars, rightMax.index, toIndex);
		
		return currVol;
	}
	
	public static Bar getMax(int[] bars, int fromIndex, int toIndex){
		int indexOfMax=-1;
		int heightOfMax=0;
		for (int i=fromIndex; i<=toIndex; i++){
			if (bars[i] > heightOfMax){
				heightOfMax=bars[i];
				indexOfMax=i;
			}
		}
		if (indexOfMax==-1)
			return null; // all indexes are 0
		return (new Bar(heightOfMax, indexOfMax));
	}
	
	public static int getVolBetween(int[] bars, Bar left, Bar right){
		if (left==null || right==null)
			return 0;
		int height = Math.min(left.height, right.height);
		int width = right.index-left.index-1;
		int vol = height*width;
		for (int i=left.index+1; i<right.index; i++)
			if (bars[i]>0)
				vol-=bars[i];
		return vol;
	}

}
