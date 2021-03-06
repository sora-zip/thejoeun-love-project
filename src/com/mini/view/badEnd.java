package com.mini.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mini.controller.UserController;

import java.util.Timer;
import java.util.TimerTask;

public class badEnd extends JFrame {
	
	public badEnd() {
		
	}

	public badEnd(String name, int stage, int lovePoint) {
		JFrame jframe = this;

		// 프레임 설정
		this.setSize(1000, 680);
		this.setTitle("시뮬레이션");
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// 배경값 설정을 위한 컬러 생성
		Color b = new Color(255, 225, 235);

		// Panel 설정
		JPanel pan = new JPanel();
		pan.setBounds(10, 10, 965, 620);
		pan.setLayout(null);
		pan.setBackground(b);

		// 상단에 사람 이미지
		Image personImg = new ImageIcon("image/선호배드엔딩.jpg").getImage();
		personImg.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JLabel person = new JLabel(new ImageIcon(personImg));

		// 상단의 이미지 크기, 위치 조정
		person.setBounds(87, 20, 780, 300);

		// 상단 오른쪽 프로그램 종료 버튼
		Image closeImg = new ImageIcon("image/close.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel closewords = new JLabel(new ImageIcon(closeImg));

		// 상단 종료 버튼 크기, 위치 조정
		closewords.setBounds(900, 0, 50, 50);

		// 하단에 대화 테두리
		Image talkBackGroundImg = new ImageIcon("image/bottom.png").getImage();
		talkBackGroundImg.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JLabel talkBackGround = new JLabel(new ImageIcon(talkBackGroundImg));

		// 하단에 대화 테두리의 크기, 위치 조정
		talkBackGround.setBounds(20, 340, 920, 270);

		// 하단 대화 내용
		JLabel talk = new JLabel("<html>선호 : 네가 이렇게 하는거 너무 부담스럽다.<br>" + "앞으로는 회사에서도 선을 지켜줬으면해<br>"
				+ "니가 잘모르나 본데! 나 결혼도 했고, 아이도 둘이나 있어!!<br>" + "이제 나한테 관심꺼줘 회사에서는 일만 하자</html>");
		talk.setBounds(50, -50, 1000, 350);
		talk.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));

		// 하단 대화 테두리의 대화라벨 추가
		talkBackGround.add(talk);
		
		// 하단 다음 이미지
		Image nextImg = new ImageIcon("image/next.png").getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		JLabel next = new JLabel(new ImageIcon(nextImg));

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				next.setBounds(750, 150, 150, 80);
				talkBackGround.add(next);
				jframe.repaint();

			}
		};

		// 다음 버튼이 쪼금 더 천천히 나왔으면 좋겠다 싶으면 1000보다 높은 숫자로 수정하세용
		timer.schedule(timerTask, 1000);

		// panel에 추가
		pan.add(person);
		pan.add(closewords);
		pan.add(talkBackGround);

		// 프레임 판넬 추가
		this.add(pan, "Center");

		// 닫기 버튼 이벤트 -> 클릭하면 경고 창 출력
		closewords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new warning();
			}
		});

		// 다음 버튼 이벤트 -> 화면 전환
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserController().savaStage(name,stage,lovePoint);
				badEnd.this.dispose();

				new rankList();

			}
		});

		// 프레임 설정
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
