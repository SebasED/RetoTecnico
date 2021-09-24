package Modelo;

public class Premio {
	private int dinero = 0;
	private int ronda;
	
	public Premio(int ronda) {
		super();
		this.ronda = ronda;
		
		dineroPorRonda(ronda);
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	
	private void dineroPorRonda(int ronda) {
		switch(ronda) {
		case 1:
			this.dinero = 0;
			break;
		case 2:
			this.dinero = 300000;
			break;
		case 3:
			this.dinero = 700000;
			break;
		case 4:
			this.dinero = 1500000;
			break;
		case 5:
			this.dinero = 4000000;
			break;
		default:
			this.dinero = 10000000;
			break;
		}
		
	}
}
