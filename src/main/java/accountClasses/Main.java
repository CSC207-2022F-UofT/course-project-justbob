package accountClasses;

public class Main {

    public static void main(String[] args) {

        MyFrame f = new MyFrame();

        MyPanel panel = new MyPanel();
        panel.isFrontPage();

        f.add(panel);

    }
}
