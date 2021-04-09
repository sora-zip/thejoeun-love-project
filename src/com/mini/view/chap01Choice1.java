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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class chap01Choice1 extends JFrame {

	public chap01Choice1() {

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
		Image personImg = new ImageIcon("image/김선호.png").getImage();
		personImg.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JLabel person = new JLabel(new ImageIcon(personImg));

		// 상단의 이미지 크기, 위치 조정
		person.setBounds(5, 20, 1000, 300);

		// 상단 호감도 표시
		Image loveBarImg = new ImageIcon("image/loveBar.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel loveBar = new JLabel(new ImageIcon(loveBarImg));

		// 상단 호감도 표시 크기, 위치 조정
		loveBar.setBounds(10, 0, 50, 50);

		// 상단 오른쪽 프로그램 종료 버튼
		Image closeImg = new ImageIcon("image/close.png").getImage().getScaledInstance(50, 50, 0);
		JLabel closewords = new JLabel(new ImageIcon(closeImg));

		// 상단 종료 버튼 크기, 위치 조정
		closewords.setBounds(900, 0, 50, 50);

		// 하단에 선택지 테두리
		Image talkBackGroundImg = new ImageIcon("image/bottom.png").getImage();
		talkBackGroundImg.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JLabel talkBackGround = new JLabel(new ImageIcon(talkBackGroundImg));

		// 하단에 선택지 테두리의 크기, 위치 조정
		talkBackGround.setBounds(20, 340, 920, 270);

		// 선택지 버튼
		JButton choice1_btn = new JButton();
		JButton choice2_btn = new JButton();
		JButton choice3_btn = new JButton();

		// 선택지 버튼의 라벨
		JLabel choiec1_lb = new JLabel("<html>우와 재밌겠다~<br><br>선배 우리 한번 해봐요 !!</html>");
		JLabel choiec2_lb = new JLabel("<html>저희 시간 별로 없지 않아요?<br><br>괜찮습니다 그냥 주세요</html>");
		JLabel choiec3_lb = new JLabel("<html>오빠(하트만땅)<br>저만 믿으세요.<br><br>제가 커피 따올게요</html>");

		// 선택지 버튼의 크기, 위치 조정
		choice1_btn.setBounds(50, 50, 250, 180);
		choice2_btn.setBounds(330, 50, 250, 180);
		choice3_btn.setBounds(610, 50, 250, 180);

		// 선택지 버튼의 배경 색
		choice1_btn.setBackground(new Color(255, 255, 240));
		choice2_btn.setBackground(new Color(255, 255, 240));
		choice3_btn.setBackground(new Color(255, 255, 240));

		// 선택지 버튼에 대한 이벤트 -> 마우스에 대한 색깔 변경 이벤트 & 창 닫기
		choice1_btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				choice1_btn.setBackground(Color.pink);
			}

			public void mouseExited(MouseEvent e) {
				choice1_btn.setBackground(new Color(255, 255, 240));
			}

			public void mouseClicked(MouseEvent e) {
				chap01Choice1.this.dispose();
				//미니게임 gui 호출
			}

		});

		choice2_btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				choice2_btn.setBackground(Color.pink);
			}

			public void mouseExited(MouseEvent e) {
				choice2_btn.setBackground(new Color(255, 255, 240));
			}

			public void mouseClicked(MouseEvent e) {
				chap01Choice1.this.dispose();
				//미니게임 gui 호출
			}

		});

		choice3_btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				choice3_btn.setBackground(Color.pink);
			}

			public void mouseExited(MouseEvent e) {
				choice3_btn.setBackground(new Color(255, 255, 240));
			}

			public void mouseClicked(MouseEvent e) {
				chap01Choice1.this.dispose();
				//미니게임 gui 호출
			}

		});

		// 선택지 버튼의 라벨에 폰트 적용
		choiec1_lb.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		choiec2_lb.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		choiec3_lb.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));

		// 버튼에 라벨 추가
		choice1_btn.add(choiec1_lb);
		choice2_btn.add(choiec2_lb);
		choice3_btn.add(choiec3_lb);

		// 하단 선택지 테두리에 버튼 추가
		talkBackGround.add(choice1_btn);
		talkBackGround.add(choice2_btn);
		talkBackGround.add(choice3_btn);

		// panel에 추가
		pan.add(person);
		pan.add(loveBar);
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

		// 프레임 설정
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}