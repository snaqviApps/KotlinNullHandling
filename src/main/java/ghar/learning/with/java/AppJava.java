package ghar.learning.with.java;

public class AppJava {
    boolean closeMeeting(Meeting meeting){
        if(meeting.canClose) return meeting.close();
        return false;
    }

    public static void main(String... args){
        System.out.println("Java-main");
        AppJava appJava = new AppJava();
        appJava.closeMeeting(null);
    }

}

class Meeting {
    public boolean canClose;
    public boolean close() {
        return false;
    }
}
