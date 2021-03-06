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
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class chap03Narration1 extends JFrame {

	public chap03Narration1() {

	}

	public chap03Narration1(String name, int stage, int lovePoint) {

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
		Image personImg = new ImageIcon("image/선호미소.png").getImage();
		personImg.getScaledInstance(780, 300, Image.SCALE_SMOOTH);
		JLabel person = new JLabel(new ImageIcon(personImg));

		// 상단의 이미지 크기, 위치 조정
		person.setBounds(87, 20, 780, 300);

		String img = "";

		if (lovePoint >= 80) {

			img = "image/loveBar3.png";

		} else if (lovePoint >= 50) {

			img = "image/loveBar2.png";
		} else {

			img = "image/loveBar1.png";
		}

		// 상단 호감도 표시
		Image loveBarImg = new ImageIcon(img).getImage();
		loveBarImg.getScaledInstance(130, 330, Image.SCALE_SMOOTH);
		JLabel loveBar = new JLabel(new ImageIcon(loveBarImg));

		// 상단 호감도 표시 크기, 위치 조정
		loveBar.setBounds(895, 50, 60, 150);

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
		talkBackGround.setBounds(20, 335, 920, 270);

		// 하단 대화 내용
		JLabel talk = new JLabel("<html>회사에서 새 프로젝트에 들어가게 되었는데,<br>" + "선호선배와 함께 현장조사를 다녀오라고 배정받게되었다<br><br>"
				+ "대리님 감사합니다..! 선배와 단 둘이 외근이라니!</html>");
		talk.setBounds(50, -50, 1000, 350);
		talk.setFont(new Font("배달의민족 주아", Font.PLAIN, 33));

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

		// 매개변수로 전달받은 스테이지 번호를 넘겨주기 위한 작업
		String stageNum = String.valueOf(stage);
		JLabel test = new JLabel(stageNum);
		test.setVisible(false);
		
		// 매개변수로 전달받은 호감도 넘겨주기 위한 작업
		String lovePointNum = String.valueOf(lovePoint);
		JLabel lovePointLabel = new JLabel(lovePointNum);
		lovePointLabel.setVisible(false);

		// panel에 추가
		pan.add(person);
		pan.add(loveBar);
		pan.add(closewords);
		pan.add(talkBackGround);
		pan.add(test);
		pan.add(lovePointLabel);

		// 하단 대화 테두리에 다음 이미지 추가
		talkBackGround.add(next);

		// 프레임 판넬 추가
		this.add(pan, "Center");

		// 닫기 버튼 이벤트 -> 클릭하면 경고 창 출력
		closewords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String num = test.getText();
				int stage1 = Integer.parseInt(num);
				
				new warning(name, stage1, lovePoint);
			}
		});

		// 다음 버튼 이벤트 -> 화면 전환
		next.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				chap03Narration1.this.dispose();
				
				String num = test.getText();
				int stage2 = Integer.parseInt(num);
				stage2++;
				
				new chap03Narration2(name, stage2, lovePoint);
			}
		});

		// 프레임 설정
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
