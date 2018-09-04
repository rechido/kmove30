package android;

public class adbSize1080x1920 {

	public static void main(String[] args) {
		try
        { 
         // We are running "dir" and "ping" command on cmd
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"adb devices && adb shell wm size 1080x1920\"");
         Runtime.getRuntime().exec("wm size 1080x2160");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }

	}

}
