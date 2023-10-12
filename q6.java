import java.util.*;

// Interface for basic TV remote
interface TVRemote {
    void powerOn();

    void powerOff();

    void changeChannel(int channel);

    void volumeUp();

    void volumeDown();
}

// Interface for smart TV remote extending TVRemote
interface SmartTvRemote extends TVRemote {
    void openApp(String appName);

    void browseInternet();
}

// Example implementation of the SmartTvRemote interface
class MySmartTvRemote implements SmartTvRemote {
    int currentChannel = 1;
    int currentVolume = 10;

    @Override
    public void powerOn() {
        System.out.println("Smart TV is powered ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("Smart TV is powered OFF.");
    }

    @Override
    public void changeChannel(int channel) {
        this.currentChannel = channel;
        System.out.println("Channel changed to " + channel);
    }

    @Override
    public void volumeUp() {
        this.currentVolume++;
        System.out.println("Volume increased to " + currentVolume);
    }

    @Override
    public void volumeDown() {
        this.currentVolume--;
        System.out.println("Volume decreased to " + currentVolume);
    }

    @Override
    public void openApp(String appName) {
        System.out.println("Opening app: " + appName);
    }

    @Override
    public void browseInternet() {
        System.out.println("Browsing the internet on Smart TV.");
    }
}

public class q6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        // Using SmartTvRemote
        SmartTvRemote Remote = new MySmartTvRemote();
        Remote.powerOn();
        Remote.changeChannel(c);
        Remote.volumeUp();
        Remote.browseInternet();
        Remote.openApp("YouTube");
        Remote.volumeDown();
        Remote.powerOff();
        in.close();
    }
}
