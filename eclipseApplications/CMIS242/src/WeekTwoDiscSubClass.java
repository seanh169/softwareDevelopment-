class WeekTwoDiscSubClass extends WeekTwoDisc {
		
		
		private int anotherNum = 20;
		
		
		
		public int getAnotherNum() {
			return anotherNum;
		}

		public void setAnotherNum(int anotherNum) {
			this.anotherNum = anotherNum;
		}

		public WeekTwoDiscSubClass(int num, int anotherNum) {
			
			super(num); 
			this.anotherNum = anotherNum;
		}
		
		@Override
		public String weekTwoDiscToString() {
			
			return "Private Instance Variable num: " + this.getNum() + " \nPrivate Second Instance Variable anotherNum: " + this.getAnotherNum();
			
			
		}
		
		
		
	}
