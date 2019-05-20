package com.dmfa.picoplaca.enums;


/**
 * @author dfuentes
 * 
 * Enum that contain the restriction days and the numbers with restriction 
 *
 */
public enum RestrictionDaysEnum {

		SUNDAY(1, null),
		MONDAY(2, new int[] {1,2}),
		TUESDAY(3, new int[] {3,4}),
		WEDNESDAY(4, new int[] {5,6}),
		THURSDAY(5, new int[] {7,8}),
		FRIDAY(6, new int[] {9,0}),
		SATURDAY(7, null);
		
		private int day;
		private int[] numbers;
		
		/**
		 * Constructor
		 * @param day of week
		 * @param numbers with restriction
		 */
		private RestrictionDaysEnum(int day, int[] numbers) {
			this.day=day;
			this.numbers=numbers;
		}

		/**
		 * @return the day of week
		 */
		public int getDay() {
			return day;
		}

		
		/**
		 * @return the numbers with restriction
		 */
		public int[] getNumbers() {
			return numbers;
		}
		
		
		public static RestrictionDaysEnum findDay(int day) {
			for (RestrictionDaysEnum rde : RestrictionDaysEnum.values()) {
				if(rde.getDay() == day) {
					return rde;
				}
			}
			return null;
		}
}
