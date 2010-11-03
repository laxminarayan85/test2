package com.efi.printsmith.comparator;

import java.util.Comparator;

import com.efi.printsmith.data.MatrixElement;

public class MatrixElementComparator implements Comparator<MatrixElement>{

	public int compare(MatrixElement o1, MatrixElement o2) {
		if(o1==null || o2==null) {
			return 1;
		}
		if(o1.getQty()==null || o2.getQty()==null) {
			return 1;
		}
		try {
			if(o1.getQty()>o2.getQty()) {
				return 1;
			}
		} catch(Exception e) {
			return 1;
		}
		try {
			if(o1.getQty()<o2.getQty()) {
				return -1;
			}
		} catch(Exception e) {
			return 1;
		}
		return 0;
	}

};