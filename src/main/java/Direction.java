public enum Direction
{
	Horizontal (1, 0),
	Vertical (0, 1);

	private final int xdir;
	private final int ydir;

	Direction(int xdir, int ydir){
		this.xdir = xdir;
		this.ydir = ydir;
	}

	private int xDir(){
		return xdir;
	}

	private int yDir(){
		return ydir;
	}
}
