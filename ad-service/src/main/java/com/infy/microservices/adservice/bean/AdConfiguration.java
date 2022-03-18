package com.infy.microservices.adservice.bean;

public class AdConfiguration {
	 
		private int maximum;  
		private int minimum;  
		
		protected AdConfiguration()
		{
		
		}
		

		public int getMaximum() {
			return maximum;
		}

		public void setMaximum(int maximum) {
			this.maximum = maximum;
		}

		public int getMinimum() {
			return minimum;
		}

		public void setMinimum(int minimum) {
			this.minimum = minimum;
		}


		public AdConfiguration(int maximum, int minimum) {
			super();
			this.maximum = maximum;
			this.minimum = minimum;
		}
}
		
		//no-argument constructor  
		/**protected AdConfiguration()  
		{  
		}  
		//generating getters  
		public int getMaximum()   
		{  
		return maximum;  
		}  
		public int getMinimum()   
		{  
		return minimum;  
		}  
		//constructor using fields  
		public AdConfiguration(int maximum, int minimum)   
		{  
		super();  
		this.maximum = maximum;  
		this.minimum = minimum;  
		}  **/
		


