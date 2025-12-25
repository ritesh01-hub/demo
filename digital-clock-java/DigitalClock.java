import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;

public class DigitalClock extends JFrame {

    JLabel l1, l2;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;

    DigitalClock(String title) {
        super(title);
        setComponent();
        setTime();
    }

    void setComponent() {
        l1 = new JLabel();
        l2 = new JLabel();

        Font f = new Font("Verdana", Font.BOLD, 40);
        Color glow = Color.RED.brighter();

        l1.setFont(f);
        l1.setForeground(glow);
        l1.setBackground(Color.BLACK);
        l1.setOpaque(true);

        l2.setFont(new Font("Verdana", Font.BOLD, 25));
        l2.setForeground(glow);
        l2.setBackground(Color.BLACK);
        l2.setOpaque(true);

        setLayout(null);
        add(l1);
        add(l2);

        l1.setBounds(40, 40, 350, 80);
        l2.setBounds(60, 140, 350, 60);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dateFormat = new SimpleDateFormat("EEE dd-MM-yyyy");
    }

    void setTime() {
        Timer t = new Timer(1000, e -> {
            String time = timeFormat.format(Calendar.getInstance().getTime());
            String date = dateFormat.format(Calendar.getInstance().getTime());

            l1.setText(time);
            l2.setText(date);
        });
        t.start();
    }

    public static void main(String[] args) {
        DigitalClock d = new DigitalClock("Digital Clock");
        d.setSize(450, 280);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
