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
                // Створення кульок
                Ball redBall = new Ball(canvas, Color.RED);
                canvas.add(redBall);
                BallThread redBallThread = new BallThread(redBall, canvas);

                Ball blueBall = new Ball(canvas, Color.BLUE);
                canvas.add(blueBall);
                BallThread blueBallThread = new BallThread(blueBall, canvas);

                // Запуск потоків
                redBallThread.start();
                blueBallThread.start();
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
}
