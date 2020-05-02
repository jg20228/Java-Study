package a01;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class movechar extends JFrame implements Runnable {
	Player player;
	JLabel playerImg;
	JFrame frame;

	// ȸ��
	private GraphicsConfiguration gc = getDefaultConfiguration();
	private BufferedImage result;
	Graphics2D g;
	// ȸ�� ��
	private final int rotateAxisX = 100;
	private final int rotateAxisY = 100;
	// ȸ�� �� ĳ���͸� �׸� ���ο� BufferedImage ����, ���� (���� ĳ���� �̹��� ������ ����,���� ���� �ξ� Ŀ����)
	// �� ���� ratio�� ���� ���� rotatedCharacter�� ����, ���� ���̰� �� ����
	private final int newBuffImageW = 600;
	private final int newBuffImageH = 600;

	// ĳ���� �̵�
	boolean rightPressed = false, leftPressed = false, upPressed = false, downPressed = false;

	private ImageIcon setImg = new ImageIcon("img/heroU.jpg");

	public movechar() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("�̵� �׽�Ʈ");
		frame.setSize(500, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player = new Player(100, 100, 100.0, 10, 10, 1);
		playerImg = new JLabel(setImg);
		playerImg.setSize(100, 100);
		playerImg.setLocation(100, 100);
		frame.add(playerImg);

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					upPressed = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					rightPressed = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					leftPressed = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					downPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					upPressed = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					rightPressed = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					leftPressed = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					downPressed = false;
				}
			}
		});

		frame.setVisible(true);
	}

	// ȸ��
	private BufferedImage rotate(BufferedImage image, double angle) {
		result = gc.createCompatibleImage(newBuffImageW, newBuffImageH, Transparency.TRANSLUCENT);
		g = result.createGraphics();

		g.translate((newBuffImageW - image.getWidth()) / 2, (newBuffImageH - image.getHeight()) / 2);
		g.rotate(angle, rotateAxisX, rotateAxisY);

		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	private GraphicsConfiguration getDefaultConfiguration() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}

	public static void main(String[] args) {
		new movechar();
	}

	@Override
	public void run() {
		if (rightPressed) {
			player.setPlayerX(player.getPlayerX() + player.getMoveSpeed());
		}
		if (leftPressed) {
			player.setPlayerX(player.getPlayerX() - player.getMoveSpeed());
		}
		if (upPressed) {
			player.setPlayerY(player.getPlayerY() - player.getMoveSpeed());
		}
		if (downPressed) {
			player.setPlayerY(player.getPlayerY() + player.getMoveSpeed());
		}
		playerImg.setLocation(player.getPlayerX(), player.getPlayerY());
	}
}
