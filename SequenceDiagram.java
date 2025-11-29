import javax.swing.*;
import java.awt.*;

public class SequenceDiagram extends JPanel {

    private String[] participants = {"Client", "System", "Payment Gateway", "Venue Admin", "Contractors", "Manager"};
    private int margin = 100; // верхний отступ
    private int spacing = 120; // расстояние между участниками

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setFont(new Font("Arial", Font.PLAIN, 12));

        // Рисуем участников и их линии жизни
        for (int i = 0; i < participants.length; i++) {
            int y = margin + i * spacing;
            g2.drawLine(200, y, getWidth() - 50, y); // линия жизни
            g2.drawString(participants[i], 20, y + 5); // имя участника
        }

        // Рисуем сообщения стрелками
        drawArrow(g2, 0, 1, 250, "Check venue availability");
        drawArrow(g2, 1, 0, 300, "Provide cost and conditions");
        drawArrow(g2, 0, 1, 350, "Confirm booking");
        drawArrow(g2, 1, 2, 400, "Request prepayment");
        drawArrow(g2, 2, 1, 450, "Payment success / failure");
        drawArrow(g2, 1, 3, 500, "Notify admin tasks");
        drawArrow(g2, 3, 4, 550, "Assign tasks");
        drawArrow(g2, 4, 3, 600, "Confirm task completion");
        drawArrow(g2, 1, 5, 650, "Send report to Manager");
    }

    private void drawArrow(Graphics2D g2, int from, int to, int x, String text) {
        int y1 = margin + from * spacing;
        int y2 = margin + to * spacing;
        int arrowSize = 10;

        g2.drawLine(x, y1, x, y2);
        if (y1 != y2) {
            int dir = y2 > y1 ? -1 : 1;
            g2.drawLine(x, y2, x - arrowSize, y2 + dir * arrowSize);
            g2.drawLine(x, y2, x + arrowSize, y2 + dir * arrowSize);
        }
        g2.drawString(text, x + 5, Math.min(y1, y2) + Math.abs(y2 - y1)/2 - 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sequence Diagram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.add(new SequenceDiagram());
        frame.setVisible(true);
    }
}
