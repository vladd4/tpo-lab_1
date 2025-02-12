import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class BounceFrame extends JFrame {
    private BallCanvas canvas;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 450;
    private ArrayList<BallThread> ballThreads = new ArrayList<>();
    private JLabel statusLabel;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce Program");
        this.canvas = new BallCanvas();

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        statusLabel = new JLabel("Status: Ready");
        buttonPanel.add(statusLabel);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(e -> {
            buttonStart.setEnabled(false);
            canvas.clear();
            ballThreads.clear();

            new Thread(() -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        final int ballNumber = i + 1;
                        SwingUtilities.invokeLater(() ->
                                statusLabel.setText("Spawning ball " + ballNumber)
                        );

                        Ball ball = new Ball(canvas, getBallColor(i));
                        canvas.add(ball);
                        BallThread ballThread = new BallThread(ball);
                        ballThreads.add(ballThread);

                        ballThread.start();

                        ballThread.join();

                        SwingUtilities.invokeLater(() ->
                                statusLabel.setText("Ball " + ballNumber + " finished!")
                        );

                        System.out.println("Ball " + ballNumber + " finished.");
                    }

                    SwingUtilities.invokeLater(() -> {
                        statusLabel.setText("All balls finished!");
                        buttonStart.setEnabled(true);
                    });

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    private Color getBallColor(int index) {
        switch (index) {
            case 0: return Color.RED;
            case 1: return Color.BLUE;
            case 2: return Color.GREEN;
            case 3: return Color.YELLOW;
            case 4: return Color.PINK;
            default: return Color.BLACK;
        }
    }
}
