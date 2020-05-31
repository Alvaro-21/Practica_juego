package Juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MiJuego extends JFrame {

	private JPanel contentPane;

	Link player;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiJuego frame = new MiJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MiJuego() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,541,300);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		player= new Link(panel,100,0,0);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Salud"+player.getSalud());
		
		JLabel lblNewLabel_1 = new JLabel("Escudo"+player.getEscudo());
		
		JLabel lblNewLabel_2 = new JLabel("Arma"+player.getArmas());
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				int x, y;
				String Direc = "src/juego/izquierda.png";
				x = player.Coordx();
				y = player.Coordy();
				System.out.println("x-->" + x + ",y-->" + y);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					x = x - 10;
					Direc = "src/juego/izquierda.png";
					break;
				case KeyEvent.VK_RIGHT:
					x = x + 10;
					Direc = "src/juego/derecha.png";
					break;
				case KeyEvent.VK_UP:
					y = y - 10;
					Direc = "src/juego/Arriba.png";
					break;
				case KeyEvent.VK_DOWN:
					y = y + 10;
					Direc = "src/juego/Abajo.png";
					break;

				}
				player.DibujarPersonaje(panel.getGraphics(), x, y, Direc);
			}
		});
		
	}
}
