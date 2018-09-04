package android;

//Java program to illustrate
//open cmd prompt

public class AccessCmd {

	public static void main(String[] args) {
		try
        {
            // Just one line and you are done ! 
            // We have given a command to start cmd
            // /K : Carries out command specified by string
           Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
           Runtime.getRuntime().exec(new String[] {"cmd", "/K", "exit"});
 
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }

	}

}
