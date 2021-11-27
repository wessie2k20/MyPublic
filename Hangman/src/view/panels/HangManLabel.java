package view.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class HangManLabel extends JLabel {

	private int hangCount;
	private Ellipse2D.Double heaD;
	private Line2D.Double body;
	private Line2D.Double lArm;
	private Line2D.Double rArm;
	private Line2D.Double lleg;
	private Line2D.Double rLeg;
	private Line2D.Double bottom;
	private Line2D.Double pole;
	private Line2D.Double pole2;
	private Line2D.Double rope;
	
	public int getHangCount() {
		return hangCount;
	}

	public void setHangCount(int hangCount) {
		this.hangCount = hangCount;
		this.repaint();
	}

	public Ellipse2D.Double getHeaD() {
		return heaD;
	}

	public void setHeaD(Ellipse2D.Double heaD) {
		this.heaD = heaD;
	}

	public Line2D.Double getBody() {
		return body;
	}

	public void setBody(Line2D.Double body) {
		this.body = body;
	}

	public Line2D.Double getlArm() {
		return lArm;
	}

	public void setlArm(Line2D.Double lArm) {
		this.lArm = lArm;
	}

	public Line2D.Double getrArm() {
		return rArm;
	}

	public void setrArm(Line2D.Double rArm) {
		this.rArm = rArm;
	}

	public Line2D.Double getLleg() {
		return lleg;
	}

	public void setLleg(Line2D.Double lleg) {
		this.lleg = lleg;
	}

	public Line2D.Double getrLeg() {
		return rLeg;
	}

	public void setrLeg(Line2D.Double rLeg) {
		this.rLeg = rLeg;
	}
	
	public Line2D.Double getBottom() {
		return bottom;
	}

	public void setBottom(Line2D.Double bottom) {
		this.bottom = bottom;
	}

	public Line2D.Double getPole() {
		return pole;
	}

	public void setPole(Line2D.Double pole) {
		this.pole = pole;
	}

	public Line2D.Double getPole2() {
		return pole2;
	}

	public void setPole2(Line2D.Double pole2) {
		this.pole2 = pole2;
	}

	public Line2D.Double getRope() {
		return rope;
	}

	public void setRope(Line2D.Double rope) {
		this.rope = rope;
	}

	public HangManLabel() {
		this.setBounds(800, 100, 200, 400);
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createBevelBorder(3));
		this.setOpaque(true);
		this.setHeaD(new Ellipse2D.Double(50, 105, 30, 30));
		this.setBody(new Line2D.Double(65, 135, 65, 180));
		this.setlArm(new Line2D.Double(65, 140, 45, 155));
		this.setrArm(new Line2D.Double(65, 140, 85, 155));
		this.setLleg(new Line2D.Double(65, 180, 45, 195));
		this.setrLeg(new Line2D.Double(65, 180, 85, 195));
		this.setBottom(new Line2D.Double(30, 380, 180, 380));
		this.setPole(new Line2D.Double(150, 380, 150, 50));
		this.setPole2(new Line2D.Double(150, 50, 60, 50));
		this.setRope(new Line2D.Double(65, 50, 65, 100));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.paintGalgen(g2d);
	}

	private void paintGalgen(Graphics2D g) {
		Path2D.Double line = new Path2D.Double();
		g.setColor(Color.black);
		// ------------------------------------
		for (int i = 0; i <= this.getHangCount(); i++) {
			if (i == 1) {
				g.setStroke(new BasicStroke(10));
				g.draw(this.getBottom());
			}
			if (i == 2) {
				g.draw(this.getPole());
			}
			if (i == 3) {
				g.draw(this.getPole2());
			}
			if (i == 4) {
				g.setStroke(new BasicStroke(5));
				g.draw(this.getRope());
			}
			if (i == 5) {
				g.draw(this.getHeaD());
			}
			if (i == 6) {
				g.draw(this.getBody());
			}
			if (i == 7) {
				g.draw(this.getlArm());
			}
			if (i == 8) {
				g.draw(this.getrArm());
			}
			if (i == 9) {
				g.draw(this.getLleg());
			}
			if (i == 10) {
				g.draw(this.getrLeg());
			}

		}
	}

	
}
