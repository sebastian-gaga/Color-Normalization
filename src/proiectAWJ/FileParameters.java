package proiectAWJ;

//Al 3-lea nivel de ierarhizare prin mostenire
public class FileParameters extends ImplementedInput{

	//Incapsularea variabilelor
		private int width;
		private int height;
		
		public int getWidth() {
			return this.width;
		}
		
		public void setWidth(int width) {
			this.width = width;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public int getHeight() {
			return this.height;
		}
		
		//Abstractizare prin override a metodei
		@Override
		public void getPathFromUser() {
			System.out.println("Introduceti path-ul catre fisier: ");
		}
		
		
}
