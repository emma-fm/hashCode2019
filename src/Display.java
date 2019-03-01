import java.io.IOException;
import java.util.Formatter;

public class Display {
	
	

	public static void saveFile(Slide[] slide) {
		Formatter file;
		try {
			
			file = new Formatter("output.txt");
			
			file.format("%s", slide.length + "\n");
			
			for(int i = 0; i < slide.length;i++) {
				file.format("%s", slide[i].id + "\n");
			}
			
			file.close();
			
		}catch(IOException e) {
			System.out.print("Error: " + e);
		}
		
	}
	
}
