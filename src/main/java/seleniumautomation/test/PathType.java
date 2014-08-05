package seleniumautomation.test;

public enum PathType {
	id{
		public String toString()
		{
			return "id";
		}
	}, 
	xpath{
			public String toString()
			{
				return "xpath";
			}
	}, 
	name{
		public String toString()
		{
			return "name";
		}
		
	}
	, 	
	css{
		public String toString()
		{
			return "css";
		}
	}

}// PathType
