package com.tarena.fly;

import java.util.Random;

/**
 * �зɻ�: �Ƿ����Ҳ�ǵ���
 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 6;  //�ƶ�����
	
	/** ��ʼ������ */
	public Airplane(){
		this.image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;          
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
	}
	
	/** ��ȡ���� */
	@Override
	public int getScore() {  
		return 5;
	}

	/** //Խ�紦�� */
	@Override
	public 	boolean outOfBounds() {   
		boolean b=y>ShootGame.HEIGHT;
		if(b) {
			if(ShootGame.score>100) {
				ShootGame.score-=100;
			}else {
				ShootGame.score=0;
			}
		}
		return b;
	}

	/** �ƶ� */
	@Override
	public void step() {   
		y += speed;
	}

}

