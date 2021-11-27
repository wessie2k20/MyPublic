package model;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

//	private class OneUpTimerTask extends TimerTask{
//		private MainModel mainModel;
//		
//		public OneUpTimerTask(MainModel m) {
//			this.mainModel = m;
//		}
//		
//		@Override
//		public void run() {
//			if(this.mainModel.isOneup()) {
//				this.mainModel.getSpieler().setLeben(this.mainModel.getSpieler().getLeben()+1);
//				this.mainModel.setOneup(false);
//			}
//		}
//		
//		
//	}
	
	private class ExplosionTimerTask extends TimerTask {
		private MainModel mainModel;
		private int expNumber = -1;

		public MainModel getMainModel() {
			return mainModel;
		}

		public void setMainModel(MainModel mainModel) {
			this.mainModel = mainModel;
		}

		public int getExpNumber() {
			return expNumber;
		}

		public void setExpNumber(int expNumber) {
			this.expNumber = expNumber;
		}

		public ExplosionTimerTask(MainModel mainModel) {
			this.setMainModel(mainModel);
		}

		@Override
		public void run() {
			if (!this.getMainModel().isInMenu() && !this.getMainModel().isGameOver() && this.getMainModel().isGameStart() && !this.getMainModel().isHsMenu()) {
				if (this.getMainModel().getMainController().getExpNumberFromView() != -1) {
					if (this.getExpNumber() == 15) {						
						this.setExpNumber(-1);
					} else {
						this.setExpNumber(this.getExpNumber() + 1);
					}
					this.getMainModel().getMainController().updateRocketHit(this.getExpNumber());
				}
			}
		}
	}
	
	private MainModel mainModel;
	private Timer explosionTimer;
	private ExplosionTimerTask ett;
//	private Timer oneUpTimer;
//	private OneUpTimerTask oneUpTask;

	public MainModel getMainModel() {
		return mainModel;
	}

	public void setMainModel(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public Timer getExplosionTimer() {
		return explosionTimer;
	}

	public void setExplosionTimer(Timer explosionTimer) {
		this.explosionTimer = explosionTimer;
	}

	public ExplosionTimerTask getEtt() {
		return ett;
	}

	public void setEtt(ExplosionTimerTask ett) {
		this.ett = ett;
	}

//	public Timer getOneUpTimer() {
//		return oneUpTimer;
//	}
//
//	public void setOneUpTimer(Timer oneUpTimer) {
//		this.oneUpTimer = oneUpTimer;
//	}
//
//	public OneUpTimerTask getOneUpTask() {
//		return oneUpTask;
//	}
//
//	public void setOneUpTask(OneUpTimerTask oneUpTask) {
//		this.oneUpTask = oneUpTask;
//	}

	public MyTimer(MainModel m) {
		this.setMainModel(m);
		this.setExplosionTimer(new Timer());
		this.setEtt(new ExplosionTimerTask(m));
		this.getExplosionTimer().scheduleAtFixedRate(this.getEtt(), 0, 50);
//		this.setOneUpTimer(new Timer());
//		this.setOneUpTask(new OneUpTimerTask(m));
//		this.getOneUpTimer().scheduleAtFixedRate(this.getOneUpTask(), 0, 10);
	}

	public void updateExpNumberInTimerTask(int expNumber) {
		this.getEtt().setExpNumber(expNumber);
	}

}
