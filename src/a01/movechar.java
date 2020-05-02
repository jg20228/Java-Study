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

	// 회전
	private GraphicsConfiguration gc = getDefaultConfiguration();
	private BufferedImage result;
	Graphics2D g;
	// 회전 축
	private final int rotateAxisX = 100;
	private final int rotateAxisY = 100;
	// 회전 된 캐릭터를 그릴 새로운 BufferedImage 가로, 세로 (원본 캐릭터 이미지 파일의 가로,세로 보다 훨씬 커야함)
	// 이 값을 ratio로 나눈 값이 rotatedCharacter의 가로, 세로 길이가 될 것임
	private final int newBuffImageW = 600;
	private final int newBuffImageH = 600;

	// 캐릭터 이동
	boolean rightPressed = false, leftPressed = false, upPressed = false, downPressed = false;

	private ImageIcon setImg = new ImageIcon("img/heroU.jpg");

	public movechar() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("이동 테스트");
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

	// 회전
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
