import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce Program");
        this.canvas = new BallCanvas();

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 1000; i++) {
                    Ball b = new Ball(canvas, Color.BLUE);
                    canvas.add(b);
                    BallThread thread = new BallThread(b, canvas);
                    thread.start();
                }

                Ball redBall = new Ball(canvas, Color.RED);
                canvas.add(redBall);
                BallThread redBallThread = new BallThread(redBall, canvas);
                redBallThread.start();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
