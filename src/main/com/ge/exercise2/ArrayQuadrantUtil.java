package com.ge.exercise2;

import java.lang.reflect.Array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil<T> {
	private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

	T[][] data;
	Class<?> classType;
	int rowSize;
	int columnSize;

	public ArrayQuadrantUtil(T[][] data) {
		this.data = data;
		if (data != null) {
			this.classType = data[0][0].getClass();
			this.rowSize = data.length;
			this.columnSize = data[0].length;
		}
	}

	@SuppressWarnings("unchecked")
	public T[] getQuadrantValues(int row, int column, int partitionSize) {
		if (data != null) {
			for (int i = 0; i < rowSize; i++) {
				for (int j = 0; j < columnSize; j++) {
					if (i == row && j == column) {
						T[] quadrantValues = (T[]) Array.newInstance(classType, partitionSize * partitionSize);
						int index = 0;
						for (int l = i; l < i + partitionSize; l++) {
							for (int m = j; m < j + partitionSize; m++) {
								quadrantValues[index++] = data[l][m];
							}
						}
						return quadrantValues;
					}
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public T[] getRowValues(int row) {
		if (data != null) {
			for (int i = 0; i < rowSize; i++) {
				if (i == row) {
					T[] quadrantValues = (T[]) Array.newInstance(classType, columnSize);
					for (int j = 0; j < columnSize; j++) {
						quadrantValues[j] = data[i][j];
					}
					return quadrantValues;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public T[] getColumnValues(int column) {
		if (data != null) {
			for (int i = 0; i < rowSize; i++) {
				for (int j = 0; j < columnSize; j++) {
					if (i == column) {
						T[] quadrantValues = (T[]) Array.newInstance(classType, rowSize);
						for (int k = 0; k < rowSize; k++) {
							quadrantValues[j] = data[k][j];
						}
						return quadrantValues;
					}
				}

			}
		}
		return null;
	}
}
