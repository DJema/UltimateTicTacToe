import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class View {

	private final JPanel gui = new JPanel(new BorderLayout(1, 1));
	private JButton[][] gameBoardSquares = new JButton[9][9];
	private JPanel gameBoard;
	private static Panel[][] panels = new Panel[9][9];

	View() {
		initializeGui();
	}

	public final void initializeGui() {
		// set up the main GUI
		gui.setBorder(new EmptyBorder(0, 0, 0, 0));

		gameBoard = new JPanel(new GridLayout(0, 9));
		gameBoard.setBorder(new LineBorder(Color.BLACK));
		gui.add(gameBoard);

		// create the chess board squares
		Insets buttonMargin = new Insets(0, 0, 0, 0);
		for (int ii = 0; ii < 9; ii++) {
			for (int jj = 0; jj < 9; jj++) {
				JButton b = new JButton();
				b.setMargin(buttonMargin);
				// our chess pieces are 64x64 px in size, so we'll
				// 'fill this in' using a transparent icon..
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64,
						BufferedImage.TYPE_INT_ARGB));
				b.setIcon(icon);

				gameBoardSquares[jj][ii] = b;
			}
		}
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoardSquares[i][j].setBackground(Color.lightGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 0, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				gameBoardSquares[i][j].setBackground(Color.darkGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 1, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				gameBoardSquares[i][j].setBackground(Color.lightGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 2, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;

		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoardSquares[i][j].setBackground(Color.darkGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 3, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				gameBoardSquares[i][j].setBackground(Color.lightGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 4, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		for (int i = 3; i < 6; i++) {
			counter = 0;
			for (int j = 6; j < 9; j++) {
				gameBoardSquares[i][j].setBackground(Color.darkGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 5, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;

		for (int i = 6; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoardSquares[i][j].setBackground(Color.lightGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 6, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;
		for (int i = 6; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				gameBoardSquares[i][j].setBackground(Color.darkGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 7, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;
		for (int i = 6; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				gameBoardSquares[i][j].setBackground(Color.lightGray);
				Panel p = new Panel(gameBoardSquares[i][j], i, j, 8, counter);
				panels[i][j] = p;
				counter++;
			}
		}
		counter = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				gameBoard.add(gameBoardSquares[i][j]);
			}
		}

		// Define Buttons

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JButton b = gameBoardSquares[i][j];
				Panel p = panels[i][j];
				gameBoardSquares[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Components.position == -1) {
							Components.position = p.getBoardNumber();
						}

						if (Components.board[p.getXPos()][p.getYPos()] == ' '
								&& p.getBoardNumber() == Components.position
								&& Components.completedQuadrants[p
										.getBoardNumber()] == ' ') {
							// Set icon

							b.setEnabled(false);
							if (Components.turn == 'X') {
								try {
									Image img = ImageIO.read(getClass()
											.getResource("x.png"));
									b.setIcon(new ImageIcon(img));
								} catch (Exception ex) {
									System.out.println(ex);
								}
							} else {
								try {
									Image img = ImageIO.read(getClass()
											.getResource("o.png"));
									b.setIcon(new ImageIcon(img));
								} catch (Exception ex) {
									System.out.println(ex);
								}
							}
							b.setDisabledIcon(b.getIcon());
							Component[] components = gameBoard.getComponents();
							gameBoard.removeAll();
							for (int z = 0; z < components.length; z++) {
								gameBoard.add(components[z]);
							}

							// Game logic

							Components.board[p.getBoardNumber()][p
									.getNextPosition()] = Components.turn;

							if (Components.didXWin(Components.board[p
									.getBoardNumber()])) {
								Components.completedQuadrants[p
										.getBoardNumber()] = Components.turn;
							}
							if (Components.didOWin(Components.board[p
									.getBoardNumber()])) {
								Components.completedQuadrants[p
										.getBoardNumber()] = Components.turn;
							}

							if (Components
									.didXWin(Components.completedQuadrants)) {
								System.out.println("Game Over");
							}
							if (Components
									.didOWin(Components.completedQuadrants)) {
								System.out.println("Game Over");
							}

							Components.turn = Components
									.setTurn(Components.turn);
							Components.position = p.getNextPosition();
						}
					}
				});
			}
		}

	}

	public final JComponent getChessBoard() {
		return gameBoard;
	}

	public final JComponent getGui() {
		return gui;
	}

	public static Panel[][] getPanels() {
		return panels;
	}

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				View cb = new View();
				Components c = new Components();
				JFrame f = new JFrame("Ultimate Tic Tac Toe");
				f.add(cb.getGui());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocationByPlatform(true);

				// ensures the frame is the minimum size it needs to be
				// in order display the components within it
				f.pack();
				// ensures the minimum size is enforced.
				f.setMinimumSize(f.getSize());
				f.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}