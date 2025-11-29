import javax.swing.*;
import java.awt.*;

public class HiringProcessDiagramModern extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Диаграмма деятельности: Найм сотрудников (Modern)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 900);
        frame.add(new HiringProcessDiagramModern());
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(2));
        g2.setFont(new Font("Arial", Font.BOLD, 14));

        int boxWidth = 200;
        int boxHeight = 50;
        int vGap = 100;
        int startX = 500;
        int startY = 30;

        drawGradientBox(g2, startX, startY, boxWidth, boxHeight, "Начало процесса", new Color(255, 200, 200), new Color(255, 100, 100));

        int y1 = startY + vGap;
        drawGradientBox(g2, startX, y1, boxWidth, boxHeight, "Руководитель создает заявку", new Color(200, 255, 200), new Color(100, 255, 100));
        drawCurvedArrow(g2, startX + boxWidth / 2, startY + boxHeight, startX + boxWidth / 2, y1);

        int y2 = y1 + vGap;
        drawGradientBox(g2, startX, y2, boxWidth, boxHeight, "HR проверяет заявку", new Color(200, 200, 255), new Color(100, 100, 255));
        drawCurvedArrow(g2, startX + boxWidth / 2, y1 + boxHeight, startX + boxWidth / 2, y2);

        int yBranch = y2 + vGap;
        drawGradientBox(g2, startX - 300, yBranch, boxWidth, boxHeight, "Заявка отклонена", new Color(255, 220, 180), new Color(255, 160, 50));
        drawGradientBox(g2, startX + 300, yBranch, boxWidth, boxHeight, "Заявка утверждена", new Color(180, 255, 255), new Color(50, 200, 255));

        drawCurvedArrow(g2, startX + boxWidth / 2, y2 + boxHeight, startX - 300 + boxWidth / 2, yBranch);
        drawCurvedArrow(g2, startX + boxWidth / 2, y2 + boxHeight, startX + 300 + boxWidth / 2, yBranch);

        int y3 = yBranch + vGap;
        drawGradientBox(g2, startX + 300, y3, boxWidth, boxHeight, "Вакансия публикуется\nКандидаты подают заявки", new Color(255, 255, 180), new Color(255, 255, 50));
        drawCurvedArrow(g2, startX + 300 + boxWidth / 2, yBranch + boxHeight, startX + 300 + boxWidth / 2, y3);

        int y4 = y3 + vGap;
        drawGradientBox(g2, startX + 300, y4, boxWidth, boxHeight, "HR проверяет анкеты\nОтбирает кандидатов", new Color(220, 180, 255), new Color(160, 50, 255));
        drawCurvedArrow(g2, startX + 300 + boxWidth / 2, y3 + boxHeight, startX + 300 + boxWidth / 2, y4);

        int y5 = y4 + vGap;
        drawGradientBox(g2, startX + 300, y5, boxWidth, boxHeight, "HR проводит первичное интервью", new Color(180, 255, 220), new Color(50, 255, 160));
        drawCurvedArrow(g2, startX + 300 + boxWidth / 2, y4 + boxHeight, startX + 300 + boxWidth / 2, y5);

        int y6 = y5 + vGap;
        drawGradientBox(g2, startX + 300, y6, boxWidth, boxHeight, "Руководитель проводит техническое собеседование", new Color(255, 180, 220), new Color(255, 50, 160));
        drawCurvedArrow(g2, startX + 300 + boxWidth / 2, y5 + boxHeight, startX + 300 + boxWidth / 2, y6);

        int y7 = y6 + vGap;
        drawGradientBox(g2, startX + 300 - 200, y7, boxWidth, boxHeight, "Собеседование неудачно\nКандидат уведомлен", new Color(255, 200, 200), new Color(255, 100, 100));
        drawGradientBox(g2, startX + 300 + 200, y7, boxWidth, boxHeight, "Оффер отправлен кандидату", new Color(200, 255, 200), new Color(100, 255, 100));

        drawCurvedArrow(g2, startX + 300 + boxWidth / 2, y6 + boxHeight, startX + 300 - 200 + boxWidth / 2, y7);
        drawCurvedArrow(g2, startX + 300 + boxWidth / 2, y6 + boxHeight, startX + 300 + 200 + boxWidth / 2, y7);

        int y8 = y7 + vGap;
        drawGradientBox(g2, startX + 300 + 200, y8, boxWidth, boxHeight, "Кандидат подтверждает оффер", new Color(180, 180, 255), new Color(50, 50, 255));
        drawCurvedArrow(g2, startX + 300 + 200 + boxWidth / 2, y7 + boxHeight, startX + 300 + 200 + boxWidth / 2, y8);

        int y9 = y8 + vGap;
        drawGradientBox(g2, startX + 300 + 200, y9, boxWidth, boxHeight, "Система добавляет сотрудника\nHR уведомляет IT", new Color(255, 220, 180), new Color(255, 160, 50));
        drawCurvedArrow(g2, startX + 300 + 200 + boxWidth / 2, y8 + boxHeight, startX + 300 + 200 + boxWidth / 2, y9);

        int yEnd = y9 + vGap;
        drawGradientBox(g2, startX + 300 + 200, yEnd, boxWidth, boxHeight, "Конец процесса", new Color(180, 255, 255), new Color(50, 255, 255));
        drawCurvedArrow(g2, startX + 300 + 200 + boxWidth / 2, y9 + boxHeight, startX + 300 + 200 + boxWidth / 2, yEnd);
    }

    private void drawGradientBox(Graphics2D g2, int x, int y, int width, int height, String text, Color c1, Color c2) {
        GradientPaint gp = new GradientPaint(x, y, c1, x + width, y + height, c2);
        g2.setPaint(gp);
        g2.fillRoundRect(x, y, width, height, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(x, y, width, height, 20, 20);
        drawCenteredString(g2, text, x, y, width, height);
    }

    private void drawCenteredString(Graphics2D g2, String text, int x, int y, int width, int height) {
        FontMetrics fm = g2.getFontMetrics();
        String[] lines = text.split("\n");
        int totalHeight = lines.length * fm.getHeight();
        int startY = y + (height - totalHeight) / 2 + fm.getAscent();
        for (String line : lines) {
            int textWidth = fm.stringWidth(line);
            int startX = x + (width - textWidth) / 2;
            g2.drawString(line, startX, startY);
            startY += fm.getHeight();
        }
    }

    private void drawCurvedArrow(Graphics2D g2, int x1, int y1, int x2, int y2) {
        g2.setColor(Color.BLACK);
        int ctrlX = (x1 + x2) / 2;
        g2.drawLine(x1, y1, x2, y2);
        int arrowSize = 8;
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - arrowSize, ym = 4;
        double xn = xm, yn = -4;
        double sin = dy / D, cos = dx / D;
        int xArrow1 = (int)(x2 - xm * cos + ym * sin);
        int yArrow1 = (int)(y2 - xm * sin - ym * cos);
        int xArrow2 = (int)(x2 - xn * cos + yn * sin);
        int yArrow2 = (int)(y2 - xn * sin - yn * cos);
        int[] xPoints = {x2, xArrow1, xArrow2};
        int[] yPoints = {y2, yArrow1, yArrow2};
        g2.fillPolygon(xPoints, yPoints, 3);
    }
}
