package com.Apriori_SP;

import java.util.Arrays;

public class Sequence {
	private String[] elements;// ���а�����Ԫ��
	private int length;// ���еĳ���
	private int count_sup; // ֧�ֶ�
	public Sequence(String[] e){
		super();
		elements = Arrays.copyOfRange(e, 0, e.length);
		length = e.length;
	}
	
	public String get(int i){
		return elements[i];
	}
	
	public String[] toArray(){
		return elements;
	}
	/**
	 * �ж�s�Ƿ��ǵ�ǰ���е�������
	 * @param s
	 * @return
	 */
	public boolean isContains(Sequence s){
		if(s.length > this.length){
			return false;
		}
		int i = 0;
		String[] sa = s.toArray();
		for(; i < this.length; i++){
			if(s.length >= this.length - i){
				return false;
			}
			if(elements[i].equals(s.get(0))) {
				if(s.length == 1){
					return true;
				}
				break;
			}
		}
		String[] newEle = Arrays.copyOfRange(elements, i + 1, this.length);
		String[] newS = Arrays.copyOfRange(sa, 1, sa.length);
		Sequence newThis = new Sequence(newEle);
		Sequence newSeq = new Sequence(newS);
		boolean j = newThis.isContains(newSeq);
		return j;
	}

	public int getCount_sup() {
		return count_sup;
	}

	public void setCount_sup(int count_sup) {
		this.count_sup = count_sup;
	}
}
