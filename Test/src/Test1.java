import java.util.Arrays;

interface ILoger{
	void log();
}



public class Test1 {

	public static void main(String[] args) {
		ILoger[] loggers = new ILoger[2];  
		
		//loggers[0] = new ClassA();
		//loggers[1] = new ClassB();
	
		for(ILoger logger : loggers)
			logger.log();

	}

}
