package com.inputabc.ftpd.util;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 当数组长度小于5000时，强烈推荐使用该工具类代替apache的ArrayUtils，因为性能会更好！
 * 当数组长度大于5000时，除非有特殊需求，如数组入栈出栈、入队出队、数组乱序、数组移动等，否则还是建议使用apache的ArrayUtils，因为这时apache的性能更好！
 * 最后更新时间：2018/1/3
 * @author 高伟益
 * @version 1.6.5
 */

public class PArrayUtils{
	/*
	 * 排序类型的常量
	 */
	public static final  int SElECT_SORT = 0,
			BUBBLE_SORT = 1,
			FAST_SORT = 2;
	/*
	 * Set集合类型的常量
	 */
	public static final String HASH_SET= "HashSet",
			LINKEDHASH_SET = "LinkedHashSet",
			COPYONWRITEARRAY_SET = "CopyOnWriteArraySet",
			CONCURRENTSKIPLIST_SET = "ConcurrentSkipListSet";
	/*
	 * List集合类型的常量
	 */
	public static final String ARRAY_LIST = "ArrayList",
			VECTOR = "Vector",
			COPYONWRITEARRAY_LIST = "CopyOnWriteArrayList",
			LINKED_LIST = "LinkedList",
			STACK = "Stack";
	/*
	 * Map集合类型的常量
	 */
	public static final String HASH_MAP = "HashMap",
			LINKEDHASH_MAP = "LinkedHashMap",
			IDENTITYHASH_MAP = "IdentityHashMap",
			TREE_MAP = "TreeMap",
			WEAKHASH_MAP = "WeakHashMap";

			
			
	
			
	/**
	 * 数组排序（int）
	 * @param arr
	 * @param sortType（排序的方式）
	 * 
	 */
	private PArrayUtils(){
		
	}
	/**
	 * 获取两个数组中不同数据
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> List<T> compare(T[] t1, T[] t2) {
	    List<T> list1 = Arrays.asList(t1);
	    List<T> list2 = new ArrayList<T>();
	    for (T t : t2) {
	      if (!list1.contains(t)) {
	        list2.add(t);
	      }
	    }
	    return list2;
	}
	public final static void sort(int[] arr,int sortType){
		if(sortType==0)//选择排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y = x+1;y<arr.length;y++){
					if(arr[y]>arr[x]){
						arr[x]  =arr[y]^arr[x];
						arr[y]  =arr[y]^arr[x];
						arr[x]  =arr[y]^arr[x];
					}
				}
			}
		else if(sortType==1){//冒泡排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y  =0;y<arr.length-x-1;y++){
					if(arr[y+1]>arr[y]){
						arr[y] = arr[y+1]^arr[y];
						arr[y+1] = arr[y+1]^arr[y];
						arr[y] = arr[y+1]^arr[y];
					}
				}
			}
		}else if(sortType==2){//快速排序
			Arrays.sort(arr);
			reverse(arr);
		}else{
			sort(arr, PArrayUtils.FAST_SORT);
			reverse(arr);
		}
	}
	/**
	 * 数组排序（int）
	 * @param arr
	 * @param sortType（排序的方式）
	 * 
	 */
	public final static void sort(short[] arr,int sortType){
		if(sortType==0)//选择排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y = x+1;y<arr.length;y++){
					if(arr[y]>arr[x]){
						arr[x]  =(short) (arr[y]^arr[x]);
						arr[y]  =(short) (arr[y]^arr[x]);
						arr[x]  =(short) (arr[y]^arr[x]);
					}
				}
			}
		else if(sortType==1){//冒泡排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y  =0;y<arr.length-x-1;y++){
					if(arr[y+1]>arr[y]){
						arr[y] = (short) (arr[y+1]^arr[y]);
						arr[y+1] = (short) (arr[y+1]^arr[y]);
						arr[y] = (short) (arr[y+1]^arr[y]);
					}
				}
			}
		}else if(sortType==2){//快速排序
			Arrays.sort(arr);
			reverse(arr);
		}else{
			sort(arr, PArrayUtils.FAST_SORT);
			reverse(arr);
		}
	}
	/**
	 * 数组排序（long）
	 * @param arr
	 * @param sortType（排序的方式）
	 * 
	 */
	public final static void sort(long[] arr,int sortType){
		if(sortType==0)//选择排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y = x+1;y<arr.length;y++){
					if(arr[y]>arr[x]){
						arr[x]  =arr[y]^arr[x];
						arr[y]  =arr[y]^arr[x];
						arr[x]  =arr[y]^arr[x];
					}
				}
			}
		else if(sortType==1){//冒泡排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y  =0;y<arr.length-x-1;y++){
					if(arr[y+1]>arr[y]){
						arr[y] = arr[y+1]^arr[y];
						arr[y+1] = arr[y+1]^arr[y];
						arr[y] = arr[y+1]^arr[y];
					}
				}
			}
		}else if(sortType==2){//快速排序
			Arrays.sort(arr);
			reverse(arr);
		}else{
			sort(arr, PArrayUtils.FAST_SORT);
			reverse(arr);
		}
	}
	/**
	 * 数组排序（char）
	 * @param arr
	 * @param sortType（排序的方式）
	 * 
	 */
	public final static void sort(char[] arr,int sortType){
		if(sortType==0)//选择排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y = x+1;y<arr.length;y++){
					if(arr[y]>arr[x]){
						arr[x]  =(char) (arr[y]^arr[x]);
						arr[y]  =(char) (arr[y]^arr[x]);
						arr[x]  =(char) (arr[y]^arr[x]);
					}
				}
			}
		else if(sortType==1){//冒泡排序
			for(int x = 0;x<arr.length-1;x++){
				for(int y  =0;y<arr.length-x-1;y++){
					if(arr[y+1]>arr[y]){
						arr[y] = (char) (arr[y+1]^arr[y]);
						arr[y+1] = (char) (arr[y+1]^arr[y]);
						arr[y] = (char) (arr[y+1]^arr[y]);
					}
				}
			}
		}else if(sortType==2){//快速排序
			Arrays.sort(arr);
			reverse(arr);
		}else{
			sort(arr, PArrayUtils.FAST_SORT);
			reverse(arr);
		}
	}
	
	/**
	 * 拷贝数组（int）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(int[] oldArr,int[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（short）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(short[] oldArr,short[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（long）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(long[] oldArr,long[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（char）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(char[] oldArr,char[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（byte）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(byte[] oldArr,byte[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（float）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(float[] oldArr,float[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（double）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(double[] oldArr,double[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	/**
	 * 拷贝数组（Object）
	 * @param oldArr
	 * @param newArr
	 */
	public final static void copy(Object[] oldArr,Object[] newArr){
		if(newArr.length<oldArr.length)
			throw new RuntimeException("新数组的长度小于原数组的长度");
		if(oldArr.length==0&&newArr.length==0)
			return;
		if(newArr.length>=oldArr.length){
			for(int x = 0;x<oldArr.length;x++){
				newArr[x] = oldArr[x];
			}
		}
	}
	
	/**
	 * 获取回文数数组（int）
	 * @param n
	 * @return
	 */
	public final static int[] getPalindrome(int n){
		int start = 0,end = 9;
		int[] huiwenshuzu = new int[]{};
		for(int x = 1;x<=n;x++){
			if(x==1&&n==1)
				break;
			else if(x==1&&n>1){
				String startString = "1"+String.valueOf(start);
				String endString = String.valueOf(end);
				endString+="9";
				start = Integer.parseInt(startString);
				end = Integer.parseInt(endString);
			}
			else{
				String startString = String.valueOf(start);
				startString+="0";
				String endString = String.valueOf(end);
				endString+="9";
				start = Integer.parseInt(startString);
				end = Integer.parseInt(endString);
			}
			
		}
		for(int x = start;x<=end;x++){
			StringBuilder sb = new StringBuilder(String.valueOf(x));
			StringBuilder reverse = sb.reverse();
			if(String.valueOf(x).equals(reverse.toString())){
				huiwenshuzu = add(huiwenshuzu, x);
			}
		}
		return huiwenshuzu;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（int）
	 * @param arr
	 * @return
	 */
	public final static int[] noRepeat(int[] arr){
		int[] newArr = new int[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（short）
	 * @param arr
	 * @return
	 */
	public final static short[] noRepeat(short[] arr){
		short[] newArr = new short[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（long）
	 * @param arr
	 * @return
	 */
	public final static long[] noRepeat(long[] arr){
		long[] newArr = new long[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（byte）
	 * @param arr
	 * @return
	 */
	public final static byte[] noRepeat(byte[] arr){
		byte[] newArr = new byte[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（char）
	 * @param arr
	 * @return
	 */
	public final static char[] noRepeat(char[] arr){
		char[] newArr = new char[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（float）
	 * @param arr
	 * @return
	 */
	public final static float[] noRepeat(float[] arr){
		float[] newArr = new float[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（double）
	 * @param arr
	 * @return
	 */
	public final static double[] noRepeat(double[] arr){
		double[] newArr = new double[]{};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x]==newArr[y])
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return newArr;
	}
	/**
	 * 去掉数组中重复的值，返回新数组（T）
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] noRepeat(T[] arr){

	    Object[] newArr = {};
		newArr = add(newArr, arr[0]);
		for(int x = 0;x<arr.length;x++){
			boolean hadValue = false;
			for(int y = 0;y<newArr.length;y++){
				if(arr[x].equals(newArr[y]))
					hadValue = true;
			}
			if(hadValue==false)
				newArr = add(newArr, arr[x]);
			
		}
		return (T[]) newArr;
	}

	/**
	 * 获取目标值在原数组中的数量（int）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(int[] arr,int value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（short）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(short[] arr,short value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（long）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(long[] arr,long value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（byte）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(byte[] arr,byte value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（boolean）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(boolean[] arr,boolean value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（char）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(char[] arr,char value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（float）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(float[] arr,float value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（double）
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static int getCount(double[] arr,double value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==value)
				count++;
		}
		return count;
	}
	/**
	 * 获取目标值在原数组中的数量（T）
	 * @param <T>
	 * @param arr
	 * @param value
	 * @return
	 */
	public final static <T> int getCount(T[] arr,T value){
		int count = 0;
		for(int x = 0;x<arr.length;x++){
			if(arr[x].equals(value))
				count++;
		}
		return count;
	}
	/**
	 * 数组增加元素（int）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static int[] add(int[] oldArr,int element){
		int[] newArr = new int[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		oldArr = newArr;
		return newArr;
	}
	/**
	 * 数组增加元素（short）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static short[] add(short[] oldArr,short element){
		short[] newArr = new short[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		return newArr;
	}
	/**
	 * 数组增加元素（char）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static char[] add(char[] oldArr,char element){
		char[] newArr = new char[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		return newArr;
	}
	/**
	 * 数组增加元素（long）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static long[] add(long[] oldArr,long element){
		long[] newArr = new long[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		return newArr;
	}
	/**
	 * 数组增加元素（float）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static float[] add(float[] oldArr,float element){
		float[] newArr = new float[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		return newArr;
	}
	/**
	 * 数组增加元素（double）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static double[] add(double[] oldArr,double element){
		double[] newArr = new double[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		return newArr;
	}
	
	/**
	 * 数组增加元素（byte）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static byte[] add(byte[] oldArr,byte element){
		byte[] newArr = new byte[oldArr.length+1];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		newArr[oldArr.length] = element;
		return newArr;
	}
	/**
	 * 数组增加元素（T）
	 * @param oldArr
	 * @param element
	 * @return
	 */
	public final static <T> T[] add(T[] arr, T element) {
	
		@SuppressWarnings("unchecked")
		T[] newArr = (T[])Array.newInstance(arr.getClass().getComponentType(), arr.length+1);
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		newArr[newArr.length-1] = element;
        return newArr;
    }
	/**
	 * 数组增加多个元素（int）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static int[] addAll(int[] oldArr,int... elements){
		int[] newArr = new int[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 数组增加多个元素（short）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static short[] addAll(short[] oldArr,short... elements){
		short[] newArr = new short[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 数组增加多个元素（char）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static char[] addAll(char[] oldArr,char... elements){
		char[] newArr = new char[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 数组增加多个元素（long）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static long[] addAll(long[] oldArr,long... elements){
		long[] newArr = new long[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 数组增加多个元素（float）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static float[] addAll(float[] oldArr,float... elements){
		float[] newArr = new float[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 数组增加多个元素（double）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static double[] addAll(double[] oldArr,double... elements){
		double[] newArr = new double[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	
	/**
	 * 数组增加多个元素（byte）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static byte[] addAll(byte[] oldArr,byte... elements){
		byte[] newArr = new byte[oldArr.length+elements.length];
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 数组增加多个元素（T）
	 * @param oldArr
	 * @param elements
	 * @return
	 */
	public final static <T> T[] addAll(T[] oldArr,T... elements){
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) Array.newInstance(oldArr.getClass().getComponentType(), oldArr.length+elements.length);
		for(int x = 0;x<oldArr.length;x++){
			newArr[x] = oldArr[x];
		}
		for(int x = 0;x<elements.length;x++){
			newArr[oldArr.length+x] = elements[x];
		}
		return newArr;
	}
	/**
	 * 判断数组是否包含指定元素（int）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(int[] arr,int element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 判断数组是否包含指定元素（short）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(short[] arr,short element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 判断数组是否包含指定元素（char）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(char[] arr,char element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 判断数组是否包含指定元素（long）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(long[] arr,long element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 判断数组是否包含指定元素（float）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(float[] arr,float element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 判断数组是否包含指定元素（double）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(double[] arr,double element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 判断数组是否包含指定元素（byte）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static boolean containts(byte[] arr,byte element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	
	/**
	 * 判断数组是否包含指定元素（T）
	 * @param <T>
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static <T> boolean containts(T[] arr,T element){
		for(int x = 0;x<arr.length;x++){
			if(arr[x]==element)
				return true;
		}
		return false;
	}
	/**
	 * 数组插入某些元素（int）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */
	public final static int[] insertAll(int index,int[] arr,int... elements){
		int[] newArr = new int[]{};
		int[] pre = new int[]{};
		int[] after = new int[]{};
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	/**
	 * 数组插入某些元素（short）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */
	public final static short[] insertAll(int index,short[] arr,short... elements){
		short[] newArr = new short[]{};
		short[] pre = new short[]{};
		short[] after = new short[]{};
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	/**
	 * 数组插入某些元素（long）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */
	public final static long[] insertAll(int index,long[] arr,long... elements){
		long[] newArr = new long[]{};
		long[] pre = new long[]{};
		long[] after = new long[]{};
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	/**
	 * 数组插入某些元素（byte）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */
	public final static byte[] insertAll(int index,byte[] arr,byte... elements){
		byte[] newArr = new byte[]{};
		byte[] pre = new byte[]{};
		byte[] after = new byte[]{};
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	/**
	 * 数组插入某些元素（float）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */
	public final static float[] insertAll(int index,float[] arr,float... elements){
		float[] newArr = new float[]{};
		float[] pre = new float[]{};
		float[] after = new float[]{};
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	/**
	 * 数组插入某些元素（double）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */ 
	public final static double[] insertAll(int index,double[] arr,double... elements){
		double[] newArr = new double[]{};
		double[] pre = new double[]{};
		double[] after = new double[]{};
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	
	/**  
	 * 数组插入某些元素（T）
	 * @param index
	 * @param arr
	 * @param elements
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] insertAll(int index,T[] arr,T... elements){
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		T[] pre = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		T[] after = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		for(int x = 0;x<=index;x++){
			pre = add(pre, arr[x]);
		}
		for(int x = index+1;x<arr.length;x++){
			after = add(after, arr[x]);
		}
		newArr = addAll(newArr, pre);
		newArr = addAll(newArr, elements);
		newArr = addAll(newArr, after);
		return newArr;
	}
	/**
	 * 比较两个或多个数组是否完全相同（int）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(int[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		int element = 0;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 比较两个或多个数组是否完全相同（short）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(short[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		short element = 0;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 比较两个或多个数组是否完全相同（long）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(long[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		long element = 0l;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 比较两个或多个数组是否完全相同（byte）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(byte[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		byte element = 0;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 比较两个或多个数组是否完全相同（float）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(float[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		float element = 0f;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 比较两个或多个数组是否完全相同（double）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(double[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		double element = 0d;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 比较两个或多个数组是否完全相同（char）
	 * @param arr
	 * @return
	 */
	public final static boolean equals(char[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		char element = (char)0;
		for(int x = 0;x<arr.length;){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 比较两个或多个数组是否完全相同（T）
	 * @param <T>
	 * @param arr
	 * @return
	 */
	public final static <T> boolean equals(T[]... arr){
		for(int x = 0;x<arr.length;x++){
			if((x+1)>=arr.length)
				break;
			if(arr[x].length!=arr[x+1].length)
				return false;
		}
		T element = null;
		for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<arr[x].length;y++){
				element = arr[x][y];
				if((x+1)<arr.length){
					for(int z = (x+1);z<arr.length;z++){
						if(!String.valueOf(element).equals(String.valueOf(arr[z][y]))){
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * 克隆数组（int）
	 * @param arr
	 * @return
	 */
	public final static int[] clone(int[] arr){
		int[] newArr = new int[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 克隆数组（short）
	 * @param arr
	 * @return
	 */
	public final static short[] clone(short[] arr){
		short[] newArr = new short[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 克隆数组（long）
	 * @param arr
	 * @return
	 */
	public final static long[] clone(long[] arr){
		long[] newArr = new long[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 克隆数组（byte）
	 * @param arr
	 * @return
	 */
	public final static byte[] clone(byte[] arr){
		byte[] newArr = new byte[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 克隆数组（float）
	 * @param arr
	 * @return
	 */
	public final static float[] clone(float[] arr){
		float[] newArr = new float[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 克隆数组（double）
	 * @param arr
	 * @return
	 */
	public final static double[] clone(double[] arr){
		double[] newArr = new double[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 克隆数组（char）
	 * @param arr
	 * @return
	 */
	public final static char[] clone(char[] arr){
		char[] newArr = new char[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	
	/**
	 * 克隆数组（T）
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] clone(T[] arr){
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(),arr.length);
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 反转数组中的元素（int）
	 * @param arr
	 * @return
	 */
	public final static void reverse(int[] arr){
		int[] newArr = new int[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（short）
	 * @param arr
	 * @return
	 */
	public final static void reverse(short[] arr){
		short[] newArr = new short[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（long）
	 * @param arr
	 * @return
	 */
	public final static void reverse(long[] arr){
		long[] newArr = new long[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（byte）
	 * @param arr
	 * @return
	 */
	public final static void reverse(byte[] arr){
		byte[] newArr = new byte[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（float）
	 * @param arr
	 * @return
	 */
	public final static void reverse(float[] arr){
		float[] newArr = new float[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（double）
	 * @param arr
	 * @return
	 */
	public final static void reverse(double[] arr){
		double[] newArr = new double[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（char）
	 * @param arr
	 * @return
	 */
	public final static void reverse(char[] arr){
		char[] newArr = new char[arr.length];
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	/**
	 * 反转数组中的元素（T）
	 * @param <T>
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> void reverse(T[] arr){
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(),arr.length);
		for(int x= 0;x<arr.length;x++){
			newArr[arr.length-x-1] = arr[x];
		}
		for(int x = 0;x<newArr.length;x++){
			arr[x] = newArr[x];
		}
	}
	
	/**
	 * 获取目标元素在数组中最后一次出现的索引（int）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(int[] arr,int element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 获取目标元素在数组中最后一次出现的索引（short）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(short[] arr,short element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 获取目标元素在数组中最后一次出现的索引（long）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(long[] arr,long element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 获取目标元素在数组中最后一次出现的索引（byte）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(byte[] arr,byte element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 获取目标元素在数组中最后一次出现的索引（char）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(char[] arr,char element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 获取目标元素在数组中最后一次出现的索引（float）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(float[] arr,float element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 获取目标元素在数组中最后一次出现的索引（double）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int lastIndexOf(double[] arr,double element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	
	/**
	 * 获取目标元素在数组中最后一次出现的索引（T）
	 * @param <T>
	 * @param arr
	 * @param element
	 * @return
	 */
	
	public final static <T> int lastIndexOf(T[] arr,T element){
		reverse(arr);
		for(int x = 0;x<arr.length;x++){
			if(element==arr[x]){
				return arr.length-x-1;
			}
		}
		return -1;
	}
	/**
	 * 通过索引移除数组中的相应的元素（int）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static int[] remove(int[] arr,int... indexs){
		int[] newArr = new int[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 通过索引移除数组中的相应的元素（short）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static short[] remove(short[] arr,int... indexs){
		short[] newArr = new short[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 通过索引移除数组中的相应的元素（long）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static long[] remove(long[] arr,int... indexs){
		long[] newArr = new long[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 通过索引移除数组中的相应的元素（char）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static char[] remove(char[] arr,int... indexs){
		char[] newArr = new char[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 通过索引移除数组中的相应的元素（byte）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static byte[] remove(byte[] arr,int... indexs){
		byte[] newArr = new byte[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 通过索引移除数组中的相应的元素（float）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static float[] remove(float[] arr,int... indexs){
		float[] newArr = new float[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 通过索引移除数组中的相应的元素（double）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	public final static double[] remove(double[] arr,int... indexs){
		double[] newArr = new double[]{};
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	
	/**
	 * 通过索引移除数组中的相应的元素（T）
	 * @param arr
	 * @param indexs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] remove(T[] arr,int... indexs){
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		int[] newIndexs = {};
		for(int x =0;x<indexs.length;x++){
			if(x<newArr.length){
				newIndexs = add(newIndexs,x);
			}
		}
		a:for(int x = 0;x<arr.length;x++){
			for(int y = 0;y<indexs.length;y++){
				if(x==indexs[y])
					continue a;
			}
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（int）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int[] push(int[] arr,int element){
		int[] newArr = new int[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（short）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static short[] push(short[] arr,short element){
		short[] newArr = new short[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（char）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static char[] push(char[] arr,char element){
		char[] newArr = new char[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（long）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static long[] push(long[] arr,long element){
		long[] newArr = new long[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（byte）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static byte[] push(byte[] arr,byte element){
		byte[] newArr = new byte[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（float）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static float[] push(float[] arr,float element){
		float[] newArr = new float[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入栈操作（double）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static double[] push(double[] arr,double element){
		double[] newArr = new double[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	
	/**
	 * 数组入栈操作（T）
	 * @param arr
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] push(T[] arr,T element){
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组出栈操作（int）
	 * @param arr
	 * @return
	 */
	public final static int pop(int[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		int head = arr[0];
		arr[0] = 0;
		return head;
	}
	/**
	 * 数组出栈操作（short）
	 * @param arr
	 * @return
	 */
	public final static short pop(short[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		short head = (short)arr[0];
		arr[0] = 0;
		return head;
	}
	/**
	 * 数组出栈操作（char）
	 * @param arr
	 * @return
	 */
	public final static char pop(char[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		char head = arr[0];
		arr[0] = 0;
		return head;
	}
	/**
	 * 数组出栈操作（long）
	 * @param arr
	 * @return
	 */
	public final static long pop(long[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		long head = arr[0];
		arr[0] = 0L;
		return head;
	}
	/**
	 * 数组出栈操作（float）
	 * @param arr
	 * @return
	 */
	public final static float pop(float[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		float head = arr[0];
		arr[0] = 0.0f;
		return head;
	}
	/**
	 * 数组出栈操作（double）
	 * @param arr
	 * @return
	 */
	public final static double pop(double[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		double head = arr[0];
		arr[0] = 0.0D;
		return head;
	}
	/**
	 * 数组出栈操作（byte）
	 * @param arr
	 * @return
	 */
	public final static byte pop(byte[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		byte head = arr[0];
		arr[0] = (byte)0;
		return head;
	}
	
	/**
	 * 数组出栈操作（T）
	 * @param <T>
	 * @param arr
	 * @return
	 */
	public final static <T> T pop(T[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		T head = arr[0];
		arr[0] = null;
		return head;
	}
	/**
	 * 数组入队操作（int）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static int[] enqueue(int[] arr,int element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		int[] newArr = new int[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（short）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static short[] enqueue(short[] arr,short element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		short[] newArr = new short[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（char）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static char[] enqueue(char[] arr,char element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		char[] newArr = new char[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（long）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static long[] enqueue(long[] arr,long element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		long[] newArr = new long[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（byte）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static byte[] enqueue(byte[] arr,byte element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		byte[] newArr = new byte[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（float）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static float[] enqueue(float[] arr,float element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		float[] newArr = new float[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（double）
	 * @param arr
	 * @param element
	 * @return
	 */
	public final static double[] enqueue(double[] arr,double element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		double[] newArr = new double[]{};
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组入队操作（T）
	 * @param arr
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] enqueue(T[] arr,T element){
		if(arr.length==0){
			arr = add(arr,element);
			return arr;
		}
		arr = remove(arr, arr.length-1);
		
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(),0);
		newArr = add(newArr,element);
		for(int x = 0;x<arr.length;x++){
			newArr = add(newArr,arr[x]);
		}
		return newArr;
	}
	/**
	 * 数组出队操作（int）
	 * @param arr
	 * @return
	 */
	public final static int dequeue(int[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		int last = arr[arr.length-1];
		int[] newArr = new int[]{};
		newArr = add(newArr,0);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（short）
	 * @param arr
	 * @return
	 */
	public final static short dequeue(short[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		short last = arr[arr.length-1];
		short[] newArr = new short[]{};
		newArr = add(newArr,(short)0);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（long）
	 * @param arr
	 * @return
	 */
	public final static long dequeue(long[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		long last = arr[arr.length-1];
		long[] newArr = new long[]{};
		newArr = add(newArr,0L);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（char）
	 * @param arr
	 * @return
	 */
	public final static char dequeue(char[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		char last = arr[arr.length-1];
		char[] newArr = new char[]{};
		newArr = add(newArr,(char)0);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（byte）
	 * @param arr
	 * @return
	 */
	public final static byte dequeue(byte[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		byte last = arr[arr.length-1];
		byte[] newArr = new byte[]{};
		newArr = add(newArr,(byte)0);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（float）
	 * @param arr
	 * @return
	 */
	public final static float dequeue(float[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		float last = arr[arr.length-1];
		float[] newArr = new float[]{};
		newArr = add(newArr,(short)0);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（double）
	 * @param arr
	 * @return
	 */
	public final static double dequeue(double[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		double last = arr[arr.length-1];
		double[] newArr = new double[]{};
		newArr = add(newArr,(double)0);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 数组出队操作（T）
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T dequeue(T[] arr){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		T last = arr[arr.length-1];
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		newArr = add(newArr,null);
		for(int x = 0;x<arr.length-1;x++){
			newArr = add(newArr,arr[x]);
		}
		copy(newArr, arr);
		return last;
	}
	/**
	 * 清除多余的元素（int）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static int[] clearZero(int[] arr,boolean clearAll ){
		int[] newArr = new int[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 清除多余的元素（short）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static short[] clearZero(short[] arr,boolean clearAll ){
		short[] newArr = new short[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 清除多余的元素（char）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static char[] clearZero(char[] arr,boolean clearAll ){
		char[] newArr = new char[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 清除多余的元素（long）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static long[] clearZero(long[] arr,boolean clearAll ){
		long[] newArr = new long[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 清除多余的元素（byte）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static byte[] clearZero(byte[] arr,boolean clearAll ){
		byte[] newArr = new byte[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 清除多余的元素（float）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static float[] clearZero(float[] arr,boolean clearAll ){
		float[] newArr = new float[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 清除多余的元素（double）
	 * @param arr
	 * @param clearAll
	 * @return
	 */
	public final static double[] clearZero(double[] arr,boolean clearAll ){
		double[] newArr = new double[]{};
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != 0)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有0元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边0元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=0)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	@SuppressWarnings("unchecked")
	public final static <T> T[] clearNull(T[] arr,boolean clearAll){
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		
		if(clearAll){
			for(int x = 0;x<arr.length;x++){
				if(arr[x] != null)
					newArr = add(newArr,arr[x]);
			}
			return newArr;
		}else{
			int[] leftIndexs = new int[]{};
			//找出左边null元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=null)
					break;
				leftIndexs = add(leftIndexs,x);
			}
			//真正清除左边的所有null元素
			arr = remove(arr,leftIndexs);
			reverse(arr);
			int[] rightIndexs = {};
			//找出左边null元素的所有索引
			for(int x = 0;x<arr.length;x++){
				if(arr[x]!=null)
					break;
				rightIndexs = add(rightIndexs,x);
			}
			arr = remove(arr,rightIndexs);
			reverse(arr);
		}
		return arr;
		
	}
	/**
	 * 更新数组（int）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(int[] arr,int index,int value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（short）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(short[] arr,int index,short value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（long）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(long[] arr,int index,long value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（byte）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(byte[] arr,int index,byte value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（char）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(char[] arr,int index,char value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（float）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(float[] arr,int index,float value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（double）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static void set(double[] arr,int index,double value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 更新数组（T）
	 * @param arr
	 * @param index
	 * @param value
	 */
	public final static <T> void set(T[] arr,int index,T value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		arr[index] = value;
	}
	/**
	 * 填充数组（int）
	 * @param arr
	 * @param value
	 */
	public final static void fill(int[] arr,int value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（short）
	 * @param arr
	 * @param value
	 */
	public final static void fill(short[] arr,short value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（long）
	 * @param arr
	 * @param value
	 */
	public final static void fill(long[] arr,long value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（char）
	 * @param arr
	 * @param value
	 */
	public final static void fill(char[] arr,char value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（byte）
	 * @param arr
	 * @param value
	 */
	public final static void fill(byte[] arr,byte value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（float）
	 * @param arr
	 * @param value
	 */
	public final static void fill(float[] arr,float value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（double）
	 * @param arr
	 * @param value
	 */
	public final static void fill(double[] arr,double value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 填充数组（T）
	 * @param arr
	 * @param value
	 */
	public final static <T> void fill(T[] arr,T value){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		for(int x=  0;x<arr.length;x++){
			arr[x] = value;
		}
	}
	/**
	 * 数组扩容（int）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static int[] spread(int[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,0);
			}
			return arr;
		}else{
			int[] newArr = new int[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,0);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（short）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static short[] spread(short[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,(short)0);
			}
			return arr;
		}else{
			short[] newArr = new short[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,(short)0);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（long）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static long[] spread(long[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,0L);
			}
			return arr;
		}else{
			long[] newArr = new long[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,0L);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（byte）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static byte[] spread(byte[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,(byte)0);
			}
			return arr;
		}else{
			byte[] newArr = new byte[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,(byte)0);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（char）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static char[] spread(char[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,(char)0);
			}
			return arr;
		}else{
			char[] newArr = new char[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,(char)0);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（float）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static float[] spread(float[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,0.0F);
			}
			return arr;
		}else{
			float[] newArr = new float[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,0.0f);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（double）
	 * @param arr
	 * @param length
	 * @return
	 */
	public final static double[] spread(double[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,0.0D);
			}
			return arr;
		}else{
			double[] newArr = new double[]{};
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,0.0D);
			}
			return newArr;
		}
	}
	/**
	 * 数组扩容（T）
	 * @param arr
	 * @param length
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] spread(T[] arr,int length){
		if(arr.length==0){
			for(int x = 0;x<length;x++){
				arr = add(arr,null);
			}
			return arr;
		}else{
			T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
			for(int x = 0;x<arr.length;x++){
				newArr = add(newArr,arr[x]);
			}
			for(int x = 0;x<length;x++){
				newArr = add(newArr,null);
			}
			return newArr;
		}
	}
	/**
	 * 数组合并（int）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static int[] merge(int[]... arrs){
		int length = 0;
		int[][] newArrs = new int[][]{};
		int[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（short）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static short[] merge(short[]... arrs){
		int length = 0;
		short[][] newArrs = new short[][]{};
		short[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（long）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static long[] merge(long[]... arrs){
		int length = 0;
		long[][] newArrs = new long[][]{};
		long[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（byte）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static byte[] merge(byte[]... arrs){
		int length = 0;
		byte[][] newArrs = new byte[][]{};
		byte[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（char）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static char[] merge(char[]... arrs){
		int length = 0;
		char[][] newArrs = new char[][]{};
		char[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（float）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static float[] merge(float[]... arrs){
		int length = 0;
		float[][] newArrs = new float[][]{};
		float[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（double）
	 * @return
	 */
	@SuppressWarnings("unused")
	public final static double[] merge(double[]... arrs){
		int length = 0;
		double[][] newArrs = new double[][]{};
		double[] newArr = {};
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 数组合并（T）
	 * @return
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public final static <T> T[] merge(T[]... arrs){
		int length = 0;
		T[][] newArrs = (T[][]) Array.newInstance(arrs.getClass().getComponentType(),0);
		T[] newArr = (T[]) Array.newInstance(arrs[0].getClass().getComponentType(),0);
		for(int x = 0;x<arrs.length;x++){
			if(arrs[x].length>0){
				newArrs = add(newArrs,arrs[x]);
				length += arrs[x].length;
			}
		}
		for(int x = 0;x<newArrs.length;x++){
			for(int y = 0;y<newArrs[x].length;y++){
				newArr = add(newArr,newArrs[x][y]);
			}
		}
		return newArr;
	}
	/**
	 * 使用自定义样式遍历数组（int）
	 * @param arr
	 * @return
	 */
	public final static String toString(int[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	
	/**
	 * 使用自定义样式遍历数组（short）
	 * @param arr
	 * @return
	 */
	public final static String toString(short[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 使用自定义样式遍历数组（long）
	 * @param arr
	 * @return
	 */
	public final static String toString(long[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 使用自定义样式遍历数组（byte）
	 * @param arr
	 * @return
	 */
	public final static String toString(byte[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 使用自定义样式遍历数组（char）
	 * @param arr
	 * @return
	 */
	public final static String toString(char[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 使用自定义样式遍历数组（float）
	 * @param arr
	 * @return
	 */
	public final static String toString(float[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 使用自定义样式遍历数组（double）
	 * @param arr
	 * @return
	 */
	public final static String toString(double[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 使用自定义样式遍历数组（T）
	 * @param arr
	 * @return
	 */
	public final static <T> String toString(T[] arr,String surroundStyle,String splitStyle,int countOfLine){
		StringBuffer sb = new StringBuffer();
		if(surroundStyle==null){
			if(splitStyle==null){
				sb.append("["+arr[0]+", ");
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+", ");
				}
			}else{
				sb.append("["+arr[0]+splitStyle);
				for(int x = 1;x<arr.length;x++){
					if(x==arr.length-1){
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+"]");
						break;
					}
					if(x%countOfLine==0)
						sb.append("\n");
					sb.append(arr[x]+splitStyle);
				}
			}
			
		}else{
			if(splitStyle==null){
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+", ");
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+", ");
					}
				}
			}else{
				if(surroundStyle.length()==1||surroundStyle.length()==0||surroundStyle.length()>2){
					sb.append(surroundStyle+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle);
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}else{
					sb.append(surroundStyle.substring(0, 1)+arr[0]+splitStyle);
					for(int x = 1;x<arr.length;x++){
						if(x==arr.length-1){
							if(x%countOfLine==0)
								sb.append("\n");
							sb.append(arr[x]+surroundStyle.substring(1));
							break;
						}
						if(x%countOfLine==0)
							sb.append("\n");
						sb.append(arr[x]+splitStyle);
					}
				}
			}
		}

		return sb.toString();
	}
	/**
	 * 转换int数组为Integer数组
	 * @param arr
	 * @return
	 */
	public final static Integer[] parse(int[] arr){
		Integer[] newArr = new Integer[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 转换short数组为Short数组
	 * @param arr
	 * @return
	 */
	public final static Short[] parse(short[] arr){
		Short[] newArr = new Short[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 转换long数组为Long数组
	 * @param arr
	 * @return
	 */
	public final static Long[] parse(long[] arr){
		Long[] newArr = new Long[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 转换char数组为Character数组
	 * @param arr
	 * @return
	 */
	public final static Character[] parse(char[] arr){
		Character[] newArr = new Character[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 转换byte数组为Byte数组
	 * @param arr
	 * @return
	 */
	public final static Byte[] parse(byte[] arr){
		Byte[] newArr = new Byte[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 转换float数组为Float数组
	 * @param arr
	 * @return
	 */
	public final static Float[] parse(float[] arr){
		Float [] newArr = new Float[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 转换double数组为Double数组
	 * @param arr
	 * @return
	 */
	public final static Double[] parse(double[] arr){
		Double[] newArr = new Double[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中的某一元素（int）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static int get(int[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（short）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static short get(short[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（long）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static long get(long[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（char）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static char get(char[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（byte）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static byte get(byte[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（float）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static float get(float[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（double）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static double get(double[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中的某一元素（T）
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static <T> T get(T[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		return arr[index];
	}
	/**
	 * 获取数组中某一范围的元素（int）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static int[] getAll(int[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		int[] newArr = new int[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（short）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static short[] getAll(short[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		short[] newArr = new short[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（long）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static long[] getAll(long[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		long[] newArr = new long[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（char）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static char[] getAll(char[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		char[] newArr = new char[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（byte）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static byte[] getAll(byte[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		byte[] newArr = new byte[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（float）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static float[] getAll(float[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		float[] newArr = new float[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（double）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	public final static double[] getAll(double[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		double[] newArr = new double[arr.length-index];
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（T）
	 * 从目标索引开始，截取到原数组中最后一个元素
	 * @param arr
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] getAll(T[] arr,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(index>=arr.length||index<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(),arr.length-index);
		for(int x = index;x<arr.length;x++){
			newArr[x-index] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（int）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static int[] getAll(int[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		int[] newArr = new int[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（short）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static short[] getAll(short[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		short[] newArr = new short[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（long）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static long[] getAll(long[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		long[] newArr = new long[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（byte）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static byte[] getAll(byte[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		byte[] newArr = new byte[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（char）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static char[] getAll(char[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		char[] newArr = new char[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（float）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static float[] getAll(float[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		float[] newArr = new float[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（double）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	public final static double[] getAll(double[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		double[] newArr = new double[endIndex-startIndex];
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 获取数组中某一范围的元素（T）
	 * 从原数组的开始索引，截取到原数组的结束索引（不包含结束索引）
	 * @param arr
	 * @param startIndex（开始索引）
	 * @param endIndex（结束索引）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] getAll(T[] arr,int startIndex,int endIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(startIndex>=arr.length||startIndex<0||endIndex>arr.length||endIndex<0)
			throw new RuntimeException("目标索引不在原数组范围内");
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), endIndex-startIndex);
		for(int x = startIndex;x<endIndex;x++){
			newArr[x-startIndex] = arr[x];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（int）
	 * @param arr
	 * @return
	 */
	public final static int[] upset(int[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		int[] newArr = new int[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（short）
	 * @param arr
	 * @return
	 */
	public final static short[] upset(short[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		short[] newArr = new short[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（long）
	 * @param arr
	 * @return
	 */
	public final static long[] upset(long[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		long[] newArr = new long[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（char）
	 * @param arr
	 * @return
	 */
	public final static char[] upset(char[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		char[] newArr = new char[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（byte）
	 * @param arr
	 * @return
	 */
	public final static byte[] upset(byte[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		byte[] newArr = new byte[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（float）
	 * @param arr
	 * @return
	 */
	public final static float[] upset(float[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		float[] newArr = new float[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（double）
	 * @param arr
	 * @return
	 */
	public final static double[] upset(double[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		double[] newArr = new double[arr.length];
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 打乱数组中的元素的顺序（T）
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] upset(T[] arr){
		int[] indexArr = {};
		while(true){
			indexArr = add(indexArr,new Random().nextInt(arr.length));
			indexArr = noRepeat(indexArr);
			if(indexArr.length==arr.length)
				break;
		}
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
		for(int x = 0;x<arr.length;x++){
			newArr[x] = arr[indexArr[x]];
		}
		return newArr;
	}
	/**
	 * 数组插入某个元素（int）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static int[] insert(int[] arr,int element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		int[] previous = new int[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		int[] newArr = null;
		if(arr.length==1){
			newArr = new int[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			int[] later = new int[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new int[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（short）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static short[] insert(short[] arr,short element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		short[] previous = new short[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		short[] newArr = null;
		if(arr.length==1){
			newArr = new short[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			short[] later = new short[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new short[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（long）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static long[] insert(long[] arr,long element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		long[] previous = new long[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		long[] newArr = null;
		if(arr.length==1){
			newArr = new long[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			long[] later = new long[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new long[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（char）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static char[] insert(char[] arr,char element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		char[] previous = new char[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		char[] newArr = null;
		if(arr.length==1){
			newArr = new char[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			char[] later = new char[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new char[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（byte）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static byte[] insert(byte[] arr,byte element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		byte[] previous = new byte[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		byte[] newArr = null;
		if(arr.length==1){
			newArr = new byte[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			byte[] later = new byte[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new byte[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（float）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static float[] insert(float[] arr,float element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		float[] previous = new float[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		float[] newArr = null;
		if(arr.length==1){
			newArr = new float[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			float[] later = new float[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new float[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（double）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	public final static double[] insert(double[] arr,double element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		double[] previous = new double[index+1];
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		double[] newArr = null;
		if(arr.length==1){
			newArr = new double[arr.length+1];
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			double[] later = new double[arr.length-previous.length];
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = new double[]{};
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组插入某个元素（T）
	 * @param arr
	 * @param element
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T[] insert(T[] arr,T element,int index){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		T[] previous = (T[]) Array.newInstance(arr.getClass().getComponentType(), index+1);
		for(int x  =0;x<previous.length;x++){
			previous[x] = arr[x];
		}
		T[] newArr = null;
		if(arr.length==1){
			newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(),arr.length+1);
			copy(previous, newArr);
			newArr[newArr.length-1] = element;
			return newArr;
		}else{
			T[] later = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length-previous.length);
			for(int x  = 0;x<later.length;x++){
				later[x] = arr[index+1+x];
			}
			newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
			newArr = addAll(newArr,previous);
			newArr = add(newArr,element);
			newArr = addAll(newArr,later);
			return newArr;
		}
			
	}
	/**
	 * 数组移动某个元素的位置（int）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(int[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		int element = arr[elementIndex];
		int[] newArr = new int[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（short）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(short[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		short element = arr[elementIndex];
		short[] newArr = new short[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（long）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(long[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		long element = arr[elementIndex];
		long[] newArr = new long[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（byte）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(byte[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		byte element = arr[elementIndex];
		byte[] newArr = new byte[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（char）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(char[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		char element = arr[elementIndex];
		char[] newArr = new char[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（float）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(float[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		float element = arr[elementIndex];
		float[] newArr = new float[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（double）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void move(double[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		double element = arr[elementIndex];
		double[] newArr = new double[arr.length];
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组移动某个元素的位置（T）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	@SuppressWarnings("unchecked")
	public final static <T> void move(T[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		T element = arr[elementIndex];
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
		copy(arr, newArr);
		newArr = remove(newArr, elementIndex);
		newArr = insert(newArr, element, targetIndex-1);
		copy(newArr, arr);

	}
	/**
	 * 数组元素两两交换位置（int）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(int[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		arr[elementIndex] = arr[elementIndex]^arr[targetIndex];
		arr[targetIndex] = arr[elementIndex]^arr[targetIndex];
		arr[elementIndex] = arr[elementIndex]^arr[targetIndex];
		
	}
	/**
	 * 数组元素两两交换位置（short）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(short[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		arr[elementIndex] = (short) (arr[elementIndex]^arr[targetIndex]);
		arr[targetIndex] = (short) (arr[elementIndex]^arr[targetIndex]);
		arr[elementIndex] = (short) (arr[elementIndex]^arr[targetIndex]);
		
	}
	/**
	 * 数组元素两两交换位置（long）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(long[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		arr[elementIndex] = (long)arr[elementIndex]^arr[targetIndex];
		arr[targetIndex] = (long)arr[elementIndex]^arr[targetIndex];
		arr[elementIndex] = (long)arr[elementIndex]^arr[targetIndex];
		
	}
	/**
	 * 数组元素两两交换位置（char）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(char[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		arr[elementIndex] = (char) (arr[elementIndex]^arr[targetIndex]);
		arr[targetIndex] = (char) (arr[elementIndex]^arr[targetIndex]);
		arr[elementIndex] = (char) (arr[elementIndex]^arr[targetIndex]);
		
	}
	/**
	 * 数组元素两两交换位置（byte）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(byte[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		arr[elementIndex] = (byte) (arr[elementIndex]^arr[targetIndex]);
		arr[targetIndex] = (byte) (arr[elementIndex]^arr[targetIndex]);
		arr[elementIndex] = (byte) (arr[elementIndex]^arr[targetIndex]);
		
	}
	/**
	 * 数组元素两两交换位置（float）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(float[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		float tmp = arr[targetIndex];
		arr[targetIndex] = arr[elementIndex];
		arr[elementIndex] = tmp;
		
	}
	/**
	 * 数组元素两两交换位置（double）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static void swap(double[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		double tmp = arr[targetIndex];
		arr[targetIndex] = arr[elementIndex];
		arr[elementIndex] = tmp;
		
	}
	/**
	 * 数组元素两两交换位置（T）
	 * @param arr
	 * @param elementIndex
	 * @param targetIndex
	 */
	public final static <T> void swap(T[] arr,int elementIndex,int targetIndex){
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(elementIndex==targetIndex)
			throw new RuntimeException("元素已被覆盖");
		T tmp = arr[targetIndex];
		arr[targetIndex] = arr[elementIndex];
		arr[elementIndex] = tmp;
		
	}
	/**
	 * 数组移动某一范围的元素的位置（int）
	 * 将[startIndex,endIndex)范围内的所有元素移动到targetIndex所在的元素的后面
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	/*
	
	*/
	/**
	 * 转换数组为Set集合（int）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Integer> toSet(int[] arr){
		Integer[] newArr = parse(arr);
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Integer>) set;
	}
	/**
	 * 转换数组为Set集合（short）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Short> toSet(short[] arr){
		Short[] newArr = parse(arr);
		Set<Short> set = new LinkedHashSet<Short>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Short>) set;
	}
	/**
	 * 转换数组为Set集合（long）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Long> toSet(long[] arr){
		Long[] newArr = parse(arr);
		Set<Long> set = new LinkedHashSet<Long>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Long>) set;
	}
	/**
	 * 转换数组为Set集合（char）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Character> toSet(char[] arr){
		Character[] newArr = parse(arr);
		Set<Character> set = new LinkedHashSet<Character>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Character>) set;
	}
	/**
	 * 转换数组为Set集合（byte）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Byte> toSet(byte[] arr){
		Byte[] newArr = parse(arr);
		Set<Byte> set = new LinkedHashSet<Byte>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Byte>) set;
	}
	/**
	 * 转换数组为Set集合（float）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Float> toSet(float[] arr){
		Float[] newArr = parse(arr);
		Set<Float> set = new LinkedHashSet<Float>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Float>) set;
	}
	/**
	 * 转换数组为Set集合（double）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<Double> toSet(double[] arr){
		Double[] newArr = parse(arr);
		Set<Double> set = new LinkedHashSet<Double>();
		for(int x = 0;x<newArr.length;x++){
			set.add(newArr[x]);
		}
		return (Set<Double>) set;
	}
	/**
	 * 转换数组为Set集合（T）
	 * @param arr
	 * @return
	 */
	public final static <T> Set<T> toSet(T[] arr){
		Set<T> set = new LinkedHashSet<T>();
		for(int x = 0;x<arr.length;x++){
			set.add(arr[x]);
		}
		return (Set<T>) set;
	}
	/**
	 * 转换数组为指定的Set集合（int）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Integer> toSet(int[] arr,String setType){
		Integer[] newArr = parse(arr);
		Set<Integer> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Integer>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Integer>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Integer>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Integer>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Integer>) set;
	}
	/**
	 * 转换数组为指定的Set集合（short）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Short> toSet(short[] arr,String setType){
		Short[] newArr = parse(arr);
		Set<Short> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Short>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Short>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Short>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Short>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Short>) set;
	}
	/**
	 * 转换数组为指定的Set集合（long）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Long> toSet(long[] arr,String setType){
		Long[] newArr = parse(arr);
		Set<Long> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Long>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Long>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Long>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Long>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Long>) set;
	}
	/**
	 * 转换数组为指定的Set集合（char）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Character> toSet(char[] arr,String setType){
		Character[] newArr = parse(arr);
		Set<Character> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Character>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Character>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Character>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Character>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Character>) set;
	}
	/**
	 * 转换数组为指定的Set集合（byte）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Byte> toSet(byte[] arr,String setType){
		Byte[] newArr = parse(arr);
		Set<Byte> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Byte>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Byte>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Byte>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Byte>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Byte>) set;
	}
	/**
	 * 转换数组为指定的Set集合（float）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Float> toSet(float[] arr,String setType){
		Float[] newArr = parse(arr);
		Set<Float> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Float>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Float>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Float>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Float>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Float>) set;
	}
	/**
	 * 转换数组为指定的Set集合（double）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<Double> toSet(double[] arr,String setType){
		Double[] newArr = parse(arr);
		Set<Double> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<Double>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<Double>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<Double>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<Double>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<newArr.length;x++) {
			set.add(newArr[x]);
		}
		return (Set<Double>) set;
	}
	/**
	 * 转换数组为指定的Set集合（T）
	 * @param arr
	 * @param setType
	 * @return
	 */
	public final static <T> Set<T> toSet(T[] arr,String setType){
		Set<T> set = null;
		if("hashset".equals(setType.trim().toLowerCase()))
			set = new HashSet<T>();
		else if("linkedhashset".equals(setType.trim().toLowerCase()))
			set = new LinkedHashSet<T>();
		else if("copyonwritearrayset".equals(setType.trim().toLowerCase()))
			set = new CopyOnWriteArraySet<T>();
		else if("concurrentskiplistset".equals(setType.trim().toLowerCase()))
			set = new ConcurrentSkipListSet<T>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			set.add(arr[x]);
		}
		return (Set<T>) set;
	}
	/**
	 * 转换数组为List集合（int）
	 * @param arr
	 * @return
	 */
	public final static List<Integer> toList(int[] arr){
		List<Integer> list = new ArrayList<Integer>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（short）
	 * @param arr
	 * @return
	 */
	public final static List<Short> toList(short[] arr){
		List<Short> list = new ArrayList<Short>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（long）
	 * @param arr
	 * @return
	 */
	public final static List<Long> toList(long[] arr){
		List<Long> list = new ArrayList<Long>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（char）
	 * @param arr
	 * @return
	 */
	public final static List<Character> toList(char[] arr){
		List<Character> list = new ArrayList<Character>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（byte）
	 * @param arr
	 * @return
	 */
	public final static List<Byte> toList(byte[] arr){
		List<Byte> list = new ArrayList<Byte>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（float）
	 * @param arr
	 * @return
	 */
	public final static List<Float> toList(float[] arr){
		List<Float> list = new ArrayList<Float>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（Double）
	 * @param arr
	 * @return
	 */
	public final static List<Double> toList(double[] arr){
		List<Double> list = new ArrayList<Double>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为List集合（T）
	 * @param arr
	 * @return
	 */
	public final static <T> List<T> toList(T[] arr){
		List<T> list = new ArrayList<T>();
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（int）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Integer> toList(int[] arr,String listType){
		List<Integer> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Integer>();
		else if("vector".equals(listType))
			list = new Vector<Integer>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Integer>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Integer>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Integer>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（short）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Short> toList(short[] arr,String listType){
		List<Short> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Short>();
		else if("vector".equals(listType))
			list = new Vector<Short>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Short>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Short>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Short>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（long）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Long> toList(long[] arr,String listType){
		List<Long> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Long>();
		else if("vector".equals(listType))
			list = new Vector<Long>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Long>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Long>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Long>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（char）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Character> toList(char[] arr,String listType){
		List<Character> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Character>();
		else if("vector".equals(listType))
			list = new Vector<Character>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Character>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Character>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Character>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（byte）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Byte> toList(byte[] arr,String listType){
		List<Byte> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Byte>();
		else if("vector".equals(listType))
			list = new Vector<Byte>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Byte>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Byte>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Byte>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（float）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Float> toList(float[] arr,String listType){
		List<Float> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Float>();
		else if("vector".equals(listType))
			list = new Vector<Float>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Float>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Float>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Float>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（double）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static List<Double> toList(double[] arr,String listType){
		List<Double> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<Double>();
		else if("vector".equals(listType))
			list = new Vector<Double>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<Double>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<Double>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<Double>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为指定的List集合（T）
	 * @param arr
	 * @param listType
	 * @return
	 */
	public final static <T> List<T> toList(T[] arr,String listType){
		List<T> list = null;
		if("arraylist".equals(listType.trim().toLowerCase()))
			list = new ArrayList<T>();
		else if("vector".equals(listType))
			list = new Vector<T>();
		else if("copyonwritearraylist".equals(listType.trim().toLowerCase()))
			list = new CopyOnWriteArrayList<T>();
		else if("linkedlist".equals(listType.trim().toLowerCase()))
			list = new LinkedList<T>();
		else if("stack".equals(listType.trim().toLowerCase()))
			list = new Stack<T>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			list.add(arr[x]);
		}
		return list;
	}
	/**
	 * 转换数组为Map集合（int）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Integer> toMap(int[] arr){
		Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（short）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Short> toMap(short[] arr){
		Map<Integer,Short> map = new LinkedHashMap<Integer,Short>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（long）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Long> toMap(long[] arr){
		Map<Integer,Long> map = new LinkedHashMap<Integer,Long>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（char）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Character> toMap(char[] arr){
		Map<Integer,Character> map = new LinkedHashMap<Integer,Character>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（byte）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Byte> toMap(byte[] arr){
		Map<Integer,Byte> map = new LinkedHashMap<Integer,Byte>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（float）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Float> toMap(float[] arr){
		Map<Integer,Float> map = new LinkedHashMap<Integer,Float>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（double）
	 * @param arr
	 * @return
	 */
	public final static Map<Integer,Double> toMap(double[] arr){
		Map<Integer,Double> map = new LinkedHashMap<Integer,Double>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为Map集合（T）
	 * @param arr
	 * @return
	 */
	public final static <T> Map<Integer,T> toMap(T[] arr){
		Map<Integer,T> map = new LinkedHashMap<Integer,T>();
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（int）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Integer> toMap(int[] arr,String mapType){
		Map<Integer,Integer> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Integer>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Integer>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Integer>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Integer>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Integer>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（short）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Short> toMap(short[] arr,String mapType){
		Map<Integer,Short> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Short>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Short>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Short>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Short>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Short>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（long）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Long> toMap(long[] arr,String mapType){
		Map<Integer,Long> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Long>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Long>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Long>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Long>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Long>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（char）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Character> toMap(char[] arr,String mapType){
		Map<Integer,Character> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Character>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Character>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Character>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Character>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Character>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（byte）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Byte> toMap(byte[] arr,String mapType){
		Map<Integer,Byte> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Byte>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Byte>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Byte>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Byte>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Byte>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（float）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Float> toMap(float[] arr,String mapType){
		Map<Integer,Float> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Float>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Float>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Float>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Float>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Float>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（Double）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static Map<Integer,Double> toMap(double[] arr,String mapType){
		Map<Integer,Double> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,Double>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,Double>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,Double>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,Double>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,Double>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 转换数组为指定的Map集合（T）
	 * @param arr
	 * @param mapType
	 * @return
	 */
	public final static <T> Map<Integer,T> toMap(T[] arr,String mapType){
		Map<Integer,T> map = null;
		if("hashmap".equals(mapType.trim().toLowerCase()))
			map = new HashMap<Integer,T>();
		else if("linkedhashmap".equals(mapType.trim().toLowerCase()))
			map = new LinkedHashMap<Integer,T>();
		else if("identityhashmap".equals(mapType.trim().toLowerCase()))
			map = new IdentityHashMap<Integer,T>();
		else if("treemap".equals(mapType.trim().toLowerCase()))
			map = new TreeMap<Integer,T>();
		else if("weakhashmap".equals(mapType.trim().toLowerCase()))
			map = new WeakHashMap<Integer,T>();
		else
			throw new RuntimeException("不被支持的集合类型");
		for(int x = 0;x<arr.length;x++) {
			map.put(x, arr[x]);
		}
		return map;
	}
	/**
	 * 遍历数组并以字符串的形式返回（short）
	 * @param arr
	 * @return
	 */
	public final static String toString(short[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 遍历数组并以字符串的形式返回（char）
	 * @param arr
	 * @return
	 */
	public final static String toString(char[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 遍历数组并以字符串的形式返回（long）
	 * @param arr
	 * @return
	 */
	public final static String toString(long[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 遍历数组并以字符串的形式返回（byte）
	 * @param arr
	 * @return
	 */
	public final static String toString(byte[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 遍历数组并以字符串的形式返回（float）
	 * @param arr
	 * @return
	 */
	public final static String toString(float[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 遍历数组并以字符串的形式返回（double）
	 * @param arr
	 * @return
	 */
	public final static String toString(double[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 遍历数组并以字符串的形式返回（T）
	 * @param arr
	 * @return
	 */
	public final static <T> String toString(T[] arr) {
		return Arrays.toString(arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（int）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(int[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		int[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（short）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(short[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		short[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（long）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(long[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		long[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（char）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(char[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		char[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（byte）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(byte[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		byte[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（float）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(float[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		float[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（double）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	public final static void moveAll(double[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		double[] newArr = {};
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 数组移动某一范围的元素到一个指定位置（T）
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @param targetIndex
	 */
	@SuppressWarnings("unchecked")
	public final static <T> void moveAll(T[] arr,int startIndex,int endIndex,int targetIndex) {
		if(arr.length==0)
			throw new RuntimeException("数组的长度为0");
		if(arr.length==1)
			throw new RuntimeException("数组的长度为1");
		if(targetIndex==startIndex-1)
			throw new RuntimeException("元素被覆盖");
		if(targetIndex>=startIndex&&targetIndex<=endIndex-1)
			throw new RuntimeException("元素被覆盖");
		T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), 0);
		if(targetIndex<startIndex) {
			for(int x = 0;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}else if(targetIndex>=endIndex) {
			for(int x = 0;x<startIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = endIndex;x<targetIndex;x++)
				newArr = add(newArr,arr[x]);
			newArr = add(newArr,arr[targetIndex]);
			for(int x = startIndex;x<endIndex;x++)
				newArr = add(newArr,arr[x]);
			for(int x = targetIndex+1;x<arr.length;x++)
				newArr = add(newArr,arr[x]);
		}
		copy(newArr,arr);
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（int）
	 * @param arr
	 * @return
	 */
	public final static int max(int... arr){
		int max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（short）
	 * @param arr
	 * @return
	 */
	public final static short max(short... arr){
		short max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（char）
	 * @param arr
	 * @return
	 */
	public final static char max(char... arr){
		char max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（long）
	 * @param arr
	 * @return
	 */
	public final static long max(long... arr){
		long max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（byte）
	 * @param arr
	 * @return
	 */
	public final static byte max(byte... arr){
		byte max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（float）
	 * @param arr
	 * @return
	 */
	public final static float max(float... arr){
		float max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最大值（double）
	 * @param arr
	 * @return
	 */
	public final static double max(double... arr){
		double max = arr[0];
		for(int x  = 0;x<arr.length;x++){
			if(arr[x]>max)
				max = arr[x];
		}
		return max;
	}
	/**
	 * 获取一组数或一个数组中的数字的最小值（int）
	 * @param arr
	 * @return
	 */
	public final static int min(int... arr){
		int min = arr[0];
		for(int x = 0;x<arr.length;x++){
			if(arr[x]<min)
				min = arr[x];
		}
		return min;
	}
	/**
	 * 获取一组数或一个数组中的数字的最小值（short）
	 * @param arr
	 * @return
	 */
	public final static short min(short... arr){
		short min = arr[0];
		for(int x = 0;x<arr.length;x++){
			if(arr[x]<min)
				min = arr[x];
		}
		
		return min;
	}
	
}
